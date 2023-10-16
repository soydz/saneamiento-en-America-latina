package org.proyecto2.service;

import java.util.ArrayList;
import java.util.List;

import org.proyecto2.model.CountrySanitationStatistics;
import org.proyecto2.repository.CountrySanitationStatisticsRepository;

public class SanitationStatisticServiceImpl implements SanitationStatisticService {

    private final CountrySanitationStatisticsRepository countrySanitationStatisticsRepository;
    private final List<CountrySanitationStatistics> countriesList;

    public SanitationStatisticServiceImpl(
            CountrySanitationStatisticsRepository countrySanitationStatisticsRepository) {
        this.countrySanitationStatisticsRepository = countrySanitationStatisticsRepository;
        this.countriesList = this.countrySanitationStatisticsRepository.statisticsOfCountries();
    }

    @Override
    public Double averageWaterAccess() {
        Double sumAverageWaterAccess = 0D;
        int numCountries = this.countriesList.size();

        for (CountrySanitationStatistics i : this.countriesList) {
            sumAverageWaterAccess += i.waterAccessPercentage();
        }

        return sumAverageWaterAccess / numCountries;
    }

    @Override
    public String countryGreaterAccessWater() {
        String country = "";
        Double waterAccessPercentage = 0D;

        for (CountrySanitationStatistics i : this.countriesList) {

            if (i.waterAccessPercentage() > waterAccessPercentage) {
                country = i.country();
                waterAccessPercentage = i.waterAccessPercentage();
            }
        }

        return country;
    }

    @Override
    public Double medianPopulation() {
        ArrayList<Integer> population = new ArrayList<Integer>();

        for (CountrySanitationStatistics i : this.countriesList) {
            population.add(i.population());
        }

        ArrayList<Integer> orderedPopulation = (ArrayList<Integer>) sortData(population).clone();

        if ((orderedPopulation.size() % 2) == 0) {
            int data = orderedPopulation.size() / 2;

            return Double.valueOf(
                    (orderedPopulation.get(data - 1) + orderedPopulation.get(data)) / 2);
        } else {
            int data = (int) Math.floor(orderedPopulation.size() / 2);

            return Double.valueOf(orderedPopulation.get(data));
        }
    }

    @Override
    public Double averagePopulationAffectedByDrought() {
        Double sum = 0D;

        for (CountrySanitationStatistics i : this.countriesList) {
            sum += i.populationAffectedByDrought();
        }

        return sum / this.countriesList.size();
    }

    @Override
    public Double varianceAffectedPopulationDroughts(Double averagePopulationAffectedByDrought) {
        Double sumSquare = 0D;

        for (CountrySanitationStatistics i : this.countriesList) {
            Double difference =
                    i.populationAffectedByDrought() - averagePopulationAffectedByDrought;
            sumSquare += difference * difference;
        }

        return sumSquare / this.countriesList.size();
    }

    @Override
    public ArrayList<Integer> sortData(ArrayList<Integer> list) {
        ArrayList<Integer> orderedList = list;

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < (list.size() - i); j++) {

                if (orderedList.get(j) > orderedList.get(j + 1)) {
                    Integer num = orderedList.get(j + 1);
                    orderedList.set((j + 1), orderedList.get(j));
                    orderedList.set(j, num);
                }
            }
        }

        return orderedList;
    }
}

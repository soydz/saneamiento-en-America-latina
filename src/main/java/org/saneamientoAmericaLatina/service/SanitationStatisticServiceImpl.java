package org.saneamientoAmericaLatina.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.saneamientoAmericaLatina.model.CountrySanitationStatistics;
import org.saneamientoAmericaLatina.repository.CountrySanitationStatisticsRepository;

public class SanitationStatisticServiceImpl implements SanitationStatisticService {
    private final List<CountrySanitationStatistics> countriesList;

    public SanitationStatisticServiceImpl(
            CountrySanitationStatisticsRepository countrySanitationStatisticsRepository) {
        this.countriesList = countrySanitationStatisticsRepository.statisticsOfCountries();
    }

    @Override
    public Double averageWaterAccess() {
        return this.countriesList.stream()
                .mapToDouble(CountrySanitationStatistics::waterAccessPercentage)
                .average()
                .getAsDouble();
    }

    @Override
    public String countryGreaterAccessWater() {
        return this.countriesList.stream()
                .max(Comparator.comparingDouble(CountrySanitationStatistics::waterAccessPercentage))
                .get()
                .country()
                .replace("\"", "");
    }

    @Override
    public Double medianPopulation() {
        ArrayList<Integer> population = new ArrayList<>();

        for (CountrySanitationStatistics i : this.countriesList) {
            if (i.population() != null) {
                population.add(i.population());
            }
        }

        ArrayList<Integer> orderedPopulation = (ArrayList<Integer>) sortData(population).clone();

        if ((orderedPopulation.size() % 2) == 0) {
            int data = orderedPopulation.size() / 2;

            return (double) ((orderedPopulation.get(data - 1) + orderedPopulation.get(data)) / 2);

        } else {
            int data = (int) Math.floor((double) orderedPopulation.size() / 2);

            return Double.valueOf(orderedPopulation.get(data));
        }
    }

    @Override
    public Double averagePopulationAffectedByDrought() {
        return this.countriesList.stream()
                .mapToInt(CountrySanitationStatistics::populationAffectedByDrought)
                .average()
                .getAsDouble();
    }

    @Override
    public Double varianceAffectedPopulationDroughts(Double averagePopulationAffectedByDrought) {
        double sumSquare = 0D;
        int numCountries = 0;

        for (CountrySanitationStatistics i : this.countriesList) {
            if (i.populationAffectedByDrought() != null) {
                Double difference =
                        i.populationAffectedByDrought() - averagePopulationAffectedByDrought;
                sumSquare += difference * difference;
                numCountries++;
            }
        }

        return sumSquare / numCountries;
    }

    @Override
    public ArrayList<Integer> sortData(ArrayList<Integer> list) {

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < (list.size() - i); j++) {

                if (list.get(j) > list.get(j + 1)) {
                    Integer num = list.get(j + 1);
                    list.set((j + 1), list.get(j));
                    list.set(j, num);
                }
            }
        }

        return list;
    }
}

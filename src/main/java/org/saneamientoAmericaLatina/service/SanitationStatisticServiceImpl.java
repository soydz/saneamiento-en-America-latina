package org.saneamientoAmericaLatina.service;

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

        List<Integer> orderedPopulation =
                this.countriesList.stream()
                        .mapToInt(CountrySanitationStatistics::population)
                        .sorted()
                        .boxed()
                        .toList();

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
}

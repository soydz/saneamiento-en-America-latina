package org.sanitationInLatinAmerica.service;

import org.sanitationInLatinAmerica.model.CountrySanitationStatistics;
import java.util.List;

public interface SanitationStatisticService {
    Double averageWaterAccess();

    String countryGreaterAccessWater();

    Double medianPopulation();

    Double averagePopulationAffectedByDrought();

    Double varianceAffectedPopulationDroughts(Double averagePopulationAffectedByDrought);

    List<CountrySanitationStatistics> statisticsList();

    CountrySanitationStatistics addStatistics(CountrySanitationStatistics newStatistics);
}

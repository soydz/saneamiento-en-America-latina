package org.saneamientoAmericaLatina.service;

public interface SanitationStatisticService {
    Double averageWaterAccess();

    String countryGreaterAccessWater();

    Double medianPopulation();

    Double averagePopulationAffectedByDrought();

    Double varianceAffectedPopulationDroughts(Double averagePopulationAffectedByDrought);
}

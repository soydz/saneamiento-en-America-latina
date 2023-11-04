package org.saneamientoAmericaLatina.service;

import java.util.ArrayList;

public interface SanitationStatisticService {
    Double averageWaterAccess();

    String countryGreaterAccessWater();

    Double medianPopulation();

    Double averagePopulationAffectedByDrought();

    Double varianceAffectedPopulationDroughts(Double averagePopulationAffectedByDrought);
}

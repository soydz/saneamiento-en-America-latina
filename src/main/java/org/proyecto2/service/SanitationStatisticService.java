package org.proyecto2.service;

import java.util.ArrayList;

public interface SanitationStatisticService {
    Double averageWaterAccess();
    String countryGreaterAccessWater();
    Double medianPopulation();
    Double averagePopulationAffectedByDrought();
    Double varianceAffectedPopulationDroughts(Double averagePopulationAffectedByDrought);
    ArrayList<Integer> sortData(ArrayList<Integer> list);
}

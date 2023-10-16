package org.proyecto2;

import org.proyecto2.model.CountrySanitationStatistics;
import org.proyecto2.repository.CountrySanitationStatisticsRepository;
import org.proyecto2.repository.CountrySanitationStatisticsRepositoryImpl;
import org.proyecto2.service.SanitationStatisticService;
import org.proyecto2.service.SanitationStatisticServiceImpl;
import java.util.List;

public class AppRun {
    public static void main(String[] args) {

        SanitationStatisticService sanitationStatisticService =
                new SanitationStatisticServiceImpl(new CountrySanitationStatisticsRepositoryImpl());

        Double averageWaterAccess = sanitationStatisticService.averageWaterAccess();
        String countryGreaterAccessWater = sanitationStatisticService.countryGreaterAccessWater();
        Double medianPopulation = sanitationStatisticService.medianPopulation();
        Double averagePopulationAffectedByDrought =
                sanitationStatisticService.averagePopulationAffectedByDrought();
        Double varianceAffectedPopulationDroughts =
                sanitationStatisticService.varianceAffectedPopulationDroughts(
                        averagePopulationAffectedByDrought);
    }
}

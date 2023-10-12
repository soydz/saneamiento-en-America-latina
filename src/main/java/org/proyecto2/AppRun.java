package org.proyecto2;

import org.proyecto2.repository.CountrySanitationStatisticsRepositoryImpl;
import org.proyecto2.service.SanitationStatisticService;
import org.proyecto2.service.SanitationStatisticServiceImpl;
public class AppRun {
    public static void main(String[] args) {

        SanitationStatisticService sanitationStatisticService =
                new SanitationStatisticServiceImpl(new CountrySanitationStatisticsRepositoryImpl());

        double averageWaterAccess = sanitationStatisticService.averageWaterAccess();
        String countryGreaterAccessWater = sanitationStatisticService.countryGreaterAccessWater();

    }
}
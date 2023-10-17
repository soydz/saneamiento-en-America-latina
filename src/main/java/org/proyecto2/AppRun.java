package org.proyecto2;

//mvn fmt:format

import java.text.MessageFormat;
import org.proyecto2.repository.CountrySanitationStatisticsRepositoryImpl;
import org.proyecto2.service.SanitationStatisticService;
import org.proyecto2.service.SanitationStatisticServiceImpl;
public class AppRun {
    public static void main(String[] args) {

        SanitationStatisticService sanitationStatisticService =
                new SanitationStatisticServiceImpl(new CountrySanitationStatisticsRepositoryImpl());

        Double averageWaterAccess = sanitationStatisticService.averageWaterAccess();
        String countryGreaterAccessWater = sanitationStatisticService.countryGreaterAccessWater();
        Double medianPopulation = sanitationStatisticService.medianPopulation();
        Double averagePopulationAffectedByDrought = sanitationStatisticService.averagePopulationAffectedByDrought();
        Double varianceAffectedPopulationDroughts = sanitationStatisticService.
                varianceAffectedPopulationDroughts(averagePopulationAffectedByDrought);
        
        System.out.println(
        MessageFormat.format(
            "Average water access: {0}", averageWaterAccess));

        System.out.println(
            MessageFormat.format("Country greater access water: {0}", countryGreaterAccessWater));

        System.out.println(
            MessageFormat.format("Median Sanitation Statistic for Population: {0}", medianPopulation));
        
        System.out.println(
            MessageFormat.format("Average population affected by drought: {0}", averagePopulationAffectedByDrought));
        
        System.out.println(
            MessageFormat.format("Variance affected population droughts: {0}", varianceAffectedPopulationDroughts));
    }
}
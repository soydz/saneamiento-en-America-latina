package org.sanitationInLatinAmerica;

import java.text.MessageFormat;
// import org.saneamientoAmericaLatina.repository.CountrySanitationStatisticsRepositoryImpl;
import org.sanitationInLatinAmerica.repository.CountrySanitationStatisticsUsingFileRepositoryImpl;
import org.sanitationInLatinAmerica.service.SanitationStatisticService;
import org.sanitationInLatinAmerica.service.SanitationStatisticServiceImpl;

public class AppRun {
    public static void main(String[] args) {

        /*SanitationStatisticService sanitationStatisticService =
         *      new SanitationStatisticServiceImpl(new CountrySanitationStatisticsRepositoryImpl());
         */

        SanitationStatisticService sanitationStatisticService =
                new SanitationStatisticServiceImpl(
                        new CountrySanitationStatisticsUsingFileRepositoryImpl());

        Double averageWaterAccess = sanitationStatisticService.averageWaterAccess();
        String countryGreaterAccessWater = sanitationStatisticService.countryGreaterAccessWater();
        Double medianPopulation = sanitationStatisticService.medianPopulation();
        Double averagePopulationAffectedByDrought =
                sanitationStatisticService.averagePopulationAffectedByDrought();
        Double varianceAffectedPopulationDroughts =
                sanitationStatisticService.varianceAffectedPopulationDroughts(
                        averagePopulationAffectedByDrought);

        System.out.println(MessageFormat.format("Average water access: {0}", averageWaterAccess));

        System.out.println(
                MessageFormat.format(
                        "Country greater access water: {0}", countryGreaterAccessWater));

        System.out.println(
                MessageFormat.format(
                        "Median Sanitation Statistic for Population: {0}", medianPopulation));

        System.out.println(
                MessageFormat.format(
                        "Average population affected by drought: {0}",
                        averagePopulationAffectedByDrought));

        System.out.println(
                MessageFormat.format(
                        "Variance affected population droughts: {0}",
                        varianceAffectedPopulationDroughts));
    }
}

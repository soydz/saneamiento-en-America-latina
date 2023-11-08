package org.sanitationInLatinAmerica.service;

import org.junit.jupiter.api.BeforeEach;
//import org.saneamientoAmericaLatina.repository.CountrySanitationStatisticsRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sanitationInLatinAmerica.repository.CountrySanitationStatisticsUsingFileRepositoryImpl;

public class SanitationStatisticServiceImplTest {
    private SanitationStatisticService sanitationStatisticService;

    @BeforeEach
    public void setup() {

        this.sanitationStatisticService =
                new SanitationStatisticServiceImpl(
                        new CountrySanitationStatisticsUsingFileRepositoryImpl());
    }

    @Test
    public void average_water_access_return_a_valid_number() {
        Double averageWaterAccess = this.sanitationStatisticService.averageWaterAccess();
        assertNotNull(averageWaterAccess);
        assertEquals(75.93333333333332, averageWaterAccess);
    }

    @Test
    public void country_greater_access_water_return_a_valid_number() {
        String countryGreaterAccessWater =
                this.sanitationStatisticService.countryGreaterAccessWater();
        assertNotNull(countryGreaterAccessWater);
        assertEquals("Uruguay", countryGreaterAccessWater);
    }

    @Test
    public void median_population_return_a_valid_number() {
        Double medianPopulation = this.sanitationStatisticService.medianPopulation();
        assertNotNull(medianPopulation);
        assertEquals(1.1216E7, medianPopulation);
    }

    @Test
    public void average_population_affected_by_drought_return_a_valid_number() {
        Double averagePopulationAffectedByDrought =
                this.sanitationStatisticService.averagePopulationAffectedByDrought();
        assertNotNull(averagePopulationAffectedByDrought);
        assertEquals(2857117.4285714286, averagePopulationAffectedByDrought);
    }

    @Test
    public void variance_affected_population_droughts_return_a_valid_number() {
        Double averagePopulationAffectedByDrought =
                this.sanitationStatisticService.averagePopulationAffectedByDrought();
        Double varianceAffectedPopulationDroughts =
                this.sanitationStatisticService.varianceAffectedPopulationDroughts(
                        averagePopulationAffectedByDrought);
        assertNotNull(varianceAffectedPopulationDroughts);
        assertEquals(1.6367929365640812E13, varianceAffectedPopulationDroughts);
    }
}

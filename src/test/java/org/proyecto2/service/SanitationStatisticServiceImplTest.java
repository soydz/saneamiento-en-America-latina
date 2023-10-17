package org.proyecto2.service;

import org.junit.jupiter.api.BeforeEach;
import org.proyecto2.repository.CountrySanitationStatisticsRepositoryImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SanitationStatisticServiceImplTest {
    private SanitationStatisticService sanitationStatisticService;
    private static final Logger logger = LoggerFactory.getLogger(SanitationStatisticServiceImplTest.class);

    @BeforeEach
    public void setup() {
        this.sanitationStatisticService =
                new SanitationStatisticServiceImpl(new CountrySanitationStatisticsRepositoryImpl());
    }

    @Test
    public void average_water_access_return_a_valid_number() {
        Double averageWaterAccess = this.sanitationStatisticService.averageWaterAccess();
        assertNotNull(averageWaterAccess);
        assertEquals(75.93333333333335, averageWaterAccess);
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
  
  @Test
    public void testAverageWaterAccess() {
        logger.info("Average Water Access");
        SanitationStatisticServiceImpl instance = null;
        Double expResult = null;
        Double result = instance.averageWaterAccess();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
       logger.error("The test case is a prototype.");
    }

    @Test
    public void testCountryGreaterAccessWater() {
        logger.info("Country greater access Water");
        SanitationStatisticServiceImpl instance = null;
        String expResult = "";
        String result = instance.countryGreaterAccessWater();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        logger.error("The test case is a prototype.");
    }

    @Test
    public void testMedianPopulation() {
        logger.info("Median population Water Access");
        SanitationStatisticServiceImpl instance = null;
        Double expResult = null;
        Double result = instance.medianPopulation();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        logger.error("The test case is a prototype.");
    }

    @Test
    public void testAveragePopulationAffectedByDrought() {
        logger.info("Average Population Affected By Drought");
        SanitationStatisticServiceImpl instance = null;
        Double expResult = null;
        Double result = instance.averagePopulationAffectedByDrought();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        logger.error("The test case is a prototype.");
    }

    @Test
    public void testVarianceAffectedPopulationDroughts() {
        logger.info("Variance affected populationdroughts");
        Double averagePopulationAffectedByDrought = null;
        SanitationStatisticServiceImpl instance = null;
        Double expResult = null;
        Double result = instance.varianceAffectedPopulationDroughts(averagePopulationAffectedByDrought);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        logger.error("The test case is a prototype.");
    }

    @Test
    public void testSortData() {
        logger.info("Sort data");
        ArrayList<Integer> list = null;
        SanitationStatisticServiceImpl instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.sortData(list);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        logger.error("The test case is a prototype.");   
    }
}

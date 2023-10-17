/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.proyecto2.service;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author estebanh
 */
public class SanitationStatisticServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(SanitationStatisticServiceImplTest.class);
    
    public SanitationStatisticServiceImplTest() {
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

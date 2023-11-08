package org.sanitationInLatinAmerica.model;

public record CountrySanitationStatistics(
        String country,
        Integer population,
        Double waterAccessPercentage,
        Integer populationAffectedByDrought,
        Integer numberOfHospitals,
        Integer numberOfHospitalsSanitationProblems,
        Double numberOfWaterTreatmentPlantsPerHundredThousandInhabitants) {}

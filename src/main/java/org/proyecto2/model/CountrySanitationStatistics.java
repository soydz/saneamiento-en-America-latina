package org.proyecto2.model;

public record CountrySanitationStatistics(String country,
                                          Integer population,
                                          Double waterAccessPercentage,
                                          Integer populationAffectedByDrought,
                                          Integer numberOfHospitals,
                                          Integer numberOfHospitalsSanitationProblems,
                                          Double numberOfWaterTreatmentPlantsPerHundredThousandInhabitants) {}

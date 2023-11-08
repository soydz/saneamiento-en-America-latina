package org.saneamientoAmericaLatina.repository;

import org.saneamientoAmericaLatina.model.CountrySanitationStatistics;

import java.util.List;

public class CountrySanitationStatisticsRepositoryImpl
        implements CountrySanitationStatisticsRepository {

    @Override
    public List<CountrySanitationStatistics> statisticsOfCountries() {

        return List.of(
                new CountrySanitationStatistics(
                        "Colombia", 50340000, 72.3, 4500000, 3500, 900, 15.7),
                new CountrySanitationStatistics(
                        "Argentina", 46044703, 88.6, 1400000, 4200, 150, 32.1),
                new CountrySanitationStatistics("Bolivia", 11216000, 61.9, 1600000, 1021, 400, 9.7),
                new CountrySanitationStatistics("Chile", 17574003, 92.6, 958100, 3200, 98, 48.9),
                new CountrySanitationStatistics(
                        "Venezuela", 32605423, 24.5, 10800000, 1207, 2100, 14.8),
                new CountrySanitationStatistics("Haití", 11488792, 16.3, 950000, 420, 950, 5.2),
                new CountrySanitationStatistics("Uruguay", 3286314, 97.9, 410, 3130, 45, 21.4),
                new CountrySanitationStatistics(
                        "Costa Rica", 5100000, 94.7, 280000, 900, 240, 11.3),
                new CountrySanitationStatistics("Cuba", 11200000, 89.1, 400000, 700, 250, 13.3),
                new CountrySanitationStatistics(
                        "Ecuador", 17800000, 79.6, 1100000, 1650, 380, 14.2),
                new CountrySanitationStatistics(
                        "El Salvador", 6300000, 86.8, 600000, 619, 320, 9.2),
                new CountrySanitationStatistics(
                        "Guatemala", 17100000, 72.9, 7200000, 1300, 430, 12.3),
                new CountrySanitationStatistics(
                        "Honduras", 10200000, 76.2, 900000, 1716, 320, 11.3),
                new CountrySanitationStatistics(
                        "México", 126200000, 89.9, 9300000, 4900, 1230, 16.2),
                new CountrySanitationStatistics(
                        "Nicaragua", 6850000, 66.5, 740000, 1343, 410, 10.6),
                new CountrySanitationStatistics("Panamá", 4350000, 92.3, 380000, 209, 89, 17.1),
                new CountrySanitationStatistics("Paraguay", 6700000, 68.4, 1200000, 217, 98, 11.2),
                new CountrySanitationStatistics("Perú", 33700000, 84.7, 1700000, 3807, 1230, 16.),
                new CountrySanitationStatistics(
                        "República Dominicana", 11100000, 81.5, 960000, 960, 287, 13.9),
                new CountrySanitationStatistics(
                        "Guayana Francesa", 300000, 88.7, 30000, 40, 23, 7.3),
                new CountrySanitationStatistics(
                        "Brasil", 215313498, 69.2, 15000956, 5210, 1405, 13.9),
                new CountrySanitationStatistics(null, null, null, null, null, null, null));
    }
}

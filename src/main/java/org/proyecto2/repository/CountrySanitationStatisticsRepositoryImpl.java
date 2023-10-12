package org.proyecto2.repository;

import org.proyecto2.model.CountrySanitationStatistics;
import java.util.List;

public class CountrySanitationStatisticsRepositoryImpl implements CountrySanitationStatisticsRepository {

    @Override
    public List<CountrySanitationStatistics> statisticsOfCountries(){

        List<CountrySanitationStatistics> countriesList = List.of(
                new CountrySanitationStatistics("Colombia",
                        50340000,
                        72.3,
                        4500000,
                        3500,
                        900,
                        15.7),
                new CountrySanitationStatistics("Argentina",
                        46044703,
                        88.6,
                        1400000,
                        4200,
                        150,
                        32.1)
                // falta terminar de llenar los datos
        );

        return countriesList;
    }
}

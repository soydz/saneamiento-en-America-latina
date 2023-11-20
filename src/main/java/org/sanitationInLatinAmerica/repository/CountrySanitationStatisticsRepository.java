package org.sanitationInLatinAmerica.repository;

import org.sanitationInLatinAmerica.model.CountrySanitationStatistics;
import java.util.List;

public interface CountrySanitationStatisticsRepository {
    List<CountrySanitationStatistics> statisticsOfCountries();

    CountrySanitationStatistics addStatistics(CountrySanitationStatistics newStatistics);
}

package org.proyecto2.repository;

import org.proyecto2.model.CountrySanitationStatistics;
import java.util.List;

public interface CountrySanitationStatisticsRepository {
    List<CountrySanitationStatistics> statisticsOfCountries();
}

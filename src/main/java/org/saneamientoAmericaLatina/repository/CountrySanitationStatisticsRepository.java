package org.saneamientoAmericaLatina.repository;

import org.saneamientoAmericaLatina.model.CountrySanitationStatistics;
import java.util.List;

public interface CountrySanitationStatisticsRepository {
    List<CountrySanitationStatistics> statisticsOfCountries();
}

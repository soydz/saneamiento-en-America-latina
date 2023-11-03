package org.saneamientoAmericaLatina.repository;

import org.saneamientoAmericaLatina.model.CountrySanitationStatistics;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountrySanitationStatisticsUsingFileRepositoryImpl
        implements CountrySanitationStatisticsRepository {

    private static final Logger logger =
            LoggerFactory.getLogger(CountrySanitationStatisticsUsingFileRepositoryImpl.class);

    private List<CountrySanitationStatistics> countriesList;

    public CountrySanitationStatisticsUsingFileRepositoryImpl() {
        this.countriesList = new ArrayList<>(loadCountriesStatistics());
    }

    @Override
    public List<CountrySanitationStatistics> statisticsOfCountries() {
        return this.countriesList;
    }

    private List<CountrySanitationStatistics> loadCountriesStatistics() {
        List<String> txt = readFileCountriesStatistics();

        return txt.stream().map(this::buildCountriesStatistics).toList();
    }

    private List<String> readFileCountriesStatistics() {
        Path path = Paths.get("src/main/resources/countriesStatistics.txt");

        try (Stream<String> stream = Files.lines(path)) {
            return stream.toList();
        } catch (IOException e) {
            logger.error("IOException: {0}", e);
        }

        return Collections.emptyList();
    }

    private CountrySanitationStatistics buildCountriesStatistics(String txt) {
        String[] arrTxt = txt.split(", ");

        return new CountrySanitationStatistics(
                arrTxt[0],
                Integer.valueOf(arrTxt[1]),
                Double.valueOf(arrTxt[2]),
                Integer.valueOf(arrTxt[3]),
                Integer.valueOf(arrTxt[4]),
                Integer.valueOf(arrTxt[5]),
                Double.valueOf(arrTxt[6]));
    }
}

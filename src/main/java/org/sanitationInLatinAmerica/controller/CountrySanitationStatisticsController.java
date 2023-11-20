package org.sanitationInLatinAmerica.controller;

import org.sanitationInLatinAmerica.model.CountrySanitationStatistics;
import org.sanitationInLatinAmerica.repository.CountrySanitationStatisticsUsingFileRepositoryImpl;
import org.sanitationInLatinAmerica.service.SanitationStatisticService;
import org.sanitationInLatinAmerica.service.SanitationStatisticServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/statistics")
@CrossOrigin(origins = "*")
public class CountrySanitationStatisticsController {

    private static final Logger logger =
            LoggerFactory.getLogger(CountrySanitationStatisticsController.class);
    SanitationStatisticService sanitationStatisticService =
            new SanitationStatisticServiceImpl(
                    new CountrySanitationStatisticsUsingFileRepositoryImpl());

    @GetMapping
    public List<CountrySanitationStatistics> countrySanitationStatisticsList() {
        logger.info("Listed country sanitation statistics");
        return sanitationStatisticService.statisticsList();
    }

    @PostMapping
    public ResponseEntity<CountrySanitationStatistics> add(
            @RequestBody CountrySanitationStatistics newStatistics) {
        logger.info("Aggregate Country Sanitation Statistics");
        CountrySanitationStatistics countrySanitationStatistics =
                sanitationStatisticService.addStatistics(newStatistics);
        return ResponseEntity.status(HttpStatus.OK).body(countrySanitationStatistics);
    }
}

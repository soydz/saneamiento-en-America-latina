package org.proyecto2.service;

import java.util.List;
import org.proyecto2.model.CountrySanitationStatistics;
import org.proyecto2.repository.CountrySanitationStatisticsRepository;

public class SanitationStatisticServiceImpl implements SanitationStatisticService{

    private final CountrySanitationStatisticsRepository countrySanitationStatisticsRepository;

    public SanitationStatisticServiceImpl(CountrySanitationStatisticsRepository countrySanitationStatisticsRepository){
        this.countrySanitationStatisticsRepository = countrySanitationStatisticsRepository;
    }


    @Override
    public Double averageWaterAccess(){
        List<CountrySanitationStatistics> countriesList = this.countrySanitationStatisticsRepository.statisticsOfCountries();

        Double sumAverageWaterAccess = 0D;
        int numCountries = countriesList.size();

        for(CountrySanitationStatistics i:countriesList){
            sumAverageWaterAccess += i.waterAccessPercentage();
        }

        return sumAverageWaterAccess / numCountries;
    }

    @Override
    public String countryGreaterAccessWater(){
        List<CountrySanitationStatistics> countriesList = this.countrySanitationStatisticsRepository.statisticsOfCountries();

        String country = "";
        Double waterAccessPercentage = 0D;

        for(CountrySanitationStatistics i:countriesList){

            if(i.waterAccessPercentage() > waterAccessPercentage){
                country = i.country();
                waterAccessPercentage = i.waterAccessPercentage();
            }
        }

        return country;
    }
}

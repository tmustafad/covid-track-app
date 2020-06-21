package com.turkmen.covidtrack.service;


import com.turkmen.covidtrack.dto.SummaryApiResponse;
import com.turkmen.covidtrack.repository.CovidRepository;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by turkmenmustafademirci on 6/20/20.
 */

@Service
public class CovidDataService {

    Logger logger = LoggerFactory.getLogger(CovidRepository.class);

    @Autowired
    CovidRepository covidRepository;

    public SummaryApiResponse getCovidSummary(){
        return this.covidRepository.getSummaryApiResponse();
    }

    }


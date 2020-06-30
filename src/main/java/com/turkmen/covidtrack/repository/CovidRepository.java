package com.turkmen.covidtrack.repository;

import com.turkmen.covidtrack.dto.SummaryApiResponse;
import com.turkmen.covidtrack.model.Country;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by turkmenmustafademirci on 6/21/20.
 */

@Repository
@Getter
public class CovidRepository {

    Logger logger = LoggerFactory.getLogger(CovidRepository.class);

    @Value( "${covid.data.url}" )
    private String covidDataUrl;

    @Autowired
    RestTemplate restTemplate;

    private SummaryApiResponse summaryApiResponse=new SummaryApiResponse();


    @PostConstruct
    @Scheduled(cron = "* 1 1 * * *")
    public void getCovidInfo() throws IOException {
        logger.info("IN GET COVID INFO METHOD.......");

//        List<Country> newSummaries = new ArrayList();//in order to allow concurrent calls work smoothly every time a new list is created then the main list populated


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SummaryApiResponse> response = restTemplate.getForEntity(covidDataUrl,SummaryApiResponse.class);
        SummaryApiResponse summaryApiResponse = response.getBody();

        this.summaryApiResponse = summaryApiResponse;

        logger.info("COVID INFO SUMMARY FETCHED.......");


    }




}

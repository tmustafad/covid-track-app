package com.turkmen.covidtrack.service;


import com.turkmen.covidtrack.model.Location;
import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by turkmenmustafademirci on 6/20/20.
 */

@Service
@Getter
public class CovidDataService {

    Logger logger = LoggerFactory.getLogger(CovidDataService.class);


    private static String COVID_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    // TODO  This is a bad practice , in service layer u should not keep state!!
    private List<Location> locations= new ArrayList();



    @PostConstruct
    @Scheduled(cron = "* 1 1 * * *")
    public void getCovidInfo() throws IOException {
        logger.info("IN GET COVID INFO METHOD.......");

        List<Location> newLocations= new ArrayList();//in order to allow concurrent calls work smoothly every time a new list is created then the main list populated

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(URI.create(COVID_DATA_URL));

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpClient.execute(request,responseHandler);
        StringReader csvBodyReader=new StringReader(responseBody);

        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {

            Location location=new Location();
            location.setProvince(record.get("Province/State"));
            location.setCountry(record.get("Country/Region"));
            int currentCases=Integer.parseInt(record.get(record.size()-1));
            int prevDayCases=Integer.parseInt(record.get(record.size()-2));
            location.setTotalConfirmedCases(currentCases);
            location.setDelta(currentCases-prevDayCases);
            logger.info(location.toString());
            newLocations.add(location);
        }
        this.locations=newLocations;


    }
}

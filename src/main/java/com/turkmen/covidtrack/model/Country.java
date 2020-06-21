package com.turkmen.covidtrack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by turkmenmustafademirci on 6/20/20.
 */

@Getter @Setter @NoArgsConstructor @ToString
public class Country {


    @JsonProperty("Country")
    private String country;

    @JsonProperty("Slug")
    private String slug;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("NewConfirmed")
    private int newConfirmed;

    @JsonProperty("TotalConfirmed")
    private int totalConfirmed;

    @JsonProperty("NewDeaths")
    private int newDeaths;

    @JsonProperty("TotalDeaths")
    private int totalDeaths;

    @JsonProperty("NewRecovered")
    private int newRecovered;

    @JsonProperty("TotalRecovered")
    private int totalRecovered;

    @JsonProperty("Date")
    private Date date;







}

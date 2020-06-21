package com.turkmen.covidtrack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by turkmenmustafademirci on 6/21/20.
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Global {

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
}

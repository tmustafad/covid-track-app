package com.turkmen.covidtrack.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.turkmen.covidtrack.model.Country;
import com.turkmen.covidtrack.model.Global;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Created by turkmenmustafademirci on 6/21/20.
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SummaryApiResponse {

    @JsonProperty("Global")
    private Global global;

    @JsonProperty("Countries")
    private List<Country> countries;

    @JsonProperty("Date")
    private Date date;

}

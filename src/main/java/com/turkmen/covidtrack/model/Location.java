package com.turkmen.covidtrack.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by turkmenmustafademirci on 6/20/20.
 */

@Getter @Setter @NoArgsConstructor @ToString
public class Location {

    private String province;

    private String country;

    private int totalConfirmedCases;

    private int delta;

}

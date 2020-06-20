package com.turkmen.covidtrack.controller;

import com.turkmen.covidtrack.model.Location;
import com.turkmen.covidtrack.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 6/20/20.
 */

@Controller // this is not a rest controller  , this controller is used to map ther incoming request to  an html template
public class Main {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/")
    public String main(Model model){
        List<Location> locations=covidDataService.getLocations();
        int totalConfirmedCases=locations.stream().mapToInt(i->i.getTotalConfirmedCases()).sum();
        int totalNewCases=locations.stream().mapToInt(i->i.getDelta()).sum();
        model.addAttribute("locations",locations);
        model.addAttribute("totalConfirmedCases",totalConfirmedCases);
        model.addAttribute("totalNewCases",totalNewCases);
        return "main";
    }

}

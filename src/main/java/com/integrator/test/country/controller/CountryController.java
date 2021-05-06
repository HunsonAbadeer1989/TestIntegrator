package com.integrator.test.country.controller;

import com.integrator.test.country.service.CountryService;
import com.integrator.test.country.view.CountryView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "CountryController")
@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @ApiOperation(value = "получить список стран", httpMethod = "GET")
    @GetMapping(value = "/")
    public List<CountryView> getAllCountries() {
        return countryService.getAllCountries();
    }

}

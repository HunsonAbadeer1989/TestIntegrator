package com.integrator.test.country.service;

import com.integrator.test.country.dao.CountryDao;
import com.integrator.test.country.model.Country;
import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.country.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryView> getAllCountries() {
        List<Country> allCountries = countryDao.all();
        return allCountries.stream().map(mapCountry()).collect(Collectors.toList());
    }

    private Function<Country, CountryView> mapCountry() {
        return country -> {
            CountryView countryView = new CountryView();
            countryView.setCode(country.getCitizenshipCode());
            countryView.setName(country.getCitizenshipName());
            return countryView;
        };
    }

}

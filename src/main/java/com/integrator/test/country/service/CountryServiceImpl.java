package com.integrator.test.country.service;

import com.integrator.test.country.dao.CountryDao;
import com.integrator.test.country.model.Country;
import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.country.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao, MapperFacade mapperFacade) {
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryView> getAllCountries() {
        List<Country> allCountries = countryDao.all();
        return mapperFacade.mapAsList(allCountries, CountryView.class);
    }

    /**
     * @param code
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public CountryView getCountryByCode(String code) {
//        List<Country> listCountries = countryDao.loadByCode(code);
        Country countryByCode = countryDao.loadByCode(code);
        return mapperFacade.map(countryByCode, CountryView.class);
    }
}

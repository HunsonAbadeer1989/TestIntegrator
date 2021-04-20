package com.integrator.test.country.service;

import com.integrator.test.country.view.CountryView;

import java.util.List;

/**
 * Сервис
 */
public interface CountryService {

    /**
     * Получить список стран
     * @return
     */
    List<CountryView> getAllCountries();

    /**
     * Получить страну по коду
     * @param code
     * @return
     */
    CountryView getCountryByCode(String code);

}

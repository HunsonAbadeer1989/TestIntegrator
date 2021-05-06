package com.integrator.test.country.service;

import com.integrator.test.country.view.CountryView;

import java.util.List;

/**
 * Сервис
 */
public interface CountryService {

    /**
     * Получить список стран
     * void
     * @return List<CountryView>
     */
    List<CountryView> getAllCountries();

}

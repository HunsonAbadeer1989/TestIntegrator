package com.integrator.test.country.dao;


import com.integrator.test.country.model.Country;
import com.integrator.test.country.view.CountryView;

import java.util.List;

/**
 * DAO для работы с Country
 */
public interface CountryDao {

    /**
     * Получить все страны
     *
     * @return
     */
    List<Country> all();

    /**
     * Получить название страны по коду
     *
     * @param code
     * @return
     */
    Country loadByCode(String code);

}
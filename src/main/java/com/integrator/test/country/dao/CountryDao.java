package com.integrator.test.country.dao;


import com.integrator.test.country.model.Country;

import java.util.List;

/**
 * DAO для работы с Country
 */
public interface CountryDao {

    /**
     * Получить все страны
     *
     * @return  List<Country>
     */
    List<Country> all();

    /**
     * Получить название страны по коду
     *
     * @param code - код страны
     * @return Country
     */
    Country loadByCode(String code);

}

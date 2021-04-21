package com.integrator.test.organization.dao;

import com.integrator.test.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с организацией
 */
public interface OrganizationDao {

    /**
     * Получить список организаций согласно параметрам
     *
     * @param name      - название организации
     * @param inn       - ИНН организации
     * @param is_active - статус активности
     * @return List<Organization>
     */
    List<Organization> loadListByParams(String name, String inn, Boolean is_active);

    /**
     * Получить организацию по идентификатору
     *
     * @param id - ID огранизации
     * @return Organization
     */
    Organization loadById(Long id);

    /**
     * Получить список всех организаций
     *
     * @return List<Organization>
     */
    List<Organization> all();

    /**
     * Получить организацию по идентификатору
     *
     * @param id - ID огранизации
     * @param organization - огранизация
     */
    void updateOrganization(Long id, Organization organization);

    /**
     * Сохранить Organization
     * @param newOrg - организация
     */
    void save(Organization newOrg);

}

package com.integrator.test.organization.service;

import com.integrator.test.organization.view.OrganizationListInView;
import com.integrator.test.organization.view.OrganizationListOutView;
import com.integrator.test.organization.view.OrganizationView;
import com.integrator.test.organization.view.ResultEntity;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {

    /**
     * Получить список организаций
     * @param view
     * @return List<OrganizationListOutView>
     */
    List<OrganizationListOutView> getListOfOrgs(OrganizationListInView view);

    /**
     * Получить организацию по идентификатору
     * @param id
     * @return OrganizationView
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Добавление новой организации
     * @param organizationView - организация
     */
    void saveOrganization(OrganizationView organizationView);

    /**
     * Изменение существующей организации
     * @param id - идентификатор организации
     * @param organizationView - организация
     */
    void updateOrganization(Long id ,OrganizationView organizationView);
}
package com.integrator.test.organization.service;

import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.organization.dao.OrganizationDao;
import com.integrator.test.organization.model.Organization;
import com.integrator.test.organization.view.OrganizationListInView;
import com.integrator.test.organization.view.OrganizationListOutView;
import com.integrator.test.organization.view.OrganizationView;
import com.integrator.test.organization.view.ResultEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    public final OrganizationDao organizationDao;
    public final MapperFacade mapperFacade;

    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationListOutView> getListOfOrgs(OrganizationListInView view) {
        List<Organization> organizations = organizationDao.loadListByParams(
                                                                            view.getName(),
                                                                            view.getInn(),
                                                                            view.getIsActive());
        return mapperFacade.mapAsList(organizations, OrganizationListOutView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.loadById(id);
        return mapperFacade.map(organization, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultEntity saveOrganization(OrganizationView organizationView) {
        Organization newOrg = new Organization(
                organizationView.getName(),
                organizationView.getFullName(),
                organizationView.getInn(),
                organizationView.getKpp(),
                organizationView.getAddress(),
                organizationView.getPhone(),
                organizationView.getIsActive()
        );
        organizationDao.save(newOrg);
        return new ResultEntity("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultEntity updateOrganization(Long id ,OrganizationView organizationView) {
        Organization newOrg = new Organization(
                organizationView.getName(),
                organizationView.getFullName(),
                organizationView.getInn(),
                organizationView.getKpp(),
                organizationView.getAddress(),
                organizationView.getPhone(),
                organizationView.getIsActive()
        );
        organizationDao.updateOrganization(organizationView.getId(), newOrg);
        return new ResultEntity("success");
    }

}

package com.integrator.test.organization.dao;

import com.integrator.test.country.model.Country;
import com.integrator.test.organization.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> loadListByParams(String name, String inn, Boolean active) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> tempQuery = cb.createQuery(Organization.class);
        Root<Organization> org = tempQuery.from(Organization.class);
        tempQuery.select(org);

        Predicate predicate = cb.like(cb.lower(org.get("name")), "%" + name.toLowerCase() + "%");
        if (inn != null && !inn.equals("")){
            predicate = cb.and(predicate, cb.equal(org.get("inn"), inn));
        }
        if (active != null){
            predicate = cb.and(predicate, cb.equal(org.get("isActive"), active));
        }
        tempQuery.where(predicate);

        TypedQuery<Organization> query = entityManager.createQuery(tempQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id) {
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> all() {
        String query = "SELECT o FROM Organization o";
        TypedQuery<Organization> all = entityManager.createQuery(query, Organization.class);
        return all.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrganization(Long id, Organization organization) {
        Organization newOrganization = loadById(id);
        newOrganization.setAddress(organization.getAddress());
        newOrganization.setFullName(organization.getFullName());
        newOrganization.setInn(organization.getInn());
        newOrganization.setKpp(organization.getKpp());
        newOrganization.setName(organization.getName());
        if (organization.getPhone() != null) {
            newOrganization.setPhone(organization.getPhone());
        }
        if (organization.getIsActive() != null) {
            newOrganization.setIsActive(organization.getIsActive());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization newOrg) {
        entityManager.persist(newOrg);
    }

}

package com.integrator.test.organization.dao;

import com.integrator.test.exception.OrganizationException;
import com.integrator.test.exception.WrongInputException;
import com.integrator.test.organization.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

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
    @Transactional(readOnly = true)
    public List<Organization> loadListByParams(String name, String inn, Boolean active) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> tempQuery = cb.createQuery(Organization.class);
        Root<Organization> org = tempQuery.from(Organization.class);
        tempQuery.select(org);

        if (name.isBlank()) {
            throw new OrganizationException("Не задано имя организации");
        }
        Predicate predicate = cb.equal(org.get("name"), name);

        if (!inn.isBlank()){
            predicate = cb.and(predicate, cb.equal(org.get("inn"), inn));
        }

        if (Objects.isNull(active)){
            throw new WrongInputException("Не задан параметр активности организации");
        }
        else{
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
    @Transactional(readOnly = true)
    public Organization loadById(Long id) {
        if(Objects.isNull(id)){
            throw new OrganizationException("Не задан id организации");
        }
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Organization> all() {
        String query = "SELECT o FROM Organization o";
        TypedQuery<Organization> all = entityManager.createQuery(query, Organization.class);
        return all.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOrganization(Long id, Organization organization) {
        Organization newOrganization = entityManager.find(Organization.class, id);
        if(!Objects.nonNull(newOrganization)){
            throw new OrganizationException("Нет организации с id=" + id);
        }
        if(checkParams(organization)) {
            newOrganization.setName(organization.getName());
            newOrganization.setFullName(organization.getFullName());
            newOrganization.setInn(organization.getInn());
            newOrganization.setKpp(organization.getKpp());
            newOrganization.setAddress(organization.getAddress());
        }
        if (organization.getPhone().isBlank()) {
            newOrganization.setPhone(organization.getPhone());
        }
        if (Objects.nonNull(organization.getIsActive())) {
            newOrganization.setIsActive(organization.getIsActive());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(Organization newOrg) {
        if(checkParams(newOrg)){
            entityManager.persist(newOrg);
        }
    }

    public boolean checkParams(Organization org){
        if(org.getName().isBlank()){
            throw new WrongInputException("Не задано название организации");
        }
        if(org.getFullName().isBlank()){
            throw new WrongInputException("Не задано полное название организации");
        }
        if(org.getInn().isBlank()){
            throw new WrongInputException("Не задан ИНН организации");
        }
        if(org.getKpp().isBlank()){
            throw new WrongInputException("Не задан КПП организации");
        }
        if(org.getAddress().isBlank()){
            throw new WrongInputException("Не задан адрес организации");
        }
        return true;
    }

}

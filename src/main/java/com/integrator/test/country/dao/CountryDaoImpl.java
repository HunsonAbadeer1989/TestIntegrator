package com.integrator.test.country.dao;

import com.integrator.test.country.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager entityManager;

    @Autowired
    public CountryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> all() {
        /* Get all countries by JPQL */
        String query = "SELECT c FROM Country c";
        TypedQuery<Country> all = entityManager.createQuery(query, Country.class);
        return all.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /* Get one country by code through Criteria Api */
    public Country loadByCode(String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);

        Root<Country> countryRoot = criteriaQuery.from(Country.class);
        criteriaQuery.where(countryRoot.get("code").in(code));
        criteriaQuery.select(countryRoot);

        TypedQuery<Country> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country getCountryById(Long id){
        String query = "SELECT c FROM Country c WHERE id=:id";
        TypedQuery<Country> all = entityManager.createQuery(query, Country.class);
        return all.getSingleResult();
    }

}

package com.integrator.test.office.dao;

import com.integrator.test.office.model.Office;
import com.integrator.test.office.view.OfficeView;
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

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Office loadById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);

        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        criteriaQuery.where(officeRoot.get("id").in(id));
        criteriaQuery.select(officeRoot);

        TypedQuery<Office> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Office> loadOfficeList(Organization org, String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
        Root<Office> office = criteriaQuery.from(Office.class);
        criteriaQuery.select(office);

        Predicate mainPredicate = builder.equal(office.get("organization"), org);
        if (name != null && !name.equals("")){
            Predicate officeName = builder.like(builder.lower(office.get("name")), "%" + name.toLowerCase() + "%");
            mainPredicate = builder.and(mainPredicate, officeName);
        }
        if (phone != null && !phone.equals("")){
            Predicate officePhone = builder.like(office.get("phone"), "%" + phone + "%");
            mainPredicate = builder.and(mainPredicate, officePhone);
        }
        if (isActive != null) {
            Predicate officeIsActive = builder.equal(office.get("isActive"), isActive);
            mainPredicate = builder.and(mainPredicate, officeIsActive);
        }
        criteriaQuery.where(mainPredicate);
        TypedQuery<Office> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(Long id, OfficeView officeView) {
        Office renewableOffice = loadById(id);
        renewableOffice.setName(officeView.getName());
        renewableOffice.setAddress(officeView.getAddress());
        if (officeView.getPhone() != null) {
            renewableOffice.setPhone(officeView.getPhone());
        }
        if (officeView.getIsActive() != null ) {
            renewableOffice.setIsActive(officeView.getIsActive());
        }
        entityManager.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(Office office) {
        entityManager.persist(office);
    }
}

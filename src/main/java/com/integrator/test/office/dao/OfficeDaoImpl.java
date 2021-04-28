package com.integrator.test.office.dao;

import com.integrator.test.exception.OfficeException;
import com.integrator.test.exception.OrganizationException;
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
import java.util.Objects;

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
        if (Objects.isNull(id)) {
            throw new OfficeException("Не задан id офиса");
        }
        Office office = entityManager.find(Office.class, id);
        if (Objects.isNull(office)) {
            throw new OfficeException("Нет офиса с id=" + id);
        }
        return office;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Office> loadOfficeList(Long orgId, String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
        Root<Office> office = criteriaQuery.from(Office.class);
        criteriaQuery.select(office);

        if (!Objects.nonNull(orgId)) {
            throw new OrganizationException("Не задан id организации");
        }
        Predicate mainPredicate = builder.equal(office.get("organization").get("id"), orgId);

        if (name.isBlank()) {
            Predicate officeName = builder.equal(office.get("name"), name);
            mainPredicate = builder.and(mainPredicate, officeName);
        }

        if (phone.isBlank()) {
            Predicate officePhone = builder.like(office.get("phone"), "%" + phone + "%");
            mainPredicate = builder.and(mainPredicate, officePhone);
        }

        if (!Objects.nonNull(isActive)) {
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
        Office renewableOffice = entityManager.find(Office.class, id);
        if (Objects.isNull(renewableOffice)) {
            throw new OfficeException("Нет офиса с id=" + id);
        }

        if (!officeView.getName().isBlank()) {
            throw new OfficeException("Не указано назввание офиса");
        }
        renewableOffice.setName(officeView.getName());

        if (!officeView.getAddress().isBlank()) {
            throw new OfficeException("Не указан адресс офиса");
        }
        renewableOffice.setAddress(officeView.getAddress());

        if (officeView.getPhone().isBlank()) {
            renewableOffice.setPhone(officeView.getPhone());
        }

        if (officeView.getIsActive() != null) {
            renewableOffice.setIsActive(officeView.getIsActive());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(Office office, Long orgId) {
        if (Objects.isNull(orgId)) {
            throw new OrganizationException("Не указан id организации");
        }
        Organization organization = entityManager.find(Organization.class, orgId);
        if(Objects.isNull(organization)){
            throw new OrganizationException("Нет организации с id=" + orgId);
        }
        office.setOrganization(organization);
        entityManager.persist(office);
    }
}

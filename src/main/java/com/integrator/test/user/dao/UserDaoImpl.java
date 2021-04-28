package com.integrator.test.user.dao;

import com.integrator.test.office.model.Office;
import com.integrator.test.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.where(userRoot.get("id").in(id));
        criteriaQuery.select(userRoot);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public List<User> getUsersList(@RequestParam Office officeById,
                                              @RequestParam(defaultValue = "%%") String firstName,
                                              @RequestParam(defaultValue = "%%")String secondName,
                                              @RequestParam(defaultValue = "%%")String middleName,
                                              @RequestParam(defaultValue = "%%")String position,
                                              @RequestParam(defaultValue = "%%")String docCode,
                                              @RequestParam(defaultValue = "true")String citizenshipCode) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user);
        Predicate mainPredicate = builder.equal(user.get("office"), officeById);

        mainPredicate = builder.and(mainPredicate, builder.like(builder.lower(user.get("firstName")), firstName.toLowerCase()));
        mainPredicate = builder.and(mainPredicate, builder.like(builder.lower(user.get("secondName")), secondName.toLowerCase()));
        mainPredicate = builder.and(mainPredicate, builder.like(builder.lower(user.get("middleName")), middleName.toLowerCase()));
        mainPredicate = builder.and(mainPredicate, builder.like(builder.lower(user.get("position")), position.toLowerCase()));
        mainPredicate = builder.and(mainPredicate, builder.like(builder.lower(user.get("docCode")), docCode.toLowerCase()));
        mainPredicate = builder.and(mainPredicate, builder.like(builder.lower(user.get("citizenshipCode")), citizenshipCode.toLowerCase()));
        criteriaQuery.where(mainPredicate);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}

package com.integrator.test.user.dao;

import com.integrator.test.document.dao.DocumentDao;
import com.integrator.test.document.model.Document;
import com.integrator.test.exception.UserException;
import com.integrator.test.exception.WrongInputException;
import com.integrator.test.office.model.Office;
import com.integrator.test.user.model.User;
import com.integrator.test.user.view.UserView;
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
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;
    private final DocumentDao documentDao;

    @Autowired
    public UserDaoImpl(EntityManager entityManager, DocumentDao documentDao) {
        this.entityManager = entityManager;
        this.documentDao = documentDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if (Objects.isNull(user)) {
            throw new UserException("Нет пользователя с таким id " + id);
        }
        return user;
    }

    @Override
    public List<User> getUsersList(Long officeId, User user, String docCode) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> rootUser = criteriaQuery.from(User.class);
        criteriaQuery.select(rootUser);
        if (!Objects.nonNull(officeId)) {
            throw new UserException("Не задан id офиса");
        }
        Office office = entityManager.find(Office.class, officeId);
        if (Objects.isNull(office)) {
            throw new UserException("Нет офиса с id = " + officeId);
        }
        Predicate mainPredicate = builder.equal(rootUser.get("office"), officeId);
        if (!user.getFirstName().isBlank()) {
            mainPredicate = builder.and(mainPredicate, builder.equal(rootUser.get("firstName"), user.getFirstName()));
        }
        if (!user.getSecondName().isBlank()) {
            mainPredicate = builder.and(mainPredicate, builder.equal(rootUser.get("secondName"), user.getSecondName()));
        }
        if (!user.getMiddleName().isBlank()) {
            mainPredicate = builder.and(mainPredicate, builder.equal(rootUser.get("middleName"), user.getMiddleName()));
        }
        if (!user.getPosition().isBlank()) {
            mainPredicate = builder.and(mainPredicate, builder.equal(rootUser.get("position"), user.getPosition()));
        }

        if (user.getDocument() != null && user.getDocument().getDocType() != null && user.getDocument().getDocType().getCode() != null) {
            mainPredicate = builder.and(mainPredicate,
                    builder.like(rootUser.get("userDocument").get("documentType").get("docCode"),
                            "%" + user.getDocument().getDocType().getCode() + "%"));
        }
        if (user.getCitizenshipCode() != null && user.getCitizenshipCode().getCitizenshipCode() != null) {
            mainPredicate = builder.and(mainPredicate, builder.like(rootUser.get("country").get("citizenshipCode"),
                            "%" + user.getCitizenshipCode().getCitizenshipCode() + "%"));
        }

        criteriaQuery.where(mainPredicate);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateUser(UserView updUsr, String docCode) {
        if (Objects.isNull(updUsr.getId()) || updUsr.getFirstName().isBlank() || updUsr.getPosition().isBlank()) {
            throw new WrongInputException("Введите обязательные параметры Id, имя пользователя и должность");
        }
        User user = entityManager.find(User.class, updUsr.getId());
        if (Objects.isNull(user)) {
            throw new UserException("Нет пользователя с таким id =" + updUsr.getId());
        }
        user.setFirstName(updUsr.getFirstName());
        if (!updUsr.getSecondName().isBlank()) {
            user.setSecondName(updUsr.getSecondName());
        }
        if (!updUsr.getMiddleName().isBlank()) {
            user.setMiddleName(updUsr.getMiddleName());
        }
        if (!updUsr.getPhone().isBlank()) {
            user.setPhone(updUsr.getPhone());
        }
        if (!updUsr.getPosition().isBlank()) {
            user.setPosition(updUsr.getPosition());
        }
        user.setIsIdentified(updUsr.getIsIdentified());

    }

    @Override
    @Transactional
    public void saveUser(UserView userView, Long id, Document doc) {
        if (Objects.isNull(id) || userView.getFirstName().isBlank() || userView.getPosition().isBlank()) {
            throw new WrongInputException("Введите обязательные параметры Id, имя пользователя и должность");
        }
        Office office = entityManager.find(Office.class, id);
        if (Objects.isNull(office)) {
            throw new UserException("Office not exist");
        }

        User newUser = new User();
        newUser.setOffice(office);
        newUser.setFirstName(userView.getFirstName());
        newUser.setSecondName(userView.getSecondName());
        newUser.setMiddleName(userView.getMiddleName());
        newUser.setPhone(userView.getPhone());
        newUser.setDocument(doc);
        newUser.setPosition(userView.getPosition());
        newUser.setIsIdentified(userView.getIsIdentified());

        entityManager.persist(newUser);
    }

}
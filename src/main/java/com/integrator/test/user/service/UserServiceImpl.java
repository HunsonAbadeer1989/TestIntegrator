package com.integrator.test.user.service;

import com.integrator.test.country.dao.CountryDao;
import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.document.dao.DocumentDao;
import com.integrator.test.document.dao.DocumentTypeDao;
import com.integrator.test.document.model.Document;
import com.integrator.test.document.model.DocumentType;
import com.integrator.test.office.dao.OfficeDao;
import com.integrator.test.user.dao.UserDao;
import com.integrator.test.user.model.User;
import com.integrator.test.user.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final CountryDao countryDao;
    private final DocumentDao documentDao;
    private final DocumentTypeDao documentTypeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, MapperFacade mapperFacade, CountryDao countryDao, DocumentDao documentDao, DocumentTypeDao documentTypeDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
        this.countryDao = countryDao;
        this.documentDao = documentDao;
        this.documentTypeDao = documentTypeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserView getUserById(Long id) {
        User userById = userDao.getUserById(id);
        UserView userView = mapperFacade.map(userById, UserView.class);
        userView.setDocNumber(userById.getDocument().getDocNumber());
        userView.setDocDate(userById.getDocument().getDocDate().toString());
        DocumentType docType = documentTypeDao.findByCode(Integer.valueOf(userById.getDocument().getDocCode()));
        userView.setDocName(docType.getName());
        return userView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserListOutView> getListOfUsers(UserView userListInView) {
        User user = mapperFacade.map(userListInView, User.class);
        Long officeId = userListInView.getOfficeId();
        String code = userListInView.getDocCode();
        List<User> usersList = userDao.getUsersList(officeId, user, code);
        return mapperFacade.mapAsList(usersList, UserListOutView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(UserView user) {
        String code = user.getDocCode();
        userDao.updateUser(user, code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveUser(UserView user) {
        Long id = user.getOfficeId();
        Document document = documentDao.findByDocCode(user.getDocCode());
//        User saveUser = mapperFacade.map(user, User.class);
        userDao.saveUser(user, id, document);
    }
}

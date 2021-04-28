package com.integrator.test.user.service;

import com.integrator.test.country.dao.CountryDao;
import com.integrator.test.country.model.Country;
import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.office.dao.OfficeDao;
import com.integrator.test.office.model.Office;
import com.integrator.test.user.dao.UserDao;
import com.integrator.test.user.model.User;
import com.integrator.test.user.view.UserListInView;
import com.integrator.test.user.view.UserListOutView;
import com.integrator.test.user.view.UserUpdateView;
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
    private final MapperFacade mapperFacade;
    private final CountryDao countryDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, MapperFacade mapperFacade, CountryDao countryDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateView getUserById(Long id) {
        User userById = userDao.getUserById(id);
        return mapperFacade.map(userById, UserUpdateView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserListOutView> getListOfUsers(UserListInView userListInView) {
        Office officeById = officeDao.loadById(userListInView.getOfficeId());
        String firstName = userListInView.getFirstName();
        String lastName = userListInView.getLastName();
        String middleName = userListInView.getMiddleName();
        String position = userListInView.getPosition();
        String docCode = userListInView.getDocCode();
        Country citizenshipCode = countryDao.loadByCode(userListInView.getCitizenshipCode());
        List<User> usersList = userDao.getUsersList(officeById, firstName, lastName, middleName,
                                                                position, docCode, citizenshipCode.toString());
        return mapperFacade.mapAsList(usersList, UserListOutView.class);
    }
}

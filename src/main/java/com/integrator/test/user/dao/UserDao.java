package com.integrator.test.user.dao;

import com.integrator.test.office.model.Office;
import com.integrator.test.user.model.User;
import com.integrator.test.user.view.UserListOutView;

import java.util.List;

/**h
 * Слой связи с БД для сотрудника
 */
public interface UserDao {

    /**
     * Получение списока сотрудников по фильтру
     *
     * @param id - идентификатор сотрудника
     * @return UserUpdateView
     */
    User getUserById(Long id);

    /**
     * Получение списока сотрудников по фильтру
     *
     * @param officeById - Офис сотрудника
     * @param firstName - идентификатор сотрудника
     * @return UserUpdateView
     */
    List<User> getUsersList(Office officeById,
                            String firstName,
                            String lastName,
                            String middleName,
                            String position,
                            String docCode,
                            String citizenshipCode);
}

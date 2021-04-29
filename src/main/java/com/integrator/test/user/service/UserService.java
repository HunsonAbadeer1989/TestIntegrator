package com.integrator.test.user.service;

import com.integrator.test.user.model.User;
import com.integrator.test.user.view.*;

import java.util.List;

/**
 * Сервис для сотрудника
 */
public interface UserService {

    /**
     * Получение списока сотрудников по фильтру
     * @param id - идентификатор сотрудника
     * @return UserView
     */
    UserView getUserById(Long id);

    /**
     * Получение списока сотрудников по фильтру
     * @param userListInView - паретры сотрудников
     * @return UserListOutView
     */
    List<UserListOutView> getListOfUsers(UserView userListInView);

    /**
     * Обновление сотрудника
     * @param user - параметр сотрудника
     * @return void
     */
    void updateUser(UserView user);

    /**
     * Добавлние сотрудника
     * @param user - параметр сотрудника
     * @return void
     */
    void saveUser(UserView user);
}

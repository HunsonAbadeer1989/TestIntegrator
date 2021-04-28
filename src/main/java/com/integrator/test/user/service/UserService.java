package com.integrator.test.user.service;

import com.integrator.test.user.view.UserListInView;
import com.integrator.test.user.view.UserListOutView;
import com.integrator.test.user.view.UserUpdateView;

import java.util.List;

/**
 * Сервис для сотрудника
 */
public interface UserService {

    /**
     * Получение списока сотрудников по фильтру
     * @param id - идентификатор сотрудника
     * @return UserUpdateView
     */
    UserUpdateView getUserById(Long id);

    /**
     * Получение списока сотрудников по фильтру
     * @param userListInView - паретры сотрудников
     * @return UserListOutView
     */
    List<UserListOutView> getListOfUsers(UserListInView userListInView);
}

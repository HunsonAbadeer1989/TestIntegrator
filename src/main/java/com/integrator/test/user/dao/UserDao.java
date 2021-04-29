package com.integrator.test.user.dao;

import com.integrator.test.document.model.Document;
import com.integrator.test.user.model.User;
import com.integrator.test.user.view.UserView;

import java.util.List;

/**h
 * Слой связи с БД для сотрудника
 */
public interface UserDao {

    /**
     * Получение списока сотрудников по фильтру
     *
     * @param id - идентификатор сотрудника
     * @return User
     */
    User getUserById(Long id);

    /**
     * Получение списока сотрудников по фильтру
     *
     * @param officeId - id офиса
     * @param userParam - параметры сотрудника
     * @param docCode - код документа
     * @return List<User>
     */
    List<User> getUsersList(Long officeId ,User userParam, String docCode);

    /**
     * Обновление сотрудника
     *
     * @param user - параметры сотрудника
     * @return void
     */
    void updateUser(UserView user, String docCOde);

    /**
     * Добавление сотрудника
     *
     * @param user - параметры сотрудника
     * @param id
     * @param doc
     * @return void
     */
    void saveUser(UserView user, Long id, Document doc);
}

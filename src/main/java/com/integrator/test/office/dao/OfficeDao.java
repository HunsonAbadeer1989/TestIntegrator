package com.integrator.test.office.dao;

import com.integrator.test.office.model.Office;
import com.integrator.test.office.view.OfficeView;

import java.util.List;

/**
 * DAO для работы с офисом
 */
public interface OfficeDao {

    /**
     *  Получение офиса по идентификатору
     * @param id - идентификатор офиса
     * @return Office
     */
    Office loadById(Long id);

    /**
     *  Получение офиса по идентификатору
     * @param orgId - организация
     * @param name - наименование офиса
     * @param phone - телефон офиса
     * @param isActive - статус активности офиса
     * @return List<Office>
     */
    List<Office> loadOfficeList(Long orgId, String name, String phone, Boolean isActive);

    /**
     *  Обновление офиса
     * @param id - идентификатор офиса
     * @param officeView - офис для обновления
     */
    void updateOffice(Long id, OfficeView officeView);

    /**
     *  Сохранение офиса
     * @param office - офис для сохранения
     * @param orgId - id организации
     */
    void save(Office office, Long orgId);
}

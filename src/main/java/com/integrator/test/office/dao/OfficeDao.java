package com.integrator.test.office.dao;

import com.integrator.test.office.model.Office;
import com.integrator.test.office.view.OfficeForSaveView;
import com.integrator.test.office.view.OfficeListInView;
import com.integrator.test.office.view.OfficeView;
import com.integrator.test.organization.model.Organization;
import com.integrator.test.organization.view.ResultEntity;

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
     * @param org - организация
     * @param name - наименование офиса
     * @param phone - телефон офиса
     * @param isActive - статус активности офиса
     * @return List<Office>
     */
    List<Office> loadOfficeList(Organization org, String name, String phone, Boolean isActive);

    /**
     *  Обновление офиса
     * @param id - идентификатор офиса
     * @param officeView - офис для обновления
     * @return
     */
    void updateOffice(Long id, OfficeView officeView);

    /**
     *  Сохранение офиса
     * @param office - офис для сохранения
     * @return
     */
    void save(Office office);
}

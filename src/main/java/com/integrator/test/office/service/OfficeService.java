package com.integrator.test.office.service;

import com.integrator.test.office.view.OfficeForSaveView;
import com.integrator.test.office.view.OfficeListInView;
import com.integrator.test.office.view.OfficeListOutView;
import com.integrator.test.office.view.OfficeView;
import com.integrator.test.organization.view.ResultEntity;

import java.util.List;

/**
 * Сервис офиса
 */
public interface OfficeService {

    /**
     * Получение офиса по идентификатору
     * @param id - идентификатор офиса
     * @return Office
     */
    OfficeView getOfficeById(Long id);

    /**
     * Получение списка офисов по параметрам
     * @param officeListInView - параметры офиса
     * @return List<OfficeListOutView>
     */
    List<OfficeListOutView> getOfficesList(OfficeListInView officeListInView);

    /**
     * Обновление офиса
     * @param id - новый офис
     * @param officeView - новый офис
     * @return ResultEntity
     */
    ResultEntity updateOffice(Long id , OfficeView officeView);

    /**
     * Сохранение нового офиса
     * @param officeForSaveView - офис для сохранения в базе
     * @return ResultEntity
     */
    ResultEntity saveOffice(OfficeForSaveView officeForSaveView);
}

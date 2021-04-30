package com.integrator.test.office.controller;

import com.integrator.test.office.service.OfficeService;
import com.integrator.test.office.view.OfficeForSaveView;
import com.integrator.test.office.view.OfficeListInView;
import com.integrator.test.office.view.OfficeListOutView;
import com.integrator.test.office.view.OfficeView;
import com.integrator.test.organization.view.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController")
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService){
        this.officeService = officeService;
    }

    @ApiOperation(value = "Получение офиса по id", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable Long id){
        return officeService.getOfficeById(id);
    }

    @ApiOperation(value = "Получение списка офисов согласно параметрам", httpMethod = "POST")
    @PostMapping(value = "/list")
    public List<OfficeListOutView> getOfficeListByParams(@RequestBody OfficeListInView officeListInView){
        return officeService.getOfficesList(officeListInView);
    }

    @ApiOperation(value = "Обновление офиса", httpMethod = "POST")
    @PostMapping(value = "/update")
    public void updateOffice(@RequestBody OfficeView officeView){
        Long id = officeView.getId();
        officeService.updateOffice(id ,officeView);
    }

    @ApiOperation(value = "Сохранение нового офиса", httpMethod = "POST")
    @PostMapping(value = "/save")
    public void saveOffice(@RequestBody OfficeForSaveView officeForSaveView){
        officeService.saveOffice(officeForSaveView);
    }

}

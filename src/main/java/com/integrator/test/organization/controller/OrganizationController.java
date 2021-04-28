package com.integrator.test.organization.controller;

import com.integrator.test.organization.service.OrganizationService;
import com.integrator.test.organization.view.OrganizationListInView;
import com.integrator.test.organization.view.OrganizationListOutView;
import com.integrator.test.organization.view.OrganizationView;
import com.integrator.test.organization.view.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить список организаций по параметрам", httpMethod = "POST")
    @PostMapping(value = "/list")
    public List<OrganizationListOutView> getOrganizationsByParams(@RequestBody OrganizationListInView listInView){
        return organizationService.getListOfOrgs(listInView);
    }

    @ApiOperation(value = "Получить организацию по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@PathVariable Long id){
        return organizationService.getOrganizationById(id);
    }

    @ApiOperation(value = "Сохранить организацию", httpMethod = "POST")
    @PostMapping(value = "/save")
    public ResultEntity saveOrganization(@RequestBody OrganizationView organizationView){
        organizationService.saveOrganization(organizationView);
        return  new ResultEntity("success");
    }

    @ApiOperation(value = "Редактировать организацию")
    @PostMapping(value = "/update")
    public ResultEntity updateOrganization(Long id ,@RequestBody OrganizationView organizationView){
        organizationService.updateOrganization(id, organizationView);
        return  new ResultEntity("success");
    }

}

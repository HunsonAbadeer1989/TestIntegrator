package com.integrator.test.organization.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "organization")
@Getter
@Setter
public class OrganizationView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true)
    public Long id;

    @Size(max = 50)
    @NotEmpty
    @ApiModelProperty(value = "Название организации")
    public String name;

    @Size(max = 500)
    @NotEmpty
    @ApiModelProperty(value = "Полное название организации")
    public String fullName;

    @Size(max = 12)
    @NotEmpty
    @ApiModelProperty(value = "ИНН организации")
    public String inn;

    @Size(max = 10)
    @NotEmpty
    @ApiModelProperty(value = "КПП организации")
    public String kpp;

    @Size(max = 500)
    @NotEmpty
    @ApiModelProperty(value = "Адрес организации")
    public String address;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон организации")
    public String phone;

    @ApiModelProperty(value = "Статус активности организации")
    public Boolean isActive;

}
package com.integrator.test.office.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Api(value = "Представление офиса")
@Getter
@Setter
public class OfficeView {

    @ApiModelProperty(value = "Уникальный идентификатор офиса")
    private Long id;

    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса")
    private String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Адрес офиса")
    private String address;

    @ApiModelProperty(value = "Телефонный номер офиса")
    private String phone;

    @ApiModelProperty(value = "Статус активности офиса")
    private Boolean isActive;

}

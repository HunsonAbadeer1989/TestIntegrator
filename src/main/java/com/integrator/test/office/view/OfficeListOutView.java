package com.integrator.test.office.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Api(value = "Вид вывода списка офисов")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfficeListOutView {

    @ApiModelProperty(value = "Уникальный идентификатор офиса")
    private Long Id;

    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса")
    private String name;

    @ApiModelProperty(value = "Стату активности офиса")
    private Boolean isActive;

}

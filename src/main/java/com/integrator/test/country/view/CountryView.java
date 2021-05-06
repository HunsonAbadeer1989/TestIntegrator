package com.integrator.test.country.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Страна")
@Getter
@Setter
public class CountryView {

    @Size(max = 3)
    @NotEmpty
    @ApiModelProperty(value = "Код страны")
    public String code;

    @Size(max = 100)
    @NotEmpty
    @ApiModelProperty(value = "Название страны")
    public String name;

}

package com.integrator.test.country.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Страна")
public class CountryView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @NotEmpty
    @ApiModelProperty(value = "Код страны", hidden = true, example = "528")
    public String code;

    @Size(max = 100)
    @NotEmpty
    @ApiModelProperty(value = "Название страны", hidden = true, example = "Nederland")
    public String name;

    @Override
    public String toString() {
        return "{id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

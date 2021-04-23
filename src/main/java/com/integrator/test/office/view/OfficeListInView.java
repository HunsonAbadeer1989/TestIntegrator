package com.integrator.test.office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel(value = "Вид фильтра для формирования списока офисов")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfficeListInView {

        @ApiModelProperty(value = "Уникальный идентификатор организации")
        private Long orgId;

        @Size(max = 50)
        @ApiModelProperty(value = "Название офиса")
        private String name;

        @Size(max = 50)
        @ApiModelProperty(value = "Телефонный номер офиса")
        private String phone;

        @ApiModelProperty(value = "Стату активности офиса")
        private Boolean isActive;

}

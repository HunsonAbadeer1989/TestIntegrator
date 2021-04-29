package com.integrator.test.user.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Api(value = "Вид фильтра для формирования списока сотрудников")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserListInView {

    @ApiModelProperty(value = "Уникальный идентификатор офиса")
    private Long officeId;

    @ApiModelProperty(value = "Имя сотрудника")
    @NotNull
    private String firstName;

    @ApiModelProperty(value = "Фамилия сотрудника")
    @NotNull
    private String secondName;

    @ApiModelProperty(value = "Отчество сотрудника")
    private String middleName;

    @ApiModelProperty(value = "Должность сотрудника")
    private String position;

    @ApiModelProperty(value = "Код документа")
    private String docCode;

    @ApiModelProperty(value = "Код страны")
    private String citizenshipCode;


}

package com.integrator.test.user.view;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Api(value = "Вид фильтра для формирования списока сотрудников")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserListOutView {

    @ApiModelProperty(value = "Уникальный идентификатор сотрудника")
    private Long id;

    @ApiModelProperty(value = "Имя сотрудника")
    private String firstName;

    @ApiModelProperty(value = "Фамилия сотрудника")
    private String secondName;

    @ApiModelProperty(value = "Отчество сотрудника")
    private String middleName;

    @ApiModelProperty(value = "Должность сотрудника")
    private String position;

}

package com.integrator.test.user.view;

import com.integrator.test.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Api(value = "Представление сотрудника")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserView {

    @ApiModelProperty(value = "Id сотрудника")
    private Long id;

    @ApiModelProperty(value = "Уникальный идентификатор офиса сотрудника")
    private Long officeId;

    @Size(max = 50)
    @ApiModelProperty(value = "Имя сотрудника")
    private String firstName;

    @Size(max = 50)
    @ApiModelProperty(value = "Фамилия сотрудника")
    private String secondName;

    @Size(max = 50)
    @ApiModelProperty(value = "Отчество сотрудника")
    private String middleName;

    @Size(max = 50)
    @ApiModelProperty(value = "Должность сотрудника")
    private String position;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон сотрудника")
    private String phone;

    @ApiModelProperty(value = "Название документа сотрудника", name = "doc_name")
    private String docName;

    @ApiModelProperty(value = "Номер документа сотрудника", name = "doc_number")
    private String docNumber;

    @ApiModelProperty(value = "Дата выдачи документа сотруднику", name = "doc_date")
    private String docDate;

    @ApiModelProperty(value = "Код документа")
    private String docCode;

    @ApiModelProperty(value = "Код страны сотрудника")
    private String citizenshipCode;

    @ApiModelProperty(value = "Статус идентификации сотрудника")
    private Boolean isIdentified;

}
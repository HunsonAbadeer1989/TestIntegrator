package com.integrator.test.organization.view;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "organization_list_in_params")
@Getter
@Setter
public class OrganizationListInView {

    @Size(max = 50)
    @NotNull
    public String name;

    @NotEmpty
    public String inn;

    @NotNull
    public Boolean isActive;

}

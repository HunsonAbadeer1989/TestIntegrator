package com.integrator.test.organization.view;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "organization_list_in_params")
@Getter
@Setter
public class OrganizationListInView {

    public String name;

    public String inn;

    public Boolean isActive;

}

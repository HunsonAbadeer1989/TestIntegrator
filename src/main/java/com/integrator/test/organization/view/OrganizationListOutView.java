package com.integrator.test.organization.view;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "organization_list_out_params")
@Getter
@Setter
public class OrganizationListOutView {

    public Long id;

    public String name;

    public Boolean isActive;

}

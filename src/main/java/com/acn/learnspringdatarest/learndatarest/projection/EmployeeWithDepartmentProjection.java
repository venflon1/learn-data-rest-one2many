package com.acn.learnspringdatarest.learndatarest.projection;

import org.springframework.data.rest.core.config.Projection;

import com.acn.learnspringdatarest.learndatarest.entity.DepartmentEntity;
import com.acn.learnspringdatarest.learndatarest.entity.EmployeeEntity;

@Projection(name = "with-dep", types = EmployeeEntity.class)
public interface EmployeeWithDepartmentProjection extends EmployeeDefaultProjection {
	DepartmentEntity getDepartment();
}
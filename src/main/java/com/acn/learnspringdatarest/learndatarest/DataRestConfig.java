package com.acn.learnspringdatarest.learndatarest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.acn.learnspringdatarest.learndatarest.entity.DepartmentEntity;
import com.acn.learnspringdatarest.learndatarest.entity.EmployeeEntity;
import com.acn.learnspringdatarest.learndatarest.projection.EmployeeDefaultProjection;
import com.acn.learnspringdatarest.learndatarest.projection.EmployeeWithDepartmentProjection;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.setDefaultMediaType(MediaType.APPLICATION_JSON);
		config.useHalAsDefaultJsonMediaType(false);
		config.exposeIdsFor(EmployeeEntity.class, DepartmentEntity.class);
		
		config
	      .getProjectionConfiguration()
	      .addProjection(EmployeeDefaultProjection.class)
	      .addProjection(EmployeeWithDepartmentProjection.class);
	}
}
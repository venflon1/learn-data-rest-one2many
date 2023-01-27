package com.acn.learnspringdatarest.learndatarest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.acn.learnspringdatarest.learndatarest.entity.EmployeeEntity;

@Projection(name = "def", types = EmployeeEntity.class)
public interface EmployeeDefaultProjection{
	Long getId(); 
	@Value("#{target.firstname.toUpperCase()}, #{target.lastname.toUpperCase()}")
	String getCompleteName(); 
	String getEmail(); 
}
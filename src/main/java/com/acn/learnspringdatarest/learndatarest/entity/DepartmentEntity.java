package com.acn.learnspringdatarest.learndatarest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "department",
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = {"name", "country"})
	}
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(
		nullable = false,
		length = 255
	)
	private String name;
	@Column(
		length = 455
	)
	private String description;
	@Column(
		nullable = false,
		length = 255
	)
	private String country;
	@OneToMany(
		mappedBy = "department",
		fetch = FetchType.LAZY,
		targetEntity = EmployeeEntity.class
	)
	private List<EmployeeEntity> employees;
}
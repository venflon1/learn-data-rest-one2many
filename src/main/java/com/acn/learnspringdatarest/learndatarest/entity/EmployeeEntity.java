package com.acn.learnspringdatarest.learndatarest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "employee",
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = {"first_name", "last_name"})
	}
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(
		name = "first_name",
		nullable = false,
		length = 255
	)
	private String firstname;
	@Column(
		name = "last_name",
		nullable = false,
		length = 255
	)
	private String lastname;
	@Column(
		nullable = false,
		length = 255,
		unique = true
	)
	private String email;
	@ManyToOne(
		targetEntity = DepartmentEntity.class,
		optional = true
	)
	@JoinColumn(
		name = "department_id",
		referencedColumnName = "id"
	)
	public DepartmentEntity department;
}
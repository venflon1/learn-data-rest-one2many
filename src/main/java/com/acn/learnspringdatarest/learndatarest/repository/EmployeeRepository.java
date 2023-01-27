package com.acn.learnspringdatarest.learndatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.acn.learnspringdatarest.learndatarest.entity.EmployeeEntity;
import com.acn.learnspringdatarest.learndatarest.projection.EmployeeDefaultProjection;

// ATTENTION:
// IF NOT SPECIFY ANY PATH ATTRIBUTE with @RepositoryRestResource OR
// NOT SPECIFY ANY ANNOTATION @RepositoryRestResource,
// 
// THEN the name of default path of resource will be:
//  ---> the name of class Entity with first letter lowercase and plural.
// Example in this case without @RepositoryRestResource(path = "/users") the path will be:
// 	---> userEntities

@RepositoryRestResource(
	path = "employees",
	excerptProjection = EmployeeDefaultProjection.class
)
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	@RestResource(path = "firstname")
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.firstname = :fname")
	List<EmployeeEntity> findByFirstname(@Param(value = "fname") String firstname);

	@RestResource(path = "lastname")
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.lastname = :lname")
	List<EmployeeEntity> findByLastname(@Param(value = "lname") String lastname);
	

	@RestResource(path = "email")
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.email = :email")
	EmployeeEntity findByEmail(@Param(value = "email") String email);

	@RestResource(path = "firstname-and-lastname")
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.firstname = :fname AND e.lastname = :lname")
	EmployeeEntity findByFirstnameAndLastname(
		@Param(value = "fname") String firstname,
		@Param(value = "lname") String lastname
	);
	
	@RestResource(path = "/employees-department-unassigned", exported = true)
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.department IS NULL")
	EmployeeEntity findWithUnassignedDepartment();
	
	
	// To Disable DELETE API METHOD
	@Override
	@RestResource(exported = false)
	void delete(EmployeeEntity entity);

	// To Disable CREAZTION METHOD
//	@Override
//	@RestResource(exported = false)
//	<S extends EmployeeEntity> S save(S entity);
}
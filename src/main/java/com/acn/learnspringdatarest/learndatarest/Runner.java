package com.acn.learnspringdatarest.learndatarest;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.acn.learnspringdatarest.learndatarest.entity.DepartmentEntity;
import com.acn.learnspringdatarest.learndatarest.entity.EmployeeEntity;
import com.acn.learnspringdatarest.learndatarest.repository.DepartmentRepository;
import com.acn.learnspringdatarest.learndatarest.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class Runner implements CommandLineRunner {

	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("saving departments...");
		this.departmentRepository.saveAll((Iterable<DepartmentEntity>) 
				List.of(
					DepartmentEntity.builder()
						.name("COMPUTER SCIENCE")
						.description(" --- ")
						.country("ITALIA")
						.build(),
					DepartmentEntity.builder()
						.name("ECONOMY")
						.description(" --- ")
						.country("GERMANY")
						.build(),
					DepartmentEntity.builder()
						.name("DEFENSE")
						.description(" --- ")
						.country("USA")
						.build()
				)
			);
		
		log.info("saving employeers...");
		this.employeeRepository.saveAll((Iterable<EmployeeEntity>) 
			List.of(
					EmployeeEntity.builder()
						.email("mino.pluto@libero.it")
						.firstname("Mino")
						.lastname("Pluto")
						.department(this.departmentRepository.findById(1L).get())
						.build(),
					EmployeeEntity.builder()
						.email("mino.paperino@libero.it")
						.firstname("Mino")
						.lastname("Paperino")
						.department(this.departmentRepository.findById(1L).get())
						.build(),
					EmployeeEntity.builder()
						.email("mino.topolino@libero.it")
						.firstname("Mino")
						.lastname("Topolino")
						.department(this.departmentRepository.findById(1L).get())
						.build(),
					EmployeeEntity.builder()
						.email("mino.qui@libero.it")
						.firstname("Mino")
						.lastname("Qui")
						.department(this.departmentRepository.findById(2L).get())
						.build(),
					EmployeeEntity.builder()
						.email("mino.quo@libero.it")
						.firstname("Mino")
						.lastname("Quo")
						.department(this.departmentRepository.findById(2L).get())
						.build(),
					EmployeeEntity.builder()
						.email("mino.qua@libero.it")
						.firstname("Mino")
						.lastname("Qua")
						.department(this.departmentRepository.findById(3L).get())
						.build(),
					EmployeeEntity.builder()
						.email("mino.quaquaraqua@libero.it")
						.firstname("Mino")
						.lastname("Quaquaraqua")
						.build()
				)
		);
	}
}

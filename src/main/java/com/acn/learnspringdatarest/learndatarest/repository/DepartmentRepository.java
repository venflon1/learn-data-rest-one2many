package com.acn.learnspringdatarest.learndatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acn.learnspringdatarest.learndatarest.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {}
package com.tcs.springcoreexample.basic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.springcoreexample.basic.bean.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByDeptno(int deptno);
}

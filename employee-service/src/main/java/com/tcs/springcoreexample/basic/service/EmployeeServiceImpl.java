package com.tcs.springcoreexample.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springcoreexample.basic.bean.Employee;
import com.tcs.springcoreexample.basic.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "Employee is saved";
	}

	@Override
	public Employee getEmployee(int empno) {
		Optional<Employee> emp = repo.findById(empno);
		return emp.orElse(Employee.builder().empno(0).build());
	}

	@Override
	public void updateEmployee(Employee emp) {
		repo.saveAndFlush(emp);

	}

	@Override
	public List<Employee> getEmployeesBasedDeptno(int deptno) {
		List<Employee> list = repo.findByDeptno(deptno);
		return list;
	}

}

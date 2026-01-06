package com.tcs.springcoreexample.basic.service;

import java.util.List;

import com.tcs.springcoreexample.basic.bean.Employee;

public interface EmployeeService {

	public String addEmployee(Employee emp);
	
	public Employee getEmployee(int empno);

	public void updateEmployee(Employee emp);

	public List<Employee> getEmployeesBasedDeptno(int deptno);
}

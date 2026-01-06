package com.tcs.springcoreexample.basic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springcoreexample.basic.bean.Employee;
import com.tcs.springcoreexample.basic.dto.EmployeeDTO;
import com.tcs.springcoreexample.basic.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private Environment env;

	@PostMapping
	public String saveEmployee(@RequestBody EmployeeDTO empDto) {
		Employee emp = Employee.builder()
				.ename(empDto.getEname())
				.basicSalary(empDto.getSal()*0.6f)
				.bonus(empDto.getSal()*0.3f)
				.tax(empDto.getSal()*0.1f)
				.deptno(empDto.getDeptno())
				.build();
		String result = "";
		try {
		 result = service.addEmployee(emp);
		}catch(Exception e) {
			service.updateEmployee(emp);
		}
		return result;
	}
	
	@GetMapping("/{empno}")
	public EmployeeDTO getEmployee(@PathVariable int empno) {
		Employee emp = service.getEmployee(empno);
		EmployeeDTO empDto = new EmployeeDTO();
		empDto.setEmpno(emp.getEmpno());
		empDto.setEname(emp.getEname());
		empDto.setSal((int)(emp.getBasicSalary()+emp.getBonus()+emp.getTax()));
		empDto.setDeptno(emp.getDeptno());
		return empDto;
	}
	
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getEmployeeBasedDeptno(@RequestParam int deptno) {
		List<Employee> list = service.getEmployeesBasedDeptno(deptno);
		List<EmployeeDTO> result = new ArrayList<>();
		list.forEach(x->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(x, dto);
			dto.setSal((int)(x.getBasicSalary()+x.getBonus()+x.getTax()));
			result.add(dto);
		});
		System.out.println("calling from employee service with port: "+env.getProperty("local.server.port"));
		return ResponseEntity.ok(result);
	}
	
	
}

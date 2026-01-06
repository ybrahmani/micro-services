package com.tcs.springcoreexample.basic.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.springcoreexample.basic.dto.EmployeeDTO;

@FeignClient("EMPLOYEE-SERVICE")
public interface ApiClient {
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDTO>> getEmployeeBasedDeptno(@RequestParam int deptno);

}

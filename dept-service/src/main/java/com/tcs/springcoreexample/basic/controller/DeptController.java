package com.tcs.springcoreexample.basic.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springcoreexample.basic.bean.Dept;
import com.tcs.springcoreexample.basic.dto.DeptDto;
import com.tcs.springcoreexample.basic.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService service;
	
	@PostMapping
	public String saveDept(@RequestBody DeptDto deptDto) {
		Dept dept = Dept.builder()
				.deptno(deptDto.getDeptno())
				.dname(deptDto.getDname())
				.loc(deptDto.getLoc())
				.build();
		
		return service.saveDept(dept);
	}
	
	@GetMapping("/{deptno}")
	public DeptDto getDept(@PathVariable int deptno) {
		DeptDto d = service.getDept(deptno);
		return d;
	}
}

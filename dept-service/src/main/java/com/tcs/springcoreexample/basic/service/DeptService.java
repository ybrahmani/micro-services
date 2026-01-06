package com.tcs.springcoreexample.basic.service;

import org.springframework.stereotype.Service;

import com.tcs.springcoreexample.basic.bean.Dept;
import com.tcs.springcoreexample.basic.dto.DeptDto;


public interface DeptService {

	public String saveDept(Dept dept);
	
	public DeptDto getDept(int deptno);
}

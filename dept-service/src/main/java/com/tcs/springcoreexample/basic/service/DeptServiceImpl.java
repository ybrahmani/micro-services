package com.tcs.springcoreexample.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.springcoreexample.basic.api.ApiClient;
import com.tcs.springcoreexample.basic.bean.Dept;
import com.tcs.springcoreexample.basic.dto.DeptDto;
import com.tcs.springcoreexample.basic.dto.EmployeeDTO;
import com.tcs.springcoreexample.basic.repo.DeptRepo;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptRepo repo;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private ApiClient client;

	@Override
	public String saveDept(Dept dept) {
		// TODO Auto-generated method stub
		repo.save(dept);
		return "Data has been Saved";
	}

	@Override
	public DeptDto getDept(int deptno) {
		/*String url = "http://localhost:8083/employee?deptno="+deptno;
		ResponseEntity<List<EmployeeDTO>> list=restTemplate.exchange(
	            url,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<EmployeeDTO>>() {}
		);*/
		ResponseEntity<List<EmployeeDTO>> list=client.getEmployeeBasedDeptno(deptno);
		Dept d= repo.findById(deptno).get();
		DeptDto dto = new DeptDto();
		dto.setDeptno(d.getDeptno());
		dto.setDname(d.getDname());
		dto.setLoc(d.getLoc());
		dto.setList(list.getBody());
		return dto;
		
	}

}

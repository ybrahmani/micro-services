package com.tcs.springcoreexample.basic.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptDto {
	
	private int deptno;
	private String dname;
	private String loc;
	
	private List<EmployeeDTO> list;

}

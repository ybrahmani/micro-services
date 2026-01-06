package com.tcs.springcoreexample.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

	private Integer empno;
	private String ename;
	private int sal;
	
	private int deptno;
}

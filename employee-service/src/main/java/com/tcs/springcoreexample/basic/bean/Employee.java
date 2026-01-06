package com.tcs.springcoreexample.basic.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;
	
	@Column
	private String ename;
	
	@Column
	private double basicSalary;
	
	@Column
	private double bonus;
	
	@Column
	private double tax;
	
	@Column
	private int deptno;
	
}

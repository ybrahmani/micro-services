package com.tcs.springcoreexample.basic.bean;

import com.tcs.springcoreexample.basic.dto.DeptDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {

	@Id
	private int deptno;
	
	@Column
	private String dname;
	
	@Column
	private String loc;
}

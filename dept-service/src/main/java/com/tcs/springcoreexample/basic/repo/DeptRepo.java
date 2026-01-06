package com.tcs.springcoreexample.basic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.springcoreexample.basic.bean.Dept;

@Repository
public interface DeptRepo extends JpaRepository<Dept, Integer> {

}

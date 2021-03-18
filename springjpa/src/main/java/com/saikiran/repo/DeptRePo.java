package com.saikiran.repo;

import org.springframework.data.repository.CrudRepository;

import com.saikiran.model.Department;

public interface DeptRePo  extends CrudRepository<Department ,Integer>{

}

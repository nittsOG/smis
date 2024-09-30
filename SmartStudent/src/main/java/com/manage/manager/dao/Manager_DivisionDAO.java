package com.manage.manager.dao;

import java.util.List;
import com.manage.home.entities.Division;

public interface Manager_DivisionDAO {
    void save(Division division);
    void update(Division division);
    void delete(Division division);
    Division findById(Long id);
    List<Division> findAll();
	List<Division> findByDepartmentId(Long departmentId);
}

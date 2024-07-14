package com.manage.admin.dao;

import java.util.List;
import com.manage.home.entities.Division;

public interface Admin_DivisionDAO {
	
	    public void save(Division division);
	    public void update(Division division);
	    public void delete(Division division);
	    public Division findById(Long id);
	    public List<Division> findAll();
}

package com.manage.student.dao;

import com.manage.home.entities.Division;
import java.util.List;

public interface Student_DivisionDAO {
    Division findById(Long id);
    List<Division> findAll();
}

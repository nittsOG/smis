package com.manage.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.Manager_DivisionDAO;
import com.manage.home.entities.Division;

@Service
@Qualifier("managerDivisionServiceImpl")
@Transactional(transactionManager = "managerTransactionManager")
public class Manager_DivisionServiceImpl implements Manager_DivisionService {

    private final Manager_DivisionDAO divisionDao;

    @Autowired
    public Manager_DivisionServiceImpl(@Qualifier("managerDivisionDAOImpl") Manager_DivisionDAO divisionDao) {
        this.divisionDao = divisionDao;
    }

    @Override
    public Division getDivisionById(Long id) {
        return divisionDao.findById(id);
    }

    @Override
    public void saveDivision(Division division) {
        divisionDao.save(division);
    }

    @Override
    public void updateDivision(Division division) {
        Division existingDivision = divisionDao.findById(division.getDivisionId());
        if (existingDivision != null) {
            divisionDao.update(division);
        }
    }

    @Override
    public void deleteDivision(Division division) {
        divisionDao.delete(division);
    }

    @Override
    public List<Division> getAllDivisions() {
        return divisionDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.deleteDivision(this.getDivisionById(id));
    }

    @Override
    public List<Division> getDivisionsByDepartment(Long departmentId) {
        return divisionDao.findByDepartmentId(departmentId);
    }
}

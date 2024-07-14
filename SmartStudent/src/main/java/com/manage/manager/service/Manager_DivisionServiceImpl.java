package com.manage.manager.service;

import com.manage.home.entities.Division;
import com.manage.manager.dao.Manager_DivisionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("managerTransactionManager")
public class Manager_DivisionServiceImpl implements Manager_DivisionService {

    private final Manager_DivisionDAO managerDivisionDAO;

    @Autowired
    public Manager_DivisionServiceImpl(Manager_DivisionDAO managerDivisionDAO) {
        this.managerDivisionDAO = managerDivisionDAO;
    }

    @Override
    public void saveDivision(Division division) {
        managerDivisionDAO.save(division);
    }

    @Override
    public void updateDivision(Division division) {
        managerDivisionDAO.update(division);
    }

    @Override
    public void deleteDivision(Division division) {
        managerDivisionDAO.delete(division);
    }

    @Override
    public Division getDivisionById(Long divisionId) {
        return managerDivisionDAO.findById(divisionId);
    }

    @Override
    public List<Division> getAllDivisions() {
        return managerDivisionDAO.findAll();
    }
}

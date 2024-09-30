package com.manage.manager.service;

import com.manage.manager.dao.Manager_BacklogDAO;
import com.manage.student.entities.Backlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerBacklogServiceImpl")
public class Manager_BacklogServiceImpl implements Manager_BacklogService {

    private final Manager_BacklogDAO managerBacklogDAO;

    @Autowired
    public Manager_BacklogServiceImpl(@Qualifier("managerBacklogDAOImpl") Manager_BacklogDAO managerBacklogDAO) {
        this.managerBacklogDAO = managerBacklogDAO;
    }

    @Override
    @Transactional("managerTransactionManager")
    public void saveBacklog(Backlog backlog) {
        managerBacklogDAO.saveBacklog(backlog);
    }

    @Override
    @Transactional("managerTransactionManager")
    public void updateBacklog(Backlog backlog) {
        managerBacklogDAO.updateBacklog(backlog);
    }

    @Override
    @Transactional("managerTransactionManager")
    public void deleteBacklog(Long studentId, String subjectCode, Integer semester) {
        managerBacklogDAO.deleteBacklog(studentId, subjectCode, semester);
    }

    @Override
    @Transactional("managerTransactionManager")
    public Backlog getBacklogById(Long studentId, String subjectCode, Integer semester) {
        return managerBacklogDAO.getBacklogById(studentId, subjectCode, semester);
    }

    @Override
    @Transactional("managerTransactionManager")
    public List<Backlog> getAllBacklogs() {
        return managerBacklogDAO.getAllBacklogs();
    }

    @Override
    @Transactional("managerTransactionManager")
    public List<Backlog> getBacklogsByStudentId(Long studentId) {
        return managerBacklogDAO.getBacklogsByStudentId(studentId);
    }
}

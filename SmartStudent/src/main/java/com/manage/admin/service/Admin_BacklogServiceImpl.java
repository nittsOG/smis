package com.manage.admin.service;

import com.manage.admin.dao.Admin_BacklogDAO;
import com.manage.student.entities.Backlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminBacklogServiceImpl")
public class Admin_BacklogServiceImpl implements Admin_BacklogService {

    private final Admin_BacklogDAO adminBacklogDAO;

    @Autowired
    public Admin_BacklogServiceImpl(@Qualifier("adminBacklogDAOImpl") Admin_BacklogDAO adminBacklogDAO) {
        this.adminBacklogDAO = adminBacklogDAO;
    }

    @Override
    @Transactional("adminTransactionManager")
    public void saveBacklog(Backlog backlog) {
        adminBacklogDAO.saveBacklog(backlog);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void updateBacklog(Backlog backlog) {
        adminBacklogDAO.updateBacklog(backlog);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void deleteBacklog(Integer studentId, String subjectCode, Integer semester) {
        adminBacklogDAO.deleteBacklog(studentId, subjectCode, semester);
    }

    @Override
    @Transactional("adminTransactionManager")
    public Backlog getBacklogById(Integer studentId, String subjectCode, Integer semester) {
        return adminBacklogDAO.getBacklogById(studentId, subjectCode, semester);
    }

    @Override
    @Transactional("adminTransactionManager")
    public List<Backlog> getAllBacklogs() {
        return adminBacklogDAO.getAllBacklogs();
    }
}

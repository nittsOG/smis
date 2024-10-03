package com.manage.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.dao.StudentCommunityDAO;
import com.manage.student.entities.Student;

@Service
@Transactional(transactionManager = "studentTransactionManager")
@Qualifier("studentCommunityServiceImpl")
public class StudentCommunityServiceImpl implements StudentCommunityService {


    private StudentCommunityDAO studentCommunityDAO;
    
    @Autowired
    public StudentCommunityServiceImpl(@Qualifier("studentCommunityDAOImpl")StudentCommunityDAO studentCommunityDAO) {
		this.studentCommunityDAO = studentCommunityDAO;
	}

	@Override
    public List<Community> getAllCommunitiesByStudent(Long studentId) {
        Student student = studentCommunityDAO.getStudentById(studentId);
        return studentCommunityDAO.getAllCommunitiesByStudent(student);
    }

    @Override
    public Community getCommunityById(Long communityId) {
        return studentCommunityDAO.getCommunityById(communityId);
    }

    @Override
    public List<CommunityPost> getPostsByCommunity(Long communityId) {
        Community community = studentCommunityDAO.getCommunityById(communityId);
        return studentCommunityDAO.getPostsByCommunity(community);
    }

    @Override
    public void createPost(CommunityPost post) {
        studentCommunityDAO.createPost(post);
    }
}

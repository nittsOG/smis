package com.manage.faculty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.dao.FacultyCommunityDAO;
import com.manage.faculty.entities.Faculty;
import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.entities.Student;

@Service
@Transactional(transactionManager = "facultyTransactionManager")
@Qualifier("facultyCommunityServiceImpl")
public class FacultyCommunityServiceImpl implements FacultyCommunityService {

	private final FacultyCommunityDAO communityDAO;

	@Autowired
	public FacultyCommunityServiceImpl(@Qualifier("facultyCommunityDAOImpl") FacultyCommunityDAO communityDAO) {
		this.communityDAO = communityDAO;
	}

	@Override
	public void createCommunity(Community community) {
		communityDAO.createCommunity(community);
	}

	@Override
	public List<Community> getAllCommunitiesByFaculty(Faculty faculty) {
		return communityDAO.getAllCommunitiesByFaculty(faculty);
	}

	@Override
	public Community getCommunityById(Long communityId) {
		return communityDAO.getCommunityById(communityId);
	}

	@Override
	public void deleteCommunity(Long communityId) {
		communityDAO.deleteCommunity(communityId);
	}

	@Override
	public void addStudentToCommunity(Long communityId, Student student) {
		Community community = communityDAO.getCommunityById(communityId);
		communityDAO.addStudentToCommunity(community, student);
	}

	@Override
	public void removeStudentFromCommunity(Long communityId, Student student) {
		Community community = communityDAO.getCommunityById(communityId);
		communityDAO.removeStudentFromCommunity(community, student);
	}

	@Override
	public void createPost(CommunityPost post) {
		communityDAO.createPost(post);
	}

	@Override
	public List<CommunityPost> getPostsByCommunity(Long communityId) {
		Community community = communityDAO.getCommunityById(communityId);
		return communityDAO.getPostsByCommunity(community);
	}

	@Override
	public List<Student> getAllStudents() {
		return communityDAO.getAllStudents(); // DAO call
	}

	@Override
	public Student getStudentById(Long studentId) {
		return communityDAO.getStudentById(studentId);
	}

}

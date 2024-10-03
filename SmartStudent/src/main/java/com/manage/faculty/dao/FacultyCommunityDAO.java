package com.manage.faculty.dao;

import java.util.List;

import com.manage.faculty.entities.Faculty;
import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.entities.Student;

public interface FacultyCommunityDAO {
    void createCommunity(Community community);
    List<Community> getAllCommunitiesByFaculty(Faculty faculty);
    Community getCommunityById(Long communityId);
    void deleteCommunity(Long communityId);
    void addStudentToCommunity(Community community, Student student);
    void removeStudentFromCommunity(Community community, Student student);
    void createPost(CommunityPost post);
    List<CommunityPost> getPostsByCommunity(Community community);
	List<Student> getAllStudents();
	Student getStudentById(Long studentId);
}

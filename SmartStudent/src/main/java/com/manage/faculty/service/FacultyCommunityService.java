package com.manage.faculty.service;

import java.util.List;

import com.manage.faculty.entities.Faculty;
import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.entities.Student;

public interface FacultyCommunityService {
    void createCommunity(Community community);
    List<Community> getAllCommunitiesByFaculty(Faculty faculty);
    Community getCommunityById(Long communityId);
    void deleteCommunity(Long communityId);
    void addStudentToCommunity(Long communityId, Student student);
    void removeStudentFromCommunity(Long communityId, Student student);
    void createPost(CommunityPost post);
    List<CommunityPost> getPostsByCommunity(Long communityId);
	List<Student> getAllStudents();
	Student getStudentById(Long studentId);
}

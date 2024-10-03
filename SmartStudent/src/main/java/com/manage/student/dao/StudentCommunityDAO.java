package com.manage.student.dao;

import java.util.List;
import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.student.entities.Student;

public interface StudentCommunityDAO {
    List<Community> getAllCommunitiesByStudent(Student student);
    Community getCommunityById(Long communityId);
    List<CommunityPost> getPostsByCommunity(Community community);
    void createPost(CommunityPost post);
    Student getStudentById(Long studentId);
}

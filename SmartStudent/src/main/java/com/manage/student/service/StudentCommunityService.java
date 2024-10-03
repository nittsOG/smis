package com.manage.student.service;

import java.util.List;

import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;

public interface StudentCommunityService {
    List<Community> getAllCommunitiesByStudent(Long studentId);
    Community getCommunityById(Long communityId);
    List<CommunityPost> getPostsByCommunity(Long communityId);
    void createPost(CommunityPost post);
}

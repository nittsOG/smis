package com.manage.student.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.home.entities.PostType;
import com.manage.student.entities.Student;
import com.manage.student.service.StudentCommunityService;

@Controller
@RequestMapping("/student/community")
public class StudentCommunityController {

	private StudentCommunityService communityService;

	@Autowired
	public StudentCommunityController(
			@Qualifier("studentCommunityServiceImpl") StudentCommunityService communityService) {
		super();
		this.communityService = communityService;
	}

	// Show all communities where student is added
	@GetMapping("/list")
	public ModelAndView listCommunities(HttpSession session) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return new ModelAndView("redirect:/login");
		}

		List<Community> communities = communityService.getAllCommunitiesByStudent(studentId);
		ModelAndView mav = new ModelAndView("JSP/STUDENT/COMMUNITY/list-communities");
		mav.addObject("communities", communities);
		return mav;
	}

	// Show posts in a specific community
	@GetMapping("/posts/{communityId}")
	public ModelAndView listPosts(@PathVariable("communityId") Long communityId, HttpSession session) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return new ModelAndView("redirect:/login");
		}

		List<CommunityPost> posts = communityService.getPostsByCommunity(communityId);

		// Convert image attachments to Base64 for displaying
		for (CommunityPost post : posts) {
			if (post.getAttachmentData() != null) {
				String photoBase64 = Base64.getEncoder().encodeToString(post.getAttachmentData());
				post.setPhotoBase64(photoBase64);
			}
		}

		ModelAndView mav = new ModelAndView("JSP/STUDENT/COMMUNITY/list-posts");
		mav.addObject("posts", posts);
		return mav;
	}

	// Create a new post
	@PostMapping("/createPost")
	public String createPost(@RequestParam("communityId") Long communityId, @RequestParam("content") String content,
			@RequestParam(value = "photoBase64", required = false) String photoBase64, HttpSession session) {

		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return "redirect:/login";
		}

		Student student = new Student();
		student.setStudentId(studentId);

		Community community = communityService.getCommunityById(communityId);

		CommunityPost post = new CommunityPost();
		post.setContent(content);
		post.setCommunity(community);
		post.setStudent(student);
		post.setPostType(PostType.TEXT); // Default is TEXT

		// Handle image attachment if provided
		if (photoBase64 != null && !photoBase64.isEmpty()) {
			byte[] imageBytes = Base64.getDecoder().decode(photoBase64);
			post.setAttachmentData(imageBytes);
			post.setPostType(PostType.IMAGE);
		}

		communityService.createPost(post);
		return "redirect:/student/community/posts/" + communityId;
	}

	// *************

	// Add the method to show the form for creating a post
	@GetMapping("/createPost/{communityId}")
	public ModelAndView showCreatePostForm(@PathVariable("communityId") Long communityId, HttpSession session) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return new ModelAndView("redirect:/login");
		}

		// Retrieve the community to pass the name and ID to the view
		Community community = communityService.getCommunityById(communityId);
		if (community == null) {
			return new ModelAndView("redirect:/student/community/list");
		}

		// Create a ModelAndView to display the form
		ModelAndView mav = new ModelAndView("JSP/STUDENT/COMMUNITY/create-post");
		mav.addObject("community", community);
		return mav;
	}

}

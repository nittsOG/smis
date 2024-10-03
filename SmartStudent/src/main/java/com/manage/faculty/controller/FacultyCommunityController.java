package com.manage.faculty.controller;

import java.util.Base64;
import java.util.List;
import java.util.Set;

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

import com.manage.faculty.entities.Faculty;
import com.manage.faculty.service.FacultyCommunityService;
import com.manage.home.entities.Community;
import com.manage.home.entities.CommunityPost;
import com.manage.home.entities.PostType;
import com.manage.student.entities.Student;

@Controller
@RequestMapping("/faculty/community")
public class FacultyCommunityController {

	private final FacultyCommunityService communityService;

	@Autowired
	public FacultyCommunityController(
			@Qualifier("facultyCommunityServiceImpl") FacultyCommunityService communityService) {
		this.communityService = communityService;
	}

	// Show form to create a new community
	@GetMapping("/create")
	public ModelAndView showCreateCommunityForm(HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/faculty/login");
		}
		return new ModelAndView("JSP/FACULTY/COMMUNITY/create-community");
	}

	// Handle form submission to create a community
	@PostMapping("/create")
	public String createCommunity(@RequestParam("name") String name, @RequestParam("description") String description,
			HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return "redirect:/faculty/login";
		}

		Faculty faculty = new Faculty();
		faculty.setFacultyId(facultyId);

		Community community = new Community();
		community.setName(name);
		community.setDescription(description);
		community.setCreatedBy(faculty);

		communityService.createCommunity(community);
		return "redirect:/faculty/community/list";
	}

	// List all communities created by the logged-in faculty
	@GetMapping("/list")
	public ModelAndView listCommunities(HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/faculty/login");
		}

		Faculty faculty = new Faculty();
		faculty.setFacultyId(facultyId);

		List<Community> communities = communityService.getAllCommunitiesByFaculty(faculty);

		// Log the size of the retrieved list
		System.out.println("Number of communities: " + communities.size());

		ModelAndView mav = new ModelAndView("JSP/FACULTY/COMMUNITY/list-communities");
		mav.addObject("communities", communities);
		return mav;
	}

	// List all posts in a specific community
	// List all posts in a specific community
	@GetMapping("/posts/{communityId}")
	public ModelAndView listPosts(@PathVariable("communityId") Long communityId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/faculty/login");
		}

		List<CommunityPost> posts = communityService.getPostsByCommunity(communityId);

		// Convert attachment data to Base64 for images
		for (CommunityPost post : posts) {
			if (post.getAttachmentData() != null) {
				String photoBase64 = Base64.getEncoder().encodeToString(post.getAttachmentData());
				post.setPhotoBase64(photoBase64);
			}
		}

		ModelAndView mav = new ModelAndView("JSP/FACULTY/COMMUNITY/list-posts");
		mav.addObject("posts", posts);
		return mav;
	}

	// Handle form submission to create a post in a community
	@PostMapping("/post")
	public String createPost(@RequestParam("communityId") Long communityId, @RequestParam("content") String content,
			@RequestParam(value = "photoBase64", required = false) String photoBase64, HttpSession session) {

		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return "redirect:/faculty/login";
		}

		Faculty faculty = new Faculty();
		faculty.setFacultyId(facultyId);

		Community community = communityService.getCommunityById(communityId);

		CommunityPost post = new CommunityPost();
		post.setContent(content);
		post.setCommunity(community);
		post.setFaculty(faculty);
		post.setPostType(PostType.TEXT); // Default is TEXT

		// Handle base64 image (if present)
		if (photoBase64 != null && !photoBase64.isEmpty()) {
			byte[] imageBytes = Base64.getDecoder().decode(photoBase64);
			post.setAttachmentData(imageBytes);
			post.setPostType(PostType.IMAGE); // Set post type as IMAGE
		}

		communityService.createPost(post);
		return "redirect:/faculty/community/posts/" + communityId;
	}

	// Show the form to create a new post in a community
	@GetMapping("/createPost/{communityId}")
	public ModelAndView showCreatePostForm(@PathVariable("communityId") Long communityId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/faculty/login");
		}

		Community community = communityService.getCommunityById(communityId);
		ModelAndView mav = new ModelAndView("JSP/FACULTY/COMMUNITY/create-post");
		mav.addObject("community", community);
		return mav;
	}

	// ***********************************************////

	// Show community management page
	@GetMapping("/manage/{communityId}")
	public ModelAndView manageCommunity(@PathVariable("communityId") Long communityId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/faculty/login");
		}

		Community community = communityService.getCommunityById(communityId);
		List<Student> allStudents = communityService.getAllStudents(); // Fetch all available students
		Set<Student> communityMembers = community.getMembers(); // Fetch members of the community

		ModelAndView mav = new ModelAndView("JSP/FACULTY/COMMUNITY/manage-community");
		mav.addObject("community", community);
		mav.addObject("allStudents", allStudents);
		mav.addObject("communityMembers", communityMembers);
		return mav;
	}

	// Add a student to the community
	@PostMapping("/addStudent")
	public String addStudentToCommunity(@RequestParam("communityId") Long communityId,
			@RequestParam("studentId") Long studentId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return "redirect:/faculty/login";
		}

		Student student = communityService.getStudentById(studentId);
		communityService.addStudentToCommunity(communityId, student);
		return "redirect:/faculty/community/manage/" + communityId;
	}

	// Remove a student from the community
	@PostMapping("/removeStudent")
	public String removeStudentFromCommunity(@RequestParam("communityId") Long communityId,
			@RequestParam("studentId") Long studentId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return "redirect:/faculty/login";
		}

		Student student = communityService.getStudentById(studentId);
		communityService.removeStudentFromCommunity(communityId, student);
		return "redirect:/faculty/community/manage/" + communityId;
	}

	// Delete a community
	@PostMapping("/delete")
	public String deleteCommunity(@RequestParam("communityId") Long communityId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return "redirect:/faculty/login";
		}

		communityService.deleteCommunity(communityId);
		return "redirect:/faculty/community/list";
	}

}

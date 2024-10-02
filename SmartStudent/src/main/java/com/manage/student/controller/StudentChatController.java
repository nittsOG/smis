package com.manage.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.chat.ChatMessageService;
import com.manage.chat.entities.ChatMessage;
import com.manage.chat.entities.SenderType;
import com.manage.faculty.entities.Faculty;
import com.manage.faculty.service.FacultyService;
import com.manage.student.entities.Student;
import com.manage.student.service.StudentService;

@Controller
@RequestMapping("/student/chat")
public class StudentChatController {

	private ChatMessageService chatMessageService;
	private StudentService studentService;
	private FacultyService facultyService;

	@Autowired
	public StudentChatController(@Qualifier("studentChatMessageServiceImpl") ChatMessageService chatMessageService,
			@Qualifier("studentServiceImpl") StudentService studentService,
			@Qualifier("facultyServiceImpl") FacultyService facultyService) {
		super();
		this.chatMessageService = chatMessageService;
		this.studentService = studentService;
		this.facultyService = facultyService;
	}

	@GetMapping("/inbox")
	public ModelAndView inbox(HttpSession session) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mav = new ModelAndView("JSP/STUDENT/student-inbox");
		Student student = studentService.getStudentById(studentId);
		List<ChatMessage> inbox = chatMessageService.getInbox(studentId); // Fetch messages for this student
		mav.addObject("student", student);
		mav.addObject("inbox", inbox);
		return mav;
	}

	@GetMapping("/new")
	public ModelAndView newChat(HttpSession session) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mav = new ModelAndView("JSP/STUDENT/student-new-chat");
		Student student = studentService.getStudentById(studentId);
		mav.addObject("student", student);
		return mav;
	}

	@PostMapping("/send")
	public String sendMessage(HttpSession session, @RequestParam Long facultyId,
			@RequestParam String message) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return "redirect:/login";
		}

		Student student = studentService.getStudentById(studentId);
		Faculty faculty = facultyService.getFacultyById(facultyId);

		ChatMessage chatMessage = new ChatMessage(student, faculty, message, SenderType.STUDENT);
		chatMessageService.sendMessage(chatMessage);

		return "redirect:/student/chat/conversation?facultyId=" + facultyId;
	}

	@GetMapping("/conversation")
	public ModelAndView conversation(HttpSession session, @RequestParam Long facultyId) {
		Long studentId = (Long) session.getAttribute("studentId");
		if (studentId == null) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mav = new ModelAndView("JSP/STUDENT/student-conversation");
		List<ChatMessage> messages = chatMessageService.getChatHistory(studentId, facultyId);
		mav.addObject("messages", messages);
		return mav;
	}
}

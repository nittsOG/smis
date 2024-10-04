//package com.manage.faculty.controller;
//
//import java.util.List;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import com.manage.chat.ChatMessageService;
//import com.manage.chat.entities.ChatMessage;
//import com.manage.chat.entities.SenderType;
//import com.manage.faculty.entities.Faculty;
//import com.manage.faculty.service.FacultyService;
//import com.manage.student.entities.Student;
//import com.manage.student.service.StudentService;
//
//@Controller
//@RequestMapping("/faculty/chat")
//public class FacultyChatController {
//
//	private ChatMessageService chatMessageService;
//
//	private FacultyService facultyService;
//
//	private StudentService studentService;
//
//	@Autowired
//	public FacultyChatController(@Qualifier("facultyChatMessageServiceImpl") ChatMessageService chatMessageService,
//			@Qualifier("facultyServiceImpl") FacultyService facultyService,
//			@Qualifier("studentServiceImpl") StudentService studentService) {
//		this.chatMessageService = chatMessageService;
//		this.facultyService = facultyService;
//		this.studentService = studentService;
//	}
//
//	@GetMapping("/inbox")
//	public ModelAndView inbox(HttpSession session) {
//		Long facultyId = (Long) session.getAttribute("facultyId");
//		if (facultyId == null) {
//			return new ModelAndView("redirect:/faculty/login");
//		}
//
//		Faculty faculty = facultyService.getFacultyById(facultyId);
//		List<ChatMessage> inbox = chatMessageService.getInbox(facultyId); // Fetch messages for this faculty
//
//		ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-inbox");
//		mav.addObject("faculty", faculty);
//		mav.addObject("inbox", inbox);
//		return mav;
//	}
//
//	@GetMapping("/new")
//	public ModelAndView newChat(HttpSession session) {
//		Long facultyId = (Long) session.getAttribute("facultyId");
//		if (facultyId == null) {
//			return new ModelAndView("redirect:/faculty/login");
//		}
//
//		Faculty faculty = facultyService.getFacultyById(facultyId);
//		ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-new-chat");
//		mav.addObject("faculty", faculty);
//		return mav;
//	}
//
//	@PostMapping("/send")
//	public String sendMessage(HttpSession session, @RequestParam Long studentId, @RequestParam String message) {
//		Long facultyId = (Long) session.getAttribute("facultyId");
//		if (facultyId == null) {
//			return "redirect:/faculty/login";
//		}
//
//		Student student = studentService.getStudentById(studentId);
//		Faculty faculty = facultyService.getFacultyById(facultyId);
//
//		ChatMessage chatMessage = new ChatMessage(student, faculty, message, SenderType.FACULTY);
//		chatMessageService.sendMessage(chatMessage);
//
//		return "redirect:/faculty/chat/conversation?studentId=" + studentId;
//	}
//
//	@GetMapping("/conversation")
//	public ModelAndView conversation(HttpSession session, @RequestParam Long studentId) {
//		Long facultyId = (Long) session.getAttribute("facultyId");
//		if (facultyId == null) {
//			return new ModelAndView("redirect:/faculty/login");
//		}
//
//		List<ChatMessage> messages = chatMessageService.getChatHistory(studentId, facultyId);
//
//		ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-conversation");
//		mav.addObject("messages", messages);
//		mav.addObject("studentId", studentId); // Add studentId to the model
//		return mav;
//	}
//
//}

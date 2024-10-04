package com.manage.chat.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.manage.chat.entities.User;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String getChatPage(HttpSession session) {
        // Ensure the user is authenticated
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }
        return "chat"; // Returns chat.jsp
    }
}

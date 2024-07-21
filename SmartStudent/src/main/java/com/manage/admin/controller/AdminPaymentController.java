package com.manage.admin.controller;

import com.manage.admin.service.Admin_PaymentService;
import com.manage.student.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/payments")
public class AdminPaymentController {

    private final Admin_PaymentService adminPaymentService;

    @Autowired
    public AdminPaymentController(@Qualifier("adminPaymentServiceImpl") Admin_PaymentService adminPaymentService) {
        this.adminPaymentService = adminPaymentService;
    }

    @GetMapping
    public ModelAndView listPayments(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Payment> payments = adminPaymentService.getAllPayments();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-payments");
        mav.addObject("payments", payments);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showPaymentDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Payment payment = adminPaymentService.getPaymentById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-payment-details");
        mav.addObject("payment", payment);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditPaymentForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Payment payment = adminPaymentService.getPaymentById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-payment-edit");
        mav.addObject("payment", payment);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updatePayment(@PathVariable Long id, @ModelAttribute("payment") Payment payment, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminPaymentService.updatePayment(payment);
        return "redirect:/admin/payments/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deletePayment(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminPaymentService.deletePayment(id);
        return "redirect:/admin/payments";
    }

    @GetMapping("/new")
    public ModelAndView showNewPaymentForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-payment-new");
        mav.addObject("payment", new Payment());
        return mav;
    }

    @PostMapping("/new")
    public String savePayment(@ModelAttribute("payment") Payment payment, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminPaymentService.savePayment(payment);
        return "redirect:/admin/payments";
    }
}

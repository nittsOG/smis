package com.manage.admin.controller;

import com.manage.admin.service.Admin_FeeService;
import com.manage.student.entities.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/fees")
public class AdminFeeController {

    private final Admin_FeeService adminFeeService;

    @Autowired
    public AdminFeeController(@Qualifier("adminFeeServiceImpl") Admin_FeeService adminFeeService) {
        this.adminFeeService = adminFeeService;
    }

    @GetMapping
    public ModelAndView listFees(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Fee> fees = adminFeeService.getAllFees();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fees");
        mav.addObject("fees", fees);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showFeeDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Fee fee = adminFeeService.getFeeById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fee-details");
        mav.addObject("fee", fee);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFeeForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Fee fee = adminFeeService.getFeeById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fee-edit");
        mav.addObject("fee", fee);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateFee(@PathVariable Long id, @ModelAttribute("fee") Fee fee, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFeeService.updateFee(fee);
        return "redirect:/admin/fees/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteFee(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFeeService.deleteFee(id);
        return "redirect:/admin/fees";
    }

    @GetMapping("/new")
    public ModelAndView showNewFeeForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fee-new");
        mav.addObject("fee", new Fee());
        return mav;
    }

    @PostMapping("/new")
    public String saveFee(@ModelAttribute("fee") Fee fee, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFeeService.saveFee(fee);
        return "redirect:/admin/fees";
    }
}

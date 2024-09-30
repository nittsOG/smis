package com.manage.manager.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.manage.manager.service.Manager_FeeService;
import com.manage.manager.service.Manager_StudentSemesterService;
import com.manage.student.entities.Fee;

@Controller
@RequestMapping("/manager/fees")
public class ManagerFeeController {

    private final Manager_FeeService managerFeeService;
    private final Manager_StudentSemesterService manager_StudentSemesterService;

    @Autowired
    public ManagerFeeController(
            @Qualifier("managerFeeServiceImpl") Manager_FeeService managerFeeService,
            @Qualifier("managerStudentSemesterServiceImpl") Manager_StudentSemesterService manager_StudentSemesterService) {
        this.managerFeeService = managerFeeService;
        this.manager_StudentSemesterService = manager_StudentSemesterService;
    }

    // List fees with optional filtering by studentId
    @GetMapping
    public ModelAndView listFees(@RequestParam(value = "studentId", required = false) Long studentId,
            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Fee> fees;
        if (studentId != null) {
            fees = managerFeeService.getFeesByStudentId(studentId);
        } else {
            fees = managerFeeService.getAllFees();
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-fees");
        mav.addObject("fees", fees);
        return mav;
    }

    // Show fee details
    @GetMapping("/{id}")
    public ModelAndView showFeeDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Fee fee = managerFeeService.getFeeById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-fee-details");
        mav.addObject("fee", fee);
        return mav;
    }

    // Show form to edit a fee
    @GetMapping("/{id}/edit")
    public ModelAndView showEditFeeForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Fee fee = managerFeeService.getFeeById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-fee-edit");
        mav.addObject("fee", fee);
        return mav;
    }

    // Update fee using @RequestParam instead of @ModelAttribute
    @PostMapping("/{id}/edit")
    public String updateFee(@PathVariable Long id, @RequestParam("totalAmount") BigDecimal totalAmount,
            @RequestParam("paidAmount") BigDecimal paidAmount, @RequestParam("dueDate") String dueDate,
            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        Fee fee = managerFeeService.getFeeById(id);
        fee.setTotalAmount(totalAmount);
        fee.setPaidAmount(paidAmount);

        // Parsing date from string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fee.setDueDate(dateFormat.parse(dueDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/manager/fees/" + id + "/edit?error=Invalid date format";
        }

        managerFeeService.updateFee(fee);
        return "redirect:/manager/fees/" + id;
    }

//    // Delete fee
//    @GetMapping("/{id}/delete")
//    public String deleteFee(@PathVariable Long id, HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return "redirect:/manager/login";
//        }
//
//        managerFeeService.deleteFee(id);
//        return "redirect:/manager/fees";
//    }
//
//    // Show form to create a new fee
//    @GetMapping("/new")
//    public ModelAndView showNewFeeForm(HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return new ModelAndView("redirect:/manager/login");
//        }
//
//        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-fee-new");
//        mav.addObject("fee", new Fee());
//        return mav;
//    }
//
//    // Save new fee using @RequestParam instead of @ModelAttribute
//    @PostMapping("/new")
//    public String saveFee(@RequestParam("totalAmount") BigDecimal totalAmount,
//            @RequestParam("paidAmount") BigDecimal paidAmount, @RequestParam("dueDate") String dueDate,
//            @RequestParam("studentSemesterId") Long studentSemesterId, HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return "redirect:/manager/login";
//        }
//
//        Fee fee = new Fee();
//        fee.setTotalAmount(totalAmount);
//        fee.setPaidAmount(paidAmount);
//        fee.setStudentSemester(manager_StudentSemesterService.getStudentSemesterById(studentSemesterId));
//
//        // Parsing date from string
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            fee.setDueDate(dateFormat.parse(dueDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return "redirect:/manager/fees/new?error=Invalid date format";
//        }
//
//        managerFeeService.saveFee(fee);
//        return "redirect:/manager/fees";
//    }
}

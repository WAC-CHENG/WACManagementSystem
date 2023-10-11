package com.milotnt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milotnt.pojo.Admin;
import com.milotnt.pojo.Employee;
import com.milotnt.pojo.Member;
import com.milotnt.service.AdminService;
import com.milotnt.service.EmployeeService;
import com.milotnt.service.EquipmentService;
import com.milotnt.service.MemberService;


@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;

    //main go to admin page
    @RequestMapping("/")
    public String toAdminLogin() {
        return "adminLogin";
    }

    //membership login page redirect
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "userLogin";
    }

    //staff login page redirect
    @RequestMapping("/toEmployeeLogin")
    public String toEmployeeLogin() {
        return "employeeLogin";
    }

//get session's account
    public final String getAccountFromSession(HttpSession session) {
        return session.getAttribute("account").toString();
    }

    //admin login
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
//Call the business object to perform the administrator login function and obtain the return value
        Admin admin1 = adminService.adminLogin(admin);

        if (admin1 != null) {
//            Complete data binding to the session object (global)
//            model.addAttribute("account", admin1.getAdminAccount());

//            Complete data binding in the session object (global)
            session.setAttribute("account", admin1.getAdminAccount());
            System.out.println(getAccountFromSession(session));

            //Number of members
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            //Number of staff
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            //total number of people in the gym
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            //facilities number
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
//            return "redirect:/adminMain.html";
        }
        model.addAttribute("msg", "The account number or password you entered is incorrect, please re-enter it!");
        return "adminLogin";
    }

    //member login
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "The account number or password you entered is incorrect, please re-enter it!");
        return "userLogin";
    }

    //staff login
    @RequestMapping("/employeeLogin")
    public String employeeLogin(Employee employee, Model model, HttpSession session) {
        Employee member1 = employeeService.selectByAccountAndPassword(employee);
        if (member1 != null) {
            model.addAttribute("employee", member1);
            session.setAttribute("employee", member1);
            return "employeeMain";
        }
        model.addAttribute("msg", "The account number or password you entered is incorrect, please re-enter it!");
        return "employeeLogin";
    }

    //Jump to administrator homepage
//    @RequestMapping("/toAdminMain")
//    public String toAdminMain(Model model, HttpSession session) {
//        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
//        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
//        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
//        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
//        model.addAttribute("memberTotal", memberTotal);
//        model.addAttribute("employeeTotal", employeeTotal);
//        model.addAttribute("humanTotal", humanTotal);
//        model.addAttribute("equipmentTotal", equipmentTotal);
//        return "adminMain";
//    }

    //Jump to member homepage
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

}

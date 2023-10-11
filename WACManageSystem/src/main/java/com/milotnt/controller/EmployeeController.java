package com.milotnt.controller;

import com.milotnt.pojo.Employee;
import com.milotnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;



@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //search staff
    @RequestMapping("/selEmployee")
    public String selectEmployee(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "selectEmployee";
    }

    //go to new added staff page
    @RequestMapping("/toAddEmployee")
    public String toAddEmployee() {
        return "addEmployee";
    }

    //new added staff
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        //random staff number generate
        Random random = new Random();
        String account1 = "1010";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        //get current date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        employee.setEmployeeAccount(account);
        employee.setEntryTime(nowDay);

        employeeService.insertEmployee(employee);

        return "redirect:selEmployee";

    }

    //delete staff
    @RequestMapping("/delEmployee")
    public String deleteEmployee(Integer employeeAccount) {
        employeeService.deleteByEmployeeAccount(employeeAccount);
        return "redirect:selEmployee";
    }

    //go to staff modify page
    @RequestMapping("/toUpdateEmployee")
    public String toUpdateEmployee(Integer employeeAccount, Model model) {
        List<Employee> employeeList = employeeService.selectByEmployeeAccount(employeeAccount);
        model.addAttribute("employeeList", employeeList);
        return "updateEmployee";
    }

    //modify staff info
    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee) {
        employeeService.updateMemberByEmployeeAccount(employee);
        return "redirect:selEmployee";
    }

}

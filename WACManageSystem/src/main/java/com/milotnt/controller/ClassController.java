package com.milotnt.controller;

import com.milotnt.pojo.ClassOrder;
import com.milotnt.pojo.ClassTable;
import com.milotnt.service.ClassOrderService;
import com.milotnt.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

    @Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    //search class
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("classList", classList);
        return "selectClass";
    }

    //search class
    @RequestMapping("/selClass2")
    public String selectClass2(Model model) {
    	List<ClassTable> classList = classTableService.findAll();
    	model.addAttribute("classList", classList);
    	return "selectClass2";
    }

    //go to new added courses page
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    //new added course
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable) {
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    //delete course
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        classTableService.deleteClassByClassId(classId);
        classTableService.deleteOrderByClassId(classId);
        return "redirect:selClass";
    }

    //search course register
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }

    //check course register info
    @RequestMapping("/selClassOrder2")
    public String selectClassOrder2(Integer classId, Model model) {
    	List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
    	model.addAttribute("classOrderList", classOrderList);
    	return "selectClassOrder2";
    }

}

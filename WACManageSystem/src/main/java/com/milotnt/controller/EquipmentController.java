package com.milotnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;



@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //facility check
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model, HttpSession session) {
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipment";
    }
    
    //facility check
    @RequestMapping("/selEquipmentForUser")
    public String selEquipmentForUser(Model model, HttpSession session) {
    	Map<String,String> params=new HashMap<String,String>();
    	params.put("equipmentStatus", "normal");
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipmentForUser";
    }


    //delete facility
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:selEquipment";
    }

    //modify
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);
        return "updateEquipment";
    }

    //modify
    @RequestMapping("/toYuyueEquipment")
    public String toYuyueEquipment(Integer equipmentId, Model model) {
    	List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
    	model.addAttribute("equipmentList", equipmentList);
    	return "yuyueEquipment";
    }


    //modify
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:selEquipment";
    }

    //go to the new page
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment() {
        return "addEquipment";
    }

    //add facilities
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
    	equipment.setEquipmentStatus("正常");
        equipmentService.insertEquipment(equipment);
        return "redirect:selEquipment";
    }

}

package com.milotnt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.milotnt.pojo.EqOrder;
import com.milotnt.pojo.Equipment;
import com.milotnt.pojo.Member;
import com.milotnt.service.EqOrderService;
import com.milotnt.service.EquipmentService;


@Controller
@RequestMapping("/eqOrder")
public class EqOrderController {
    @Autowired
    private EqOrderService eqOrderService;
    @Autowired
    private EquipmentService equipmentService;

    //check facilities appointments
    @RequestMapping("/selEqOrder")
    public String selectEqOrder(String date, String time, Model model, HttpSession session) {
        //~~~~~~~~~~~~~~
        //incrypt info
        EqOrder seat = new EqOrder();
        if (date == null || date.length() == 0) {
            //2022-05-08  for checking all of the current date
            seat.setEqdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        } else {
                seat.setEqdate(date);
        }
        if (time == null || time.length() == 0) {
            //seat.setEqBegin("08am-12pm");
        } else {
            seat.setEqBegin(time);
        }
        List<EqOrder> equipmentList = eqOrderService.findAll(seat);
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEqOrder";
    }

    //check facility appointment
    @RequestMapping("/selEqOrder1")
    public String selectEqOrder1(String date, String time, Model model, HttpSession session) {
        //~~~~~~~~~~~~~~
        EqOrder seat = new EqOrder();
        if (date == null || date.length() == 0) {
            seat.setEqdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        } else {
            seat.setEqdate(date);
        }
        if (time == null || time.length() == 0) {
            //seat.setEqBegin("08点-12点");
        } else {
            seat.setEqBegin(time);
        }
        List<EqOrder> equipmentList = eqOrderService.findAll(seat);
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEqOrder1";
    }

    //go to the admin page
    @RequestMapping("/selEqOrderAdmin")
    public String selectEqOrderAdmin(String date, String time, Model model, HttpSession session) {

        EqOrder seat = new EqOrder();
        if (date == null || date.length() == 0) {
            seat.setEqdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        } else {
            seat.setEqdate(date);
        }
        if (time == null || time.length() == 0) {
            seat.setEqBegin("08am-12pm");
        } else {
            seat.setEqBegin(time);
        }
        List<EqOrder> equipmentList = eqOrderService.findAll(seat);
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEqOrderAdmin";
    }

    //check room
    @RequestMapping("/selEquipmentForUser")
    public String selEquipmentForUser(Model model, HttpSession session) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("equipmentStatus", "normal");
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipmentForUser";
    }


    //go to the facility modify page
    @RequestMapping("/toyuyueEquipment")
    public String toyuyueEquipment(Integer equipmentId, Model model, HttpSession session) {

        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        Integer memberAccount = member.getMemberAccount();
        List<EqOrder> equipmentList = eqOrderService.selectEqOrderByMemberAccount(memberAccount);
        model.addAttribute("equipmentList", equipmentList);
        return "yuyueEquipment";
    }

    //go to the facility modify page
    @RequestMapping("/yuyueEquipment")
    public String yuyueEquipment(Integer eqOrderId, Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();
        EqOrder eqOrder = eqOrderService.selectBYid(eqOrderId);
        eqOrder.setMemberAccount(memberAccount);
        eqOrder.setMemberName(memberName);
        eqOrder.setStatus("appointed");
        eqOrderService.updateEqOrder(eqOrder);
        return "redirect:toyuyueEquipment";
    }

    //go to the facility modify page
    @RequestMapping("/yuyueXiaofeiEquipment")
    public String yuyueXiaofeiEquipment(Integer eqOrderId, Model model) {

        EqOrder eqOrder = eqOrderService.selectBYid(eqOrderId);
        eqOrder.setStatus("arrived");
        eqOrderService.updateEqOrder(eqOrder);
        return "redirect:selEqOrderAdmin";
    }

    //go to the facility modify page
    @RequestMapping("/yuyueShuangyueEquipment")
    public String yuyueShuangyueEquipment(Integer eqOrderId, Model model) {

        EqOrder eqOrder = eqOrderService.selectBYid(eqOrderId);
        eqOrder.setStatus("爽约");
        eqOrderService.updateEqOrder(eqOrder);
        return "redirect:selEqOrderAdmin";
    }


    //新增器材
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
        equipment.setEquipmentStatus("正常");
        equipmentService.insertEquipment(equipment);
        return "redirect:toyuyueEquipment";
    }

    @RequestMapping("/totalBystatus1")
    public String TotalBystatus1(Model model) {
        return "totalBystatus";
    }

    @RequestMapping("/totalBystatus")
    @ResponseBody
    public List<EqOrder> TotalBystatus(Model model) {
        List<EqOrder> equipmentList = eqOrderService.TotalBystatus();
        return equipmentList;
    }

    @RequestMapping("/TotalByEq1")
    public String TotalByEq1(Model model) {
        return "totalByEq";
    }

    @RequestMapping("/TotalByEq")
    @ResponseBody
    public List<EqOrder> TotalByEq(Model model) {
        List<EqOrder> equipmentList = eqOrderService.TotalByEq();
        return equipmentList;
    }

    @RequestMapping("/TotalByEqBegin1")
    public String TotalByEqBegin1(Model model) {
        return "TotalByEqBegin";
    }

    @RequestMapping("/TotalByEqBegin")
    @ResponseBody
    public List<EqOrder> TotalByEqBegin(Model model) {
        List<EqOrder> equipmentList = eqOrderService.TotalByEqBegin();
        return equipmentList;
    }

}

package com.milotnt.service;

import com.milotnt.pojo.ClassOrder;

import java.util.List;


public interface ClassOrderService {

    //retrieve all registration info
    List<ClassOrder> findAll();

    //add registration info
    Boolean insertClassOrder(ClassOrder classOrder);

    //retrieve personal schedule by membership account
    List<ClassOrder> selectClassOrderByMemberAccount(Integer memberAccount);

    //delete appointed course
    Boolean deleteByClassOrderId(Integer classOrderId);

    //confirm if member registered
    ClassOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount);

    //retrieve all registered member by course id
    List<ClassOrder> selectMemberOrderList(Integer classId);

}

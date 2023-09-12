package com.milotnt.service;

import com.milotnt.pojo.Equipment;

import java.util.List;
import java.util.Map;



public interface EquipmentService {

    //Check all equipment
    List<Equipment> findAll();
    List<Equipment> findAllForUser(Map<String,String> params);

    //Delete equipment by ID
    Boolean deleteByEquipmentId(Integer equipmentId);

    //add equipment
    Boolean insertEquipment(Equipment equipment);

    //modify equipment info
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    //search equipment by ID
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    //check total equipment amount
    Integer selectTotalCount();

}

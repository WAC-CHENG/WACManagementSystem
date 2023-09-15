package com.milotnt.service;

import com.milotnt.pojo.ClassTable;

import java.util.List;


public interface ClassTableService {

    //Retrive all courses
    List<ClassTable> findAll();

    //delete course by id
    Boolean deleteClassByClassId(Integer classId);

    //add courses
    Boolean insertClass(ClassTable classTable);

    //retrive schedule by id
    ClassTable selectByClassId(Integer classId);

    //delete appointed courses by id
    Boolean deleteOrderByClassId(Integer classId);

}

package com.milotnt.service;

import com.milotnt.pojo.Employee;

import java.util.List;


public interface EmployeeService {

    //retrive all staff
    List<Employee> findAll();

    //delete staff by account
    Boolean deleteByEmployeeAccount(Integer employeeAccount);

    //add new staff
    Boolean insertEmployee(Employee employee);

    //modify member info by account
    Boolean updateMemberByEmployeeAccount(Employee employee);

    //retrive staff by account
    List<Employee> selectByEmployeeAccount(Integer employeeAccount);

    //retrive staff amount
    Integer selectTotalCount();

    Employee selectByAccountAndPassword(Employee employee);
}

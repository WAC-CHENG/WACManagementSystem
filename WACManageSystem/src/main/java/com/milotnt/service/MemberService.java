package com.milotnt.service;

import com.milotnt.pojo.Member;

import java.util.List;



public interface MemberService {

    //search member info
    List<Member> findAll();

    //new member info
    Boolean insertMember(Member member);

    //modify member info by id
    Boolean updateMemberByMemberAccount(Member member);

    //search member login password
    Member userLogin(Member member);
//    Member selectByAccountAndPassword(Member member);

    //delete member info by account
    Boolean deleteByMemberAccount(Integer memberAccount);

    //search member amount
    Integer selectTotalCount();

    //search member by account
    List<Member> selectByMemberAccount(Integer memberAccount);

}

package com.milotnt.service;

import com.milotnt.pojo.Notice;

import java.util.List;



public interface NoticeService {

    //search all informs
    List<Notice> findAll();

    //delete informs by id
//    Boolean deleteByNoticeId(Integer noticeId);
    Boolean deleteByNoticeId(Integer id);

    //add informs
    Boolean insertNotice(Notice notice);

    //modify inform info by id
    Boolean updateNoticeByNoticeId(Notice notice);

    //search informs by id
    List<Notice> selectByNoticeId(Integer noticeId);

    //search total amount of informs
    Integer selectTotalCount();

}

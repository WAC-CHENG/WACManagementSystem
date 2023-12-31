package com.milotnt.pojo;

import lombok.Data;

// 通知
//@Data
public class Notice {

	private Integer id;   //
	private String  title;   //标题
	private String  content;  //内容
	private String  time;   //时间
	

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

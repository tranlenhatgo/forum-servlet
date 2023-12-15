package com.myproject.model;

import java.sql.Date;

public class Thread {
	private int thread_id;
	private String thread_name;
	private String description;
	private String img;
	private String about_info;
	private Date created_at;
	private String lastPost;
	
	
	public Thread() {
		super();
	}

	public Thread(int thread_id, String thread_name, String description, String img, String about_info, Date created_at,
			String lastPost) {
		this.thread_id = thread_id;
		this.thread_name = thread_name;
		this.description = description;
		this.img = img;
		this.about_info = about_info;
		this.created_at = created_at;
		this.lastPost = lastPost;
	}

	public Thread(int thread_id, String thread_name, String description, String img, Date created_at) {
		this.thread_id = thread_id;
		this.thread_name = thread_name;
		this.description = description;
		this.img = img;
		this.created_at = created_at;
	}

	public Thread(String thread_name, String description, String img) {
		this.thread_name = thread_name;
		this.description = description;
		this.img = img;
	}
	
	public int getThread_id() {
		return thread_id;
	}
	public void setThread_id(int thread_id) {
		this.thread_id = thread_id;
	}
	public String getThread_name() {
		return thread_name;
	}
	public void setThread_name(String thread_name) {
		this.thread_name = thread_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getCreated_at() {
		return created_at;
	}
	
	public String getAbout_info() {
		return about_info;
	}

	public void setAbout_info(String about_info) {
		this.about_info = about_info;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getLastPost() {
		return lastPost;
	}
	public void setLastPost(String lastPost) {
		this.lastPost = lastPost;
	}
	@Override
	public String toString() {
		return "Thread [thread_id=" + thread_id + ", thread_name=" + thread_name + ", description=" + description
				+ ", img=" + img + ", created_at=" + created_at + ", lastPost=" + lastPost + "]";
	}
	
}

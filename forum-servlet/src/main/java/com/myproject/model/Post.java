package com.myproject.model;

import java.sql.Date;

public class Post {
	private int post_id;
	private User creater;
	private Thread thread;
	private String title;
	private String content;
	private String img;
	private Date created_at;
	
	
	public Post() {
	}
	
	public Post(User creater, Thread thread, String content, String img) {
		this.creater = creater;
		this.thread = thread;
		this.content = content;
		this.img = img;
	}

	public Post(int post_id, User creater, Thread thread, String title, String content, String img, Date created_at) {
		this.post_id = post_id;
		this.creater = creater;
		this.thread = thread;
		this.title = title;
		this.content = content;
		this.img = img;
		this.created_at = created_at;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public User getCreater() {
		return creater;
	}

	public void setcreater(User creater) {
		this.creater = creater;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", creater=" + creater.getUsername() + ", thread=" + thread.getThread_name() + ", title=" + title
				+ ", content=" + content + ", img=" + img + ", created_at=" + created_at + "]";
	}
	
	
	
}

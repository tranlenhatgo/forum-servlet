package com.myproject.model;

import java.sql.Date;

public class User {
	private int id;
	private String username;
	private String email;
	private String password;
	private String profile_pic;
	private int admin; //0=user 1=admin
	private Date created_at;
	
	public User() {
	}
	
	public User(int id, String username, String email, String password, String profile_pic, int admin, Date created_at) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.profile_pic = profile_pic;
		this.admin = admin;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getprofile_pic() {
		return profile_pic;
	}

	public void setprofile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}

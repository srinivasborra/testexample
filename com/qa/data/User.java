package com.qa.data;

public class User {
	private String name;
	private String job;
	
	public User(String name,String job){
		this.name = name;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
//	private int id;
//	private String first_name;
//	private String last_name;
//	private String avatar;
//	
//	public User(int id, String first_name,String last_name,String avatar){
//		this.id=id;
//		this.first_name=first_name;
//		this.last_name=last_name;
//		this.avatar = avatar;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getFirst_name() {
//		return first_name;
//	}
//	public void setFirst_name(String first_name) {
//		this.first_name = first_name;
//	}
//	public String getLast_name() {
//		return last_name;
//	}
//	public void setLast_name(String last_name) {
//		this.last_name = last_name;
//	}
//	public String getAvatar() {
//		return avatar;
//	}
//	public void setAvatar(String avatar) {
//		this.avatar = avatar;
//	}
//	
	
}

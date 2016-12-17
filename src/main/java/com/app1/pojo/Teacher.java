package com.app1.pojo;

import java.util.Arrays;

public class Teacher {
	private String name;
	private Course[] courses;
		
	public Teacher(String name, Course[] courses) {
		super();
		this.name = name;
		this.courses = courses;
	}
	
	public String getName() {
		return name;
	}
	public Course[] getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", courses=" + Arrays.toString(courses) + "]";
	}
	
	

}

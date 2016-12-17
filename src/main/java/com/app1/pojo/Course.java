package com.app1.pojo;

public class Course {
	private String name;
	private int fees;
	private int duration;
	public Course(int fees, String name, int duration) {
		super();
		this.name = name;
		this.fees = fees;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public int getFees() {
		return fees;
	}
	public int getDuration() {
		return duration;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", fees=" + fees + ", duration=" + duration + "]";
	}
	

}

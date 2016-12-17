package com.app1.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Student implements Comparable<Student> {
	private int rollNo;
	private String name;
	private Date dob;
	private String fathersName;
	private List<Course> courses;

	public Student(int rollNo, String name, Date dob, String fathersName) {
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.fathersName = fathersName;
		courses = new ArrayList<>();
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return dob;
	}

	public String getFathersName() {
		return fathersName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(Course course) {
		courses.add(course);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((fathersName == null) ? 0 : fathersName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (fathersName == null) {
			if (other.fathersName != null)
				return false;
		} else if (!fathersName.equals(other.fathersName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + ", fathersName=" + fathersName +
				"Courses=,"+Arrays.toString(courses.toArray())+"]";
	}

	@Override
	public int compareTo(Student name2) {
		return name2.rollNo - this.rollNo;
	}
	
	public static Comparator<Student> nameAscendingComparator =  new Comparator<Student>() {
		public int  compare(Student student1, Student student2) {
			return student1.getName().compareTo(student2.getName());
		}
	};
}

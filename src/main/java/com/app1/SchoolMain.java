package com.app1;

import com.app1.pojo.Course;
import com.app1.pojo.Student;
import com.app1.pojo.Teacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolMain {

	public static void main(String[] args) {
		// First creating students
		Student s1 = new Student(1, "Sudheer", new Date(), "Prasad");
		Student s3 = new Student(3, "Simple", new Date(), "Aba");
		Student s2 = new Student(2, "Aditya", new Date(), "Sub");
		
		// Now create 
		Course java = new Course( 10, "Java",30);
		Course ajs = new Course( 7, "AngularJS", 20);
		
		// Creating teachers
		Teacher t1=new Teacher("t1",new Course[]{java});
		Teacher t2=new Teacher("t2",new Course[]{ajs});
		Teacher t3=new Teacher("t3",new Course[]{java,ajs});
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		System.out.println(students.get(0).toString());
		
		s1.setCourses(java);
		s2.setCourses(ajs);
		s3.setCourses(java);
		s3.setCourses(ajs);
		
		System.out.println(students.get(0).toString());
		
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(t1);
		teachers.add(t2);
		teachers.add(t3);
		
		List<Course> courses = new ArrayList<>();
		courses.add(java);
		courses.add(ajs);
		
		System.out.println("All Students taking Java");
		takesCourse(students, java);
		System.out.println("All Stundents taking AngularJS");
		takesCourse(students, ajs);
		System.out.println("All Stundents only Java");
		takesOnlyCourse(students, java);
		System.out.println("All Stundents only AngularJS");
		takesOnlyCourse(students, ajs);
		System.out.println("All Teachers taking Java");
		getTeacherCourse ( java, teachers );

		System.out.println("All Teachers taking AngularJS");
		getTeacherCourse ( ajs, teachers );
	}

	private static void getTeacherCourse(Course course, List<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			Course[] tCourses = teacher.getCourses();
			for (int i = 0; i < tCourses.length; i++) {
				if(tCourses[i].equals(course)){
					System.out.println(teacher);
				}
			}
		}
	}

	public static void takesCourse(List<Student> students, Course course){
		for (Student student : students) {
			if(student.getCourses().contains(course)){
				System.out.println(student.getName());
			}
		}
	}
	
	public static void takesOnlyCourse(List<Student> students, Course course){
		for (Student student : students) {
			if(student.getCourses().contains(course) && student.getCourses().size()==1){
				System.out.println(student.getName());
			}
		}
	}

}

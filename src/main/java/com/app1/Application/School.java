package com.app1.Application;

import com.app1.pojo.Course;
import com.app1.pojo.Student;
import com.app1.pojo.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for supriya project
 * Created by sudheer on 26/11/16.
 */
public class School {
    private static List<Student> students = new ArrayList<> ( );
    private static List<Teacher> teachers = new ArrayList<> ( );
    private static List<Course> courses = new ArrayList<> ( );

    public static Student getStudentInforName(String name){
        printStudents ();
        for (Student student: students) {
            if(student.getName ().equals ( name )){
                return student;
            }
        }
        return null;
    }

    public static Student getStudentInforRollNumber(int rollNumber){
        printStudents ();
        for (Student student: students) {
            System.out.println ( "Searching for student : "+student );
            if(student.getRollNo () == rollNumber){
                return student;
            }
        }
        return null;
    }

    public static List<Student> getAllStudents(){
        return students;
    }

    public static void addStudent(Student student) {
        printStudents ();
        System.out.println ( "Adding student : "+student );
        students.add ( student );
        System.out.println ("Now count : "+students.size () );
        printStudents ();
    }

    private static void printStudents(){
        System.out.println ( "Print students..." );
        for (Student student:students){
            System.out.println ( student );
        }
    }

    public static void addCourse(Course course) {
        courses.add ( course );
    }

    public static List<Course> getAllCourses(){
        return courses;
    }



    public static void addTeacher(Teacher teacher) {
        printStudents ();
        System.out.println ( "Adding teacher : "+teacher );
        teachers.add ( teacher );
        System.out.println ("Now count : "+teachers.size () );
        printStudents ();
    }

    public static Course getCourseInforName(String name) {
        for (Course course:courses ) {
            if(course.getName ().equalsIgnoreCase ( name )) {
                return course;
            }
        }
        return null;
    }
}

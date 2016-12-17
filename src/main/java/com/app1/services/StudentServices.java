package com.app1.services;

import com.app1.Application.School;
import com.app1.pojo.Student;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Class for supriya project
 * Created by sudheer on 26/11/16.
 */
@Path ( "/studentInfo" )
public class StudentServices {

    @GET
    @Path ( "/rollNo={rollNo}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentData(@PathParam ( "rollNo" ) int rollNo){
        System.out.println ( "Looking for student with rollno : "+rollNo );
        Student matching = School.getStudentInforRollNumber ( rollNo );
        System.out.println ( "Got match : "+matching );
        return Response.status(200).entity(matching).build ();
    }

    @GET
    @Path ( "/name={name}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentData(@PathParam ( "name" ) String name){
        System.out.println ( "Looking for student with name : "+name+"****" );
        Student matching = School.getStudentInforName ( name );
        System.out.println ( "Got match : "+matching );
        return Response.status(200).entity(matching).build ();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentData(){
        return Response.status(200).entity(School.getAllStudents ()).build ();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testStudentService(){
        return "Student service is working fine!!!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path ( "/addStudent" )
    public Response addStudent(String input){
        JSONObject body = new JSONObject ( input );
        System.out.println ( "Got the body as : "+body.toString () );
        Student student = new Student ( body.getInt ( "rollNo" ), body.getString ( "name" ), new Date(), body
                .getString ( "fathersName" ));
        School.addStudent(student);
        String result = "Student created : " + student;
        return Response.status(201).entity(result).build();

    }

}

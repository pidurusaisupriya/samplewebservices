package com.app1.services;

import com.app1.Application.School;
import com.app1.pojo.Course;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Class for supriya project
 * Created by sudheer on 26/11/16.
 */
@Path ( "/courseInfo" )
public class CourseServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path( "/addCourse" )
    public Response addStudent(String input){
        JSONObject body = new JSONObject ( input );
        System.out.println ( "Got the body as : "+body.toString () );
        Course course = new Course ( body.getInt ( "fee" ), body.getString ( "name" ), body
                .getInt ( "duration" ));
        School.addCourse(course);
        String result = "course created : " + course;
        return Response.status(201).entity(result).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseData(){
        return Response.status(200).entity(School.getAllCourses ()).build ();
    }


    @GET
    @Path ( "/name={name}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseData(@PathParam ( "name" ) String name){
        System.out.println ( "Looking for student with name : "+name+"****" );
        Course matching = School.getCourseInforName ( name );
        System.out.println ( "Got match : "+matching );
        return Response.status(200).entity(matching).build ();
    }

}

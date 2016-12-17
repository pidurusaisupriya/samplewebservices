package com.app1.services;

import com.app1.Application.School;
import com.app1.pojo.Course;
import com.app1.pojo.Teacher;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Class for supriya project
 * Created by sudheer on 26/11/16.
 */
public class TeacherServices {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path( "/addTeacher" )
    public Response addTeacher(String input){
        JSONObject body = new JSONObject ( input );
        System.out.println ( "Got the body as : "+body.toString () );
        String name = body.getString ( "name" );
        JSONArray courseArray = body.getJSONArray ( "course" );
        Course[] courses = new Course[courseArray.length ()];
        for (int i=0;i<courseArray.length ();i++){
            courses[i] = School.getCourseInforName ( courseArray.getString ( i ) );
        }
        Teacher teacher = new Teacher ( name, courses);
        School.addTeacher(teacher);
        String result = "Teacher created : " + teacher;
        return Response.status(201).entity(result).build();

    }
}

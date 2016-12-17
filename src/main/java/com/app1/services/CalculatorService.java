package com.app1.services;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Class for supriya project
 * Created by sudheer on 27/11/16.
 */
@Path ( "/calculator" )
public class CalculatorService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public static Response calculator(String input){
        JSONObject body=new JSONObject ( input );
        String operation=body.getString ( "operation" );
        JSONArray data=body.getJSONArray ( "input" );
        double result = 0;
        switch(operation){
            case "ADD":
                result = add(data);
                break;
            case "SUB":
                result = sub(data);
                break;
            case "MUL":
                result = mul(data);
                break;
            case "DIV":
                result =  divide(data);
                break;
                
        }
        return Response.status(200).entity(result).build();
    }

    private static double add(JSONArray data) {
        double result=0;
        for(int i=0;i<data.length ();i++){
            result=result+data.getInt ( i );
        }
        return result;
    }

    private static double mul(JSONArray data) {
        double result=1;
        for(int i=0;i<data.length ();i++){
            result=result-data.getInt ( i );
        }
        return result;
    }

    private static double sub(JSONArray data) {
        double result=0;
        for(int i=0;i<data.length ();i++){
            result=result*data.getInt ( i );
        }
        return result;
    }

    private static double divide(JSONArray data) {
        double result=1;
        for(int i=0;i<data.length ();i++){
            result=result/data.getInt ( i );
        }
        return result;
    }
}

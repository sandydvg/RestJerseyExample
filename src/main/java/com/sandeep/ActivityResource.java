package com.sandeep;

import com.sandeep.model.Activity;
import com.sandeep.model.User;
import com.sandeep.repository.ActivityRepository;
import com.sandeep.repository.ActivityRepositoryStub;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;


@Path("activities")// http://localhost:8080/webapi/activities
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();



    @POST
    @Path("activity")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_JSON)
    public Activity createActivity(Activity activity){
        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());
        activityRepository.create(activity);
        return activity;
    }



    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String,String> formParams){

        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));
        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
        activityRepository.create(activity);
        return activity;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Activity> getAllActivity(){
        return activityRepository.findAllActivity();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{activityId}") //http://localhost:8080/webapi/activities/1234
    public Activity getActivity(@PathParam("activityId") String activityId){
        return activityRepository.findActivty(activityId);
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{activityId}/user") //http://localhost:8080/webapi/activities/1234
    public User getActivityUser(@PathParam("activityId") String activityId){
        Activity activity = activityRepository.findActivty(activityId);
        User user = activity.getUser();
        return  user;
       // return activityRepository.findActivty(activityId).getUser();
    }




}

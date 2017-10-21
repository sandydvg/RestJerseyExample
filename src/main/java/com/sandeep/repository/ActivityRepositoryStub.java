package com.sandeep.repository;

import com.sandeep.model.Activity;
import com.sandeep.model.User;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository{


    @Override
    public List<Activity> findAllActivity() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(45);

        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        activities.add(activity1);
        activities.add(activity2);

        return activities;
    }

    @Override
    public Activity findActivty(String activityId) {
        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(45);
        activity1.setId("1234");
        User user = new User();
        user.setId("7657");
        user.setName("Sandeep");
        activity1.setUser(user);
        return  activity1;
    }

    @Override
    public void create(Activity activity) {
        // Should insert Db call ideally
    }
}

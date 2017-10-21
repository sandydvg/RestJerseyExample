package com.sandeep.repository;

import com.sandeep.model.Activity;

import java.util.List;

public interface ActivityRepository {

    List<Activity> findAllActivity();

    Activity findActivty(String activityId);


    void create(Activity activity);
}

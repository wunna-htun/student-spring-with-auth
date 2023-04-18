package com.example.studentregistration.controller;

import com.example.studentregistration.service.MySchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerController {

    @Autowired
    private

    MySchedulerService schedulerService;


    @PostMapping("/schedule")
    public void updateSchedule(@RequestBody String cronExpression)

    {

        System.out.println("schedule controller");

        schedulerService.changeCronExpression(cronExpression);



    }
}

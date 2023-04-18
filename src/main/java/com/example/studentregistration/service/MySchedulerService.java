package com.example.studentregistration.service;

import com.example.studentregistration.scheduler.MyScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class MySchedulerService {

    @Autowired
    private

    ThreadPoolTaskScheduler taskScheduler;


    @Autowired
    private

    MyScheduler myScheduler;


    public void changeCronExpression(String cronExpression)

    {


        System.out.println("schedule service");

        myScheduler.setCronExpression(cronExpression);



        taskScheduler.schedule(myScheduler::runScheduledTask,

                new CronTrigger

                        (cronExpression));



    }
}

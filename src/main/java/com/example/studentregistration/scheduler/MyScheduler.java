package com.example.studentregistration.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

//    @Scheduled(cron = "0 0/5 * * * *") // run every 5 minutes
@Scheduled(cron = "*/10 * * * * *")
    public void runScheduledTask()

    {


        // put your code here that you want to run periodically

        System.out.println(

                "Running scheduled task..."

        );



    }
}

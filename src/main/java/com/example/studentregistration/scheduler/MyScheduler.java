package com.example.studentregistration.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {
    private String cronExpression = "0 0/5 * * * *"; // default cron expression



    //    @Scheduled(cron = "0 0/5 * * * *") // run every 5 minutes
//@Scheduled(cron = "*/10 * * * * *")// run every 10 seconds
@Scheduled(cron = "#{@myScheduler.getCronExpression()}")
    public void runScheduledTask()

    {


        // put your code here that you want to run periodically

        System.out.println(

                "Running scheduled task...cron:"+getCronExpression()

        );



    }


    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}

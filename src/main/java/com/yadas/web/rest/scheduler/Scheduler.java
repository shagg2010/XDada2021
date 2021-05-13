package com.yadas.web.rest.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class Scheduler {

    /**
     * to execute the task every minute starting at 9:00 AM and ending at 9:59 AM, every day
     */
    @Scheduled(cron = "0 * 19 * * ?")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("---> Java cron job expression:: " + strDate);
    }

    //The fixedDelay property makes sure that there is a delay of n millisecond between the finish time of an
    // execution of a task and the start time of the next execution of the task. For dependent jobs, it is quite helpful.
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        //System.out.println("Fixed delay task:\t\t" + strDate);
    }

    //The fixedRate property runs the scheduled task at every n millisecond.
    // It doesn't check for any previous executions of the task.
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = new Date();
            String strDate = sdf.format(now);
            //System.out.println("Fixed rate task async:\t" + strDate);
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
    }
}

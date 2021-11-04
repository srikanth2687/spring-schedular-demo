package com.schedular.demo;

import org.springframework.stereotype.Component;

import java.util.Date;


public class MyTask implements Runnable{

    private TaskScheduler taskScheduler;

    public MyTask(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void run() {
        System.out.println( new Date() + " Running Task for::"+ taskScheduler.getClientName()+" Cron Expression:: "+ taskScheduler.getCronExpression());
    }
}

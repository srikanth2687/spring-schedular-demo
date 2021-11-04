package com.schedular.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ScheduledTasks {

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private TaskSchedulerRepo taskSchedulerRepo;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public void scheduleAllCrons() {
        List<com.schedular.demo.TaskScheduler> taskSchedulers = taskSchedulerRepo.findAll();
        taskSchedulers.forEach(cronJob -> taskScheduler.schedule(new MyTask(cronJob), new CronTrigger(cronJob.getCronExpression())));
    }
}

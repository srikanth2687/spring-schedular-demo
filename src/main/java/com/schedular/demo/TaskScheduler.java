package com.schedular.demo;

import javax.persistence.*;

@Entity
@Table(name = "TASK_SCHEDULER")
public class TaskScheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "cron_expression")
    private String cronExpression;
    @Column(name = "clientName")
    private String clientName;
    @Column(name = "config_1")
    private String config1;
    @Column(name = "config_2")
    private String config2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getConfig1() {
        return config1;
    }

    public void setConfig1(String config1) {
        this.config1 = config1;
    }

    public String getConfig2() {
        return config2;
    }

    public void setConfig2(String config2) {
        this.config2 = config2;
    }
}

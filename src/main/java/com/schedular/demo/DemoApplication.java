package com.schedular.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		ScheduledTasks scheduledTasks = ctx.getBean(ScheduledTasks.class);
		scheduledTasks.scheduleAllCrons();
	}

	@PostConstruct
	private void initDb() {
		System.out.println("****** Inserting more sample data in the table: TASK_SCHEDULER ******");
		String sqlStatements[] = {
				"INSERT INTO TASK_SCHEDULER (id,cron_expression, client_name, config_1,config_2) VALUES (1,'10 * * * * *', 'client1', 'client1_config_1', 'client1_config_2')",
		"INSERT INTO TASK_SCHEDULER (id, cron_expression, client_name, config_1,config_2) VALUES (2,'20 * * * * *', 'client2', 'client2_config_1', 'client2_config_2')",
		"INSERT INTO TASK_SCHEDULER (id, cron_expression, client_name, config_1,config_2) VALUES (3,'30 * * * * *', 'client3', 'client3_config_1', 'client3_config_2')"
		};

		Arrays.asList(sqlStatements).stream().forEach(sql -> {
			System.out.println(sql);
			jdbcTemplate.execute(sql);
		});
	}

}

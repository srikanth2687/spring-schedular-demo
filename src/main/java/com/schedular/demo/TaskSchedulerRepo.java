package com.schedular.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSchedulerRepo extends JpaRepository<TaskScheduler,Long> {



}

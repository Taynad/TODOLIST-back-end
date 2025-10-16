package com.tay.springSecurityWithJWT2.repository;

import com.tay.springSecurityWithJWT2.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    boolean existsByNameTask(String nameTask);

}

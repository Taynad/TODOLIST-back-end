package com.tay.springSecurityWithJWT2.controller;

import com.tay.springSecurityWithJWT2.dto.TaskDTO;
import com.tay.springSecurityWithJWT2.model.TaskModel;
import com.tay.springSecurityWithJWT2.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //métodos
    @PostMapping
    public ResponseEntity<TaskDTO>save(@RequestBody TaskDTO taskDTO){
        taskService.save(taskDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<TaskModel> findAll(){
        return taskService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update (@PathVariable Long id, @RequestBody TaskDTO TaskDTO){
        taskService.updateTask(id, TaskDTO.getNameTask(), TaskDTO.getDescription());
        return ResponseEntity.ok().build();
    }
}

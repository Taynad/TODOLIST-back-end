package com.tay.springSecurityWithJWT2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private long id;
    private String nameTask;
    private String description;

    public TaskDTO(String nameTask, String description){
        this.nameTask = nameTask;
        this.description = description;
    }
}

package com.tay.springSecurityWithJWT2.service;

import com.tay.springSecurityWithJWT2.dto.TaskDTO;
import com.tay.springSecurityWithJWT2.exception.BusinessException;
import com.tay.springSecurityWithJWT2.exception.TaskIsNullException;
import com.tay.springSecurityWithJWT2.exception.TaskNotFoundException;
import com.tay.springSecurityWithJWT2.model.TaskModel;
import com.tay.springSecurityWithJWT2.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //métodos
    public TaskDTO save (TaskDTO taskDTO){
        //não pode enviar dados nulos e não pode salvar a mesma tarefa
        if(taskDTO.getNameTask() == null && taskDTO.getDescription() == null){
            throw new TaskIsNullException("Dados não podem estar nulos");
        }

        if(taskRepository.existsByNameTask(taskDTO.getNameTask())){
            throw new BusinessException("Tarefa já cadastrada!");
        }

        TaskModel taskModel = new TaskModel();
        taskModel.setNameTask(taskDTO.getNameTask());
        taskModel.setDescription(taskDTO.getDescription());

        taskRepository.save(taskModel);

        return new TaskDTO(taskDTO.getId(), taskDTO.getNameTask(), taskDTO.getDescription());
    }

    public List<TaskModel> findAll(){
        //Se a lista estiver vazia
        List<TaskModel> listTask = taskRepository.findAll();

        if (listTask.isEmpty()){
            throw new TaskNotFoundException("Nenhuma tarefa cadastrada");
        }

        return listTask;
    }

    public void delete(Long id){
        //não achar a tarefa
        if (!taskRepository.existsById(id)){
            throw new TaskNotFoundException("Tarefa não cadastrada!");
        }

        taskRepository.deleteById(id);
    }

    public void updateTask (Long id, String nameTask, String description){
        //pode acontecer de não achar a tarefa
        TaskModel taskModel = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa não cadastrada!"));

        taskModel.setNameTask(nameTask);
        taskModel.setDescription(description);

        TaskModel updateTask = taskRepository.save(taskModel);
    }
}

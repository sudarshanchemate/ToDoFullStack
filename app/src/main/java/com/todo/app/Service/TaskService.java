package com.todo.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.Model.Task;
import com.todo.app.Repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public String addTask(Task task) {
		taskRepository.save(task);
		return "Task added successfully.";
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}

	public boolean deleteTask(Integer id) { // Method to delete a task by ID
        if (taskRepository.existsById(id)) { // Check if the task exists
            taskRepository.deleteById(id); // Delete the task
            return true; 
        }
        return false; // Return false if not found
    }
}

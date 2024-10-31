package com.todo.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.Model.Task;
import com.todo.app.Service.TaskService;

@RestController
public class HomeController {

	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/AddTasks")
	@CrossOrigin("*")
	public ResponseEntity<String> addTask(@RequestBody Task task) {
		String res = taskService.addTask(task);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/tasks")
	@CrossOrigin("*")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
	
	@DeleteMapping("/tasks/{id}") // Accept task ID as a path variable
    @CrossOrigin("*")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) { // Use @PathVariable to get ID
        boolean isDeleted = taskService.deleteTask(id); // Call delete method in service
        if (isDeleted) {
            return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.spring.mongo.connect;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mongo.connect.model.Task;
import com.example.spring.mongo.connect.repository.TaskRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepo;
	
	
	@GetMapping("/getAllTasks")
	public ResponseEntity<List<Task>> getAllTasks(){
		return new ResponseEntity<List<Task>>(taskRepo.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/createTask")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		
		return new ResponseEntity<Task>(taskRepo.save(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		
		
		return new ResponseEntity<Task>(taskRepo.save(task), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public void deleteTask(@PathVariable String id) {
		taskRepo.deleteById(new ObjectId(id));
	}

}

package com.example.spring.mongo.connect.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.mongo.connect.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

	void deleteById(ObjectId objectId);

}

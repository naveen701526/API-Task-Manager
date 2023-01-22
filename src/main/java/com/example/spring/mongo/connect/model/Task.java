package com.example.spring.mongo.connect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Task")
public class Task {

	@Id
    
    private String id;
	
	private String text;
	
	private String day;
	
	private boolean Reminder;

	public Task( String text, String day, boolean reminder) {
		super();
		this.text = text;
		this.day = day;
		Reminder = reminder;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isReminder() {
		return Reminder;
	}

	public void setReminder(boolean reminder) {
		Reminder = reminder;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", text=" + text + ", day=" + day + ", Reminder=" + Reminder + "]";
	}
	
	
	
	
	
	
}

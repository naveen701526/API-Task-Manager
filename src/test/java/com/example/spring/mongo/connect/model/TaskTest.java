package com.example.spring.mongo.connect.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        String text = "example task";
        String day = "Monday";
        boolean reminder = true;

        Task task = new Task(text, day, reminder);

        Assertions.assertNotNull(task);
        Assertions.assertEquals(text, task.getText());
        Assertions.assertEquals(day, task.getDay());
        Assertions.assertEquals(reminder, task.isReminder());
    }

    @Test
    public void testTaskSettersAndGetters() {
        String text = "example task";
        String day = "Monday";
        boolean reminder = true;

        Task task = new Task();
        task.setText(text);
        task.setDay(day);
        task.setReminder(reminder);

        Assertions.assertNotNull(task);
        Assertions.assertEquals(text, task.getText());
        Assertions.assertEquals(day, task.getDay());
        Assertions.assertEquals(reminder, task.isReminder());
    }

    @Test
    public void testTaskToString() {
        String id = "abc123";
        String text = "example task";
        String day = "Monday";
        boolean reminder = true;

        Task task = new Task(text, day, reminder);
        task.setId(id);

        String expectedString = "Task [id=" + id + ", text=" + text + ", day=" + day + ", Reminder=" + reminder + "]";
        Assertions.assertEquals(expectedString, task.toString());
    }
}

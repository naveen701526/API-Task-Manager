package com.example.spring.mongo.connect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.spring.mongo.connect.model.Task;
import com.example.spring.mongo.connect.repository.TaskRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
@ContextConfiguration(classes = { TaskController.class })
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepo;

    @InjectMocks
    private TaskController taskController;

    private List<Task> tasks;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tasks = Arrays.asList(
            new Task(new ObjectId(), "Task 1", "Description 1", "John"),
            new Task(new ObjectId(), "Task 2", "Description 2", "Mary")
        );
    }

    @Test
    void testGetAllTasks() throws Exception {
        when(taskRepo.findAll()).thenReturn(tasks);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/getAllTasks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), tasks.toString());
    }

    @Test
    void testCreateTask() throws Exception {
        Task task = new Task(new ObjectId(), "Task 3", "Description 3", "John");
        when(taskRepo.save(task)).thenReturn(task);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks/createTask")
                .content(task.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), task.toString());
    }

    @Test
    void testUpdateTask() throws Exception {
        Task task = tasks.get(0);
        task.setDescription("Updated description");
        when(taskRepo.save(task)).thenReturn(task);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/tasks/updateTask/" + task.getId())
                .content(task.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), task.toString());
    }

    @Test
    void testDeleteTask() throws Exception {
        Task task = tasks.get(0);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/tasks/deleteTask/" + task.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

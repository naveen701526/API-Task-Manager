# Task Manager API with Spring Boot and MongoDB


## Running the SpringBoot application

```cd``` into the project directory and run the following command to create a ```.jar``` file of the project:

```shell
mvn clean install
```

This will create a ```.jar``` file in the ```target``` directory, inside the project directory. Now to run the project, run the following command from the same project directory:

```shell
java -jar target/<name_of_jar_file>.jar
```

You should now be seeing the output in the terminal.


# Deployment Link

https://api-task-manager-o0lr.onrender.com

# Working End Points of API

## API END POINT : https://api-task-manager-o0lr.onrender.com/api/tasks

### GET ALL TASKS : /getAllTasks

### POST A SINGLE TASK : /createTask

### UPDATE A SINGLE TASK : /updateTask/{id}

### DELETE A SINGLE TASK : /deleteTask/{id}

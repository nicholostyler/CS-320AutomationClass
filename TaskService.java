import java.util.ArrayList;
import java.util.List;

//Author Name: Nicholos Tyler

//Date: 2/14/2021

//Course ID: T3228

//Description: TaskService class that takes the object Task and allows adding, deleting and modifying them.

public class TaskService {
    public List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<Task>();
    }

    public void AddTask(String id, String name, String description) {
        // If the ID is verified.
        if (VerifyID(id)) {
            // Loop through list to make sure we are not adding a duplicate task
            for (Task task : tasks) {
                // If current task equals the passed in value throw an exception
                if (task.getID().equals(id)) {
                    throw new IllegalArgumentException();
                }
            }
            Task newTask = new Task(id, name, description);
            tasks.add(newTask);
        }
    }

    public void RemoveTask(String id) {
        // if the task is verified remove it is it matches the given ID
        if (VerifyID(id)) {
            tasks.removeIf(task -> (task.getID().equals(id) == true));
        }
    }

    public void UpdateTask(String id, String name, String description) {
        // Loop through each task to find out that matches the id
        for (Task task : tasks) {
            if (task.getID().equals(id)) {
                // Use the task verifier to make sure the arguments are correct.
                if (task.VerifyInput(id, name, description)) {
                    task.setDescription(description);
                    task.setName(name);
                }
            }
        }
    }

    private boolean VerifyID(String id) {
        // Verify that the ID matches the requirements of being below 10 and not null
        if (id.length() <= 10 && id != null && !id.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Author Name: Nicholos Tyler

//Date: 2/14/2021

//Course ID: T3228

//Description: TaskServiceTest class that is a UnitTest for the TaskServiec class

public class TaskServiceTest {
    @Test
    void TestAddSingleTask() {
        TaskService service = new TaskService();
        service.AddTask("123", "Get Milk", "Go To The Store and Get Milk");
        assertTrue(service.tasks.size() == 1, "True: Size of list is 1.");
    }

    @Test
    void TestAddingMultipleTasks() {
        TaskService service = new TaskService();
        service.AddTask("123", "Get Milk", "Go To The Store and Get Milk");
        service.AddTask("1234", "Get Milk", "Go To The Store and Get Milk");
        assertTrue(service.tasks.size() == 2, "True: Size of list is 2.");
    }

    @Test
    void TestErrorDuplicateID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TaskService service = new TaskService();
            service.AddTask("123", "Get Milk", "GO to Store Get Milk");
            service.AddTask("123", "Get Milk", "Go to Store Get Milk");
        }, "True: Error was thrown for duplicate ID.");
    }

    @Test
    void TestAddingAndGettingTask() {
        TaskService service = new TaskService();
        service.AddTask("123", "Get Milk", "GO to Store Get Milk");
        assertTrue(service.tasks.get(0).getID().equals("123"), "True: Returned the same task I added.");
    }

    @Test
    void TestMultipleAdditions() {
        TaskService service = new TaskService();
        for (int i = 0; i <= 5; i++) {
            service.AddTask(String.valueOf((i)), "Get Milk", "Go To The Store and Get Milk");
        }
        assertTrue(service.tasks.size() == 6);
    }

    @Test
    void TestUpdatingTask() {
        TaskService service = new TaskService();
        service.AddTask("123", "Get Milk", "Go to the store and get milk");
        service.UpdateTask("123", "Get Eggs", "Go to the store and get eggs");

        assertTrue(service.tasks.get(0).getName() == "Get Eggs", "True: Task successfully updated.");
    }

    @Test
    void TestDeletingTask() {
        TaskService service = new TaskService();
        service.AddTask("123", "Get Milk", "Go to the store and get milk");
        service.RemoveTask("123");
        assertTrue(service.tasks.size() == 0, "True: Task deleted without an error.");
    }
}

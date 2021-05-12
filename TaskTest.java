import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Author Name: Nicholos Tyler

//Date: 2/14/2021

//Course ID: T3228

//Description: TaskTest class that is a UnitTest for the Task class

public class TaskTest {
    @Test
    void TestCreateTask() {
        Task testTask = new Task("123", "Get Milk", "Go to Store Get Milk");
        assertTrue(testTask.getID().equals("123"), "ID is equal.");
        assertTrue(testTask.getName().equals("Get Milk"), "Name is equal.");
        assertTrue(testTask.getDescription().equals("Go to Store Get Milk"), "Description is equal.");
    }

    @Test
    void TestIDTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task testTask = new Task("012345678910", "Get Milk", "Go to Store Get Milk");
        }, "True: ID is too long.");
    }

    @Test
    void TestDescriptionTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task testTask = new Task("123", "Get Milk", "This Description is too long and should throw some error.");
        }, "True: Description is too long.");
    }

    @Test
    void TestNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task testTask = new Task("123", "Get Milk Is Too Long of a task", "Go to Store Get Milk");
        }, "True: Name is too long.");
    }

}

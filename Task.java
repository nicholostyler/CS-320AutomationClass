//Author Name: Nicholos Tyler

//Date: 2/14/2021

//Course ID: T3228

//Description: Task class that creates the bones for an object that can be used by the TaskService class.

public class Task {
    // Create default member variables
    private String ID;
    private String name;
    private String description;

    public Task(String id, String name, String description) {
        // If the variables are validated, assign them to the member variables
        if (VerifyInput(id, name, description)) {
            this.ID = id;
            this.name = name;
            this.description = description;
        }
    }

    public boolean VerifyInput(String id, String name, String description) {
        // Verify that the input is correct and matches the requirements.
        if (id.length() <= 10 && id != null && !id.equals("")) {
            if (name.length() <= 20 && name != null && !name.equals("")) {
                if (description.length() <= 50 && description != null && !description.equals("")) {
                    return true;
                }
            }
        }

        // If the arguments do not fill the correct value requirements.
        throw new IllegalArgumentException();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

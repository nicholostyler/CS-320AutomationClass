import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Author Name: Nicholos Tyler

//Date: 2/7/2021

//Course ID: T3228

//Description: AppointmentService class that provides a list to add and remove appointments.

public class AppointmentService {
    public List<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<Appointment>();
    }

    public void AddAppointment(String id, String description, Date date) {
        // if id is null, or has a length greater than 10 throw an exception.
        if (id == null || id.length() > 10) throw new IllegalArgumentException();
        // Loop through list to make sure we are not adding a duplicate appointment
        for (Appointment appointment : appointments) {
            // If current task equals the passed in value throw an exception
            if (appointment.getId().equals(id)) {
                throw new IllegalArgumentException();
            }
        }
        // create an appointment given the parameters.
        // this is safe as the constructor utilizes the mutator methods that have built in
        // error checking.
        Appointment newAppointment = new Appointment(id, date, description);

        appointments.add(newAppointment);
    }

    public void RemoveAppointment(String id) {
        // if id is null, or has a length greater than 10 throw an exception.
        if (id == null && id.equals("") && id.length() > 10) throw new IllegalArgumentException();
        // iterate over the array list and find an appointment that matches the id parameter.
        appointments.removeIf(appointment -> (appointment.getId().equals(id) == true));
    }
}

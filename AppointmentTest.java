import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Author Name: Nicholos Tyler

//Date: 2/7/2021

//Course ID: T3228

//Description: AppointmentTest UnitTest class that tests the functionality and error testing of the class.

public class AppointmentTest {
    @Test
    void TestCreateTask() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 5); // adds 5 days to current day.
        Date newDay = cal.getTime();

        Appointment testAppointment = new Appointment("123", newDay, "Go to Store Get Milk");
        assertTrue(testAppointment.getId().equals("123"));
        assertTrue(testAppointment.getDescription().equals("Go to Store Get Milk"));
        assertTrue(testAppointment.getDate().equals(newDay));
    }

    @Test
    void TestIDTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, 5); // adds 5 days to current day.
            Date newDay = cal.getTime();
            Appointment testAppointment = new Appointment("012345678910", newDay, "Go to Store Get Milk");
        });
    }

    @Test
    void TestDescriptionTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, 5); // adds 5 days to current day.
            Date newDay = cal.getTime();
            Appointment testAppointment = new Appointment("123", newDay, "This Description is too long and should throw some error.");
        });
    }

    @Test
    void TestDateInPast() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, -5); // adds 5 days to current day.
            Date newDay = cal.getTime();
            Appointment testAppointment = new Appointment("123", newDay, "Go to Store Get Milk");
        });
    }
}

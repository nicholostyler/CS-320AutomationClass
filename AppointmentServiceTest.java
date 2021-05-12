import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Author Name: Nicholos Tyler

//Date: 2/7/2021

//Course ID: T3228

//Description: AppointmentServiceTest UnitTest class that tests the functionality and error testing of the class.

public class AppointmentServiceTest {
    @Test
    void TestAddSingleAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 5); // adds 5 days to current day.
        Date newDay = cal.getTime();

        service.AddAppointment("123", "Go to store", newDay);

        assertTrue(service.appointments.size() == 1, "True: Successfully added appointment.");
    }

    @Test
    void TestAddingMultipleAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 5); // adds 5 days to current day.
        Date newDay = cal.getTime();

        service.AddAppointment("123", "Go to store", newDay);
        service.AddAppointment("124", "Go to store", newDay);
        assertTrue(service.appointments.size() == 2, "True: Successfully added two appointments.");
    }

    @Test
    void TestErrorDuplicateID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AppointmentService service = new AppointmentService();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, 5); // adds 5 days to current day.
            Date newDay = cal.getTime();

            service.AddAppointment("123", "get milk", newDay);
            service.AddAppointment("123", "get milk", newDay);
        }, "True: Successfully thrown error for adding duplicate IDs.");
    }

    @Test
    void TestAddingAndGettingAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 5); // adds 5 days to current day.
        Date newDay = cal.getTime();

        service.AddAppointment("123", "Go to the store", newDay);
        assertTrue(service.appointments.get(0).getId().equals("123"), "True: Appointment returned is the same added.");
    }

    @Test
    void TestDeletingAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 5); // adds 5 days to current day.
        Date newDay = cal.getTime();

        service.AddAppointment("123", "Doctors Appointment", newDay);
        service.RemoveAppointment("123");

        assertTrue(service.appointments.size() == 0, "True: Appoint size is now 0");
    }
}

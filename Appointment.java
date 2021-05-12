import java.util.Date;
//Author Name: Nicholos Tyler

//Date: 2/7/2021

//Course ID: T3228

//Description: Appointment class that is a backbone for the AppointmentService class to make appointments.
public class Appointment {
    private String id;
    private Date date;
    private String description;

    public Appointment(String ID, Date date, String description) {
        setDate(date);
        setId(ID);
        setDescription(description);
    }

    private void setId(String id) {
        // If given parameter is null or greater than 10 characters throw an exception.
        if (id == null) throw new IllegalArgumentException();
        if (id.length() > 10) throw new IllegalArgumentException();

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        // if passed argument is null throw an argument.
        if (date == null) throw new IllegalArgumentException();
        // create a previous day date to see if date passed is before that day.
        long prevDay = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
        Date prev = new Date(prevDay);

        if (date.before(prev)) {
            throw new IllegalArgumentException();
        } else {
            this.date = date;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        // if the description parameter is null or is greater than 50 characters, throw an exception.
        if (description == null && description.equals("")) throw new IllegalArgumentException();
        if (description.length() > 50) throw new IllegalArgumentException();

        this.description = description;
    }
}

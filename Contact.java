//Author Name: Nicholos Tyler

//Date: 1/24/2021

//Course ID: T3228

//Description: Contact class to hold the details of a person

public class Contact {
    private String ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
        if (ValidateContact(id))
            this.ID = id;
        if (ValidateContact(firstName))
            this.firstName = firstName;
        if (ValidateContact(lastName))
            this.lastName = lastName;
        if (ValidateContact(phoneNumber))
            this.phoneNumber = phoneNumber;
        if (ValidateContact(address))
            this.address = address;
    }

    public Contact(String id) {
        // Give all of the member variables a value so that they never can be null.
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.address = "";
        this.ID = "";

        // If value of id is not null and is validated, assign to member variable.
        if (ValidateContact(id)) {
            this.ID = id;

        }
    }

    private boolean ValidateContact(String info) {
        if (info.length() <= 10 && info != null && !info.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        if (ValidateContact(firstName)) {
            this.firstName = firstName;
            return true;
        } else {
            return false;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if (ValidateContact(lastName)) {
            this.lastName = lastName;
            return true;
        } else {
            return false;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && address != null && !address.equals("")) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (address.length() <= 30 && address != null && !address.equals("")) {
            this.address = address;
            return true;
        } else {
            return false;
        }
    }
}

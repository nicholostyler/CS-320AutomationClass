import static org.junit.jupiter.api.Assertions.assertEquals;
//Author Name: Nicholos Tyler

//Date: 1/24/2021

//Course ID: T3228

//Description: Unit Test for the Contact Class

class ContactTest {

    @org.junit.jupiter.api.Test
    void setFirstName() {
        Contact testContact = new Contact("1");
        assertEquals(false, testContact.setFirstName("nicholostyler"));
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        Contact testContact = new Contact("1");
        assertEquals(false, testContact.setLastName("nicholostyler"));
    }

    @org.junit.jupiter.api.Test
    void setPhoneNumber() {
        Contact testContact = new Contact("1");
        assertEquals(true, testContact.setLastName("0123456789"));
    }

    @org.junit.jupiter.api.Test
    void setAddress() {
        Contact testContact = new Contact("1");
        assertEquals(true, testContact.setLastName("123fakestreet"));
    }
}

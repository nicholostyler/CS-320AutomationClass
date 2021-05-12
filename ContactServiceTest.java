import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Author Name: Nicholos Tyler

//Date: 2/7/2021

//Course ID: T3228

//Description: AppointmentTest UnitTest class that tests the functionality and error testing of the class.

class ContactServiceTest {

    @org.junit.jupiter.api.Test
    void AddContact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        assertTrue(testService.contacts.get(0).getID() == "123", "True: Successfully added contact");
    }

    @Test
    void TestErrorDuplicateID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ContactService testService = new ContactService();
            testService.AddContact("123");
            testService.AddContact("123");
            assertFalse(testService.contacts.get(0).getID() == "123");
        }, "True: Error was thrown for duplicate ID.");
    }

    @org.junit.jupiter.api.Test
    void AddMultipleContacts() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        testService.AddContact("124");
        testService.AddContact("125");
        assertTrue(testService.contacts.get(2).getID().equals("125"), "True: Was able to add multiple Contacts.");
    }

    @org.junit.jupiter.api.Test
    void GetContactBackAfterAdding() {
        ContactService testService = new ContactService();
        Contact getContact = testService.AddContact("123");
        assertTrue(getContact.getID() == "123", "True: Got the same contact back as was added.");
    }


    @org.junit.jupiter.api.Test
    void DeleteContact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        testService.RemoveContact("123");
        assertTrue(testService.contacts.size() == 0, "True: Successfully deleted contact.");
    }

    @org.junit.jupiter.api.Test
    void UpdateContact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        testService.contacts.get(0).setFirstName("Joe");
        testService.UpdateContact("123", "Nick", "Tyler", "0123456789", "123FakeStreet");
        assertTrue(testService.contacts.get(0).getFirstName() == "Nick", "True: Successfully updated contact");
    }
}

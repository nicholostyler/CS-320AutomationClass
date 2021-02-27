import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactServiceTest {

    @org.junit.jupiter.api.Test
    void AddContact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        if (testService.contacts.get(0).getID() == "123") {
            assert true;
        } else {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void AddDuplicateContact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        testService.AddContact("123");
        if (testService.contacts.get(0).getID() == "123") {
            assert true;
        } else {
            // should fail.
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void AddMultipleContacts() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        testService.AddContact("124");
        testService.AddContact("125");
        if (testService.contacts.get(2).getID().equals("125")) {
            assert true;
        } else {
            // should fail.
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void GetContactBackAfterAdding() {
        ContactService testService = new ContactService();
        Contact getContact = testService.AddContact("123");
        if (getContact.getID() == "123") {
            assert true;
        } else {
            assert false;
        }
    }


    @org.junit.jupiter.api.Test
    void DeleteConact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        if (testService.contacts.size() == 1) {
            testService.DeleteContact("123");
            if (testService.contacts.size() == 0) {
                assert true;
            } else {
                assert false;
            }
        } else {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void UpdateContact() {
        ContactService testService = new ContactService();
        testService.AddContact("123");
        testService.contacts.get(0).setFirstName("Joe");
        testService.UpdateContact("123", "Nick", "Tyler", "0123456789", "123FakeStreet");
        if (testService.contacts.get(0).getFirstName() == "Nick") {
            assert true;
        } else {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void setAddress() {
        Contact testContact = new Contact("1");
        assertEquals(true, testContact.setLastName("123fakestreet"));
    }
}

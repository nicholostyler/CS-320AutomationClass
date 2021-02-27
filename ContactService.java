//Author Name: Nicholos Tyler

//Date: 1/24/2021

//Course ID: T3228

//Description: ContactService provides CRUD for the Contact class.

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    public List<Contact> contacts;

    public ContactService() {
        // initialize an empty arraylist object.
        contacts = new ArrayList<Contact>();
    }

    public Contact AddContact(String id) {
        // Create a new Contact object with given id
        Contact newContact = new Contact(id);
        // Add contact to the arraylist.
        for (Contact contact : contacts) {
            if (contact.getID().equals(id)) {
                throw new InvalidParameterException();
            }
        }
        contacts.add(newContact);
        return newContact;
    }


    public void DeleteContact(String id) {
        // Iterate over the contacts arraylist
        for (Contact contact : contacts) {
            // if the id of the current contact is equal
            // to the provided id
            if (contact.getID().equals(id)) {
                contacts.remove(contact);
            }
        }
    }

    public void UpdateContact(String id, String first, String last, String phone, String address) {
        for (Contact contact : contacts) {
            if (contact.getID().equals(id)) {
                // Update the contacts by using their mutators
                contact.setFirstName(first);
                contact.setLastName(last);
                contact.setPhoneNumber(phone);
                contact.setAddress(address);
            }
        }
    }
}

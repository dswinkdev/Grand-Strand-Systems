import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactService() {
    }

    // test new contact
    public Contact getContact(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null;
    }

    public int size() {
        return contacts.size();
    }

    // adds new contact
    public void addContact(Contact c) {

        if (c == null) {
            throw new IllegalArgumentException("Cannot add null contact.");
        }

        for (Contact contact : contacts) {
            if (contact.getContactID().equals(c.getContactID())) {
                System.out.println("Cannot add new contact, id already exists.");
                return;
            }
        }
        contacts.add(c);
        System.out.println("Contact has been added.");
    }

    // removes a contact
    public void removeContact(String contactID) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contactID.equals(contacts.get(i).getContactID())) {
                contacts.remove(i);
                System.out.println("Contact was successfully removed.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // updates an existing contact
    public void updateContact(String contactID, String firstName, String lastName,
                              String phoneNumber, String address) {
        for (Contact contact : contacts) {
            if (contactID.equals(contact.getContactID())) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setPhoneNum(phoneNumber);
                contact.setAddress(address);
            }
        }
    }
}
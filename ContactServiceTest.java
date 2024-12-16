import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService cs = new ContactService();
        Contact contact = new Contact("12345", "John","Smith",
                "1234567890","123 Happy Ln.");
        cs.addContact(contact);
        Contact exist = cs.getContact("12345");
        assertEquals("12345", exist.getContactID());
    }

    @Test
    void testContactServiceAddNull(){
        ContactService cs = new ContactService();
         IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> cs.addContact(null),
                "Expected addContact() to throw, but it didn't."
        );
        assertTrue(thrown.getMessage().contains("Cannot add null contact."));
    }

    @Test
    void testRemoveContact() {
        ContactService cs = new ContactService();
        Contact contact = new Contact("12345", "John","Smith",
                "1234567890","123 Happy Ln.");
        cs.addContact(contact);
        cs.removeContact(contact.getContactID());
        Contact exist = cs.getContact("12345");
        assertNull(exist, "Contact does not exist.");
    }

    @Test
    void testUpdateContact() {
        ContactService cs = new ContactService();
        Contact contact = new Contact("12345", "John","Smith",
                "1234567890","123 Happy Ln.");
        cs.addContact(contact);
        String firstName = "LeBron";
        String lastName = "James";
        String phoneNumber = "1987651234";
        String address = "603 Code Ave.";
        cs.updateContact(contact.getContactID(),firstName, lastName,
                phoneNumber, address);
        Contact updatedContact = cs.getContact(contact.getContactID());
        assertTrue(updatedContact.getFirstName().equals(firstName) &&
                updatedContact.getLastName().equals(lastName) &&
                updatedContact.getPhoneNum().equals(phoneNumber) &&
                updatedContact.getAddress().equals(address));

    }

    @Test
    void testGetSize(){
        ContactService cs = new ContactService();
        Contact contact1 = new Contact("12345", "John","Smith",
                "1234567890","123 Happy Ln.");
        Contact contact2 = new Contact("64245", "LeBron","James",
                "1987651234","603 Code Ave.");
        cs.addContact(contact1);
        cs.addContact(contact2);

        assertEquals(cs.size(),2);
    }
}
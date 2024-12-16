import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testFirstNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345",null, "Jones",
                "1234568327", "123 Main St"));
    }

    @Test
    void testLastNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345","David", null,
                "1234568327", "123 Main St"));
    }

    @Test
    void testConstructorWithInvalidPhoneNumNull() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Contact("12345", "David", "Jones", null, "123 Main St")
        );
        assertTrue(thrown.getMessage().contains("Invalid phone number"));
    }

    @Test
    void testConstructorWithInvalidPhoneNumLength() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Contact("12345", "David", "Jones", "1234567", "123 Main St")
        );
        assertTrue(thrown.getMessage().contains("Invalid phone number"));
    }

    @Test
    void testConstructorWithInvalidAddressNull() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Contact("12345", "David", "Jones", "1234567890", null)
        );
        assertTrue(thrown.getMessage().contains("Invalid address"));
    }

    @Test
    void testConstructorWithInvalidAddressTooLong() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Contact("12345", "David", "Jones", "1234567890", "1234567890123456789012345678901")
        );
        assertTrue(thrown.getMessage().contains("Invalid address"));
    }

    @Test
    void testConstructorWithValidAddress() {
        Contact contact = new Contact("12345", "David", "Jones", "1234567890", "123 Main St");
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testConstructorWithValidPhoneNum() {
        Contact contact = new Contact("12345", "David", "Jones", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getPhoneNum());
    }

    @Test
    void testGetContactID() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        String actualContactID = contact.getContactID();
        assertEquals("12345", actualContactID, "The contactID should match the expected value");
    }

    @Test
    void testContactConstructorWithIdNull() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {new Contact(null, "first name", "last name",
                        "1231231234", "address");});

        assertTrue(thrown.getMessage().contains("Invalid contact id"));
    }

    @Test
    void testContactConstructorWithIdTooLong() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> {new Contact("123451234567", "first name", "last name",
                        "1231231234", "address");});

        assertTrue(thrown.getMessage().contains("Invalid contact id"));
    }

    @Test
    void testGetFirstName() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        assertEquals("David",contact.getFirstName());
    }

    @Test
    void testSetFirstNameToNull() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setFirstName(null);
        assertEquals("David",contact.getFirstName());
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setFirstName("David David David");
        assertEquals("David",contact.getFirstName());
    }

    @Test
    void testSetFirstName() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setFirstName("Brandon");
        assertEquals("Brandon",contact.getFirstName());
    }

    @Test
    void testGetLastName() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        assertEquals("Jones",contact.getLastName());
    }

    @Test
    void testSetLastNameToNull() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setLastName(null);
        assertEquals("Jones",contact.getLastName());
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setLastName("David David David");
        assertEquals("Jones",contact.getLastName());
    }

    @Test
    void testSetLastName() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setLastName("Brandon");
        assertEquals("Brandon",contact.getLastName());
    }

    @Test
    void testGetPhoneNum() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        assertEquals("1234568327",contact.getPhoneNum());
    }

    @Test
    void testSetPhoneNumToNull() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setPhoneNum(null);
        assertEquals("1234568327",contact.getPhoneNum());
    }

    @Test
    void testSetPhoneNumTooLong() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setPhoneNum("12312312312341");
        assertEquals("1234568327",contact.getPhoneNum());
    }

    @Test
    void testSetPhoneNumTooShort() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setPhoneNum("123123");
        assertEquals("1234568327",contact.getPhoneNum());
    }

    @Test
    void testSetPhoneNum() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setPhoneNum("3213214321");
        assertEquals("3213214321",contact.getPhoneNum());
    }

    @Test
    void testGetAddress() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        assertEquals("455 Seven Waters Ave.",contact.getAddress());
    }

    @Test
    void testSetAddressToNull() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setAddress(null);
        assertEquals("455 Seven Waters Ave.",contact.getAddress());
    }

    @Test
    void testSetAddressTooLong() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setAddress("44755 Seven Waters Front Way Avenue Lane");
        assertEquals("455 Seven Waters Ave.",contact.getAddress());

    }

    @Test
    void testSetAddress() {
        Contact contact = new Contact("12345","David","Jones",
                "1234568327","455 Seven Waters Ave.");
        contact.setAddress("934 Seven Waters Ave.");
        assertEquals("934 Seven Waters Ave.",contact.getAddress());

    }
}
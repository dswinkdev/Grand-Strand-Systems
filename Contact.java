public class Contact {

    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;

    // constructor
    public Contact(String contactID, String firstName, String lastName,
                   String phoneNum, String address){

        if (contactID == null || contactID.length() > 10){
            throw new IllegalArgumentException("Invalid contact id");
        }

        if (firstName == null || firstName.length() > 10){
            throw new IllegalArgumentException("Invalid first name");
        }

        if (lastName == null || lastName.length() > 10){
            throw new IllegalArgumentException("Invalid last name");
        }

        if (phoneNum == null || phoneNum.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    // getters & setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10){
            System.out.println("Invalid first name");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10){
            System.out.println("Invalid last name");
        } else {
            this.lastName = lastName;
        }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if (phoneNum != null && phoneNum.length() == 10){
            this.phoneNum = phoneNum;
        } else {
            System.out.println(("Invalid phone number"));
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30){
            this.address = address;
        } else {
            System.out.println(("Invalid address"));
        }
    }

    public String getContactID() {
        return contactID;
    }
}

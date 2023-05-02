package module;

public class Person {
    private String firstName;
    private String lastName;
    private long phoneNumber;

    public Person(String firstName, String lastName, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    
    public String toString() {
        return "First name: " + firstName + "\nLast name: " + lastName + "\nPhone number: " + phoneNumber;
    }
}

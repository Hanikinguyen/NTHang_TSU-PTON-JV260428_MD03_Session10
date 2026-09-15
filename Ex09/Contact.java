package Ex09;

import java.util.Objects;

public class Contact {

    // Biến static dùng để tự động tăng ID
    private static int nextId = 1;

    private int id;
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.id = nextId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Hai Contact được xem là trùng nhau nếu cùng phoneNumber
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Contact)) {
            return false;
        }

        Contact contact = (Contact) o;

        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    // hashCode dựa trên phoneNumber
    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    // In thông tin Contact
    @Override
    public String toString() {
        return "ID: " + id
                + " | Tên: " + name
                + " | SĐT: " + phoneNumber;
    }
}

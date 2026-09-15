public class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void display() {
        System.out.println(
                "Tên: " + name
                        + " | Email: " + email
                        + " | SĐT: " + phone
        );
    }
}


package dto;

public class Contact {
    String email;
    String username;
    String message;

    public Contact(String email, String username, String message) {
        this.email = email;
        this.username = username;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
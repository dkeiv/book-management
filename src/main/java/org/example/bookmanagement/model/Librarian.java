package org.example.bookmanagement.model;

public class Librarian {
    private int id;
    private String name;
    private String email;
    private String password;

    // for update
    public Librarian() {
    }

    public Librarian(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Librarian(int id, String name, String email, String password) {
        this(name, email, password);
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    private String hashPassword(String password) {
//        String hashedPassword = "";
//        return hashedPassword;
//    }
}

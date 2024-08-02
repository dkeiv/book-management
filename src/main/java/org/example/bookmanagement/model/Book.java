package org.example.bookmanagement.model;

public class Book {
    private int id;
    private String name;
    private String publisher;
    private String imageURL;
    private String status;
//    boolean borrowedStatus;

    // for update
    public Book() {
    }

    public Book(String name, String publisher, String imageURL, String status, boolean borrowedStatus) {
        this.name = name;
        this.publisher = publisher;
        this.imageURL = imageURL;
        this.status = status;
        this.borrowedStatus = borrowedStatus;
    }

    public Book(int id, String name, String publisher, String imageURL, String status, boolean borrowedStatus) {
        this(name, publisher, imageURL, status, borrowedStatus);
        this.id = id;
    }

    public boolean isBorrowedStatus() {
        return borrowedStatus;
    }

    public void setBorrowedStatus(boolean borrowedStatus) {
        this.borrowedStatus = borrowedStatus;
    }

    public int getId() {
        return id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

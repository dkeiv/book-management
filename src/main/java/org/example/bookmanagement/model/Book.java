package org.example.bookmanagement.model;

public class Book {
    private int id;
    private String name;
    private String publisher;
    private String description;
    private String imgUrl;
    private String condition;
    private boolean borrowed;

    // for update
    public Book() {
    }

    public Book(String name, String publisher, String description, String imgUrl, String condition, boolean borrowed) {
        this.name = name;
        this.publisher = publisher;
        this.description = description;
        this.imgUrl = imgUrl;
        this.condition = condition;
        this.borrowed = borrowed;
    }

    public Book(int id, String name, String publisher, String description, String imgUrl, String condition, boolean borrowed) {
        this(name, publisher, description, imgUrl, condition, borrowed);
        this.id = id;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

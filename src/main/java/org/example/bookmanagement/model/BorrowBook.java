package org.example.bookmanagement.model;

import java.sql.Date;

public class BorrowBook {

    public static enum Status {
        BORROWING("Borrowing"),
        RETURNED("Returned"),
        OVERDUE("Over due");

        private final String description;

        Status(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private int id;
    private int userId;
    private String bookIsbn;
    private Status status;
    private Date borrowDate;
    private Date returnDate;

    public BorrowBook() {}

    public BorrowBook( int userId, String bookIsbn, String status, Date borrowDate, Date returnDate) {
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.status = Status.valueOf(status.toUpperCase());
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BorrowBook(int id, int userId, String bookIsbn, String status, Date borrowDate, Date returnDate) {
        this(userId, bookIsbn,status,borrowDate,returnDate);
        this.id = id;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getId() {
        return id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status.description;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

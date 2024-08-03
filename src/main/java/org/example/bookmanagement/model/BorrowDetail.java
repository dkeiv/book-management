package org.example.bookmanagement.model;

import java.sql.Date;

public class BorrowDetail {

    private int id;
    private int bookId;
    private int userId;
    private Date borrowDate;
    private Date returnDate;
    private Status status;

    private enum Status {
        BORROWING("borrowing"),
        RETURNED("returned"),
        OVERDUE("overdue");

        private final String description;

        Status(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    //for update
    public BorrowDetail() {
    }

    public BorrowDetail(int bookId, int userId, Date borrowDate, Date returnDate, String status) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = Status.valueOf(status);
    }

    public BorrowDetail(int id, int bookId, int userId, Date borrowDate, Date returnDate, String status) {
        this(bookId, userId, borrowDate, returnDate, status);
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public void setId(int id) {
        this.id = id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status.getDescription();
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }
}

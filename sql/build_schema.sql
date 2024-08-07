CREATE DATABASE IF NOT EXISTS bookC04;
USE borokC04;

CREATE TABLE IF NOT EXISTS book
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    isbn          NVARCHAR(50) UNIQUE NOT NULL,
    name          NVARCHAR(50)        NOT NULL,
    description   NVARCHAR(150),
    publisher     NVARCHAR(50),
    img_url       NVARCHAR(255),
    `condition`   NVARCHAR(10),
    borrow_status BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS category
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(15)
);

CREATE TABLE IF NOT EXISTS book_category
(
    category_id INT,
    book_isbn   NVARCHAR(50),
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE,
    FOREIGN KEY (book_isbn) REFERENCES book (isbn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS librarian
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     NVARCHAR(50)  NOT NULL,
    email    NVARCHAR(50)  NOT NULL,
    password NVARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     NVARCHAR(50) NOT NULL,
    course   NVARCHAR(50) NOT NULL,
    birthday DATE,
    active   BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS borrow_book
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT NOT NULL,
    book_isbn   NVARCHAR(50),
    status      NVARCHAR(10),
    borrow_date DATE,
    return_date DATE,

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
    FOREIGN KEY (book_isbn) REFERENCES book (isbn) ON DELETE CASCADE
);

CREATE TABLE publisher
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(50)
);

##########################################
DROP TABLE book;
DROP TABLE category;
DROP TABLE book_category;
DROP TABLE librarian;
DROP TABLE user;
DROP TABLE borrow_book;

SET FOREIGN_KEY_CHECKS = 1;
# SET FOREIGN_KEY_CHECKS = 0;

#########################################
INSERT INTO book (name, isbn, description, publisher, `condition`, img_url)
VALUES ('How to Train Your Robot', '978-3-16-148410-0', 'A hilarious guide to teaching your robot new tricks',
        'Fictional Press', 'new', 'https://dummyurl.com/book1'),
       ('The Invisible Sandwich', '978-1-234-56789-0', 'A funny story about an invisible lunch', 'Imaginary Books',
        'old', 'https://dummyurl.com/book2'),
       ('Cooking with Lasers', '978-0-987-65432-1', 'Delicious recipes using laser technology', 'Futuristic Eats',
        'new', 'https://dummyurl.com/book3'),
       ('The Great Cat Detective', '978-0-123-45678-9', 'A detective cat solves funny mysteries',
        'Whisker Publications', 'old', 'https://dummyurl.com/book4'),
       ('Time Travel for Dummies', '978-9-876-54321-0', 'A humorous guide to time travel', 'Time Warp Press', 'new',
        'https://dummyurl.com/book5'),
       ('The Secret Life of Office Supplies', '978-3-21-654987-0',
        'Ever wondered what your office supplies do at night?', 'Stationery Stories', 'old',
        'https://dummyurl.com/book6'),
       ('Adventures in the Grocery Store', '978-0-111-22222-3', 'Funny tales from your local grocery store',
        'Food Fun House', 'new', 'https://dummyurl.com/book7'),
       ('The Art of Procrastination', '978-2-333-44444-5', 'Mastering the fine art of putting things off',
        'Lazy Days Press', 'old', 'https://dummyurl.com/book8'),
       ('When Pigs Fly', '978-4-555-66666-7', 'A collection of funny short stories', 'Barnyard Books', 'new',
        'https://dummyurl.com/book9'),
       ('101 Ways to Lose Your Keys', '978-6-777-88888-9', 'A humorous look at everyday forgetfulness',
        'Lost & Found Publishing', 'old', 'https://dummyurl.com/book10');

INSERT INTO category (name)
VALUES ('Science fiction'),
       ('Fantasy'),
       ('Mystery'),
       ('Romance'),
       ('Horror'),
       ('Thriller'),
       ('Non-fiction'),
       ('Biography'),
       ('History'),
       ('Children');

# INSERT INTO book_category (category_id, book_isbn) VALUES ();

INSERT INTO publisher (name)
VALUES ('Penguin Random House'),
       ('HarperCollins'),
       ('Simon & Schuster'),
       ('Macmillan Publishers'),
       ('Hachette Book Group'),
       ('Scholastic Corporation'),
       ('Pearson Education'),
       ('Wiley'),
       ('Oxford University Press'),
       ('Cambridge University Press');

INSERT INTO user (name, course, birthday, active)
VALUES ('Brad Pitt', 'C001', '1963-12-18', TRUE),
       ('Angelina Jolie', 'C002', '1975-06-04', TRUE),
       ('Leonardo DiCaprio', 'C003', '1974-11-11', TRUE),
       ('Jennifer Lawrence', 'C004', '1990-08-15', TRUE),
       ('Tom Hanks', 'C005', '1956-07-09', TRUE),
       ('Emma Watson', 'C006', '1990-04-15', TRUE),
       ('Will Smith', 'C007', '1968-09-25', TRUE),
       ('Scarlett Johansson', 'C008', '1984-11-22', TRUE),
       ('Chris Hemsworth', 'C009', '1983-08-11', TRUE),
       ('Natalie Portman', 'C010', '1981-06-09', TRUE);

################################################
# get all category of a book by its id
SELECT name
FROM category,
     book_category
WHERE category_id = category.id
  AND book_isbn = (SELECT isbn FROM book WHERE book.id = 16);


# soft delete
UPDATE user
SET active = false
WHERE id = 1;

# sp to insert into borrow_book
DELIMITER //
CREATE PROCEDURE SP_INSERT_BORROW_WITH_VALIDATE(userId INT, bookIsbn NVARCHAR(50), borrowDate DATE, returnDate DATE)
BEGIN
    INSERT INTO borrow_book (user_id, book_isbn, status, borrow_date, return_date)
    SELECT userId, bookIsbn, 'borrowing', borrowDate, returnDate
    FROM book,
         user
    WHERE book.borrow_status = FALSE
      AND book.isbn = bookIsbn
      AND user.active = TRUE
      AND user.id = userId;

    UPDATE book SET borrow_status = TRUE WHERE isbn = bookIsbn AND borrow_status = FALSE;
END//
DELIMITER ;

CALL SP_INSERT_BORROW_WITH_VALIDATE(1, 11, DATE('2024-08-03'), DATE('2024-08-10'));
DROP PROCEDURE SP_INSERT_BORROW_WITH_VALIDATE;


# update a book
DROP PROCEDURE sp_update_book;

DELIMITER //
CREATE PROCEDURE sp_update_book(
    bookId INT,
    bookIsbn NVARCHAR(50),
    bookName NVARCHAR(50),
    bookDescription NVARCHAR(150),
    bookPublisher NVARCHAR(50),
    bookImg NVARCHAR(255),
    bookCondition NVARCHAR(10),
    bookBorrowed BOOLEAN)
BEGIN
    UPDATE book
    SET isbn          = bookIsbn,
        name          = bookName,
        description   = bookDescription,
        publisher     = bookPublisher,
        img_url       = bookImg,
        `condition`   = bookCondition,
        borrow_status = bookBorrowed
    WHERE book.id = bookId;

    UPDATE book_category
    SET category_id = NULL
    WHERE book_isbn = bookIsbn;

    DELETE FROM book_category WHERE book_isbn = bookIsbn;
END//
DELIMITER ;

# delete a book
DROP PROCEDURE sp_delete_book;

DELIMITER //
CREATE PROCEDURE sp_delete_book(bookIsbn NVARCHAR(50))
BEGIN
    UPDATE book_category
    SET category_id = NULL
    WHERE book_isbn = bookIsbn;

    DELETE FROM book_category WHERE book_isbn = bookIsbn;

    DELETE FROM book WHERE isbn = bookIsbn;
END//
DELIMITER ;

#delete borrow
DROP PROCEDURE sp_delete_borrow;

DELIMITER //
CREATE PROCEDURE sp_delete_borrow(borrowId INT)
BEGIN
    UPDATE borrow_book
    SET user_id = NULL,  book_isbn = NULL
    WHERE id = borrowId;

    DELETE FROM borrow_book WHERE id = borrowId;
END//
DELIMITER ;

insert into librarian (id, name, email, password) value (null, 'Nguyen Huu Trang', 'nguyenhuutrang007@gmail.com', '12345')

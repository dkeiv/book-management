
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

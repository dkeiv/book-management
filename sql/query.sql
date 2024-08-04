################################################
# get all category of a book by book_isbn
SELECT name
FROM category,
     book_category
WHERE category_id = category.id
  AND book_isbn = 10;

#  soft delete a user by id
UPDATE user
SET active = false
WHERE id = 1;

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

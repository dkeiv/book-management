CREATE DATABASE IF NOT EXISTS bookC04;
USE bookC04;

CREATE TABLE IF NOT EXISTS book
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          NVARCHAR(50) NOT NULL,
    description   NVARCHAR(150),
    publisher     NVARCHAR(50),
    img_url       NVARCHAR(255),
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
    book_id     INT,
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
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
    course    NVARCHAR(50) NOT NULL,
    birthday DATE,
    active   BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS borrow_detail
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT NOT NULL,
    book_id     INT NOT NULL,
    status      NVARCHAR(10),
    borrow_date DATE,
    return_date DATE,

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);

##########################################
DROP TABLE book;
DROP TABLE category;
DROP TABLE book_category;
DROP TABLE librarian;
DROP TABLE user;
DROP TABLE borrow_detail;
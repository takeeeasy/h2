CREATE TABLE book(title varchar(20) NOT NULL, author varchar(10), price varchar(10));
CREATE TABLE orders(id serial, book_title varchar(20) NOT NULL, author varchar(10), price varchar(10));
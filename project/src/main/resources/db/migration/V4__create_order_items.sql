CREATE TABLE order_items
(
id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
book_id INT NOT NULL,
quantity INT NOT NULL,
ordered_date TIMESTAMP DEFAULT NOW(),
CONSTRAINT fk_orders_id FOREIGN KEY(order_id) REFERENCES orders(id),
CONSTRAINT fk_books_id FOREIGN KEY(book_id) REFERENCES books(id)
);

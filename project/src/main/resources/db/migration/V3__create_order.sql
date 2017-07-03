CREATE TABLE orders
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 user_id INT,
 total_price INT NOT NULL DEFAULT 0,
 ordered_date TIMESTAMP DEFAULT NOW(),
 modified_date TIMESTAMP DEFAULT NOW(),
 cancelled_date DATETIME,
 delivered_date DATETIME,
 STATUS VARCHAR(50) DEFAULT 'ORDERED' ,
 reason VARCHAR(100) ,
 CONSTRAINT fk_users_id FOREIGN KEY(user_id) REFERENCES users(id)
 );

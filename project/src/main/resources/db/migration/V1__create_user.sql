
CREATE TABLE users
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(200)  NOT NULL,
 email VARCHAR(200) UNIQUE NOT NULL,
 password VARCHAR(200) NOT NULL,
 active TINYINT(1) NOT NULL DEFAULT 1,
 created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into users ( name,email,password) values ('karthi', 'karthi@gmail.com', '12345678');

CREATE TABLE role
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(200) UNIQUE NOT NULL,
 active TINYINT(1) NOT NULL DEFAULT 1,
 created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into role ( name ) values ('Admin');
insert into role ( name ) values ('User');

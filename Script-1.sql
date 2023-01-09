CREATE TABLE IF NOT exists users (
username VARCHAR(50) PRIMARY KEY,
password VARCHAR(100) not null,
enabled boolean not null
);



CREATE TABLE IF NOT EXISTS authorities (
 username varchar(50) NOT NULL,
 authority varchar(50) NOT NULL,
 unique(username,authority),
 CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username))
 

INSERT INTO users (username, password, enabled) VALUES
   ('admin', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', '1'),
   ('buyer', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', '1'),
   ('seller', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', '1'),
   ('contractor', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', '1');



INSERT INTO authorities (username, authority) VALUES
   ('admin', 'ROLE_ADMIN'),
   ('buyer', 'ROLE_BUYER'),
   ('seller', 'ROLE_SELLER'),
   ('contractor', 'ROLE_CONTRACTOR');


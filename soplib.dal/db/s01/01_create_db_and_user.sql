#create user
CREATE USER 'sopUser'@'localhost'
IDENTIFIED BY 'sopPss';

#create database
CREATE DATABASE sopDB;

#grant privileges
GRANT ALL ON sopDB.* TO 'sopUser'@'localhost';
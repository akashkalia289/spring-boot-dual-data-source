create database dds;

use dds;

create table cities
(
id int primary key auto_increment,
name varchar(100)
);

create table city (id bigint not null auto_increment, name varchar(255), primary key (id));

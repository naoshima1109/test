set names utf8;

set foreign_key_checks=0;

drop database if exists logindb naoshima;

create database logindb_naoshima;

use database logindb_naoshima;

create table user(
id int,
user_name varchar(255),
password varchar(255)

);

insert into user values
(1,"taro","123");
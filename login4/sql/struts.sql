set names utf8;
set foreign_key_checks=0;
drop database if exists logindb naoshima;
create database logindb_naoshima;
use logindb_naoshima;

create table user(--userテーブル--
id int,--変数--
user_name varchar(255),--変数--
password varchar(255)--変数--
);

insert into user values--データを登録--
(1,"taro","123"), --id,name,password--
(2,"jiro","123"),--id,name,password--
(3,"hanako","123"),--id,name,password--
(4,"saburo","123");--id,name,password--
set names utf8;
set foreign_key_checks=0;

drop database if exists ecsite_naoshima;

create database ecsite_naoshima;

use ecsite_naoshima;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int not null primary key auto_increment,

	login_id varchar (16) unique,
	login_pass varchar(16)unique,
	user_name varchar(100),
	insert_date datetime,
	update datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
	id int not null primary key auto_increment,

	item_name varchar(30),
	item_price int,
	item_stock int,
	insert_date datetime,
	update datetime
);

drop table if exists user_buy_item transaction;

create table user_buy_item transaction(
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	update datetime
);

INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("ノートBOOK",100,50);
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("internous","internous01","test");
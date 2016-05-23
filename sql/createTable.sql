drop database if exists lilybbs;

create database lilybbs character set utf8;

use lilybbs;

create table user (
	id int auto_increment not null primary key ,
	userid varchar(50) not null,
	username varchar(50) not null,
	logintimes int not null,
	postarticles int not null,
	title varchar(50),
	constellation varchar(20),
	lastlogintime timestamp not null,
	lastloginip varchar(50) not null,
	experience int not null,
	performance int not null,
	life int not null,
	moderators varchar(255)
);

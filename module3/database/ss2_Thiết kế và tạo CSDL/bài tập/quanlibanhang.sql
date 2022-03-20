create database quan_li_ban_hang;
use quan_li_ban_hang;
create table customer(
cid int auto_increment,
cname varchar(20),
cage varchar(20),
primary key (cid)
);
create table product(
pid int auto_increment,
pname varchar (50),
pprice varchar(50),
primary key (pid)
);
create table `order`(
oid int auto_increment,
odate date,
ototalprice varchar(50),
cid int,
primary key (oid),
foreign key (cid) references customer(cid)
);
create table orderdetail(
oid int,
pid int,
odqty varchar(50),
foreign key (oid) references `order`(oid),
foreign key (pid) references product(pid)
);
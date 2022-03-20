create database quanlisinhvien;
use quanlisinhvien;
create table class(
classid int primary key auto_increment primary key,
classname varchar(60) not null,
startdate datetime not null,
status bit
);
create table student(
studentid int auto_increment primary key not null,
studentname varchar(50) not null,
address varchar(50),
phone varchar(10),
status bit,
classid int not null,
foreign key (classid) references class(classid)
);
create table subject(
  SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
    );
create table mark(   MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
    );
use quanlisinhvien;
select class.* from class;
insert into class
values (1,"A1","2018-12-20",1);
insert into class 
values (2,"a2","2008-12-22",1);
insert into class
values (3,"b3",current_date,0);
select student.* from student;
insert into student (studentname,address,phone,status,classid)
values  ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student (studentname,address,status,classid)
values ('Hoa', 'Hai phong', 1, 1);
insert into student (studentname,address,phone,status,classid)
values ("Manh","HCM","01234569",0,2);
select `subject`.* from `subject`;
insert into `subject` 
values (1,"CF",5,1),
 (2,"C",6,1),
 (3,"HDJ",5,1),
 (4,"EDBMS",10,1);
 select Mark.* from mark;
 insert into mark(subid,studentid,mark,examtimes)
 values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);

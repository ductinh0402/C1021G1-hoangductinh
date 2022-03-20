use quanlisinhvien;
select * from student where student.studentname
like "h%";
select * from class
 where class.startdate 
like "%12%";
select * from `subject` where  `subject`.Credit
 between 3 and 5; 
 select * from student;
 SET SQL_SAFE_UPDATES = 0;
update student
set student.classid=2 where student.studentname="Hung";
select * from mark;
select student.studentname,`subject`.subname,mark.mark from student
 right join `subject` on student.studentid= `subject`.subid
 right join mark on `subject`.subid=mark.MarkId order by mark desc,subname asc;
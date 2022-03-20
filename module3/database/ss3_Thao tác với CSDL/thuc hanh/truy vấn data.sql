use quanlisinhvien;
select * from student;
select * from student where `status`=true;
select * from subject where Credit <10;
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID;
select s.studentid,s.studentname,c.classname
from student s join class c on s.classid=c.classid 
where c.classname="A1"; 
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M 
on S.StudentId = M.StudentId 
join Subject Sub 
on M.SubId = Sub.SubId;
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S 
join Mark M 
on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';
use quanlisinhvien;
select * from `subject` where Credit=(select max(Credit) from `subject`);
select `subject`.*,mark.Mark as so_diem from `subject`
inner join mark on mark.subid=`subject`.subid and
				   mark.Mark=(select max(mark) from mark);
select student.*,avg(mark) as `avg` from student 
left join mark on student.studentid=mark.StudentId
group by student.studentid order by `avg` desc;                  
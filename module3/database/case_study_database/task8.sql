select khach_hang.ho_ten from khach_hang
group by khach_hang.ho_ten;
SELECT DISTINCT ho_ten FROM khach_hang;
select khach_hang.ho_ten from khach_hang
union
select khach_hang.ho_ten from khach_hang;
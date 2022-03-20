create temporary table temp
select khach_hang.ma_khach_hang from khach_hang inner join hop_dong on
hop_dong.ma_khach_hang=khach_hang.ma_khach_hang where year(hop_dong.ngay_lam_hop_dong)<2021;
 SET FOREIGN_KEY_CHECKS=0;
delete from khach_hang where khach_hang.ma_khach_hang in (select * from temp);
 SET FOREIGN_KEY_CHECKS=1;
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten from nhan_vien
where ma_nhan_vien not in (
select ma_nhan_vien from hop_dong
where year(ngay_lam_hop_dong) between 2019 and 2021);
SET FOREIGN_KEY_CHECKS=0; 
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien
where ma_nhan_vien not in (
select ma_nhan_vien from hop_dong
where year(ngay_lam_hop_dong) between 2019 and 2021);
select * from nhan_vien;
SET FOREIGN_KEY_CHECKS=1; 
SET SQL_SAFE_UPDATES = 1;
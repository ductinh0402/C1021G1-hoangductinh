select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten,trinh_do.ten_trinh_do,bo_phan.ten_bo_phan,nhan_vien.so_dien_thoai,nhan_vien.dia_chi 
from nhan_vien inner join trinh_do on nhan_vien.ma_trinh_do=trinh_do.ma_trinh_do
               inner join bo_phan on bo_phan.ma_bo_phan=nhan_vien.ma_bo_phan
               inner join hop_dong on hop_dong.ma_nhan_vien=nhan_vien.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) <= 3
order by nhan_vien.ma_nhan_vien;




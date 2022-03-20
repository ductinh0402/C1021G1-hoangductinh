select hop_dong.ma_hop_dong,nhan_vien.ho_ten,khach_hang.ho_ten,khach_hang.so_dien_thoai,dich_vu.ten_dich_vu,dich_vu.ma_dich_vu,
sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem,hop_dong.tien_dat_coc 
from hop_dong   join nhan_vien on nhan_vien.ma_nhan_vien=hop_dong.ma_nhan_vien
                join khach_hang on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
                join dich_vu on dich_vu.ma_dich_vu=hop_dong.ma_dich_vu
               left join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
where dich_vu.ma_dich_vu IN (SELECT dich_vu.ma_dich_vu FROM hop_dong INNER JOIN dich_vu
                               ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
                               WHERE (MONTH(hop_dong.ngay_lam_hop_dong)between 10 and 12)
						             AND(YEAR(hop_dong.ngay_lam_hop_dong)=2020))
 and hop_dong.ma_hop_dong not in (select hop_dong.ma_hop_dong from hop_dong where (month(ngay_lam_hop_dong) between 1 and 6) 
                                  and year(ngay_lam_hop_dong)=2021 )                                    
group by hop_dong.ma_hop_dong;

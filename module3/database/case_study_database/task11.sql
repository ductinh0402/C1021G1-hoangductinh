select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem 
from loai_khach join  khach_hang on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach
				join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
                join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
                join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
where loai_khach.ten_loai_khach="Diamond" and khach_hang.dia_chi like "%vinh" or khach_hang.dia_chi like "%quang ngai";
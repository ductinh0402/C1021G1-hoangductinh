select khach_hang.ma_khach_hang,khach_hang.ho_ten,count(hop_dong.ma_hop_dong) as so_lan_dat_phong
from khach_hang inner join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
                inner join loai_khach on loai_khach.ma_loai_khach=khach_hang.ma_loai_khach
                where loai_khach.ten_loai_khach="Diamond"
                group by khach_hang.ma_khach_hang
                order by so_lan_dat_phong;
				
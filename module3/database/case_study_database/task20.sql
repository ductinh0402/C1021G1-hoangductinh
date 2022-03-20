select ma_nhan_vien,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi
from nhan_vien
union all
select ma_khach_hang,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi
from khach_hang;
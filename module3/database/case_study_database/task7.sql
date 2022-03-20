select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue,loai_dich_vu.ten_dich_vu
from dich_vu inner join  loai_dich_vu on loai_dich_vu.ma_loai_dich_vu=dich_vu.ma_loai_dich_vu 
             inner join hop_dong on hop_dong.ma_dich_vu=dich_vu.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong)=2020 and  year(hop_dong.ngay_lam_hop_dong)!=2021;
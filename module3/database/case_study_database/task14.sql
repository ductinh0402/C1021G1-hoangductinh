select hop_dong.ma_hop_dong,dich_vu.ten_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem,count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong inner join dich_vu on hop_dong.ma_dich_vu=dich_vu.ma_dich_vu
              inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
              inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem=hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
HAVING COUNT(dich_vu_di_kem.ma_dich_vu_di_kem) = 1
ORDER BY ma_hop_dong;
create temporary table bang_tam
SELECT khach_hang.ma_khach_hang
FROM khach_hang LEFT JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
LEFT JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE loai_khach.ten_loai_khach = "Platinium"
GROUP BY hop_dong.ma_hop_dong,ma_khach_hang
HAVING SUM(dich_vu.chi_phi_thue+(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia))>10000000;
UPDATE khach_hang
SET khach_hang.ma_loai_khach=1
WHERE khach_hang.ma_khach_hang in (select * from bang_tam);
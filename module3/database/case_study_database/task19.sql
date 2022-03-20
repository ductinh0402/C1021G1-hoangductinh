CREATE TEMPORARY TABLE temp_2 
SELECT dich_vu_di_kem.ma_dich_vu_di_kem
FROM hop_dong JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
JOIN dich_vu_di_kem  ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2020 AND hop_dong_chi_tiet.so_luong > 10;

UPDATE dich_vu_di_kem 
SET gia = dich_vu_di_kem.gia*2
WHERE ma_dich_vu_di_kem IN (SELECT * FROM temp_2);


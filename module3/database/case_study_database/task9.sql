select month(hop_dong.ngay_lam_hop_dong) as tháng,
count(hop_dong.ma_khach_hang) as số_lượng from hop_dong where year(hop_dong.ngay_lam_hop_dong)=2021
group by  month(hop_dong.ngay_lam_hop_dong)
order by  month(hop_dong.ngay_lam_hop_dong) asc;
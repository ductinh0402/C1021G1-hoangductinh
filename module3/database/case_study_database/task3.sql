SELECT *  from khach_hang WHERE (YEAR(CURRENT_TIMESTAMP)- YEAR(khach_hang.ngay_sinh) BETWEEN 18 AND 50) 
and (dia_chi like "%da nang" or dia_chi like "%quang tri") ;
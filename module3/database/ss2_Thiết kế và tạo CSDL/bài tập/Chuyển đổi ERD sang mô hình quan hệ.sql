create database erd_sang_mo_hinh_quan_he;
use erd_sang_mo_hinh_quan_he;
create table phieu_xuat(
so_px int auto_increment,
ngay_xuat date,
primary key(so_px)
);
create table vat_tu(
ma_vtu int auto_increment,
ten_vt varchar(50),
primary key(ma_vtu)
);
create table chi_tiet_phieu_xuat(
so_px int,
ma_vt int,
dgxuat int ,
slxuat int,
primary key(dgxuat,slxuat),
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vt) references vat_tu(ma_vtu)
);
create table phieu_nhap(
so_pn int auto_increment,
ngay_nhap date,
primary key (so_pn)
);
create table chi_tiet_phieu_nhap(
dgnhap int,
slnhap int,
foreign key (dgnhap) references phieu_nhap(so_pn),
foreign key(slnhap) references vat_tu(ma_vtu)
);
create table dondh(
sodh int auto_increment,
ngaydh date,
mancc int,
primary key (sodh),
foreign key (mancc) references nhacc(mancc)
);
create table chi_tiet_ddh(
ma_vt int,
sodh int,
primary key(ma_vt,sodh),
foreign key(ma_vt) references vat_tu(ma_vtu),
foreign key(sodh) references dondh(sodh)
);
create table nhacc(
mancc int auto_increment,
tenncc varchar(50),
diachi varchar(50),
primary key (mancc)
);
create table sdt(
masdt int auto_increment,
number_phone varchar(50),
mancc int,
primary key(masdt),
foreign key (mancc) references nhacc(mancc)
);

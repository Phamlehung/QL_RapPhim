drop database if exists QL_RapPhim;
create database  QL_RapPhim;
use  QL_RapPhim;
create table nhan_vien(
	id_nv int primary key auto_increment, 
    ten_nv nvarchar(200),
    ngay_sinh datetime,
    sdt varchar(20),
    dia_chi nvarchar(200), 
    chuc_vu varchar(50)
);
insert into nhan_vien (ten_nv, ngay_sinh, sdt, dia_chi, chuc_vu)values (N'Phạm Văn A', '1980-05-24', '0123456789',N'132 nguyễn thị hồng p9 quận gò vấp', 'NV');
insert into nhan_vien (ten_nv, ngay_sinh, sdt, dia_chi, chuc_vu)values (N'Phạm Văn B', '1988-10-25', '0123456789',N'132 nguyễn thị hồng gấm  p9 quận 3', 'QL');
insert into nhan_vien (ten_nv, ngay_sinh, sdt, dia_chi, chuc_vu) values (N'Phạm Văn C', '1980-02-24', '0123456789',N'112 nguyễn thị minh khai p9 quận 1', 'NV');
insert into nhan_vien (ten_nv, ngay_sinh, sdt, dia_chi, chuc_vu) values (N'Phạm Văn ABC', '1980-02-24', '0123456789',N'112 nguyễn thị minh khai p9 quận 1', 'QL');
insert into nhan_vien (ten_nv, ngay_sinh, sdt, dia_chi, chuc_vu) values (N'Phạm Văn C', '1980-02-24', '0123456789',N'112 nguyễn thị minh khai p9 quận 1', 'NV');
select * from nhan_vien;
create table Rap_phim(
	ma_rap int primary key auto_increment,
    ten_rap nvarchar(50) unique not null,
    dia_chi nvarchar(200),
    sdt varchar(20),
    nguoi_quan_ly int,
    khu_vuc nvarchar(50), 
    foreign key (nguoi_quan_ly) references nhan_vien(id_nv)
);    
    insert into rap_phim(ten_rap, dia_chi, sdt, nguoi_quan_ly, khu_vuc) values (N'CGV phan văn trị', N'123 phan văn trị', '0123456789', 2, N'Gò vấp');
	insert into rap_phim(ten_rap, dia_chi, sdt, nguoi_quan_ly, khu_vuc) values (N'CGV lanmark', N'123 nguyen huu tho p3 quận bình thạnh', '0123456789', 2, N'bình thạnh');


create table phong_chieu(
	id_phong int primary key auto_increment,
    ten_phong varchar(10) not null unique,
    ghe_thuong int, 
    ghe_vip int, 
    ghe_doi int,
    id_rap int,
    foreign key(id_rap) references rap_phim (ma_rap)
);

insert into phong_chieu (ten_phong, ghe_thuong, ghe_vip, ghe_doi, id_rap) values ('CGV01', 12,30,10,1);
insert into phong_chieu (ten_phong, ghe_thuong, ghe_vip, ghe_doi, id_rap) values ('CGV02', 12,30,10,1);
insert into phong_chieu (ten_phong, ghe_thuong, ghe_vip, ghe_doi, id_rap) values ('CGV03', 12,30,10,2);

create table phim (
	ma_phim int primary key auto_increment,
    ten_phim nvarchar(500) unique,
	thoi_luong int,
    do_tuoi int, 
    quoc_gia varchar(100)
);
insert into phim(ten_phim, thoi_luong, do_tuoi, quoc_gia) values (N'the rock', 90, 18, 'merican');
create table xuat_chieu(
	ma_xc int primary key auto_increment, 
    ma_phong int, 
    ma_phim int, 
    gio_bd varchar(10),
    gio_kt varchar(10),
    ngay_bd datetime,
    ngay_kt datetime,
    foreign key (ma_phong) references phong_chieu(id_phong),
    foreign key (ma_phim) references phim(ma_phim)
);
insert into xuat_chieu(ma_phong, ma_phim, gio_bd, gio_kt, ngay_bd, ngay_kt) values (1, 1, '19:23', '21:23', now(), '2020-09-10');
insert into xuat_chieu(ma_phong, ma_phim, gio_bd, gio_kt, ngay_bd, ngay_kt) values (2, 1, '19:23', '21:23', '2020-09-01', '2020-09-10');
select * from xuat_chieu;
create table khach_hang(
	ma_kh int primary key auto_increment,
    ten_kh nvarchar(200) unique not null, 
    sdt varchar(20) not null,
    ngay_sinh datetime, 
    diem_thuong double,
    xep_loai varchar(50)
);
insert into khach_hang(ten_kh, sdt, ngay_sinh,diem_thuong, xep_loai) values (N'trần thái abcd','31325848666', '1984-08-18', 1000, 'new');
insert into khach_hang(ten_kh, sdt, ngay_sinh,diem_thuong, xep_loai) values (N'trần thái abcd2','31325848666', '1984-08-18', 10000, 'Vip');
insert into khach_hang(ten_kh, sdt, ngay_sinh,diem_thuong, xep_loai) values (N'trần thái abcd3','31325848666', '1984-08-18', 20000, 'Vip');
create table vephim(
	id_ve int primary key auto_increment,
    ma_kh int,
    ma_nv int,
    so_ghe varchar(5), 
    gia int,
    id_xc int,
    foreign key(id_xc) references xuat_chieu(ma_xc),
    foreign key(ma_kh) references khach_hang(ma_kh),
    foreign key(ma_nv) references nhan_vien(id_nv)
);
insert into vephim(ma_kh, ma_nv, so_ghe, gia, id_xc) values (1, 1, 'A01', 45000, 1);
insert into vephim(ma_kh, ma_nv, so_ghe, gia, id_xc) values (2, 1, 'A02', 45000, 1);
insert into vephim(ma_kh, ma_nv, so_ghe, gia, id_xc) values (3, 1, 'A03', 45000, 1);
insert into vephim(ma_kh, ma_nv, so_ghe, gia, id_xc) values (4, 2, 'A04', 45000, 1);
insert into vephim(ma_kh, ma_nv, so_ghe, gia, id_xc) values (1, 2, 'A05', 45000, 1);

select * from vephim;

create table Users(
	tai_khoan varchar(200) primary key not null,
    mat_khau varchar(100) not null,
    ten_dn nvarchar(200) unique, 
    Quyen varchar(20)
);
insert into Users values ('admin', '202cb962ac59075b964b07152d234b70',N'admin', 'admin');
insert into Users values ('lehung', '202cb962ac59075b964b07152d234b70',N'Lê Hưng', 'user');

select * from Users where tai_khoan = 'admin' and mat_khau = '122' and quyen = 'admin';
update nhan_vien set ten_nv = N'Phạm Lê Hưng', ngay_sinh = '1998-02-26', sdt = '0123456789', dia_chi = N'123 Nguyễn Thị Thập', chuc_vu = 'QL' where id_nv=1;
delete from nhan_vien where id_nv = 5;
select * from nhan_vien where ten_nv like  N'%Hưng%';
update rap_phim set ten_rap = N'CFV Lanmark', dia_chi = N'123 Nguyễn Thị Thập p12 Q7', sdt = '123456789', nguoi_quan_ly = 1, khu_vuc = N'Bình Thạnh' where ma_rap = 2;
delete from rap_phim where ma_rap = 3;
select * from phong_chieu;
select id_phong, ten_phong, ghe_thuong, ghe_vip, ghe_doi, ten_rap from phong_chieu inner join rap_phim on rap_phim.ma_rap = phong_chieu.id_rap;
select ma_xc, ten_phim, ten_phong, gio_bd, gio_kt, ngay_bd, ngay_kt 
from ((xuat_chieu inner join phong_chieu on xuat_chieu.ma_phong = phong_chieu.id_rap) inner join phim on xuat_chieu.ma_phim = phim.ma_phim);
select id_ve, ten_kh, ten_nv, so_ghe, gia, xuat_chieu.ma_xc from (((vephim inner join khach_hang on vephim.ma_kh = khach_hang.ma_kh) inner join nhan_vien on vephim.ma_nv = nhan_vien.id_nv) inner join xuat_chieu on vephim.id_xc = xuat_chieu.ma_xc);
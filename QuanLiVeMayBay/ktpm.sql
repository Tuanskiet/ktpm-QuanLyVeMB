create database QuanliMaybay
go
use QuanliMayBay
go
create table NhanVien(
MaNV nvarchar(50) not null,
TenNV nvarchar(50) not null,
SDT nvarchar(50) not null,
DiaChi nvarchar(50) not null,
TenDN nvarchar(50) not null,
MatKhau nvarchar(50) not null,
ChucVu bit not null,
primary key(MaNV)
);
create table VeBan(
MaVe nvarchar(50) not null,
MaNV nvarchar(50) not null,
MaHoaDon nvarchar(50) not null,
SoLuongVe nvarchar(50) not null,
primary key (MaVe)
);
create table KhachHang(
MaKH nvarchar(50) not null,
TenKH nvarchar(50) not null,
MaVe nvarchar(50) not null,
SDT nvarchar(50) not null,
DiaChi nvarchar(50) not null,
CMND nvarchar(50) not null,
Email nvarchar(50) not null,
MaChuyenBay nvarchar(50) not null,
primary key (MaKH)
);
create table ThongKe(
MaVe nvarchar(50) not null,
MaKH nvarchar(50) not null,
NgayDat date not null,
GiaVe nvarchar(50) not null
);

create table ChuyenBay(
MaCB nvarchar(50) not null,
DiemDi nvarchar(50) not null,
DiemDen nvarchar(50) not null,
GioBay nvarchar(50) not null,
MaKH nvarchar(50) not null,
MaMB nvarchar(50) not null,
GhiChu nvarchar(50) not null,
primary key (MaCB)
);
create table MayBay(
MaMB nvarchar(50) not null,
MaCB nvarchar(50) not null,
TenMB nvarchar(50) not null,
HangMB nvarchar(50) not null,
KichThuoc nvarchar(50) not null,
TongSoGhe nvarchar(50) not null,
SoGhe1 nvarchar(50) not null,
SoGhe2 nvarchar(50) not null,
primary key (MaMB)
);
create table VeChiTiet(
MaVe nvarchar(50) not null,
MaCB nvarchar(50) not null,
LoaiVe nvarchar(50) not null,
GiaVe nvarchar(50) not null,
SoLuong nvarchar(50) not null,
SoLuongCon nvarchar(50) not null,
primary key (MaVe)
);

drop table MayBay
ALTER TABLE VeBan ADD CONSTRAINT fk_MaNV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
ALTER TABLE VeChiTiet ADD CONSTRAINT fk_MaVe1 FOREIGN KEY (MaVe) REFERENCES VeBan(MaVe)
ALTER TABLE KhachHang ADD CONSTRAINT fk_MaVe FOREIGN KEY (MaVe) REFERENCES VeBan(MaVe)
ALTER TABLE ChuyenBay ADD CONSTRAINT fk_MaKH FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
ALTER TABLE MayBay ADD CONSTRAINT fk_MaCB FOREIGN KEY (MaCB) REFERENCES ChuyenBay(MaCB)
ALTER TABLE ThongKe ADD CONSTRAINT fk_MaVe2 FOREIGN KEY (MaVe) REFERENCES VeBan(MaVe)
ALTER TABLE ThongKe ADD CONSTRAINT fk_MaKH1 FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)



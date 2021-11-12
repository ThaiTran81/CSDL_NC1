USE master
GO
IF DB_ID('QLHD') IS NOT NULL
	DROP DATABASE QLHD
GO
CREATE DATABASE QLHD
GO
USE QLHD
GO

create table KhachHang(
	MaKH varchar(15),
	Ho nvarchar(15),
	Ten nvarchar(15),
	NgSinh Date,
	SoNha varchar(10),
	Duong nvarchar(30),
	Phuong nvarchar(30),
	Quan nvarchar(30),
	TPho nvarchar(30),
	DienThoai varchar(15),
	primary key(MaKH)
)

CREATE TABLE HoaDon
(
	MaHD VARCHAR(15),
	MaKH VARCHAR(15),
	NgayLap DATE,
	TongTien MONEY,	
	PRIMARY KEY (MaHD)
)

CREATE TABLE CT_HoaDon(
  MaHD VARCHAR(15),
  MaSP VARCHAR(15),
  SoLuong INT,
  GiaBan MONEY,
  GiaGiam MONEY DEFAULT (0),
  ThanhTien MONEY,
  CONSTRAINT PK_CTHOADON PRIMARY KEY (MaHD, MaSP)
)


create table SanPham
(
	MaSP varchar(15),
	TenSP nvarchar(20),
	SoLuongTon int,
	Mota nvarchar(1024),
	Gia money,
	primary key (MaSP)
)


ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (MaKH)
REFERENCES KhachHang(MaKH)


alter table CT_HoaDon add
CONSTRAINT FK_CTHoaDon_HoaDon FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
CONSTRAINT FK_CTHoaDon_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
CONSTRAINT CK_GiaBan_GiaGiam CHECK (GiaGiam <= GiaBan AND GiaGiam >= 0)


-- Ham tinh doanh thu thang cho giao dien
create procedure doanhthu_Thang @thang1 date, @thang2 date
as
	begin
		select sum(s.tongtien) as Doanhthu
		from(select sum(TongTien) as tongtien from HoaDon
		where DATEDIFF(day, NgayLap, @thang1) <= 0 and DATEDIFF(day,NgayLap, @thang2) > 0
		group by MaKH) as s
	end
go

exec doanhthu_Thang @thang1='1995-01-01', @thang2='1995-02-01'
drop procedure doanhthu_Thang
exec listByThang @thang1='1995-02-01', @thang2='1995-03-01'
drop procedure listByThang

create procedure listByThang @thang1 date, @thang2 date
as
	begin
		select *
		from HoaDon
		where DATEDIFF(day, NgayLap, @thang1) <= 0 and DATEDIFF(day,NgayLap, @thang2) > 0
		Order By Case When IsNumeric(mahd) = 1
				Then Right('0000000000000000000' + mahd, 15)
                Else mahd End
	end
go
﻿USE master
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
	Duong varchar(30),
	Phuong varchar(30),
	Quan varchar(30),
	TPho varchar(30),
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
  GiaBan MONEY NOT NULL,
  GiaGiam MONEY NOT NULL,
  ThanhTien MONEY,
  CONSTRAINT PK_CTHOADON PRIMARY KEY (MaHD, MaSP)
)


create table SanPham
(
	MaSP varchar(15),
	TenSP nvarchar(20),
	SoLuongTon int,
	Mota nvarchar(100),
	Gia money,
	primary key (MaSP)
)

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (MaKH)
REFERENCES KhachHang(MaKH)


alter table CT_HoaDon add
CONSTRAINT FK_CTHoaDon_HoaDon FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
CONSTRAINT FK_CTHoaDon_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)  

go
create trigger TinhThanhTien on CT_HoaDon 
after insert, update
as 
begin
	update CT_HoaDon
	set CT_HoaDon.ThanhTien = (CT_HoaDon.GiaBan-CT_HoaDon.GiaGiam)*CT_HoaDon.SoLuong
	FROM CT_HoaDon
    INNER JOIN inserted i on i.MaHD = CT_HoaDon.MaHD and i.MaSP=CT_HoaDon.MaSP
end

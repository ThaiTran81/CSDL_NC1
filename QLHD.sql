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

CREATE TABLE CT_HoaDon(


create table SanPham

ALTER TABLE HoaDon


alter table CT_HoaDon add
CONSTRAINT FK_CTHoaDon_HoaDon FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
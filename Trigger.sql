USE QLHD
GO

create trigger TinhThanhTien on CT_HoaDon 
after insert, update
as 
begin
	update CT_HoaDon
	set CT_HoaDon.ThanhTien = (CT_HoaDon.GiaBan-CT_HoaDon.GiaGiam)*CT_HoaDon.SoLuong
	FROM CT_HoaDon
    INNER JOIN inserted i on i.MaHD = CT_HoaDon.MaHD and i.MaSP=CT_HoaDon.MaSP
END
GO

CREATE TRIGGER TinhTongTien ON dbo.CT_HoaDon
AFTER INSERT,UPDATE, DELETE AS 
BEGIN
	UPDATE dbo.HoaDon
	SET dbo.HoaDon.TongTien = (
		SELECT SUM(ThanhTien)
		FROM dbo.CT_HoaDon
		WHERE dbo.CT_HoaDon.MaHD = i.MaHD
	)
	FROM Inserted i 
	JOIN dbo.HoaDon ON HoaDon.MaHD = i.MaHD 
END
GO

-- update GiaBan of CT_HoaDon after Insert.
CREATE TRIGGER GiaBan ON dbo.CT_HoaDon
AFTER INSERT AS
BEGIN
	UPDATE dbo.CT_HoaDon
	SET GiaBan = (
		SELECT sp.Gia 
		FROM dbo.SanPham sp
		WHERE sp.MaSP = MaSP
	) 
	FROM dbo.CT_HoaDon
	JOIN Inserted ON CT_HoaDon.MaSP = Inserted.MaSP
	
END
GO





-- trigger update soluongton in dbo.SanPham after (insert, update and delete)
CREATE TRIGGER insert_SoLuongTon ON dbo.CT_HoaDon
AFTER INSERT AS
BEGIN
	UPDATE dbo.SanPham
	SET dbo.SanPham.SoLuongTon = SoLuongTon - (
		SELECT i.SoLuong
        FROM Inserted i
		WHERE i.MaSP = sp.MaSP
	)
	FROM dbo.SanPham sp
	JOIN Inserted i ON i.MaSP = sp.MaSP
END
GO

CREATE TRIGGER delete_SoLuongTon ON dbo.CT_HoaDon
AFTER DELETE AS
BEGIN
	UPDATE dbo.SanPham
	SET dbo.SanPham.SoLuongTon = SoLuongTon + (
		SELECT d.SoLuong
        FROM Deleted d
		WHERE d.MaSP = sp.MaSP
	)
	FROM dbo.SanPham sp
	JOIN Deleted i ON i.MaSP = sp.MaSP
END
GO

CREATE TRIGGER update_SoLuongTon ON dbo.CT_HoaDon
AFTER UPDATE AS
BEGIN
	UPDATE dbo.SanPham
	SET dbo.SanPham.SoLuongTon = SoLuongTon - (
		SELECT i.SoLuong
        FROM Inserted i
		WHERE i.MaSP = sp.MaSP
	) + (
		SELECT d.SoLuong
        FROM Deleted d
		WHERE d.MaSP = sp.MaSP
	)
	FROM dbo.SanPham sp
	JOIN Deleted d ON d.MaSP = sp.MaSP
END
GO




DROP TRIGGER insert_SoLuongTon
DROP TRIGGER delete_SoLuongTon
DROP TRIGGER update_SoLuongTon
DROP TRIGGER dbo.TinhThanhTien
DROP TRIGGER dbo.TinhTongTien
DROP TRIGGER GiaBan

SELECT	* FROM dbo.HoaDon
SELECT	* FROM dbo.CT_HoaDon
SELECT * FROM dbo.SanPham

UPDATE dbo.CT_HoaDon SET SoLuong = '10' WHERE MaSP = '1'
UPDATE dbo.CT_HoaDon SET SoLuong = '10' WHERE MaSP = '3'
UPDATE dbo.CT_HoaDon SET SoLuong = '10' WHERE MaSP = '2'
UPDATE dbo.SanPham SET SoLuongTon = '10' WHERE MaSP = '1'

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
FOR	INSERT,UPDATE, DELETE AS 
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
	
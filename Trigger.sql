USE QLHD
GO


-- Trigger Tinh thanh tien
CREATE OR ALTER TRIGGER TinhThanhTien
ON CT_HoaDon
FOR INSERT, UPDATE
AS
BEGIN
  UPDATE CT_HoaDon
  SET CT_HoaDon.ThanhTien = (CT_HoaDon.GiaBan - CT_HoaDon.GiaGiam) * CT_HoaDon.SoLuong
  FROM CT_HoaDon
  INNER JOIN inserted i
    ON i.MaHD = CT_HoaDon.MaHD
    AND i.MaSP = CT_HoaDon.MaSP
END
GO

--Trigger tinh tong tien
CREATE OR ALTER TRIGGER TinhTongTien
ON dbo.CT_HoaDon
FOR INSERT, UPDATE, DELETE
AS
BEGIN
  UPDATE dbo.HoaDon
  SET dbo.HoaDon.TongTien = (SELECT SUM(ThanhTien)
              FROM dbo.CT_HoaDon
              WHERE dbo.CT_HoaDon.MaHD = i.MaHD)
  FROM Inserted i
  JOIN dbo.HoaDon
    ON HoaDon.MaHD = i.MaHD
END
GO

-- trigger update soluongton in dbo.SanPham after (insert, update and delete)
CREATE OR ALTER TRIGGER insert_SoLuongTon
ON dbo.CT_HoaDon
FOR INSERT
AS
BEGIN
  DECLARE @SLT INT
         ,@SL INT
  SET @SLT = (SELECT
      sp.SoLuongTon
    FROM SanPham sp
    JOIN INSERTED i
      ON sp.MaSP = i.MaSP)
  SET @SL = (SELECT
      chd.SoLuong
    FROM CT_HoaDon chd
    JOIN INSERTED i
      ON chd.MaHD = i.MaHD
      AND chd.MaSP = i.MaSP)
  IF (@SLT - @SL < 0)
  BEGIN
    PRINT ('Sô´ luo?ng tô`n không du? cung câ´p')
    ROLLBACK TRAN;
  END
  ELSE
    UPDATE SanPham
    SET SanPham.SoLuongTon = @SLT - @SL
    WHERE SanPham.MaSP = (SELECT
        sp.MaSP
      FROM SanPham sp
      JOIN INSERTED i
        ON sp.MaSP = i.MaSP)
END
GO

-- Trigger cap nhat So Luong Ton khi CT Hoa don bi xoa
CREATE OR ALTER TRIGGER delete_SoLuongTon
ON dbo.CT_HoaDon
FOR DELETE
AS
BEGIN
  UPDATE dbo.SanPham
  SET dbo.SanPham.SoLuongTon = SoLuongTon + (SELECT
      d.SoLuong
    FROM Deleted d
    WHERE d.MaSP = sp.MaSP)
  FROM dbo.SanPham sp
  JOIN Deleted i
    ON i.MaSP = sp.MaSP
END
GO
-- Trigger cap nhat So luong ton 
CREATE OR ALTER TRIGGER update_SoLuongTon
ON dbo.CT_HoaDon
FOR UPDATE
AS
BEGIN
  DECLARE @SLT INT
         ,@SL_in INT
         ,@SL_out INT
  SET @SLT = (SELECT
      sp.SoLuongTon
    FROM SanPham sp
    JOIN INSERTED i
      ON sp.MaSP = i.MaSP)
  SET @SL_in = (SELECT
      i.SoLuong
    FROM CT_HoaDon chd
    JOIN INSERTED i
      ON chd.MaHD = i.MaHD
      AND chd.MaSP = i.MaSP)
  SET @SL_out = (SELECT
      d.SoLuong
    FROM CT_HoaDon chd
    JOIN DELETED d
      ON chd.MaHD = d.MaHD
      AND chd.MaSP = d.MaSP)
  IF (@SLT - @SL_in + @SL_out < 0)
  BEGIN
    PRINT ('Sô´ luo?ng tô`n không du? cung câ´p')
    ROLLBACK TRAN;
  END
  ELSE
    UPDATE SanPham
    SET SoLuongTon = (@SLT - @SL_in + @SL_out)
    WHERE MaSP = (SELECT
        i.MaSP
      FROM SanPham sp
      JOIN INSERTED i
        ON sp.MaSP = i.MaSP)

END
GO

--DROP TRIGGER dbo.TinhThanhTien
--DROP TRIGGER dbo.TinhTongTien
--DROP TRIGGER insert_SoLuongTon
--DROP TRIGGER delete_SoLuongTon
--DROP TRIGGER update_SoLuongTon

--DISABLE TRIGGER insert_SoLuongTon ON CT_HoaDon
--GO 
--enable TRIGGER insert_SoLuongTon ON CT_HoaDon


--SELECT * FROM CT_HoaDon chd
--SELECT COUNT(*) FROM HoaDon h
--SELECT COUNT(*) FROM KhachHang kh
--SELECT COUNT(*) FROM sanpham

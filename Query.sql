USE QLHD
GO 
--A
  SELECT *
FROM HoaDon hd  
WHERE YEAR( hd.NgayLap) = 2020 

--B
 SELECT 	*
FROM	KhachHang KH
WHERE	KH.TPho like N'H? Chí Minh'

--C
SELECT *
FROM SANPHAM
WHERE GIA > 50 AND  GIA < 100000

--D
SELECT
  sp.MaSP
 ,sp.TenSP
 ,sp.SoLuongTon
FROM SanPham sp
WHERE sp.SoLuongTon < 500


--E
SELECT
  sp.MaSP
 ,sp.TenSP
 ,SUM(ct.SoLuong)
FROM CT_HoaDon ct
JOIN SanPham sp
  ON ct.MaSP = sp.MaSP
GROUP BY sp.MaSP
        ,sp.TenSP
HAVING SUM(ct.SoLuong) >= ALL (SELECT
    SUM(ct1.SoLuong)
  FROM CT_HoaDon ct1
  GROUP BY ct1.MaSP)

--SELECT SUM(chd.SoLuong) AS sl, chd.MaSP
--FROM CT_HoaDon chd
--GROUP BY chd.MaSP
--HAVING SUM(chd.SoLuong) >= (
--  SELECT TOP 1 SUM(chd.SoLuong) AS sl
--  FROM CT_HoaDon chd
--  GROUP BY chd.MaSP
--  ORDER BY sl desc
--)
--ORDER BY sl desc


  
--  F - tiÌm tâìt caÒ saÒn phâÒm coì doanh thu cao nhâìt

SELECT DISTINCT(sp.MaSP), (ban.tongtienban - ban.slban*sp.Gia) AS doanhthu 
FROM SanPham sp 
JOIN (
  SELECT SUM(chd.SoLuong) AS slban, SUM(chd.ThanhTien) AS tongtienban, chd.MaSP
  FROM CT_HoaDon chd
  GROUP BY chd.MaSP) ban 
ON ban.MaSP = sp.MaSP
WHERE ban.tongtienban - ban.slban*sp.Gia >= (
  SELECT TOP 1 (ban1.tongtienban1 - ban1.slban1*sp1.Gia) AS doanhthu1
  FROM SanPham sp1
  JOIN (
  SELECT SUM(chd1.SoLuong) AS slban1, SUM(chd1.ThanhTien) AS tongtienban1, chd1.MaSP
  FROM CT_HoaDon chd1
  GROUP BY chd1.MaSP) ban1 
  ON ban1.MaSP = sp1.MaSP
  ORDER BY doanhthu1 desc
)
ORDER BY sp.MaSP
GO

--
--SELECT COUNT(*) FROM CT_HoaDon chd
--SELECT COUNT(*) FROM HoaDon hd
--SELECT COUNT(*) FROM KhachHang kh
--SELECT COUNT(*) FROM SanPham sp
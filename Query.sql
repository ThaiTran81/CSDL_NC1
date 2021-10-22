USE QLHD
GO 

--D
SELECT
  sp.MaSP
 ,sp.TenSP
 ,sp.SoLuongTon
FROM SanPham sp
WHERE sp.SoLuongTon < 100


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

  
--  F
SELECT cthd.masp, SUM(cthd.ThanhTien) AS doanhthu
FROM dbo.CT_HoaDon cthd
GROUP BY cthd.MaSP 
HAVING SUM(cthd.ThanhTien) >= (
	SELECT TOP 1 SUM(cthd2.ThanhTien)
	FROM dbo.CT_HoaDon cthd2
	GROUP BY cthd2.MaSP
	ORDER BY SUM(cthd2.ThanhTien) DESC 
)
ORDER BY doanhthu DESC 
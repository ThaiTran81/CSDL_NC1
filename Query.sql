
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
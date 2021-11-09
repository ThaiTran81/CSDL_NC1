USE QLHD
--Truy vấn lấy mã hóa đơn mới nhất
SELECT TOP 1 hd.MaHD
FROM HoaDon hd 
ORDER BY hd.MaHD DESC
--Truy vấn hóa đơn theo mã khách hàng và ngày lập
SELECT *
FROM HoaDon hd
WHERE hd.MaKH = 'ID000000'
AND NgayLap = '1975-05-24'
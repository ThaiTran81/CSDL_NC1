USE QLHD
  go
--mã hoá đơn
  DROP PROC Find_HD_MAHD
  CREATE PROC Find_HD_MAHD
  @mahd VARCHAR(15) NOT NULL
    as
      SELECT *
      FROM HoaDon hd 
      WHERE hd.MaHD = @mahd
    go
  EXEC Find_HD_MAHD @mahd = '0000001';

  SELECT *
      FROM HoaDon hd 
      WHERE hd.MaHD = 0100002
-- mã khách hàng
  DROP PROC Find_HD_MAKH
  CREATE PROC Find_HD_MAKH
  @makh VARCHAR(15)
    as
      SELECT *
      FROM HoaDon hd 
      WHERE hd.MaKH = @makh
    go
  EXEC Find_HD_MAKH @makh = 'ID000002';

  SELECT *
      FROM HoaDon hd 
      WHERE hd.MaKH = 'ID000002'
-- ngày lập (ngày tháng năm)
CREATE PROC FIND_HD_NgayLap
  @ngaylap DATE
    as
   SELECT *
    FROM HoaDon hd
    WHERE hd.NgayLap = @ngaylap
    GO
  EXEC FIND_HD_NgayLap '3/3/1974'

--  theo mã hoá đơn và khách hàng
CREATE PROC Find_HD_MAKH_MaHD
  @makh VARCHAR(15),
  @mahd VARCHAR(15)
    as
      SELECT *
      FROM HoaDon hd 
      WHERE hd.MaKH = @makh AND hd.MaHD = @mahd
    go
  EXEC Find_HD_MAKH_MaHD @makh = 'ID000002', @mahd = '0000002'

  SELECT *
      FROM HoaDon hd 
      WHERE hd.MaKH = 'ID000002' AND hd.MaHD = '0000002'
  
use QLHD
go


--select sum(s.tongtien)
--from(select sum(TongTien) as tongtien from HoaDon
--where DATEDIFF(day, NgayLap, '1995-01-01') <= 0 and DATEDIFF(day,NgayLap, '1995-02-01') > 0
--group by MaKH) as s


create procedure doanhthu_Thang @thang1 date, @thang2 date
as
	begin
		select sum(s.tongtien) as Doanhthu
		from(select sum(TongTien) as tongtien from HoaDon
		where DATEDIFF(day, NgayLap, @thang1) <= 0 and DATEDIFF(day,NgayLap, @thang2) > 0
		group by MaKH) as s
	end
go

exec doanhthu_Thang @thang1='2020-02-01', @thang2='2020-03-01'
--drop procedure doanhthu_Thang
--exec listByThang @thang1='1995-02-01', @thang2='1995-03-01'
--drop procedure listByThang

create procedure listByThang @thang1 date, @thang2 date
as
	begin
		select *
		from HoaDon
		where DATEDIFF(day, NgayLap, @thang1) <= 0 and DATEDIFF(day,NgayLap, @thang2) > 0
		Order By Case When IsNumeric(mahd) = 1
				Then Right('0000000000000000000' + mahd, 15)
                Else mahd End
	end
GO

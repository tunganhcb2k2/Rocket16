-- tao database
drop DATABASE if exists `Thuc_tap`;
create DATABASE `Thuc_tap`;
use `Thuc_tap`;

-- tao bang GiangVien
drop table if exists `GiangVien`;
create table `GiangVien`
(
	magv	tinyint UNSIGNED AUTO_INCREMENT PRIMARY key,
    hoten	varchar(50),
    luong	int UNSIGNED
);

-- tao bang SinhVien
drop table if exists `SinhVien`;
create table `SinhVien`
(
	masv	tinyint UNSIGNED AUTO_INCREMENT PRIMARY key,
    hoten	varchar(50),
    namsinh	int UNSIGNED,
    quequan varchar(30)
);

-- tao bang DeTai
drop table if exists `DeTai`;
create table `DeTai`
(
	madt	tinyint UNSIGNED AUTO_INCREMENT PRIMARY key,
    tendt	varchar(50),
    kinhphi	int UNSIGNED,
    NoiThucTap	varchar(50)
);

-- tao bang HuongDan
drop table if exists `HuongDan`;
create table `HuongDan`
(
	id	tinyint UNSIGNED AUTO_INCREMENT PRIMARY key,
    masv	tinyint UNSIGNED,
    madt	tinyint UNSIGNED,
    magv	tinyint UNSIGNED,
    ketqua	tinyint UNSIGNED
);

-- them du lieu vao bang GiangVien
insert into `giangvien` (`hoten`, `luong`)
values ('Sầm Ngọc Quỳnh', 10000000),
		('Hoàng Ngọc Dương', 16000000),
        ('Đinh Văn Bình', 12000000);
        
-- them du lieu vao bang SinhVien
insert into `Sinhvien`(`hoten`, `namsinh`, `quequan`)
values		('Lê Thái Dương', 2002, 'Cao Bằng'),
			('Lê Minh Tú', 2002, 'Yên Bái'),
            ('Ma Kiều Trinh', 2002, 'Hà Nội'),
            ('Hoàng Nguyễn Tùng Anh', 2002, 'Hà Nội'),
            ('Lương Quang Hưng', 2002, 'Hà Nội');
            
-- them du lieu vao bang DeTai
insert into `Detai` (`tendt`, `kinhphi`, `NoiThucTap`)
values 				('ngon_ngu_c', '500000', 'VTIacademy'),
					('ngon_ngu_java', '1500000', 'FPTeducation'),
					('ngon_ngu_C#', '2500000', 'VTIacademy'),
                    ('CONG NGHE SINH HOC', '15000000', 'NEUeducation');
                    
-- them du lieu vao bang HuongDan
insert into `HuongDan` (`masv`, `madt`, `magv`, `ketqua`)
values					(1,3,2,9),
						(2,1,3,5),
                        (3,2,1,10),
                        (5,4,1,10);
                        
-- cau 2:
-- a,Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
select sinhvien.*
from huongdan
right join sinhvien using(masv)
where madt is null;

-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
select count(masv) as 'Số Sv làm đề tài ‘CONG NGHE SINH HOC’'
from huongdan
join detai using(madt)
where tendt = 'CONG NGHE SINH HOC'
group by madt;

-- cau 3:Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")

drop view if exists `Sinhvieninfo`;
create view `sinhvieninfo` as 
(
	select masv, hoten, case tendt when null 
    then 'chưa có' 
    else tendt
    end as tendt
    from sinhvien
    left join huongdan using(masv)
    join detai using(madt)

);

-- cau 4: Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 thì hiện ra thông báo "năm sinh phải > 1900"
drop trigger if exists `insert_data`;
delimiter $$
create trigger `insert_data`
before insert on sinhvien
for each row
begin 
	if new.namsinh <= 1900 then
    signal SQLSTATE '12345'
    set MESSAGE_TEXT = 'năm sinh phải > 1900';
    end if;
end$$
delimiter ;

-- test cau 4:
insert into `sinhvien` ()
values 				(6, 'abc', 1890, 'Ha Noi');

-- cau 5: Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
drop trigger if exists `delete_data`;
delimiter $$
create trigger `delete_data`
before delete on sinhvien
for each row 
begin
	delete from huongdan where old.masv = masv;
end $$
delimiter ;

-- test cau 5:
begin work;
select *
from huongdan;

delete
from sinhvien
where masv = 1;

select *
from huongdan;
rollback;


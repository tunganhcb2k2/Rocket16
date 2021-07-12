-- tao database
Drop DATABASE if exists `ThucTap`;
Create DATABASE `ThucTap`;
use `ThucTap`;

-- tao bang country
drop table if exists country;
create table country
(
	Country_id tinyint unsigned AUTO_INCREMENT PRIMARY key,
    country_name varchar(50)
);

-- tao bang location
drop table if exists `location`;
create table `location`
(
	location_id tinyint unsigned AUTO_INCREMENT PRIMARY key,
    street_address varchar(50),
	postal_code varchar(10),
    country_id tinyint unsigned
);

-- tao bang employee
drop table if exists `employee`;
create table `employee`
(
	employee_id tinyint unsigned AUTO_INCREMENT PRIMARY key,
    full_name varchar(50),
    email varchar(30),
    location_id tinyint unsigned
);

-- them du lieu vao bang country
insert into `country`(country_name)
values   ('Việt Nam'),
		 ('Singapore'),
         ('American');
         
-- them du lieu vao bang location
insert into `location`(street_address, postal_code, country_id)
values ('Nguyễn Huệ', 'VN01', '1'),
		('acb123', 'SP02', '2'),
        ('cde456', 'US03', '3');
        
-- them du lieu vao bang employee
insert into `employee`(full_name, email, location_id)
values ('Lê Minh Tú', 'tule@gmail.com', '2'),
		('Lê Thái Dương', 'duongle@gmail.com', '1'),
        ('Ma Thị Kiều Trinh', 'nn03@gmail.com', '3');
        
        
-- cau 2:
drop view if exists `bang1`;
create view `bang1` as (select country_name, postal_code, location_id from country join location using(country_id));
-- a, Lấy tất cả các nhân viên thuộc Việt nam
select * from employee 
join `bang1`
using(location_id) 
where country_name = 'Việt Nam';
        
-- b, Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
select country_name 
from employee 
join `bang1` using(location_id)  
where email = 'nn03@gmail.com'; 

-- c, Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc
select country_name, count(full_name) as 'số nhân viên làm việc'  
from employee 
join `bang1` using(location_id) 
group by location_id;

-- cau 3: Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
drop trigger if exists `insert_data`;
delimiter $$
create trigger `insert_data`
BEFORE insert on Employee
for each row
begin
	declare _number tinyint unsigned;
    select count(employee_id) into _number  from employee where new.location_id = location_id  group by location_id;
    if _number >= 10 then
		signal sqlstate '12345'
		set MESSAGE_TEXT = 'mỗi quốc gia có tối đa 10 employee';
    end if;
end$$
delimiter ;

-- test cau 3
insert into employee()
values ( '4','acb', 'vti00@gamil.com', 1),
		( '5','acb1', 'vti2@gamil.com', 1),
		( '6','acb2', 'vti3@gamil.com', 1),
        ( '7','acb3', 'vti4@gamil.com', 1),
        ( '8','acb4', 'vti5@gamil.com', 1),
        ( '9','acb5', 'vti6@gamil.com', 1),
        ( '10','acb6', 'vt71@gamil.com', 1),
        ( '11','acb7', 'vti8@gamil.com', 1),
        ( '12','acb8', 'vti9@gamil.com', 1),
        ( '13','acb10', 'vti11@gamil.com', 1),
        ( '14','acb9', 'vti10@gamil.com', 1);
        
begin work;
rollback;
select * from employee;

-- cau 4: Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null
select employee.employee_id, employee.full_name, employee.email, location.location_id
from location
right join employee using(location_id);

-- test cau 4
begin work;
rollback;
select * from location;

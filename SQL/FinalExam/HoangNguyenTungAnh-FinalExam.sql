-- Tao database 
drop DATABASE if exists `testing_final`;
create DATABASE `testing_final`;
use `testing_final`;

-- Tao bang
drop table if exists `Student`;
create table `Student`
(
	`ID`		tinyint UNSIGNED AUTO_INCREMENT PRIMARY key,
    `Name`		varchar(50),
    `Age`		tinyint UNSIGNED,
    `Gender`	enum('nam', 'nu')
);

drop table if exists `subject`;
create table `subject`
(
	`ID`		tinyint UNSIGNED AUTO_INCREMENT PRIMARY key,
    `Name`		varchar(50)			
);

drop table if exists `studentsubject`;
create table `studentsubject`
(
	`StudentID`	tinyint UNSIGNED,
    `subjectID`	tinyint UNSIGNED,
    `mark`		tinyint UNSIGNED,
    `Date`		DATETIME
-- Constraint `ID_pk` PRIMARY key (`studentID`, `subjectID`)
);

-- them du lieu vao bang
insert into `student` (`Name`, `Age`, `Gender`)
values					('Hoang Nguyen Tung Anh', '19', '0'),
						('Le Minh Tu', '20', '0'),
                        ('Be Khanh Linh', '17', '1'),
                        ('Ma Kieu Trinh', '25', '1');
                        
insert into `subject` (`Name`)
values					('Toan'),
						('Ly'),
                        ('Tin'),
                        ('Hoa'),
                        ('Anh');
                        
insert into `StudentSubject` (`StudentID`, `SubjectID`, `Mark`, `Date`)
values						('1', '1', '10', now()),
							('2', '5', '8', '2021-6-30'),
                            ('3', '3', '9', '2021-6-27'),
                            ('4', '1', '9', now()),
                            ('1', '3', '10', '2021-6-29');
						
                            
-- tra loi cau hoi
-- cau 2:
-- a, Lấy tất cả các môn học không có bất kì điểm nào
select `name`
from `subject`
left join `studentsubject` on `subject`.`ID` = `studentsubject`.`SubjectID`
where `subjectID` is null;

-- b, Lấy danh sách các môn học có ít nhất 2 điểm
select `ID`, `name`, count(*) as 'so luong diem'
from `studentsubject`
join `subject` on `studentsubject`.`SubjectID` = `subject`.`ID` 
group by `SubjectID` having count(*) >= 2;

-- cau 3: Tạo view có tên là "StudentInfo" lấy các thông tin về học sinh bao gồm: Student ID,Subject ID, Student Name, Student Age, Student Gender, Subject Name, Mark, Date (Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và 'Unknow' thay thế cho null)
drop view if exists `StudentInfo`;
create view `StudentInfo`(`StudentID`, `SubjectID`, `StudentName`, `Age`, `SubjectName`, `Mark`, `Date`, `Gender`) as
(
	select `StudentID`, `SubjectID`, `student`.`Name`, `Student`.`Age`, `Subject`.`Name`, `Mark`, `Date`, case `Student`.`Gender` 
    when 0 then 'male'
    when 1 then 'Female'
    when null then 'unknow'
    end as 'GioiTinh'
    from `Studentsubject`
    join `Student` on `Studentsubject`.`StudentID` = `Student`.`ID`
    join `subject` on `Studentsubject`.`subjectID` = `subject`.`ID`
    order by `student`.`ID` 
);

-- test cau 3:
select * from `StudentInfo`;

-- cau 4: Không sử dụng On Update Cascade & On Delete Cascade
-- a, Tạo trigger cho table Subject có tên là SubjectUpdateID: Khi thay đổi data của cột ID của table Subject, thì giá trị tương ứng với cột SubjectID của table StudentSubject cũng thay đổi theo
drop trigger if exists `SubjectUpdateID`;
delimiter $$
create trigger `SubjectUpdateID`
before update on `subject`	
for each row
begin 
		update `StudentSubject` 
        set 
			`mark` = NULL,
            `date` = NULL
		where
			`SubjectID` = New.`ID`
        ;
end $$
delimiter ;				

-- test a
begin work;                
update `subject` 
set 
	`name` = 'Su' 
where
	ID = 1;
select * from `subject`;
select * from `studentsubject`;
ROLLBACK;

-- b, Tạo trigger cho table Student có tên là StudentDeleteID: Khi xóa data của cột ID của table Student, thì giá trị tương ứng với cột SubjectID của table StudentSubject cũng bị xóa theo
drop trigger if exists `StudentDeleteID`;
delimiter $$
create trigger `StudentDeleteID`
before delete on `Student`
for each row
begin
	delete from `studentsubject` where old.`ID` = `StudentID`; 
end $$
delimiter ;

-- test b
begin work;
delete from `student` where `ID` = 1;
select * from `student`;
select * from `studentsubject`;
rollback;

-- cau 5: Viết 1 store procedure (có 1 parameters: student name) sẽ xóa tất cả các thông tin liên quan tới học sinh có cùng tên như parameter Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả các học sinh
drop PROCEDURE if exists `tah`;
delimiter $$
create procedure `tah`(IN `in_StudentName` varchar(50))
begin
    delete from `student` where `in_StudentName` = `Name` 
							or	`in_StudentName` = '*'  
    ;
end $$
delimiter ;

begin work;
call `tah`('*');
select * from `student`;
rollback;

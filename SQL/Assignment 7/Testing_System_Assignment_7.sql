DROP DATABASE IF EXISTS `Testing_System_Assignment_7`;
CREATE DATABASE `Testing_System_Assignment_7`;
USE `Testing_System_Assignment_7`;

-- tao bang 1:Department
DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department`
(
	DepartmentID			TINYINT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- tao bang 2:Position    
DROP TABLE IF EXISTS `Position`;    
CREATE TABLE `Position` 
(
	PositionID				TINYINT AUTO_INCREMENT PRIMARY KEY,
    PositionName			NVARCHAR(20) NOT NULL UNIQUE KEY
);

-- tao bang 3:Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` 
(
	AccountID				TINYINT AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(30) NOT NULL UNIQUE KEY,
    Username				VARCHAR(30) NOT NULL UNIQUE KEY,
    Fullname				NVARCHAR(50) NOT NULL,
    DepartmentID			TINYINT ,
    PositionID				TINYINT NOT NULL,
    CreateDate				Datetime NOT NULL
    -- FOREIGN KEY(DepartmentID) REFERENCES `Department` (DepartmentID),
    -- FOREIGN KEY(PositionID) REFERENCES `Position` (PositionID)
);

-- tao bang 4:Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`
(
	GroupID					TINYINT AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(30) NOT NULL,
    CreatorID				TINYINT ,
    CreateDate				Date NOT NULL
);

-- tao bang 5:GroupAccount
DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount`
(
	GroupID					TINYINT NOT NULL,
    AccountID				TINYINT  ,
    JoinDate				Datetime NOT NULL
   -- FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
   -- FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID)
);

-- tao bang 6:TypeQuestion
DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQuestion`
(
	TypeID					TINYINT AUTO_INCREMENT PRIMARY KEY,
    TypeName				NVARCHAR(30) NOT NULL
);

-- tao bang 7:CategoryQuestion
DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion`
(
	CategoryID				TINYINT AUTO_INCREMENT PRIMARY KEY,
    CategoryName			VARCHAR(30) NOT NULL
);

-- tao bang 8:Question
DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question`
(
	QuestionID				TINYINT AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT NOT NULL,
    TypeID					TINYINT ,
    CreatorID				TINYINT NOT NULL,
    CreateDate				Datetime NOT NULL
  --  FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion` (CategoryID),
  --  FOREIGN KEY(TypeID) REFERENCES `TypeQuestion` (TypeID)
);
    
-- tao bang 9:Answer
DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer`
    (
		AnswerID			TINYINT AUTO_INCREMENT PRIMARY KEY,
        Content				NVARCHAR(50) NOT NULL,
        QuestionID			TINYINT ,
        isCorrect			VARCHAR(3) NOT NULL
     --   FOREIGN KEY (QuestionID) REFERENCES `Question` (QuestionID)
	);
    
-- tao bang 10:Exam
DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam`
    (
		ExamID				TINYINT AUTO_INCREMENT PRIMARY KEY,
        Code				Varchar(30) NOT NULL UNIQUE KEY,
        Title				NVARCHAR(30) NOT NULL,
        CategoryID			TINYINT NOT NULL UNIQUE KEY,
        Duration			TINYINT NOT NULL,
        CreatorID			TINYINT ,
        CreateDate			Datetime NOT NULL
	);
    
-- tao bang 11:ExamQuestion
DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion`
    (
		ExamID				TINYINT NOT NULL,
		QuestionID			TINYINT 
     --   FOREIGN KEY (ExamID) REFERENCES `Exam`(ExamID)
	);
    
-- them du lieu vao bang Department
    INSERT INTO Department(DepartmentName)
	VALUES 	('Phòng Bảo vệ'),
			('Phòng Nhân sự'),
			('Phòng Giám Đốc'),
			('Phòng Kỹ thuật'),
			('Phòng Thư ký'),
			('Phòng Tạp vụ'),
			('Phòng Phó Giám Đốc');
            
-- them du lieu vao bang Position
INSERT INTO `Position`(PositionName)
VALUES ('Dev 1'),
       ('Dev 2'),
       ('Giám đốc'),
       ('Tester'),
       ('PM'),
       ('Mentor'),
       ('Developer'),
       ('Scrum Master');
       
-- them du lieu vao bang Account
INSERT INTO `Account`(Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
VALUES ('email_vti1@gmail.com', 'acountvti1', 'Nguyễn Văn A', 4, 1, NOW()),
       ('email_vti2@gmail.com', 'acountvti2', 'Trinh Hoai Lam', 2, 1, '2021-02-26'),
       ('email_vti3@gmail.com', 'acountvti3', 'Nguyễn Thu Hoai', 4, 2, '2021-01-01'),
       ('email4@gmail.com', 'acountvti4', 'Trương Văn Bình', 2, 5, '2021-06-30'),
       ('email_vti5@gmail.com', 'acountvti5', 'Dương Chi Tai', 3, 3, '2021-01-01'),
       ('email6@gmail.com', 'acountvti6', 'Nguyễn Thế Hải', 9, 3, '2021-01-02'),
       ('email7@gmail.com', 'acountvti7', 'Dương Chí Dũng', 7, 1, NOW()),
       ('email8@gmail.com', 'acountvti8', 'Cao Hữu Đạt', 4, 2, NOW()),
       ('email9@gmail.com', 'acountvti9', 'Nguyễn văn B', 4, 4, '2021-05-01'),
       ('email10@gmail.com', 'acountvti10', 'Mai Anh Tài', 3, 5, '2021-06-06');
       
-- them du lieu vao bang Group
INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES ('Testing System', 1, '2019-03-05'),
       ('Development', 9, '2020-03-07'),
       ('VTI Sale 01', 2, '2020-03-09'),
       ('VTI Sale 02', 9, '2020-03-10'),
       ('VTI Development', 3, '2021-01-10'),
       ('VTI Sale 05', 1, '2021-03-10'),
       ('VTI Sale 03', 9, '2020-03-28'),
       ('VTI Creator', 6, '2020-04-06'),
       ('VTI Marketing 01', 5, '2020-04-07'),
       ('Management', 5, '2020-04-08'),
       ('Chat with love', 1, '2020-04-09'),
       ('Vi Ti Ai', 10, '2020-04-10');
       
-- them du lieu vao bang GroupAccount
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate)
VALUES (1, 1, '2019-03-05'),
       (1, 2, '2020-03-07'),
       (1, 10, '2020-03-07'),
       (1, 8, '2020-03-07'),
       (3, 3, '2020-03-09'),
       (3, 4, '2020-03-10'),
       (5, 5, '2020-03-28'),
       (1, 3, '2020-04-06'),
       (1, 9, NOW()),
       (8, 3, NOW()),
       (1, 7, '2020-04-09'),
       (10, 10, '2020-04-10');
       
-- them du lieu vao bang TypeQuestion
INSERT INTO TypeQuestion (TypeName)
VALUES ('Essay'),
       ('Multiple-Choice');
       
-- them du lieu vao bang CategoryQuestion
INSERT INTO CategoryQuestion (CategoryName)
VALUES ('Java'),
       ('ASP.NET'),
       ('ADO.NET'),
       ('SQL'),
       ('Postman'),
       ('Ruby'),
       ('Python'),
       ('C++'),
       ('C Sharp'),
       ('PHP');

-- them du lieu vao bang Question
INSERT INTO `Question` (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES (N'Câu hỏi về Java', 1, '1', '2', '2020-04-05'),
       (N'Câu Hỏi về PHP', 10, '2', '2', '2020-04-05'),
       (N'Hỏi về C#', 9, '2', '3', '2020-04-06'),
       (N'Hỏi về Ruby', 6, '1', '4', '2020-04-06'),
       (N'Hỏi về Postman', 5, '1', '5', '2020-04-06'),
       (N'Hỏi về ADO.NET', 3, '2', '6', '2020-04-06'),
       (N'Hỏi về ASP.NET', 2, '1', '7', '2020-04-06'),
       (N'Hỏi về C++', 8, '1', '8', '2020-04-07'),
       (N'Hỏi về SQL', 4, '2', '9', '2021-06-07'),
       (N'Hỏi về Python', 7, '1', '10', now());
       
-- them du lieu vao bang Answer
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES (N'Trả lời 01', 1, 0),
       (N'Trả lời 02', 1, 1),
       (N'Trả lời 03', 1, 0),
       (N'Trả lời 04', 1, 1),
       (N'Trả lời 05', 2, 1),
       (N'Trả lời 06', 3, 1),
       (N'Trả lời 07', 4, 0),
       (N'Trả lời 08', 8, 0),
       (N'Trả lời 09', 9, 1),
       ('Trả lời 10', 10, 1),
       ('Trả lời 11', 2, 0),
       ('Trả lời 12', 2, 0),
       ('Trả lời 13', 2, 1),
       ('Trả lời 14', 3, 1),
       ('Trả lời 15', 3, 1);
       
-- them du lieu vao bang Exam
INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES ('VTIQ001', N'Đề thi C#', 1, 60, '5', '2019-04-05'),
       ('VTIQ002', N'Đề thi PHP', 10, 60, '2', '2019-04-05'),
       ('VTIQ003', N'Đề thi C++', 9, 120, '2', '2019-04-07'),
       ('VTIQ004', N'Đề thi Java', 6, 60, '3', '2020-04-08'),
       ('VTIQ005', N'Đề thi Ruby', 5, 120, '4', '2020-04-10'),
       ('VTIQ006', N'Đề thi Postman', 3, 60, '6', '2020-04-05'),
       ('VTIQ007', N'Đề thi SQL', 2, 60, '7', '2020-04-05'),
       ('VTIQ008', N'Đề thi Python', 8, 60, '8', '2020-04-07'),
       ('VTIQ009', N'Đề thi ADO.NET', 4, 90, '9', '2017-04-07'),
       ('VTIQ010', N'Đề thi ASP.NET', 7, 90, '10', '2020-04-08');
       
-- them du lieu vao bang ExamQuestion
INSERT INTO ExamQuestion(ExamID, QuestionID)
VALUES (1, 5),
       (2, 10),
       (3, 4),
       (4, 3),
       (5, 7),
       (6, 10),
       (7, 2),
       (8, 10),
       (9, 9),
       (10, 8);
       
       
       
-- Question 1:
drop trigger if exists `bang1`;
delimiter $$
create trigger `bang1`
before insert on `group`
for each row
begin
    if new.createdate < subdate(now(), INTERVAL 1 year) then
    signal sqlstate '12345' 
    set message_text = 'không nhập vào được';
    end if;
end$$
delimiter ;

-- test Q1
insert into `group`(groupname, creatorid, createdate)
values             ('assad'  ,'12'       , '2020-7-6'),
				   ('acc'    , '13'      , '2020-7-11');
                   
                   
-- Question 2:
drop trigger if exists `bang2`;
delimiter $$
create trigger `bang2`
before insert on `account`
for each row
begin
    if new.departmentid = 2 then
    signal sqlstate '12345'
    set message_text = 'Department "Sale" cannot add more user';
    end if;
end$$
delimiter ;

-- test Q2
INSERT INTO `Account`(Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
values                ('vti123','tah','TAH', 2, 3, now());

begin work;
rollback;
select * from `account`;

-- Question 3:
drop trigger if exists `bang3`;
delimiter $$
create trigger `bang3`
before insert on groupaccount
for each row
begin
	declare _number tinyint;
    select count(accountid) into _number from groupaccount where new.groupid = groupid group by groupid;
    if _number > 5 then
    signal sqlstate '12345'
    set message_text = 'toi da 5 user';
    end if;
end$$
delimiter ;

-- test Q3:
insert into groupaccount
values	(1,3, now());

-- Question 4:
drop trigger if EXISTS `bang4`;
delimiter $$
create trigger `bang4`
before insert on examquestion
for each row 
begin
	declare _number tinyint;
    select count(examid) into _number from examquestion where new.examid = examid GROUP BY questionid;
    if _number > 10 then
    signal SQLSTATE '12345'
    set MESSAGE_TEXT = 'toi da 10 cau hoi';
    end if;
end $$
delimiter ;

-- Question 5:
drop trigger if exists `bang5`;
delimiter $$
create trigger `bang5`
before delete on `account`
for each row
begin 
	if old.email = 'admin@gmail.com' then 
    signal sqlstate '12345'
    set message_text = 'day la tai khoan admin, khong duoc phep xoa!!!';
    end if;
    delete from `account` where old.accountid = accountid;
end$$
delimiter ;


-- Question 6:
drop trigger if exists `bang6`;
delimiter $$
create trigger `bang6`
before insert on `account`
for each row
begin
	if new.departmentid is null then 
    set new.departmentid = (select departmentid
							from department
                            where departmentname = 'waiting Department');
    end if;
end$$
delimiter ;

-- Question 7:                         
drop trigger if exists `bang7`;
delimiter $$
create trigger `bang7`
before insert on `answer`
for each row
begin
	DECLARE number_answer tinyint;
    declare number_tf tinyint;
	select count(answerid) into number_answer  from answer where new.questionid = questionid and new.iscorrect = iscorrect   group by questionid; 
    select count(iscorrect) into number_tf from answer where iscorrect = 1 and new.questionid = questionid   group by questionid ;
    if number_answer >= 4 or number_tf >= 2 then
    signal SQLSTATE '12345'
    set MESSAGE_TEXT = 'toi da 4 cau tl va 2 dap an dung';
    end if;
end$$
delimiter ; 

insert into answer 
values   ( '16','tl1', 2, 1);

begin work;
rollback;
select * from answer;

-- Question 8:           
drop trigger if exists `bang8`;
delimiter $$
create trigger `bang8`
before insert on `account`
for each row 
begin
if new.gender = 'nam' then
set gender = 'M';
elseif new.gender = 'nu' then
set gender = 'F';
elseif new.gender = 'chua xac dinh' then
set gender = 'U';
end if;
end$$
delimiter ;

-- them cot 'gender' cho bang `account`
alter table `account` add column `gender` varchar(10);

-- test Q8
insert into `account`
values ('11', 'vti@gmail.com','vti','TAH', '2', '3', now(), 'nam');

select * from `account`;

-- Question 9:
drop trigger if exists `bang9`;
delimiter $$
create trigger `bang9`
before delete on `account`
for each row
begin
	if createdate <= subdate(now(), interval 2 day) then
    signal SQLSTATE '12345'
    set MESSAGE_TEXT = 'khong duoc phep xoa';
    end if;
end$$
delimiter ;

-- Question 10:              CHUA XONG NE!!!!!!!!!!!1

-- UPDATE
drop trigger if exists `bang10`;
delimiter $$
create trigger `bang10`
before update on question
for each row 
begin 
	declare _number tinyint unsigned;
    select count(examid) into _number
    from examquestion
    right join question using(questionid)  
    where new.questionid = questionid
    group by questionid;
    if _number > 0 then
    signal sqlstate '46000'
    set message_text = 'chi duoc update question khong co trong exam nao';
    end if;
end$$
delimiter ;

-- test update:
update question set content = 'lcb' where questionid = 10;
begin work;
rollback;
select * from question;

-- DELETE
drop trigger if exists `bang10`;
delimiter $$
create trigger `bang10`
before delete on question
for each row 
begin 
	declare _number tinyint unsigned;
    select count(examid) into _number
    from examquestion
    right join question using(questionid)  
    where old.questionid = questionid
    group by questionid;
    if _number > 0 then
    signal sqlstate '46000'
    set message_text = 'chi duoc xoa question khong co trong exam nao';
    end if;
end$$
delimiter ;

-- test DELETE:
delete from question where questionid = 1;
begin work;
rollback;
select * from question;

-- Question 12:
select *, case when duration <= 30 then 'short time' 
 when 30 < duration and duration <= 60 then 'Medium time' 
else 'longtime' end as 'kieu' 
from exam;
 
-- Question 13:
select `group`.`groupid`, count(accountid) as so_account, case when 
count(accountid) <= 5 then 'few' 
when count(accountid) <= 20 and count(accountid) > 5 then 'normal' 
else 'higher' end as 'the_number_user_amount' 

from groupaccount
right join `group` using(groupid)  
group by groupid;

-- Question 14:
select `department`.`departmentid`, `department`.`departmentname`, case when count(accountid) = 0 then 'khong co user' else count(accountid) end as 'so luong user' 
from account
right join department using(departmentid) 
group by departmentid






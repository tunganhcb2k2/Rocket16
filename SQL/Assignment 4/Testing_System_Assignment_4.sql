DROP DATABASE IF EXISTS `Testing_System_Assignment_4`;
CREATE DATABASE `Testing_System_Assignment_4`;
USE `Testing_System_Assignment_4`;

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
    DepartmentID			TINYINT NOT NULL,
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
    CreatorID				TINYINT NOT NULL UNIQUE KEY,
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
    TypeID					TINYINT NOT NULL,
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
        Code				TINYINT NOT NULL UNIQUE KEY,
        Title				NVARCHAR(30) NOT NULL,
        CategoryID			TINYINT NOT NULL UNIQUE KEY,
        Duration			TINYINT NOT NULL,
        CreatorID			TINYINT NOT NULL UNIQUE KEY,
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
Insert into `Department` (DepartmentID, DepartmentName)
value				   ('1'          , N'Marketing'   ),
					   ('2'		     , N'Sale'        ),
					   ('3'          , N'Bảo vệ'      ),
					   ('4'          , N'Nhân sự'     ),
					   ('5'          , N'Kỹ thuật'    ),
					   ('6'          , N'Tài chính'   ),
					   ('7'          , N'Phó giám đốc'),
					   ('8'          , N'Giám đốc'    ),
					   ('9'          , N'Thư kí'      ),
					   ('10'         , N'Bán hàng'    );

-- them du lieu vao bang Position
Insert into `Position` (PositionID, PositionName)
Value				 ('1'         , N'Dev'      ),
					 ('2'         , N'Test'     ),
                     ('3'         , N'Scrum Master'),
                     ('4'         , N'PM'       ),
                     ('5'         , N'chuc vu 1'),
                     ('6'         , N'chuc vu 2'),
                     ('7'         , N'chuc vu 3'),
                     ('8'         , N'chuc vu 4'),
                     ('9'         , N'chuc vu 5'),
                     ('10'        , N'chuc vu 6');
                     
-- them du lieu vao bang Account
Insert into `Account` (AccountID, Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
Value 				('1'        , 'account1cb@gmail.com', 'khabanh', 'Nguyen Van A', '6', '1', '2021-6-29'),
					('2'        , 'vti1cb@gmail.com', 'huanhoahong', 'Phung Thi Lanh', '6', '2', '2021-6-29'),
                    ('3'        , 'accountprocb@gmail.com', 'tienbip', 'Phung The Hoang', '6', '6', '2021-6-28'),
                    ('4'        , 'itvippro@gmail.com', 'joinwick', 'Cao My Vi', '6', '3', '2021-5-10'),
                    ('5'        , 'account2@gmail.com', 'siusao', 'Hua Minh Hoang', '2', '5', '2021-5-20'),
                    ('6'        , 'vtiaccademy@gmail.com', 'totnghiep', 'Le Duc Hanh', '1', '4', '2021-5-30'),
                    ('7'        , 'nonstop@gmail.com', 'dinhcuachop', 'Ma Thai Bao', '8', '3', '2021-6-29'),
                    ('8'        , 'siublack@gmail.com', 'proqua', 'Vu Son Tung', '7', '4', '2020-12-20'),
                    ('9'        , 'tunghoang@gmail.com', 'Thor', 'Hoang The Tung', '9', '4', '2020-12-20'),
                    ('10'       , 'viplam@gmail.com', 'haizz', 'Cao Thai Son', '10', '4', '2020-12-19');

-- them du lieu vao bang Group
Insert into `Group` (GroupID, GroupName, CreatorID, CreateDate)
Value			    ('1'      , N'VTI01', '1', '2021-6-10'),
				    ('2'      , N'VTI02', '2', '2021-6-9'),
                    ('3'      , N'VTI03', '3', '2021-6-9'),
                    ('4'      , N'VTI04', '4', '2021-6-8'),
                    ('5'      , N'VTI05', '5', '2021-6-10'),
                    ('6'      , N'VTI06', '6', '2021-6-9'),
                    ('7'      , N'VTI07', '7', '2021-6-7'),
                    ('8'      , N'VTI08', '8', '2021-6-8'),
                    ('9'      , N'VTI09', '9', '2021-6-10'),
                    ('10'     , N'VTI10', '10', '2021-6-7'),
                    ('11'     , N'VTI11',  '11', '2021-6-8');
                                    
-- them du lieu vao bang GroupAccount
Insert into `GroupAccount` (GroupID, AccountID, JoinDate)
value					   ('1', '10', '2021-6-11'),
						   ('2', '10', '2021-6-10'),
                           ('3', '10', '2021-6-10'),
                           ('4', '10', '2021-6-9'),
                           ('5', '10', '2021-6-11'),
                           ('6', '10', '2021-6-10'),
                           ('7', '10', '2021-6-10'),
                           ('8', '6', '2021-6-10'),
                           ('9', '3' , '2021-6-10'),
                           ('10', '8', '2021-6-10');
			
-- them du lieu vao bang TypeQuestion
Insert into `TypeQuestion` (TypeID, TypeName)
value					   ('1', 'Essay'),
						   ('2', 'Multiple-Choice'),
                           ('3', 'TP1'),
                           ('4', 'TP2'),
                           ('5', 'TP3'),
                           ('6', 'TP4'),
                           ('7', 'TP5'),
                           ('8', 'TP6'),
                           ('9', 'TP7'),
                           ('10', 'TP8');
                           
-- them du lieu vao bang CategoryQuestion
Insert into `CategoryQuestion` (CategoryID, CategoryName)
value						   ('1', 'Java'),
							   ('2', '.NET'),
                               ('3', 'SQL'),
                               ('4', 'Postman'),
                               ('5','Ruby'),
                               ('6', 'C'),
                               ('7', 'C++'),
                               ('8', 'C#'),
                               ('9', 'Pascal'),
                               ('10', 'S');
							
-- them du lieu vao bang Question
Insert into `Question` (QuestionID, Content, CategoryID, TypeID, CreatorID, CreateDate)
Value				   ('1', 'cau hoi ve java', '1', '2', '3', '2021-6-29'),
					   ('2', 'cau hoi ve .NET', '1', '2', '1', '2021-6-29'),
                       ('3', 'cau hoi ve SQL', '3', '2', '4', '2021-6-29'),
                       ('4', 'cau hoi ve Postman', '4', '2', '5', '2021-6-29'),
                       ('5', 'cau hoi ve Ruby', '5', '1', '2', '2021-6-28'),
                       ('6', 'cau hoi ve C', '6','1', '4', '2021-6-28'),
                       ('7', 'cau hoi ve C++', '7', '4', '5', '2021-6-28'),
                       ('8', 'cau hoi ve C#', '8', '5', '6', '2021-6-28'),
                       ('9', 'cau hoi ve Pascal', '9', '6', '7', '2021-6-28'),
                       ('10', 'cau hoi ve S', '10', '7', '8', '2021-6-28'),
                       ('11', 'cau hoi 11', '6', '8', '7', '2021-6-28');
                       
-- them du lieu vao bang Answer
Insert into `Answer` (AnswerID, Content, QuestionID, isCorrect)
value			     ('1', 'tra loi 1', '1', 'yes'),
					 ('2', 'tra loi 2', '1', 'no'),
                     ('3', 'tra loi 3', '1', 'yes'),
                     ('4', 'tra loi 4', '1', 'no'),
                     ('5', 'tra loi 5', '5', 'yes'),
                     ('6', 'tra loi 6', '6', 'no'),
                     ('7', 'tra loi 7', '7', 'yes'),
                     ('8', 'tra loi 8', '8', 'no'),
                     ('9', 'tra loi 9', '9', 'yes'),
                     ('10', 'tra loi 10', '10', 'no');
                     
-- them du lieu vao bang Exam
Insert into `Exam` (ExamID, Code,Title, CategoryID, Duration, CreatorID, CreateDate)
value			   ('1', '001', 'De thi .NET', '1', '60', '1', '2021-6-30'),
				   ('2', '002', 'De thi SQL', '2', '60', '2', '2021-6-30'),
                   ('3', '003', 'De thi java', '3', '60', '3', '2021-6-30'),
                   ('4', '004', 'De thi Ruby', '4', '60', '4', '2021-6-30'),
                   ('5', '005', 'De thi Postmen', '5', '90', '5', '2021-6-30'),
                   ('6', '006', 'De thi C', '6', '60', '6', '2021-6-30'),
                   ('7', '007', 'De thi C++', '7', '60', '7', '2021-6-30'),
                   ('8', '008', 'De thi C#', '8', '60', '8', '2021-6-30'),
                   ('9', '009', 'De thi Pascal', '9', '60', '9', '2021-6-30'),
                   ('10', '010', 'De thi S', '10', '60', '10', '2018-6-30');
                   
-- them du lieu vao bang ExamQuestion.
Insert into `ExamQuestion` (ExamID, QuestionID)
value					   ('1','2'),
						   ('2','2'),
                           ('3','2'),
                           ('4','5'),
                           ('5','4'),
                           ('6','6'),
                           ('7','7'),
                           ('8','8'),
                           ('9','9'),
                           ('10','10');
                           
 --                                                                           \\ Exercise 1 //
 -- Question 1:
 select Department.DepartmentID, Department.DepartmentName , Account.Fullname
 From `Department`
 join `Account` on Department.DepartmentID = Account.DepartmentID
 order by `DepartmentID` ASC;
 
 -- Question 2:
select *
From `account`
where CreateDate > '2010-12-20';

-- Question 3:
select Position.PositionName, account.fullname 
from `Position`
join `Account` on Position.PositionID = Account.Positionid;

-- Question 4:
select Department.departmentid, Department.departmentname, count(Department.departmentid) AS 'so luong NV'
from `Department`
join `account` on Department.Departmentid = account.Departmentid
GROUP BY account.Departmentid having count(account.Departmentid) > 3 ;

-- Question 5:                                
Drop view if exists bang1;
create view bang1 as
select `questionid`, count(examid) as 'so lan xuat hien'
from `examquestion`
group by `Questionid`;

select bang1.questionid, question.content , Max(`so lan xuat hien`) as 'so lan xuat hien'
from `bang1`
join question on question.questionid = bang1.questionid;

-- Question 6:
select Categoryid, count(questionid) as 'so lan xuat hien'
From `Question`
group by categoryid ;

-- Question 7:
select QuestionID, count(examid) AS 'so lan xuat hien'
from ExamQuestion
group by questionid
order by questionid asc;

-- Question 8:                           
drop view if exists bang2;
create view bang2 as
select questionid, count(answerid) as 'so cau tra loi'
from answer
group by questionid;

select question.questionid, question.content, MAX(`so cau tra loi`) as 'so cau tra loi'
from question
join bang2 on question.questionid = bang2.questionid;

-- Question 9:               
select `groupaccount`.`groupid`, `group`.`GroupName`, count(`groupaccount`.`accountid`) as 'so luong account'
from `groupaccount`
join `group` on `groupaccount`.`groupid` = `group`.`groupid`
group by `groupaccount`.`groupid`;

-- Question 10:
drop view if exists `bang3`;
create view `bang3` as
SELECT positionid, count(accountid) as 'so nhan vien'
from `account`
group by positionid;

select `position`.`positionid`, `position`.`positionname`, `bang3`.`so nhan vien`
from bang3
join `position` on `bang3`.`positionid` = `position`.`positionid`
where `so nhan vien` <= (select min(`so nhan vien`) from bang3);

-- Question 11:
select `department`.`departmentname`, `position`.`positionname`, count(*) 'so luong'
from `account`
join position using(positionid)
join department using(departmentid)
group by `account`.`departmentid`, `account`.`positionid` having `account`.`positionid` <= 4;

-- Question 12:
select `question`.`content`, `question`.`createdate`, `categoryquestion`.`categoryname`, `typequestion`.`typename`, `account`.`fullname`, `answer`.`content`, `answer`.`iscorrect`
from `question`
join `answer` using(questionid)
join `categoryquestion` using(categoryid)
join `typequestion` using(typeid)
join `account` on `question`.`creatorid` = `account`.`accountid` ;

-- Question 13:
select `typequestion`.`typename`, count(`question`.`questionid`) as 'so luong'
from `question`
join `typequestion` using(typeid)
group by `question`.`typeid` having `question`.`typeid` <= 2;


-- Question 14 + 15:
select G.GroupID, GroupName
from `Group` G
left join GroupAccount GA on G.GroupID = GA.GroupID where AccountID is null;

-- Question 16:
select Q.questionid, Q.content
from `question` Q
left join answer using(questionid) where answerid is null
;

 --                                                                           \\ Exercise 2 //
-- Question 17:
-- a,
select A.accountid, A.username
from account A
join groupaccount GA using(accountid) where groupid = 1;
-- b,
select A.accountid, A.username
from account A
join groupaccount GA using(accountid) where groupid = 2;
-- c,
select A.accountid, A.username
from account A
join groupaccount GA using(accountid) where groupid = 1
union
select A.accountid, A.username
from account A
join groupaccount GA using(accountid) where groupid = 2;

-- Question 18:
-- a,
select G.groupid, G.groupname, count(groupid) as 'so luong thanh vien'
from groupaccount GA
join `group` G using(groupid)
group by GA.accountid having `so luong thanh vien` > 5;
-- b,
select G.groupid, G.groupname, count(groupid) as 'so luong thanh vien'
from groupaccount GA
join `group` G using(groupid)
group by GA.accountid having `so luong thanh vien` < 7;
-- c,
select G.groupid, G.groupname, count(groupid) as 'so luong thanh vien'
from groupaccount GA
join `group` G using(groupid)
group by GA.accountid having `so luong thanh vien` > 5
union
select G.groupid, G.groupname, count(groupid) as 'so luong thanh vien'
from groupaccount GA
join `group` G using(groupid)
group by GA.accountid having `so luong thanh vien` < 7;




 








 











 

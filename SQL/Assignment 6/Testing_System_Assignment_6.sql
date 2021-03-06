DROP DATABASE IF EXISTS `Testing_System_Assignment_6`;
CREATE DATABASE `Testing_System_Assignment_6`;
USE `Testing_System_Assignment_6`;

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
	VALUES 	('Ph??ng B???o v???'),
			('Ph??ng Nh??n s???'),
			('Ph??ng Gi??m ?????c'),
			('Ph??ng K??? thu???t'),
			('Ph??ng Th?? k??'),
			('Ph??ng T???p v???'),
			('Ph??ng Ph?? Gi??m ?????c');
            
-- them du lieu vao bang Position
INSERT INTO `Position`(PositionName)
VALUES ('Dev 1'),
       ('Dev 2'),
       ('Gi??m ?????c'),
       ('Tester'),
       ('PM'),
       ('Mentor'),
       ('Developer'),
       ('Scrum Master');
       
-- them du lieu vao bang Account
INSERT INTO `Account`(Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
VALUES ('email_vti1@gmail.com', 'acountvti1', 'Nguy???n V??n A', 4, 1, NOW()),
       ('email_vti2@gmail.com', 'acountvti2', 'Trinh Hoai Lam', 2, 1, '2021-02-26'),
       ('email_vti3@gmail.com', 'acountvti3', 'Nguy???n Thu Hoai', 4, 2, '2021-01-01'),
       ('email4@gmail.com', 'acountvti4', 'Tr????ng V??n B??nh', 2, 5, '2021-06-30'),
       ('email_vti5@gmail.com', 'acountvti5', 'D????ng Chi Tai', 3, 3, '2021-01-01'),
       ('email6@gmail.com', 'acountvti6', 'Nguy???n Th??? H???i', 9, 3, '2021-01-02'),
       ('email7@gmail.com', 'acountvti7', 'D????ng Ch?? D??ng', 7, 1, NOW()),
       ('email8@gmail.com', 'acountvti8', 'Cao H???u ?????t', 4, 2, NOW()),
       ('email9@gmail.com', 'acountvti9', 'Nguy???n v??n B', 4, 4, '2021-05-01'),
       ('email10@gmail.com', 'acountvti10', 'Mai Anh T??i', 3, 5, '2021-06-06');
       
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
VALUES (N'C??u h???i v??? Java', 1, '1', '2', '2020-04-05'),
       (N'C??u H???i v??? PHP', 10, '2', '2', '2020-04-05'),
       (N'H???i v??? C#', 9, '2', '3', '2020-04-06'),
       (N'H???i v??? Ruby', 6, '1', '4', '2020-04-06'),
       (N'H???i v??? Postman', 5, '1', '5', '2020-04-06'),
       (N'H???i v??? ADO.NET', 3, '2', '6', '2020-04-06'),
       (N'H???i v??? ASP.NET', 2, '1', '7', '2020-04-06'),
       (N'H???i v??? C++', 8, '1', '8', '2020-04-07'),
       (N'H???i v??? SQL', 4, '2', '9', '2021-06-07'),
       (N'H???i v??? Python', 7, '1', '10', now());
       
-- them du lieu vao bang Answer
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES (N'Tr??? l???i 01', 1, 0),
       (N'Tr??? l???i 02', 1, 1),
       (N'Tr??? l???i 03', 1, 0),
       (N'Tr??? l???i 04', 1, 1),
       (N'Tr??? l???i 05', 2, 1),
       (N'Tr??? l???i 06', 3, 1),
       (N'Tr??? l???i 07', 4, 0),
       (N'Tr??? l???i 08', 8, 0),
       (N'Tr??? l???i 09', 9, 1),
       ('Tr??? l???i 10', 10, 1),
       ('Tr??? l???i 11', 2, 0),
       ('Tr??? l???i 12', 2, 0),
       ('Tr??? l???i 13', 2, 1),
       ('Tr??? l???i 14', 3, 1),
       ('Tr??? l???i 15', 3, 1);
       
-- them du lieu vao bang Exam
INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES ('VTIQ001', N'????? thi C#', 1, 60, '5', '2019-04-05'),
       ('VTIQ002', N'????? thi PHP', 10, 60, '2', '2019-04-05'),
       ('VTIQ003', N'????? thi C++', 9, 120, '2', '2019-04-07'),
       ('VTIQ004', N'????? thi Java', 6, 60, '3', '2020-04-08'),
       ('VTIQ005', N'????? thi Ruby', 5, 120, '4', '2020-04-10'),
       ('VTIQ006', N'????? thi Postman', 3, 60, '6', '2020-04-05'),
       ('VTIQ007', N'????? thi SQL', 2, 60, '7', '2020-04-05'),
       ('VTIQ008', N'????? thi Python', 8, 60, '8', '2020-04-07'),
       ('VTIQ009', N'????? thi ADO.NET', 4, 90, '9', '2017-04-07'),
       ('VTIQ010', N'????? thi ASP.NET', 7, 90, '10', '2020-04-08');
       
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
Drop procedure if exists `bang1`;
delimiter $$
create procedure `bang1` (IN in_DepartmentName Varchar(30))
begin
		Select a.accountid, a.email, a.username, a.fullname
        from `account` a
        join department d using(departmentid)
        where d.departmentname = in_departmentname;
End$$
delimiter ;

-- Question 2:
Drop procedure if exists `bang2`;
delimiter $$
create procedure `bang2` (In in_groupname Varchar(30))
begin
		select count(`Groupaccount`.`accountid`) as 'so luong account'
        from `groupaccount` 
        join `group` using(groupid)
        where `group`.`groupname` = `in_groupname`
        group by `groupaccount`.`groupid`;
end$$
delimiter ;

-- Question 3:                   
drop procedure if exists `bang3`;
delimiter $$
create procedure `bang3` (out out_typequestion_name varchar(30))
begin
		select `typequestion`.`typename`, count(`question`.`questionid`)
		from `typequestion`
		join question using(typeid)
		where month(`question`.`createdate`) = month(now()) and year(`question`.`createdate`) = year(now())
		group by `question`.`typeid` ;
end$$
delimiter ;

-- Question 4:
drop procedure if exists `bang4`;
delimiter $$
create procedure `bang4` (out out_ID tinyint)
begin
		select `Question`.`typeid` into out_ID
        from `Question` 	
        join `typequestion` using(typeid)
        group by `Question`.`typeid` having count(`Question`.`questionid`) = (select max(`so luong`)
        from (select count(`questionid`) as 'so luong'
			from `question`
            group by `typeid` 
        )as `max` );
end$$
delimiter ;

-- Question 5:
call `bang4`(@out_id);
select @out_id;

select `typename`
from `typequestion`
where typeid = @out_id;

-- Question 6:                        
drop procedure if exists `bang6`;
delimiter $$
create procedure `bang6` (in keyword varchar(50))
begin
		select `groupid`, `groupname`
        from `group`
		where groupname like concat('%',`keyword`,'%')
        union
        select `AccountID`, `Username`
        from `account`
        where username like concat('%',`keyword`,'%');
end$$
delimiter ;

-- Question 7:                               
drop procedure if exists `bang7`;
delimiter $$
create procedure `bang7`(in fullname varchar(50), in email varchar(30))
begin
		declare username varchar(50);
		declare	position_ID tinyint;
        set username = substring_index(email, '@', 1) ;
        select positionid into position_id from position where positionname like '%dev%' limit 1;
        select 't???o th??nh c??ng';
end$$
delimiter ;

-- Question 8:                        
drop procedure if exists `bang8`;
delimiter $$
create procedure `bang8` (in in_typename varchar(30))
begin
-- khai bao bien
        declare max_length int;
        set max_length =(select max(character_length(content)) from question join typequestion using(typeid) where in_typename = typename);
 -- cau lenh       
        select `question`.`content`,`typequestion`.`typename`, character_length(content) as 'do dai cau hoi'
        from `question`
        join `typequestion` using(typeid)
        where character_length(content) = max_length and in_typename = typename
       ;
end$$
delimiter ;

-- Question 9:
drop procedure if exists `bang9`;
delimiter $$
create procedure `bang9` (in ID tinyint)
begin
		delete from exam where ID = examid; 
end$$
delimiter ;

-- back lai data
begin work;
select *
from Exam;
call `bang9`(1);
rollback;

-- Question 10:                        
drop procedure if exists `bang10`;
delimiter $$
create procedure `bang10`()
begin
		declare done tinyint DEFAULT false;
        DECLARE _number tinyint ;
        DECLARE _id tinyint UNSIGNED;
        DECLARE _date date;
		declare cur cursor for select ExamID, CreateDate from Exam;
		declare continue handler for not found set done = true;
        
        set _number = 0;
        
        open cur;
		read_loop:
        loop
        fetch cur into _id,_date;
        if done then leave read_loop;
        end if;
        if timestampdiff(year,_date,curdate()) >=3 then
        call `bang9`(_id);
        set _number = _number + 1;
        end if;
        end loop;
        close cur;
        select _number ;
end$$
delimiter ;

-- test Q10:
begin work;
call `bang10`();
rollback;
select * from exam;

-- Question 11:
drop procedure if exists `bang11`;
delimiter $$
create procedure `bang11` (in _departmentname varchar(30))
begin
		
		declare _departmentID tinyint;
    select DepartmentId
    into _departmentID
    from Department
    limit 1;

    if (_departmentID is not null) then
        delete from Department where Departmentname = _departmentname;
        update Account set DepartmentId=null where DepartmentId = _departmentID;
    end if;
end$$
delimiter ;

-- test Q11
begin work;
rollback;
select * from department;
select `account`.*, `department`.`departmentname` from account
join department using(departmentid);
call `bang11`('phong giam doc');

-- Question 12:                           

-- C1: voi ham lap loop
drop procedure if exists `bang12`;
delimiter $$
create procedure `bang12` ()
begin
		declare _month int unsigned default 1;
        declare _number int unsigned default 0;
        declare _name varchar(50);

drop table if exists `tah`;
create table `tah` 
( month char(20),
  amount tinyint unsigned default 0
);

moon_loop:
loop
	if(_month >12 or _month <1) then leave moon_loop;
    end if;
    set _name = concat('th??ng', _month);
    set _number = 0;
	select count(questionid) into _number  from question
    where year(createdate) = year(now()) and month(createdate) = _month;
    set _month = _month +1;
    insert into `tah` values(_name, _number);
end loop;
select month as 'th??ng', amount as 's??? l?????ng c??u h???i ???????c t???o' from `tah`;
end$$
delimiter ;
 
 -- c2: voi bang tam CTE
 drop procedure if exists `bang12`;
 delimiter $$
 create procedure `bang12`()
 begin
	with `cte_bangtam` as (
    select 
			month(subdate(now(), interval 12 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 11 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 10 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 9 month)) as 'month',
            year(now()) as 'year'
    union
    select
			month(subdate(now(), interval 8 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 7 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 6 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 5 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 4 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 3 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 2 month)) as 'month',
            year(now()) as 'year'
	union
    select
			month(subdate(now(), interval 1 month)) as 'month',
            year(now()) as 'year'
    )
    
	select c.`month`, c.`year`, case when count(questionid) = 0 then 'kh??ng c?? c??u h???i n??o trong th??ng' else count(questionid)  end as 'SL'
    from `cte_bangtam` c
    left join (select * from question where year(createdate) = year(now())) as `subquery` on c.`month` = month(createdate)
    group by c.`month`, c.`year`
    order by c.`month` asc
    ;
 end$$
 delimiter ;

call `bang12`()

-- Question 13:

-- C1: voi vong lap loop
drop procedure if exists `bang13`;
delimiter $$
create procedure `bang13`()
begin
	declare curr_date date;
    declare step_date date;
    declare iter int default 0;
    declare _title varchar(50);
    declare _result varchar(50);
    declare _num int;
    set curr_date = current_date();

    drop temporary table if exists result;
    create temporary table result
    (
        title  varchar(50),
        result varchar(50)
    );

    set iter = 0;
    while iter < 6
        do
            set step_date = subdate(curr_date, interval iter month);
            set _title = concat('thang ', month(step_date), ' - ', year(step_date));

            set _num = (select count(QuestionID)
                        from Question
                        where year(CreateDate) = year(curr_date)
                          and month(CreateDate) = month(step_date));


            set _result = case _num
                              when 0 then 'kh??ng c?? c??u h???i n??o trong th??ng'
                              else _num
                end;

            insert into result values (_title, _result);
            set iter = iter + 1;
        end while;

    select title as tiltle, result as result from result;
    
    
		
end $$

call `bang13`();

-- C2: voi bang tam CTE

drop procedure if exists `bang13`;
delimiter $$
create procedure `bang13`()
begin 
	with `CTE_bangtam` as (
select 
		month(subdate(now(), interval 5 month)) as 'month' ,
		year(subdate(now(), interval 5 month)) as 'year' 
 union
 select 
		month(subdate(now(),interval 4 month)) as 'month',
		year(subdate(now(), interval 4 month)) as 'year'
union
select  
		month(subdate(now(), interval 3 month)) as 'month',
		year(subdate(now(), interval 3 month)) as 'year'
union
select	
		month(subdate(now(), interval 2 month)) as 'month',
		year(subdate(now(), interval 2 month)) as 'year'
union
select	
		month(subdate(now(), interval 1 month)) as 'month',
		year(subdate(now(), interval 1 month)) as 'year'
union
select  
		month(now()) as 'month',
		year(now()) as 'year'
    )
select `C`.`month`,`c`.`year`, case when count(questionid) = 0 then 'kh??ng c?? c??u h???i n??o trong th??ng' else count(questionid) end as 'SL'
from `CTE_bangtam` C
left join(select * from question  where createdate >= subdate(now(), interval 5 month) and createdate <= now()) as `subquery` on C.month = month(createdate)
group by c.month,c.year
;
end$$
delimiter ;

call `bang13`();










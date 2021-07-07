DROP DATABASE IF EXISTS `Testing_System_Assignment_2`;
CREATE DATABASE `Testing_System_Assignment_2`;
USE `Testing_System_Assignment_2`;

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
    CreateDate				Datetime NOT NULL,
    FOREIGN KEY(DepartmentID) REFERENCES `Department` (DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position` (PositionID)
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
    AccountID				TINYINT NOT NULL UNIQUE KEY,
    JoinDate				Datetime NOT NULL,
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID)
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
    CreateDate				Datetime NOT NULL,
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion` (CategoryID),
    FOREIGN KEY(TypeID) REFERENCES `TypeQuestion` (TypeID)
);
    
-- tao bang 9:Answer
DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer`
    (
		AnswerID			TINYINT AUTO_INCREMENT PRIMARY KEY,
        Content				NVARCHAR(50) NOT NULL,
        QuestionID			TINYINT NOT NULL,
        isCorrect			VARCHAR(3) NOT NULL,
        FOREIGN KEY (QuestionID) REFERENCES `Question` (QuestionID)
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
		QuestionID			TINYINT NOT NULL,
        FOREIGN KEY (ExamID) REFERENCES `Exam`(ExamID)
	);
    
-- them du lieu vao bang Department
Insert into `Department` (DepartmentID, DepartmentName)
value				   ('1'          , N'Marketing'   ),
					   ('2'		   , N'Sale'        ),
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
                     ('4'         , N'PM'       );
                     
-- them du lieu vao bang Account
Insert into `Account` (AccountID, Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
Value 				('1'        , 'account1cb@gmail.com', 'khabanh', 'Nguyen Van A', '6', '1', '2021-6-29'),
					('2'        , 'vti1cb@gmail.com', 'huanhoahong', 'Phung Thi Lanh', '4', '2', '2021-6-29'),
                    ('3'        , 'accountprocb@gmail.com', 'tienbip', 'Phung The Hoang', '3', '4', '2021-6-28'),
                    ('4'        , 'itvippro@gmail.com', 'joinwick', 'Cao My Vi', '5', '3', '2021-5-10'),
                    ('5'        , 'account2@gmail.com', 'siusao', 'Hua Minh Hoang', '2', '1', '2021-5-20'),
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
                    ('5'      , N'VTI05', '5', '2021-6-10');
                                    
-- them du lieu vao bang GroupAccount
Insert into `GroupAccount` (GroupID, AccountID, JoinDate)
value					   ('1', '10', '2021-6-11'),
						   ('2', '4', '2021-6-10'),
                           ('3', '5', '2021-6-10'),
                           ('4', '7', '2021-6-9'),
                           ('5', '9', '2021-6-11');
			
-- them du lieu vao bang TypeQuestion
Insert into `TypeQuestion` (TypeID, TypeName)
value					   ('1', 'Essay'),
						   ('2', 'Multiple-Choice');
                           
-- them du lieu vao bang CategoryQuestion
Insert into `CategoryQuestion` (CategoryID, CategoryName)
value						   ('1', 'Java'),
							   ('2', '.NET'),
                               ('3', 'SQL'),
                               ('4', 'Postman'),
                               ('5','Ruby');
							
-- them du lieu vao bang Question
Insert into `Question` (QuestionID, Content, CategoryID, TypeID, CreatorID, CreateDate)
Value				   ('1', 'cau hoi ve java', '1', '2', '3', '2021-6-29'),
					   ('2', 'cau hoi ve .NET', '2', '2', '1', '2021-6-29'),
                       ('3', 'cau hoi ve SQL', '3', '2', '4', '2021-6-29'),
                       ('4', 'cau hoi ve Postman', '4', '2', '5', '2021-6-29'),
                       ('5', 'cau hoi ve Ruby', '5', '1', '2', '2021-6-28');
                       
-- them du lieu vao bang Answer
Insert into `Answer` (AnswerID, Content, QuestionID, isCorrect)
value			     ('1', 'tra loi 1', '1', 'yes'),
					 ('2', 'tra loi 2', '2', 'no'),
                     ('3', 'tra loi 3', '3', 'yes'),
                     ('4', 'tra loi 4', '4', 'no'),
                     ('5', 'tra loi 5', '5', 'yes');
                     
-- them du lieu vao bang Exam
Insert into `Exam` (ExamID, Code,Title, CategoryID, Duration, CreatorID, CreateDate)
value			   ('1', '001', 'De thi .NET', '1', '60', '1', '2021-6-30'),
				   ('2', '002', 'De thi SQL', '2', '60', '2', '2021-6-30'),
                   ('3', '003', 'De thi java', '3', '60', '3', '2021-6-30'),
                   ('4', '004', 'De thi Ruby', '4', '60', '4', '2021-6-30'),
                   ('5', '005', 'De thi Postmen', '5', '90', '5', '2021-6-30');
                   
-- them du lieu vao bang ExamQuestion.
Insert into `ExamQuestion` (ExamID, QuestionID)
value					   ('1','2'),
						   ('2','3'),
                           ('3','1'),
                           ('4','5'),
                           ('5','4');
                           



                       
                       
                           
                  
						
    
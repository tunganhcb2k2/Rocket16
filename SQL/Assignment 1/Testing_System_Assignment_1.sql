DROP DATABASE IF EXISTS `Testing_System_Assignment_1`;
CREATE DATABASE `Testing_System_Assignment_1`;
USE `Testing_System_Assignment_1`;

-- tao bang 1:Department
CREATE TABLE `Department`
(
	DepartmentID			INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName			NVARCHAR(50) 
);
  
-- tao bang 2:Position  
CREATE TABLE `Position` 
(
	PositionID				INT AUTO_INCREMENT PRIMARY KEY,
    PositionName			NVARCHAR(50) 
);

-- tao bang 3:Account
CREATE TABLE `Account` 
(
	AccountID				INT AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50),
    Username				VARCHAR(50),
    Fullname				NVARCHAR(50),
    DepartmentID			INT,
    PositionID				INT,
    CreateDate				Datetime
);

-- tao bang 4:Group
CREATE TABLE `Group`
(
	GroupID					INT AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50),
    CreatorID				INT,
    CreateDate				Datetime
);

-- tao bang 5:GroupAccount
CREATE TABLE `GroupAccount`
(
	GroupID					INT,
    AccountID				INT,
    JoinDate				Datetime
);

-- tao bang 6:TypeQuestion
CREATE TABLE `TypeQuestion`
(
	TypeID					INT AUTO_INCREMENT PRIMARY KEY,
    TypeName				NVARCHAR(50) 
);

-- tao bang 7:CategoryQuestion
CREATE TABLE `CategoryQuestion`
(
	CategoryID				INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName			VARCHAR(50)
);

-- tao bang 8:Question
CREATE TABLE `Question`
(
	QuestionID				INT AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50),
    CategoryID				INT,
    TypeID					INT,
    CreatorID				INT,
    CreateDate				Datetime 
);
    
    -- tao bang 9:Answer
    CREATE TABLE `Answer`
    (
		AnswerID			INT AUTO_INCREMENT PRIMARY KEY,
        Content				NVARCHAR(50),
        QuestionID			INT,
        isCorrect			VARCHAR(50) 
	);
    
    -- tao bang 10:Exam
    CREATE TABLE `Exam`
    (
		ExamID				INT AUTO_INCREMENT PRIMARY KEY,
        Code				INT,
        Title				NVARCHAR(50),
        CategoryID			INT,
        Duration			INT,
        CreatorID			INT,
        CreateDate			Datetime 
	);
    
    -- tao bang 11:ExamQuestion
    CREATE TABLE `ExamQuestion`
    (
		ExamID				INT,
		QuestionID			INT 
	);
    
    
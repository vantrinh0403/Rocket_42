drop database if exists TestingSystem_1;
create database TestingSystem_1;
use TestingSystem_1;

create table `Department` (
	DepartmentID 	bigint unsigned AUTO_INCREMENT,
    DepartmentName 	nvarchar(50),
	PRIMARY KEY (DepartmentID)
);

create table `Position` (
	PositionID 		tinyint unsigned AUTO_INCREMENT,
    PositionName 	enum('Dev', 'Test', 'Scrum Master', 'PM'),
    PRIMARY KEY (PositionID)
);

create table `Account` (
	AccountID 		bigint unsigned AUTO_INCREMENT,
    Email 			varchar(50),
    Username 		varchar(50),
    FullName 		nvarchar(50),
    DepartmentID 	bigint unsigned,
    PositionID 		tinyint unsigned,
    CreateDate 		date,
    PRIMARY KEY (AccountID)
);

create table `Group` (
	GroupID 		bigint unsigned AUTO_INCREMENT,
    GroupName 		nvarchar(50),
    CreatorID 		bigint unsigned,
    CreateDate 		date,
    PRIMARY KEY (GroupID)
);

create table `GroupAccount` (
	GroupID 		bigint unsigned,
    AccountID 		bigint unsigned,
    JoinDate 		date
);

create table `TypeQuestion` (
	TypeID 			tinyint unsigned AUTO_INCREMENT,
    TypeName 		enum('Essay', 'Multiple-Choice'),
    PRIMARY KEY (TypeID)
);

create table `CategoryQuestion` (
	CategoryID 		bigint unsigned AUTO_INCREMENT,
    CategoryName 	varchar(50),
    PRIMARY KEY (CategoryID)
);

create table `Question` (
	QuestionID 		bigint unsigned AUTO_INCREMENT,
    Content 		text,
    CategoryID 		bigint unsigned,
    TypeID 			tinyint unsigned,
    CreatorID		bigint unsigned,
    CreateDate		date,
    PRIMARY KEY (QuestionID)
);

create table `Answer` (
	AnserID 		bigint unsigned AUTO_INCREMENT,
    Content			text,
    QuestionID 		bigint unsigned,
    isCorrect		varchar(50),
    PRIMARY KEY (AnserID)
);

create table `Exam` (
	ExamID			int unsigned AUTO_INCREMENT,
    `Code`			varchar(10),
    Title			nvarchar(50),
    CategoryID		bigint unsigned,
    Duration		int,
    CreatorID		bigint unsigned,
    CrateDate		date,
	PRIMARY KEY (ExamID)
);

create table `ExemQuestion` (
	ExamID			bigint unsigned,
    QuestionID		bigint unsigned
);















































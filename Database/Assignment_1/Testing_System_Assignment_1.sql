drop database if exists TestingSystem_2;
create database TestingSystem_2;

use TestingSystem_2;

--  bảng phòng ban
create table `Department` (
	id 					bigint not null AUTO_INCREMENT,
    department_name 	nvarchar(50) not null,
	PRIMARY KEY (id)
);

--  bảng chức vụ 
create table `Position` (
	id 					tinyint not null AUTO_INCREMENT,
    position_name 		enum('Dev', 'Test', 'Scrum Master', 'PM'),
    PRIMARY KEY (id)
);

--  bảng tài khoản 
create table `Account` (
	id 					bigint not null AUTO_INCREMENT,
    email 				varchar(50) not null unique,
    user_name 			varchar(50) not null unique,
    full_name 			nvarchar(50) not null,
    department_id 		bigint not null,
    position_id 		tinyint not null,
    create_date 		timestamp not null default CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES Department(id),
	FOREIGN KEY (position_id) REFERENCES `Position`(id)
);

--  bảng nhóm 
create table `Group` (
	id 					bigint not null AUTO_INCREMENT,
    group_name 			nvarchar(50) not null,
    creator_id 			bigint not null,
    create_date 		timestamp not null default CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    foreign key (creator_id) references `Account`(id)
);

create table `GroupAccount` (
	group_id 			bigint not null,
    account_id 			bigint not null,
    join_date 			timestamp not null default CURRENT_TIMESTAMP,
    FOREIGN KEY (group_id) REFERENCES `Group`(id),
	FOREIGN KEY (account_id) REFERENCES `Account`(id)
);

-- loại câu hỏi
create table `TypeQuestion` (
	id 					tinyint not null AUTO_INCREMENT,
    type_name 			enum('Essay', 'Multiple-Choice'),
    PRIMARY KEY (id)
);

-- chủ đề câu hỏi
create table `CategoryQuestion` (
	id 					bigint not null AUTO_INCREMENT,
    category_name 		varchar(50),
    PRIMARY KEY (id)
);

-- câu hỏi
create table `Question` (
	id 					bigint not null AUTO_INCREMENT,
    content 			text not null,
    category_id			bigint not null,
    type_id				tinyint not null,
    creator_id			bigint not null,
    create_date			timestamp not null default CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES `CategoryQuestion`(id),
	FOREIGN KEY (type_id) REFERENCES `TypeQuestion`(id),
    FOREIGN KEY (creator_id) REFERENCES `Account`(id)
);

create table `Answer` (
	id 				bigint not null AUTO_INCREMENT,
    content			text not null,
    question_id		bigint not null,
    is_correct		varchar(50) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES `Question`(id)
);

create table `Exam` (
	id				bigint not null AUTO_INCREMENT,
    `code`			varchar(10) not null,
    title			nvarchar(50) not null,
    category_id		bigint not null,
    duration		int,
    creator_id		bigint not null,
    create_date		timestamp not null default CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES `CategoryQuestion`(id),
    FOREIGN KEY (creator_id) REFERENCES `Account`(id)
);

create table `ExamQuestion` (
	exam_id			bigint not null,
    question_id		bigint not null,
    FOREIGN KEY (exam_id) REFERENCES `Exam`(id),
    FOREIGN KEY (question_id) REFERENCES `Question`(id)
);

-- insert data in Department
insert into Deparment(department_name) 
	values('Marketing'), ('Sale'), ('Bảo vệ'), ('Nhân sự'), ('Kỷ thuật'), ('Tài chính'), ('Giám đốc'), ('Phó giám đốc'), ('Bán hàng');
    
-- insert data in Position
insert into `Position`(position_name) 
	values('Dev'), ('Test'), ('Scrum Master'), ('PM');

-- insert data in Account
insert into `Account`(email, user_name, full_name, department_id, position_id) 
	values('tom@gmail', 'tom123', 'Tom Hiddleston', 6, 8), 
		('angelina@gmail', 'angelina123', 'Angelina Jolie', 1, 6), 
		('chris@gmail', 'chris123', 'Chris Hemsworth', 4, 5), 
		('scarlett@gmail', 'scarlett123', 'Scarlett Johansson', 9, 8),
        ('anne@gmail', 'anne456', 'Anne Hathaway', 2, 5),
        ('willsmith@gmail', 'willsmith', 'Will Smith', 5, 5),
        ('johnny@gmail', 'johnny123', 'Johnny Depp', 3, 7);

-- insert data in Group
insert into `Group`(group_name, creator_id) 
	values('Group 1', 13), 
    ('Group 2', 8), 
    ('Group 3', 14), 
    ('Group 4', 11),
    ('Group 5', 10);

-- insert data in GroupAccount
insert into `GroupAccount`(group_id, account_id) 
	values(1, 11), 
    (2, 12), 
    (3, 9), 
    (4, 8),
    (5, 13);

-- insert data in TypeQuestion
insert into `TypeQuestion`(type_name) 
	values('Essay'), 
    ('Essay'), 
    ('Essay'), 
    ('Multiple-Choice'),
    ('Multiple-Choice');
    
-- insert data in CategoryQuestion
insert into `CategoryQuestion`(category_name) 
	values('Java'), 
    ('.NET'), 
    ('PHP'), 
    ('React'),
    ('SQL'),
    ('Postman'),
    ('Ruby');
    
-- insert data in Question
insert into `Question`(content, category_id, type_id, creator_id) 
	values('1. Đâu không phải là một kiểu dữ liệu nguyên thủy trong Java? A. double	B. int	C. long	 D. long float', 1, 2, 10), 
    ('2. Câu lệnh SQL nào được dùng để trích xuất dữ liệu từ database? A. Get  B. Open  C. Extract  D. Select', 5, 2, 12), 
    ('3. Để khai báo một phần tử điều khiển khi nhấn vào sẽ gửi thông tin của form đi ta sử dụng thẻ: A. <input type= "text"> 
 		B. <input type = "submit" 
 		C. <input type="password" 
 		D. <input type ="reset"', 4, 2, 10), 
    ('4. Checked Exception là gì?', 1, 1, 12),
    ('5. OOP là gì?', 3, 1, 10);
    
-- insert data in Answer
insert into `Answer`(content, question_id, is_correct) 
	values('A. double	B. int	C. long	 D. long float', 1, 'D'), 
    ('A. Get  B. Open  C. Extract  D. Select', 2, 'D'), 
    ('A. <input type= "text"> 
		B. <input type = "submit" 
		C. <input type="password" 
		D. <input type ="reset"', 3, 'B'), 
    ('Checked Exception trong Java là các loại exception mà trình biên dịch yêu cầu lập trình viên phải xử lý hoặc khai báo bên trong khối mã, để đảm bảo việc xử lý exception được quyết định rõ ràng. Khi sử dụng các phương thức hoặc khối mã ném ra Checked Exception, lập trình viên buộc phải sử dụng khối try-catch hoặc khai báo sử dụng từ khóa throws để xử lý ngoại lệ này.', 4, 'true'),
    ('OOP (viết tắt của Object Orient Programming) . Lập trình hướng đối tượng là một phương pháp lập trình dựa trên khái niệm về lớp và đối tượng. OOP tập trung vào các đối tượng thao tác chúng hơn là logic để thao tác chúng.', 5, 'true');

-- insert data in Exam
insert into `Exam`(`code`, title, category_id, duration, creator_id) 
	values('MD01', 'Kiem tra dot 1', 1, 60, 10), 
    ('MD02', 'Kiem tra dot 2', 1, 60, 10), 
    ('MD03', 'Kiem tra dot 3', 1, 60, 10), 
    ('MD04', 'Kiem tra dot 4', 1, 60, 10),
    ('MD05', 'Kiem tra dot 5', 1, 60, 10);

-- insert data in ExamQuestion
insert into `ExamQuestion`(exam_id, question_id) 
	values(1, 1), 
    (1, 4), 
    (5, 2), 
    (4, 3),
    (3, 5);


alter table Account 
add gender enum('MALE', 'FEMALE', 'UNKNOWN') default 'MALE';

alter table Account 
add salary int default 0;






















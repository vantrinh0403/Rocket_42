use TestingSystem_2;

-- Question 1: Thêm ít nhất 10 record vào mỗi table

-- insert data in Department
insert into Department(department_name) 
	values('Sản xuất'), ('Quản lý'), ('Chăm sóc khách hàng');
    
-- insert data in Position
ALTER TABLE `Position` CHANGE `position_name` `position_name`
enum('Dev','Test','Scrum Master','PM', 'Giám đốc', 'Phó giám đốc', 'UX', 'BA', 'Dev-op') NOT NULL;
insert into `Position`(position_name) 
	values('Giám đốc'), ('Phó giám đốc'), ('UX'), ('BA'), ('Dev-op');

-- insert data in Account
insert into `Account`(email, user_name, full_name, department_id, position_id) 
	values('account1@gmail', 'account_1', 'Account 1', 6, 8), 
		('account2@gmail', 'account_2', 'Account 2', 1, 6), 
		('account3@gmail', 'account_3', 'Account 3', 4, 5), 
		('account4@gmail', 'account_4', 'Account 4', 9, 8),
        ('account5@gmail', 'account_5', 'Account 5', 2, 5),
        ('account6@gmail', 'account_6', 'Account 6', 5, 5),
        ('account7@gmail', 'account_7', 'Account 7', 3, 7),
        ('account8@gmail', 'account_8', 'Account 8', 5, 5),
        ('account9@gmail', 'account_9', 'Account 9', 5, 5),
        ('account10gmail', 'account_10', 'Account 10', 5, 5);

-- insert data in Group
insert into `Group`(group_name, creator_id) 
	values('Group 6', 12), 
    ('Group 7', 9), 
    ('Group 8', 11), 
    ('Group 9', 18),
    ('Group 10', 10);

-- insert data in GroupAccount
insert into `GroupAccount`(group_id, account_id) 
	values(6, 24), (7, 20), (10, 9), (4, 19), (5, 21), (1, 22), (3, 18), (3, 15);

-- insert data in CategoryQuestion
insert into `CategoryQuestion`(category_name) 
	values('Python'), 
    ('Nodejs'), 
    ('HTML-CSS'), 
    ('C++');
    
-- insert data in Question
insert into `Question`(content, category_id, type_id, creator_id) 
	values('Question 6?', 6, 1, 10), 
    ('Question 7?', 8, 1, 12), 
    ('Question 8?', 9, 1, 10), 
    ('Question 9?', 11, 1, 12),
    ('Question 10?', 10, 1, 10),
    ('Question 11?', 11, 1, 22),
    ('Question 12?', 7, 1, 24),
    ('Question 13?', 8, 1, 20),
    ('Question 14?', 5, 1, 20),
    ('Question 15?', 1, 1, 17);
    
-- insert data in Answer
insert into `Answer`(content, question_id, is_correct) 
	values('Answer', 11, 'true'), 
    ('Answer', 12, 'true'), 
    ('Answer', 13, 'true'), 
    ('Answer', 14, 'true'),
    ('Answer', 15, 'true'),
    ('Answer', 16, 'true'),
    ('Answer', 17, 'true'),
    ('Answer', 18, 'true'),
    ('Answer', 19, 'true'),
    ('Answer', 20, 'true');
insert into `Answer`(content, question_id, is_correct) 
	values('Answer2', 12, 'true'), ('Answer3', 12, 'true'), ('Answer4', 12, 'true');

-- insert data in Exam
insert into `Exam`(`code`, title, category_id, duration, creator_id) 
	values('MD06', 'Kiem tra dot 6', 5, 60, 17), 
    ('MD07', 'Kiem tra dot 7', 5, 60, 20), 
    ('MD08', 'Kiem tra dot 8', 4, 60, 20), 
    ('MD09', 'Kiem tra dot 9', 4, 90, 24),
    ('MD010', 'Kiem tra dot 10', 6, 50, 10),
    ('MD011', 'Kiem tra dot 11', 2, 50, 10),
    ('MD012', 'Kiem tra dot 12', 1, 50, 22),
    ('MD013', 'Kiem tra dot 13', 1, 45, 23),
    ('MD014', 'Kiem tra dot 14', 1, 60, 19),
    ('MD015', 'Kiem tra dot 15', 4, 90, 10);

-- insert data in ExamQuestion
insert into `ExamQuestion`(exam_id, question_id) 
	values(6, 3), 
    (6, 14), 
    (6, 12), 
    (7, 2),
    (7, 15),
    (7, 18),
    (7, 4),
    (8, 1),
    (8, 11),
    (8, 19);


-- Question 2: lấy ra tất cả các phòng ban
select * from Department;

-- Question 3: lấy ra id của phòng ban "Sale"
select id from Department where department_name = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
select *, length( full_name )
from Account
where length( full_name ) = ( select max( length( full_name ) ) from Account);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 5
select *, length( full_name )
from Account
where length( full_name ) = ( select max( length( full_name ) ) from Account where department_id = 5);

-- Question 6: Lấy ra tên group đã tham gia trước ngày 2023-12-04 00:00:00
select * from `Group` where create_date < '2023-12-04 00:00:00';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
select question_id, count(*) from Answer group by question_id  having count(*) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
select `code` from Exam where duration >= 60 and create_date < '2023-12-04 00:00:00';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group` order by create_date desc limit 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
select count(*) from Account group by department_id having department_id = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
select * from Account where  full_name like 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam WHERE create_date <= '2019-12-20 00:00:00';


-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM Question WHERE content like 'câu hỏi%';

-- Question 14: Update thông tin của account có id = 24 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE Account
SET full_name = 'Nguyễn Bá Lộc', email = 'loc.nguyenba@vti.com.vn'
WHERE id = 24;

-- Question 15: update account có id = 24 sẽ thuộc group có id = 4
UPDATE GroupAccount
SET group_id = 4
WHERE account_id = 24;






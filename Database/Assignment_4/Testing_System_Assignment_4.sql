use TestingSystem_2;

#Exercise 1: Join
#Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT Account.*, Department.department_name
FROM Account
LEFT JOIN Department
ON Account.department_id = Department.id;

#Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
select * from Account where create_date > '2010-12-20 00:00:00';

#Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT Account.*, Position.position_name
FROM Account
INNER JOIN Position
ON Account.position_id = Position.id
HAVING Position.position_name = 'Dev';

#Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT Department.department_name, count(Account.id) as SLnv
FROM Account
INNER JOIN Department
ON Account.department_id = Department.id
group by department_id
HAVING count(Account.id) > 3;

#Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
select * 
from Question
left join (SELECT question_id, COUNT(*) as dem FROM ExamQuestion GROUP BY question_id) as Results
on Question.id = Results.question_id
where Results.dem = (SELECT MAX(Total) FROM (SELECT COUNT(*) AS Total FROM ExamQuestion GROUP BY question_id) AS Results);

#Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
select cq.*, count(Question.id) 
from Question 
right join CategoryQuestion as cq
on Question.category_id = cq.id
group by  cq.id;

#Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
-- select count(q.id)
-- from Question as q
-- inner join ExamQuestion as eq
-- 	on q.id = eq.question_id
-- inner join Exam as ex
-- 	on eq.exam_id = ex.id
-- group by eq.exam_id;

#Question 8: Lấy ra Question có nhiều câu trả lời nhất
select * 
from Question
left join (SELECT question_id, COUNT(id) as dem FROM Answer GROUP BY question_id) as Results
on Question.id = Results.question_id
where Results.dem = (SELECT MAX(Total) FROM (SELECT COUNT(id) AS Total FROM Answer GROUP BY question_id) AS Results2);                       
                        
                        
#Question 9: Thống kê số lượng account trong mỗi group

#Question 10: Tìm chức vụ có ít người nhất
select p.*, COALESCE(Results.dem, 0) AS dem
from Position as p
left join (SELECT position_id, COUNT(id) as dem FROM Account GROUP BY position_id) as Results
on p.id = Results.position_id
where Results.dem = (SELECT MIN(Total) FROM (SELECT COUNT(id) as Total FROM Account GROUP BY position_id) AS Results2);   

#Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
#Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
#question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
#Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
#Question 14:Lấy ra group không có account nào
#Question 15: Lấy ra group không có account nào
#Question 16: Lấy ra question không có answer nào
#Exercise 2: Union

/* Question 17:
a) Lấy các account thuộc nhóm thứ 1
b) Lấy các account thuộc nhóm thứ 2
c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
*/
/*Question 18:
a) Lấy các group có lớn hơn 5 thành viên
b) Lấy các group có nhỏ hơn 7 thành viên
c) Ghép 2 kết quả từ câu a) và câu b)
*/
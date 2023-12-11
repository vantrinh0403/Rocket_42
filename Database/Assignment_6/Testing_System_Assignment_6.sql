use TestingSystem_2;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
drop procedure if exists getAccountByDeName;
DELIMITER $$
CREATE PROCEDURE getAccountByDeName(in department_name varchar(50))
BEGIN
-- 	SELECT * FROM Account WHERE department_id in (select id from Department where department_name = department_name );
    select * from Account a
    inner join Department d
    on a.department_id = d.id
    where d.department_name = department_name;
END$$
DELIMITER ;

Call getAccountByDeName("Kỷ thuật");

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
-- solution 1: xem tất cả từng group có bao nhiêu account
drop procedure if exists getNumberAccountInGroup;
DELIMITER $$
CREATE PROCEDURE getNumberAccountInGroup()
BEGIN
	select group_id, group_name, count(account_id) as numberAccount
	from GroupAccount ga
	inner join `Group` g
	on ga.group_id = g.id
	group by group_id;
END$$
DELIMITER ;

Call getNumberAccountInGroup();

-- Solution 2: xem số account trong group khi nhập name group
drop procedure if exists getNumberAcByGrName;
DELIMITER $$
CREATE PROCEDURE getNumberAcByGrName(in in_group_name varchar(50))
BEGIN
	select count(*) numberAccount
	from GroupAccount ga
	inner join `Group` g
	on ga.group_id = g.id 
	where group_name = in_group_name;
END$$
DELIMITER ;

Set @group_name = 'Group 1';
Call getNumberAcByGrName(@group_name);

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
drop procedure if exists reportQuestionMonth;
DELIMITER $$
CREATE PROCEDURE reportQuestionMonth()
BEGIN
	select tq.*, count(q.id) numberQuestion
	from Question q
	inner join TypeQuestion tq
	on q.type_id = tq.id
	where MONTH(q.create_date) = MONTH(CURDATE())
	group by type_id;
END$$
DELIMITER ;

Call reportQuestionMonth();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
drop procedure if exists getIdMaxQuestion;
DELIMITER $$
CREATE PROCEDURE getIdMaxQuestion(out id_type bigint)
BEGIN
	select type_id into id_type
	from Question
	group by type_id
	order by count(id) desc
	limit 1;
END$$
DELIMITER ;

Call getIdMaxQuestion(@id_type);
select @id_type;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

drop procedure if exists getTypeQuestionNameById;
DELIMITER $$
CREATE PROCEDURE getTypeQuestionNameById(in id_type_question bigint)
BEGIN
	select type_name from TypeQuestion where id = id_type_question;
END$$
DELIMITER ;

Call getTypeQuestionNameById(@id_type);

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào



-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
insert into Department(department_name) 
	values('Phòng chờ');
drop procedure if exists insertAccount;
DELIMITER $$
create procedure insertAccount(in in_fullname varchar(50), in in_email varchar(50))
begin
    declare username_variable varchar(50);
    declare position_id_variable int default 5;
    declare department_id_variable int default 16; 
	declare count int default 0;
    set username_variable = SUBSTRING_INDEX(in_email, '@', 1);
    insert into `Account`(email, user_name, full_name, department_id, position_id) 
	values(in_email, username_variable, in_fullname, department_id_variable, position_id_variable);
    
    SET count = (SELECT COUNT(id) FROM Account WHERE email = in_email);
    IF count > 0 THEN 
		 SELECT 'Insert account successful !!!' AS MESSAGE;
	ELSE
        SELECT  'Insert account error' AS ERROR;
	END IF;		
end $$
DELIMITER ;

Call insertAccount('Nguyen Van Trinh', 'vantrinh123@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
drop procedure if exists maxContentTypeQuestion;
DELIMITER $$
create procedure maxContentTypeQuestion(in in_type_ques varchar(50))
begin
    IF (in_type_ques =  'Essay') THEN 	
		select * from Question
		where type_id = 1
		order by LENGTH(content) desc
		limit 1;
	ELSEIF (in_type_ques = 'Multiple-Choice') THEN
        select * from Question
		where type_id = 2
		order by LENGTH(content) desc
		limit 1;
	ELSE 
		SELECT  'Type typequestion name not correct' AS ERROR;
	END IF;		
end $$
DELIMITER ;

Call maxContentTypeQuestion('Essay');
Call maxContentTypeQuestion('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
drop procedure if exists dropExamById;
DELIMITER $$
create procedure dropExamById (in in_id_exam bigint)
begin 
	delete from Exam where id = in_id_exam;
	select CONCAT('Exam ', in_id_exam, ' delete successful!!!') as Message;
end$$
DELIMITER ; 
CALL dropExamById(16);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
-- nay

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
-- tháng")













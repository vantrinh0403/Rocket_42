use TestingSystem_2;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
create view v_account_sale as
select * from Account
    where department_id = (select id from Department where department_name = 'Sale');
    
select * from v_account_sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất  
insert into `GroupAccount`(group_id, account_id) 
	values(9, 24), (10, 24) ;
insert into `GroupAccount`(group_id, account_id) 
	values(5, 9);
-- solution 1   
create view v_account_max_group as
	select a.*,count(group_id) dem from Account a
	inner join GroupAccount ga
	on ga.account_id = a.id
	group by ga.account_id
	having dem >= ALL(select count(group_id)from GroupAccount group by account_id);

select * from v_account_max_group;

-- solution 2
select * from Account where id in (
	select account_id 
    from GroupAccount
    group by account_id 
    having count(*) = (select max(numberOfGroup) 
						from (select count(*) numberOfGroup 
								from GroupAccount 
                                group by account_id) results)
    
);

-- Solution 3 dùng CTE
WITH
maxNumberOfGroup as ( SELECT max(numberOfGroup) as numberOfGroup FROM (SELECT count(*) as numberOfGroup FROM GroupAccount GROUP BY account_id) a
), -- tìm count lớn nhất
accIds AS ( SELECT account_id FROM GroupAccount
GROUP BY account_id
HAVING count(*) = (SELECT numberOfGroup FROM maxNumberOfGroup)
) -- lấy tất cả id có count lớn nhất
SELECT * FROM Account INNER JOIN accIds ON Account.id = accIds.account_id;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi



-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
create view v_department_max_account as
	SELECT d.id, d.department_name, count(a.id) dem  FROM Account a 
	INNER JOIN Department d
	ON d.id = a.department_id
	group by d.department_name
	HAVING dem >= ALL(select count(id) from Account group by department_id);

select * from v_department_max_account;

    
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
insert into `Question`(content, category_id, type_id, creator_id) 
	values('Question 16?', 6, 1, 24);

create view v_question_by_nguyen as
	select q.* from Question q
	inner join Account a
	on q.creator_id = a.id
	where a.full_name like "%Nguyễn%";

select * from v_question_by_nguyen;

DELIMITER $$
CREATE PROCEDURE getAllAccount()
BEGIN
    SELECT * FROM Account;
END$$

DELIMITER ;

Call getAllAccount();

drop procedure if exists getUserNameById;
DELIMITER $$
CREATE PROCEDURE getUserNameById(in account_id bigint, out user_name_out nvarchar(50))
BEGIN
    SELECT user_name into user_name_out FROM Account where id = account_id;
END$$

DELIMITER ;

Call getUserNameById(9, @user_name);
select @user_name;
















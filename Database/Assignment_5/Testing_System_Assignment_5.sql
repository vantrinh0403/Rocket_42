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
    
create view v_account_max_group as
	select a.*,count(group_id) dem from Account a
	inner join GroupAccount ga
	on ga.account_id = a.id
	group by ga.account_id
	having dem >= ALL(select count(group_id)from GroupAccount group by account_id);

select * from v_account_max_group;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi



-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
create view v_department_max_account as
	SELECT d.department_name, count(a.id) dem  FROM Account a -- , count(a.id) as SLnv
	INNER JOIN Department d
	ON a.department_id = d.id
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


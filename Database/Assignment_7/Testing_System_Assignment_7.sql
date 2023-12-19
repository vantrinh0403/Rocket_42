use TestingSystem_2;


-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
-- drop trigger trigger_check_date_group;
-- DELIMITER $$
-- 	create trigger trigger_check_date_group
--     before insert
-- DELIMITER;


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"
drop trigger if exists trigger_notadd_dept;
DELIMITER $$
	create trigger trigger_notadd_dept
    before insert on `Account`
    for each row
	begin
		declare id_sale bigint;
        select id into id_sale from Department where department_name = 'Sale';
        if (new.department_id = id_sale) then
			signal sqlstate '12345'
            set message_text = 'Department "Sale" cannot add more user';
        end if;
        
    end $$
DELIMITER ;

insert into `Account`(email, user_name, full_name, department_id, position_id) 
	values('account1024@gmail', 'account1024', 'Account 1024', 2, 8);
    
insert into `Account`(email, user_name, full_name, department_id, position_id) 
	values('trinh102@gmail', 'trinh102', 'Trình 102', 5, 8);

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
drop trigger if exists trigger_group_account;
DELIMITER $$
	create trigger trigger_group_account
    before insert on `GroupAccount`
    for each row
	begin
		declare rowcount int;
        select count(*) into rowcount from GroupAccount where group_id = new.group_id;
        if (rowcount >= 5) then
			signal sqlstate '12345'
            set message_text = 'The group has enough members';
        end if;
    end $$
DELIMITER ;
insert into `GroupAccount`(group_id, account_id) 
	values(5, 24), (5, 20);
insert into `GroupAccount`(group_id, account_id) 
	values(5, 23);

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
drop trigger if exists trigger_exam_question;
DELIMITER $$
	create trigger trigger_exam_question
    before insert on `ExamQuestion`
    for each row
	begin
		declare rowcount int;
        select count(*) into rowcount from ExamQuestion where exam_id = new.exam_id;
        if (rowcount >= 10) then
			signal sqlstate '12345'
            set message_text = 'The exam has enough question';
        end if;
    end $$
DELIMITER ;

insert into `ExamQuestion`(exam_id, question_id) 
	values(7, 3), (7, 14), (7, 12), (7, 1), (7, 11), (7, 19);
    
insert into `ExamQuestion`(exam_id, question_id) 
	values(7, 13), (7, 20);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
-- Question 12: Lấy ra thông tin exam trong đó:

-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:

-- 2

-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
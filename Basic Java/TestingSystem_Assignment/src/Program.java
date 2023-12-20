import java.util.Date;

public class Program {
    public static void main(String[] args) {
        //create department
        Department department1 = new Department();
        department1.id = 1;
        department1.departmentName = "Marketing";

        Department department2 = new Department();
        department2.id = 2;
        department2.departmentName = "Sale";

        Department department3 = new Department();
        department3.id = 3;
        department3.departmentName = "Bảo vệ";

        //create position
        Position position1 = new Position();
        position1.id = 1;
        position1.positionName = "Dev";

        Position position2 = new Position();
        position2.id = 2;
        position2.positionName = "Test";

        Position position3 = new Position();
        position3.id = 3;
        position3.positionName = "Scrum Master";

        //create group
        Group group1 = new Group();
        group1.id = 1;
        group1.groupName = "Group 1";
        group1.createDate = new Date();

        Group group2 = new Group();
        group2.id = 2;
        group2.groupName = "Group 2";
        group2.createDate = new Date();

        Group group3 = new Group();
        group3.id = 3;
        group3.groupName = "Group 3";
        group3.createDate = new Date();

        //create account
        Account account1 = new Account();
        account1.id = 1;
        account1.email = "account1@gmail.com";
        account1.userName = "account1";
        account1.fullName = "Nguyen Van A";
        account1.position = position1;
        account1.department = department1;
        account1.createDate = new Date();
        Group[] groupAccount1 = {group1, group2};
        account1.groups = groupAccount1;

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "account2@gmail.com";
        account2.userName = "account2";
        account2.fullName = "Nguyen Van B";
        account2.position = position2;
        account2.department = department2;
        account2.createDate = new Date();
        Group[] groupAccount2 = {group2};
        account2.groups = groupAccount2;

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "account3@gmail.com";
        account3.userName = "account3";
        account3.fullName = "Nguyen Van C";
        account3.position = position3;
        account3.department = department3;
        account3.createDate = new Date();


        //create question
        Question question1 = new Question();
        question1.id = 1;
        question1.content = "Content question 1";
        question1.account = account1;
        question1.createDate = new Date();

        Question question2 = new Question();
        question2.id = 2;
        question2.content = "Content question 2";
        question2.account = account2;
        question2.createDate = new Date();

        Question question3 = new Question();
        question3.id = 3;
        question3.content = "Content question 3";
        question3.account = account3;
        question3.createDate = new Date();

        Question question4 = new Question();
        question4.id = 4;
        question4.content = "Content question 4";
        question4.account = account1;
        question4.createDate = new Date();

        //create typeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.typeName = Type.ESSAY;
        Question[] questionstype1 = {question1,question2};
        typeQuestion1.questions = questionstype1;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.id = 2;
        typeQuestion2.typeName = Type.MULTIPLE_CHOICE;
        Question[] questionstype2 = {question3,question4};
        typeQuestion2.questions = questionstype2;

        //create category question
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.id = 1;
        categoryQuestion1.categoryName = "Java";
        Question[] questionsCate1 = {question1, question3};

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.categoryName = ".Net";
        Question[] questionsCate2 = {question2, question4};

        //create Answer
        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.content = "Answer question 1";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.id = 2;
        answer2.content = "Answer question 2";
        answer2.question = question2;
        answer2.isCorrect = true;

        Answer answer3 = new Answer();
        answer3.id = 3;
        answer3.content = "Answer question 3";
        answer3.question = question3;
        answer3.isCorrect = true;

        //create exam
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "MC01";
        exam1.title = "Đề thi ần 1";
        exam1.categoryQuestion = categoryQuestion1;
        exam1.duration = 60;
        Question[] questionsExam1 = {question1, question3};
        exam1.questions = questionsExam1;
        exam1.account = account1;
        exam1.createDate = new Date();

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "MC02";
        exam2.title = "Đề thi lần 2";
        exam2.categoryQuestion = categoryQuestion2;
        exam2.duration = 60;
        Question[] questionsExam2 = {question2, question4};
        exam2.questions = questionsExam2;
        exam2.account = account2;
        exam2.createDate = new Date();

        System.out.println("Thông tin phòng ban 1: ");
        System.out.println("ID phòng ban 1: " + department1.id);
        System.out.println("Tên phòng ban: " + department1.departmentName);
        System.out.println("\n");

        System.out.println("Thông tin chức vụ 1: ");
        System.out.println("ID chức vụ 1: " + position1.id);
        System.out.println("Tên chức vụ: " + position1.positionName);
        System.out.println("\n");

        System.out.println("Thông tin account 1: ");
        System.out.println("ID account 1: " + account1.id);
        System.out.println("Tên đầy đủ: " + account1.fullName);
        System.out.println("Phòng ban: " + account1.department.departmentName);
        System.out.println("\n");
    }
}
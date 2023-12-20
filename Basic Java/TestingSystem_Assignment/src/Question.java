import java.util.Date;

public class Question {
    long id;
    String content;
    CategoryQuestion categoryQuestion;
    TypeQuestion typeQuestion;
    Account account;
    Date createDate;
    Exam[] exams;
}

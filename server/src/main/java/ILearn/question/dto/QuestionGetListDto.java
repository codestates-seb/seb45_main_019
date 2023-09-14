package ILearn.question.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionGetListDto {
    private Long questionNum;
    private Long questionType;
    private String question;
    private String examples;
    private String correct;
    private String translation;
}

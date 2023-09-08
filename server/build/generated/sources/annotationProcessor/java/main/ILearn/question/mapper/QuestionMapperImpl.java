package ILearn.question.mapper;

import ILearn.question.dto.QuestionGetDto;
import ILearn.question.entity.Question;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-08T10:04:05+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.20 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionGetDto entityToResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Long questionId = null;
        Long questionType = null;
        String question1 = null;
        String examples = null;
        String correct = null;
        String translation = null;

        questionId = question.getQuestionId();
        questionType = question.getQuestionType();
        question1 = question.getQuestion();
        examples = question.getExamples();
        correct = question.getCorrect();
        translation = question.getTranslation();

        Long chapterId = null;

        QuestionGetDto questionGetDto = new QuestionGetDto( chapterId, questionId, questionType, question1, examples, correct, translation );

        return questionGetDto;
    }
}

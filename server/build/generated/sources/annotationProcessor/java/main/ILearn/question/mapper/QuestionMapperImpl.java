package ILearn.question.mapper;

import ILearn.question.dto.QuestionGetDto;
import ILearn.question.entity.Question;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-11T05:56:32+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionGetDto entityToResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionGetDto questionGetDto = new QuestionGetDto();

        questionGetDto.setQuestionId( question.getQuestionId() );
        questionGetDto.setChapterNum( question.getChapterNum() );
        questionGetDto.setWordNum( question.getWordNum() );
        questionGetDto.setQuestionType( question.getQuestionType() );
        questionGetDto.setQuestion( question.getQuestion() );
        questionGetDto.setExamples( question.getExamples() );
        questionGetDto.setCorrect( question.getCorrect() );
        questionGetDto.setTranslation( question.getTranslation() );

        return questionGetDto;
    }

    @Override
    public Question toEntity(QuestionGetDto questionGetDto) {
        if ( questionGetDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionGetDto.getQuestionId() );
        question.setQuestionType( questionGetDto.getQuestionType() );
        question.setQuestion( questionGetDto.getQuestion() );
        question.setExamples( questionGetDto.getExamples() );
        question.setCorrect( questionGetDto.getCorrect() );
        question.setTranslation( questionGetDto.getTranslation() );
        question.setWordNum( questionGetDto.getWordNum() );
        question.setChapterNum( questionGetDto.getChapterNum() );

        return question;
    }
}

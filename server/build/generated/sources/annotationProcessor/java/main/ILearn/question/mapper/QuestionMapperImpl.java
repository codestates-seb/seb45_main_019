package ILearn.question.mapper;

import ILearn.question.dto.QuestionGetDto;
import ILearn.question.dto.QuestionGetListDto;
import ILearn.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T03:52:14+0900",
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
        if ( question.getQuestionNum() != null ) {
            questionGetDto.setQuestionNum( question.getQuestionNum().intValue() );
        }
        questionGetDto.setQuestionType( question.getQuestionType() );
        questionGetDto.setQuestion( question.getQuestion() );
        List<String> list = question.getExamples();
        if ( list != null ) {
            questionGetDto.setExamples( new ArrayList<String>( list ) );
        }
        questionGetDto.setCorrect( question.getCorrect() );
        questionGetDto.setTranslation( question.getTranslation() );

        return questionGetDto;
    }

    @Override
    public QuestionGetListDto entityListToResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionGetListDto questionGetListDto = new QuestionGetListDto();

        questionGetListDto.setQuestionNum( question.getQuestionNum() );
        questionGetListDto.setQuestionType( question.getQuestionType() );
        questionGetListDto.setQuestion( question.getQuestion() );
        questionGetListDto.setExamples( map( question.getExamples() ) );
        questionGetListDto.setCorrect( question.getCorrect() );
        questionGetListDto.setTranslation( question.getTranslation() );

        return questionGetListDto;
    }

    @Override
    public Question toEntity(QuestionGetDto questionGetDto) {
        if ( questionGetDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionGetDto.getQuestionId() );
        question.setQuestionNum( (long) questionGetDto.getQuestionNum() );
        question.setQuestionType( questionGetDto.getQuestionType() );
        question.setQuestion( questionGetDto.getQuestion() );
        List<String> list = questionGetDto.getExamples();
        if ( list != null ) {
            question.setExamples( new ArrayList<String>( list ) );
        }
        question.setCorrect( questionGetDto.getCorrect() );
        question.setTranslation( questionGetDto.getTranslation() );
        question.setWordNum( questionGetDto.getWordNum() );
        question.setChapterNum( questionGetDto.getChapterNum() );

        return question;
    }
}

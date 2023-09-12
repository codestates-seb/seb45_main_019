package ILearn.question.mapper;

import ILearn.question.dto.QuestionGetDto;
import ILearn.question.dto.QuestionGetListDto;
import ILearn.question.entity.Question;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.mapper.WordMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionGetDto entityToResponseDto(Question question);

    QuestionGetListDto entityListToResponseDto(Question question);

    Question toEntity(QuestionGetDto questionGetDto);
}

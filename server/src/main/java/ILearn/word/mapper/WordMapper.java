package ILearn.word.mapper;

import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WordMapper {
    WordMapper INSTANCE = Mappers.getMapper(WordMapper.class);

    WordGetDto entityToResponseDto(Word word);

    default String map(List<String> wordMeaning) {
        String result = String.join(", ", wordMeaning);
        return result;
    }
}

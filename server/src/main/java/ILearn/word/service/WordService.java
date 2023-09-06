package ILearn.word.service;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.repository.MemberRepository;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.mapper.WordMapper;
import ILearn.word.repository.WordRepository;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.Optional;

@Service
public class WordService {
    private final Validator validator;
    private final WordRepository wordRepository;

    public WordService(Validator validator, WordRepository wordRepository) {
        this.validator = validator;
        this.wordRepository = wordRepository;
    }

    public WordGetDto getWords(Long wordId) {
        Word findWord = findVerifiedWord(wordId);
        WordGetDto wordGetDto = WordMapper.INSTANCE.entityToResponseDto(findWord);

        return wordGetDto;
    }
    public Word findVerifiedWord(Long wordId) {
        Optional<Word> optionalWord = wordRepository.findById(wordId);

        if (optionalWord.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, 930, "WORD_NOT_FOUND");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalWord.get();
    }
}

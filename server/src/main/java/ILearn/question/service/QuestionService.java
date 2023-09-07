package ILearn.question.service;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.entity.Question;
import ILearn.question.mapper.QuestionMapper;
import ILearn.question.repository.QuestionRepository;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.mapper.WordMapper;
import ILearn.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionGetDto getQuestions(Long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);
        QuestionGetDto questionGetDto = QuestionMapper.INSTANCE.entityToResponseDto(findQuestion);

        return questionGetDto;
    }

    public Question findVerifiedQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        if (optionalQuestion.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, 940, "QUESTION_NOT_FOUND");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalQuestion.get();
    }
}

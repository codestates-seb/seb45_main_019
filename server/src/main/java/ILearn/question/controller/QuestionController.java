package ILearn.question.controller;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.dto.QuestionGetListDto;
import ILearn.question.dto.QuestionTypeDto;
import ILearn.question.entity.Question;
import ILearn.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Slf4j
@Validated
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    // 문제 생성
//    @PostMapping("/generate-questions")
//    public ResponseEntity<?> createQuestion(@Valid @RequestBody QuestionTypeDto questionTypeDto) {
//        try {
//            List<Question> questions = questionService.generateQuestionsByWordId(questionTypeDto);
//            ApiResponse<List<Question>> response = new ApiResponse<>(true, "success", questions);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//
//        } catch (ApiResponseException ex) {
//            ApiResponse<?> response = ex.getResponse();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//    }

    // 질문 단일조회
    @GetMapping("/{questionId}")
    public ResponseEntity<ApiResponse<?>> getMember(@PathVariable @Positive Long questionId) {
        try {
            QuestionGetListDto question = questionService.getQuestion(questionId);
            ApiResponse<QuestionGetListDto> response = new ApiResponse<>(true, "success", question);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

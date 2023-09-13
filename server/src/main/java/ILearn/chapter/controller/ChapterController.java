package ILearn.chapter.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.response.ChapterResponse;
import ILearn.chapter.service.ChapterService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.dto.QuestionGetListDto;
import ILearn.question.entity.Question;
import ILearn.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learning")
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping
    public ResponseEntity<?> getChapters() {
        try {
            List<ChapterInfo> responseList = chapterService.getById();
            ApiResponse<List<ChapterInfo>> response = new ApiResponse<>(true, "success", responseList);

            return ResponseEntity.ok(response);
        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{chapterId}/{questionNum}")
    public ResponseEntity<?> getQuestion(@PathVariable("chapterId") @Positive Long chapterId, @PathVariable("questionNum") @Positive Long questionNum) {
        try {
            Question question = chapterService.getQuestionByChapterAndNum(chapterId, questionNum);
            ApiResponse<Question> response = new ApiResponse<>(true, "success", question);

            return ResponseEntity.ok(response);
        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
package ILearn.chapter.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.response.ChapterResponse;
import ILearn.chapter.service.ChapterService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.entity.Question;
import ILearn.question.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/learning")
@RequiredArgsConstructor
@Api(tags = "챕터 목록 전체 조회", description = "Chapter 관련 API")
public class ChapterController {

    private final ChapterService chapterService;
    private final QuestionService questionService;

    @GetMapping
    @ApiOperation(value = "모든 Chapter 조회", notes = "모든 Chapter 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "성공", response = ChapterInfo.class)
    })
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

//    @GetMapping("/{chapterNum}/{questionId}")
//    public ResponseEntity<?> getQuestion(@PathVariable("chapterNum") @Positive Long chapterNum, @PathVariable("questionId") @Positive Long questionId) {
//        try {
//            QuestionGetDto question = questionService.getQuestion(questionId);
//            ApiResponse<QuestionGetDto> response = new ApiResponse<>(true, "success", question);
//
//            return ResponseEntity.ok(response);
//        } catch (ApiResponseException ex) {
//            ApiResponse<?> response = ex.getResponse();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }
}
package ILearn.chapter.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.service.ChapterService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.question.entity.Question;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
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

    @ApiOperation(value = "모든 Chapter 조회", notes = "모든 Chapter 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "성공", response = ChapterInfo.class)
    })
    // 챕터목록 전체조회
    @GetMapping
    public ResponseEntity<?> getChapters() {
        try {
            List<ChapterInfo> responseList = chapterService.getById();

            ApiResponse<List<ChapterInfo>> response = new ApiResponse<>(true, "SUCCESS", responseList);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // 문제 조회
    @GetMapping("/{chapterId}/{questionNum}")
    public ResponseEntity<?> getQuestion(@PathVariable("chapterId") @Positive Long chapterId,
                                         @PathVariable("questionNum") @Positive Long questionNum) {
        try {
            Question question = chapterService.getQuestionByChapterAndNum(chapterId, questionNum);

            ApiResponse<Question> response = new ApiResponse<>(true, "SUCCESS", question);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
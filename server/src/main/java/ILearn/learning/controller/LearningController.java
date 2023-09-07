package ILearn.learning.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.global.Response.ApiResponse;
import ILearn.learning.dto.LearningDataDto;
import ILearn.learning.service.LearningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@Validated
@RequestMapping("/learning")
@Slf4j
@EnableSwagger2
@Api(tags = "Learning Controller", description = "Learning 관련 API")
public class LearningController {

    private final LearningService learningService;

    @Autowired
    public LearningController(LearningService learningService) {
        this.learningService = learningService;
    }

    @GetMapping
    @ApiOperation(value = "챕터 목록 조회", notes = "학습을 위한 챕터 목록을 조회")
    public ResponseEntity<LearningDataDto> getChapterListForLearning() {
        List<ChapterInfo> chapterList = learningService.getChapterListForLearning();
        LearningDataDto learningDataDto = new LearningDataDto(true, "success", chapterList);
        return new ResponseEntity<>(learningDataDto, HttpStatus.OK);
    }
}
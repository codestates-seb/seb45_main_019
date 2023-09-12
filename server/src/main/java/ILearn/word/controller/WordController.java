package ILearn.word.controller;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.word.dto.WordGetDto;
import ILearn.word.response.WordApiResponse;
import ILearn.word.service.WordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/words")
@Slf4j
@Validated
@RequiredArgsConstructor
@EnableSwagger2
@Api(tags = "Word Controller", description = "Word 관련 API")
public class WordController {
    private final WordService wordService;

    @GetMapping("/{word_Id}")
    @ApiOperation(value = "단어 정보조회", notes = "단어의 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "조회 성공"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "단어 정보 조회 실패"),
    })
    public ResponseEntity<WordApiResponse> getWord(@PathVariable("word_Id") @Positive Long wordId) {
        try {
            WordGetDto word = wordService.getWords(wordId);
            WordApiResponse response = new WordApiResponse(true, "success", word);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            WordApiResponse response = new WordApiResponse(false, "단어 정보 조회 실패", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

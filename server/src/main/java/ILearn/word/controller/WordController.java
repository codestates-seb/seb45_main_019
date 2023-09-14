package ILearn.word.controller;

import ILearn.global.response.ApiResponseException;
import ILearn.word.dto.WordAddDelDto;
import ILearn.word.dto.WordBookGetDto;
import ILearn.word.dto.WordGetDto;
import ILearn.word.response.WordApiResponse;
import ILearn.word.response.WordBookResponse;
import ILearn.word.service.WordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Positive;
import java.util.Map;

@RestController
@RequestMapping("/words")
@Slf4j
@Validated
@RequiredArgsConstructor
@EnableSwagger2
@Api(tags = "Word Controller", description = "Word 관련 API")
public class WordController {
    private final WordService wordService;

    @PostMapping("/members/{userId}")
    @ApiOperation(value = "유저 단어장 추가", notes = "유저가 단어장에 단어를 추가합니다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "추가 성공", response = WordAddDelDto.class)
    })
    public ResponseEntity<WordBookResponse> addWordToVocabulary(
            @PathVariable Long userId,
            @RequestBody WordAddDelDto requestBody) {
        Long wordId = requestBody.getWordId();
        WordBookResponse response = wordService.addWordToVocabulary(userId, wordId);

        // 요청이 성공하면 아래와 같이 WordApiResponse를 그대로 반환
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/members/{userId}")
    @ApiOperation(value = "유저 단어장 조회", notes = "유저가 추가한 단어를 조회 합니다")
    @ApiResponses(@ApiResponse(code = 200, message = "조회 성공", response = WordBookGetDto.class))
    public ResponseEntity<WordBookGetDto> getUserPostedWords(@PathVariable Long userId) {
        WordBookGetDto responseDto = wordService.getUserPostedWordIds(userId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

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

    @DeleteMapping("/members/{userId}")
    @ApiOperation(value = "유저 단어 삭제", notes = "유저 단어장에서 단어를 삭제합니다", response = WordBookResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "삭제 성공", response = WordBookResponse.class),
            @ApiResponse(code = 404, message = "삭제 실패", response = WordBookResponse.class)
    })
    public ResponseEntity<WordBookResponse> deleteWordFromVocabulary(
            @PathVariable Long userId,
            @RequestBody WordAddDelDto requestBody) {
        Long wordId = requestBody.getWordId();
        boolean deleted = wordService.deleteWordFromVocabulary(userId, wordId);

        if (deleted) {
            return new ResponseEntity<>(new WordBookResponse(true, "삭제 성공", null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new WordBookResponse(false, "삭제 실패", null), HttpStatus.NOT_FOUND);
        }
    }
}
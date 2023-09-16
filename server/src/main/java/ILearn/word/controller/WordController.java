package ILearn.word.controller;

import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
import ILearn.word.dto.WordAddDelDto;
import ILearn.word.dto.WordBookGetDto;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.response.WordApiResponse;
import ILearn.word.response.WordBookResponse;
import ILearn.word.service.WordService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Positive;
import java.util.List;

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
            @io.swagger.annotations.ApiResponse(code = 404, message = "등록된 단어가 없습니다."),
    })
    public ResponseEntity<?> getWord(@PathVariable("word_Id") @Positive Long wordId) {
        try {
            WordGetDto word = wordService.getWords(wordId);
            ApiResponse<WordGetDto> response = new ApiResponse<>(true, "SUCCESS", word);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @PostMapping("/members/{userId}")
    @ApiOperation(value = "유저 단어장 추가", notes = "유저가 단어장에 단어를 추가합니다")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "추가 성공")
    })
    public ResponseEntity addWordToVocabulary(@PathVariable Long userId,
                                              @RequestBody WordAddDelDto requestBody) {
        try {
            Long wordId = requestBody.getWordId();
            wordService.addWordToVocabulary(userId, wordId);

            ApiResponse<?> response = new ApiResponse<>(true, "SUCCESS", "");

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/members/{userId}")
    @ApiOperation(value = "유저 단어장 조회", notes = "유저가 추가한 단어를 조회 합니다")
    @ApiResponses(
            @io.swagger.annotations.ApiResponse(code = 200, message = "조회 성공", response = WordBookGetDto.class))
    public ResponseEntity<ApiResponse<?>> getUserPostedWords(@PathVariable Long userId) {
        try {
            List<Long> member = wordService.getUserPostedWordIds(userId);

            // 성공적인 응답 생성
             ApiResponse<?> response = new ApiResponse<>(true, "SUCCESS", member);

                return ResponseEntity.ok(response);

            } catch (ApiResponseException ex) {
                ApiResponse<?> response = ex.getResponse();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }



    @DeleteMapping("/members/{userId}")
    @ApiOperation(value = "유저 단어 삭제", notes = "유저 단어장에서 단어를 삭제합니다", response = WordBookResponse.class)
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "삭제 성공", response = WordBookResponse.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "삭제 실패", response = WordBookResponse.class)
    })
    public ResponseEntity<ApiResponse<?>> deleteWordFromVocabulary(@PathVariable Long userId,
                                                                   @RequestBody WordAddDelDto requestBody) {
        try {
            Long wordId = requestBody.getWordId();
            wordService.deleteWordFromVocabulary(userId, wordId);

            ApiResponse<?> response = new ApiResponse<>(true, "SUCCESS", "");

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}


    // = = = = = = = = = = = Swagger 적용 시 사용할 로직 = = = = = = = = = = =
//      유저 단어장 추가 로직
//    public WordBookResponse addWordToVocabulary(Long userId, Long wordId) {
//        if (userId == null) {
//            return new WordBookResponse(false, "유저가 존재하지 않습니다", null);
//        }
//
//        Member member = memberRepository.findById(userId).orElse(null);
//        Word word = wordRepository.findById(wordId).orElse(null);
//
//        if (member != null && word != null) {
//            // 사용자의 단어장에 WordId를 추가
//            if (word.getMember() == null) {
//                word.setMember(member);
//                wordRepository.save(word);
//                member.getWords().add(word);
//                memberRepository.save(member);
//            }
//
//            return new WordBookResponse(true, "success", null);
//        } else {
//            return new WordBookResponse(false, "유저가 존재하지 않습니다", null);
//        }
//    }
//
//    //유저 단어장 조회 로직
//    public WordBookGetDto getUserPostedWordIds(Long userId) {
//        if (userId == null) {
//            return new WordBookGetDto(false, "UserId is missing", null);
//        }
//
//        Member member = memberRepository.findById(userId).orElse(null);
//        if (member != null) {
//            List<Long> wordIds = wordRepository.findAllByMemberUserId(userId)
//                    .stream()
//                    .map(Word::getWordId)
//                    .collect(Collectors.toList());
//            return new WordBookGetDto(true, "success", wordIds);
//        } else {
//            // 유저가 존재하지 않는 경우 또는 POST한 단어가 없는 경우 등에 대한 처리
//            return new WordBookGetDto(false, "유저가 존재하지 않습니다", null);
//        }
//    }
//
//    //유저 단어장 삭제 로직
//    public boolean deleteWordFromVocabulary(Long userId, Long wordId) {
//        if (userId == null || wordId == null) {
//            return false; // 삭제 실패를 나타내는 값을 반환
//        }
//
//        Member member = memberRepository.findById(userId).orElse(null);
//        Word word = wordRepository.findById(wordId).orElse(null);
//
//        if (member != null && word != null) {
//            // 해당 단어가 사용자의 단어장에 속해 있는 경우 삭제
//            if (word.getMember() != null && word.getMember().getUserId().equals(userId)) {
//                word.setMember(null);
//                wordRepository.save(word);
//                member.getWords().remove(word);
//                memberRepository.save(member);
//                return true; // 삭제 성공을 나타내는 값을 반환
//            }
//        }
//
//        return false; // 삭제 실패를 나타내는 값을 반환
//    }
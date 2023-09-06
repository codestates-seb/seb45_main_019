package ILearn.word.controller;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.service.MemberService;
import ILearn.word.dto.WordGetDto;
import ILearn.word.mapper.WordMapper;
import ILearn.word.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/words")
@Slf4j
@Validated
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping("/{word_Id}")
    public ResponseEntity<ApiResponse<?>> getWord(@PathVariable("word_Id") @Positive Long wordId) {
        try {
            WordGetDto word = wordService.getWords(wordId);
            ApiResponse<WordGetDto> response = new ApiResponse<>(true, "success", word);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

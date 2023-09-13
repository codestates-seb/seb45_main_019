package ILearn.manage.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
//import ILearn.manage.service.ManageService;
import ILearn.manage.service.ManageService;
import ILearn.member.dto.MemberResponseDto;
import ILearn.word.dto.WordBookGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class ManageController {
    private ManageService manageService;

    @GetMapping("/{userId}")
    private ResponseEntity memberChapterListGet(@RequestParam @PathVariable @Positive Long userId) {
        List<ChapterInfo> chapterList = manageService.getChapterListByMemberId(userId);

        return ResponseEntity.ok(chapterList);
    }
}

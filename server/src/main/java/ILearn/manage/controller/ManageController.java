package ILearn.manage.controller;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.service.ChapterService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManagePatchDto;
import ILearn.manage.entity.Manage;
import ILearn.manage.service.ManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class ManageController {
    private final ManageService manageService;

    // 챕터 진행 상황 전체 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<?>> getChapterListByUserId(@PathVariable Long userId) {
        try {
            ManageGetDto manageData = manageService.getChapterData(userId);

            ApiResponse<ManageGetDto> response = new ApiResponse<>(true, "success", manageData);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    // 챕터 진행 상황 상세 조회
    @GetMapping("/{userId}/{chapterId}")
    public ResponseEntity<ApiResponse<?>> getChapterByUserIdAndChapterId(@PathVariable Long userId, @PathVariable Long chapterId) {
        try {
            ManageGetDto manageData = manageService.getChapterByUserIdAndChapterId(userId, chapterId);

            ApiResponse<ManageGetDto> response = new ApiResponse<>(true, "success", manageData);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//        @PatchMapping("/{userId}/{chapterId}")
//        public void saveDummyData(@PathVariable Long userId, @PathVariable Long chapterId, @RequestBody ManagePatchDto patchDto) {
//            manageService.upDateManage(userId, chapterId, patchDto);
//        }
    }


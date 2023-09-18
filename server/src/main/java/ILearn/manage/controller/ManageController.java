package ILearn.manage.controller;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManageListDto;
import ILearn.manage.dto.ManagePatchDto;
import ILearn.manage.entity.Manage;
import ILearn.manage.service.ManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class ManageController {

    private final ManageService manageService;

    // 챕터 진행 상황 전체 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<?>> getChapterListByUserId(@PathVariable Long userId) {
        try {
            List<ManageListDto> manageData = manageService.getAllChapter(userId);

            ApiResponse<List<ManageListDto>> response = new ApiResponse<>(true, "SUCCESS", manageData);

            // ChapterList 에 담아서 반환
//            ManageGetDto manageData = manageService.getAllChapter(userId);
//            ApiResponse<ManageGetDto> response = new ApiResponse<>(true, "SUCCESS", manageData);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // 챕터 진행 상황 상세 조회
    @GetMapping("/{userId}/{chapterId}")
    public ResponseEntity<ApiResponse<?>> getDetailChapterByUserId(@PathVariable Long userId,
                                                                   @PathVariable Long chapterId) {
        try {
            ManageListDto manageData = manageService.getDetailChapter(userId, chapterId);

            ApiResponse<ManageListDto> response = new ApiResponse<>(true, "SUCCESS", manageData);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // 챕터 진행 수정
    @PatchMapping("/{userId}/{chapterId}")
    public ResponseEntity<ApiResponse<?>> patchChapter(@PathVariable Long userId,
                                                       @PathVariable Long chapterId,
                                                       @RequestBody ManagePatchDto patchDto) {
        try {
            manageService.updateManage(userId, chapterId, patchDto);

            ApiResponse<?> response = new ApiResponse<>(true, "SUCCESS","");

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//    @PostMapping("/{userId}/{chapterId}")
//    public ResponseEntity<ApiResponse<?>> postChapter(@PathVariable Long userId,
//                                                       @PathVariable Long chapterId,
//                                                       @RequestBody ManagePatchDto patchDto) {
//        try {
//            manageService.createManage(userId, chapterId, patchDto);
//
//            ApiResponse<?> response = new ApiResponse<>(true, "SUCCESS","");
//
//            return ResponseEntity.ok(response);
//
//        } catch (ApiResponseException ex) {
//            ApiResponse<?> response = ex.getResponse();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }
}


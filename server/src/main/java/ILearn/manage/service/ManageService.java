package ILearn.manage.service;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManageListDto;
import ILearn.manage.entity.Manage;
import ILearn.manage.mapper.ManageMapper;
import ILearn.manage.repository.ManageRepository;
import ILearn.member.entity.Member;
import ILearn.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManageService {

    private final ChapterRepository chapterRepository;
    private final ManageRepository manageRepository;
    private final MemberRepository memberRepository;

    public ManageGetDto getManage(Long userId) {
        Manage findManage = findVerifiedManage(userId);
        ManageGetDto ManageGetDto = ManageMapper.INSTANCE.entityToResponseDto(findManage);

        return ManageGetDto;
    }

    public Manage findVerifiedManage(Long userId) {
        Optional<Manage> optionalManage = manageRepository.findById(userId);
        Manage manage = optionalManage.get();


        if (optionalManage.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, 920, "MANAGE_NOT_FOUND");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return manage;
    }

//    챕터 진행 상황 전체 조회
    public ManageGetDto getChapterData(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found for userId: " + userId));

        List<Chapter> chapters = chapterRepository.findAll();

        List<ManageListDto> chapterList = new ArrayList<>();
        for (Chapter chapter : chapters) {
            ManageListDto dto = new ManageListDto();
            dto.setChapterId(chapter.getChapterId());
            dto.setChapterStatus(chapter.isChapterStatus());
            dto.setProgress(chapter.getProgress());
            chapterList.add(dto);
        }

        ManageGetDto manageGetDto = new ManageGetDto();
        manageGetDto.setChapterList(chapterList);

        return manageGetDto;
    }

    // 챕터 진행 상황 상세 조회
    public ManageGetDto getChapterByUserIdAndChapterId(Long userId, Long chapterId) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found for userId: " + userId));

        List<Chapter> chapters = chapterRepository.findAll();

        List<ManageListDto> chapterList = new ArrayList<>();
        for (Chapter chapter : chapters) {
            ManageListDto dto = new ManageListDto();
            if (chapter.getChapterId().equals(chapterId)) {
                dto.setChapterId(chapter.getChapterId());
                dto.setChapterStatus(chapter.isChapterStatus());
                dto.setProgress(chapter.getProgress());
                chapterList.add(dto);
            }
        }

            ManageGetDto manageGetDto = new ManageGetDto();
            manageGetDto.setChapterList((chapterList));

            return manageGetDto;
        }



    // 이거 패치로 바꾸면 구현성공
    public void saveDummyData(Long userId, Long chapterId) {
        List<Chapter> chapters = chapterRepository.findAll();
        List<ManageListDto> chapterList = new ArrayList<>();

        // 여러 번 반복해서 데이터 추가
        int repeatCount = chapters.size(); // 원하는 횟수만큼 반복 설정
        for (Long i = 1L; i < repeatCount + 1; i++) {
            chapterList.add(createManageListDto(i, false, List.of(2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        }

        for (ManageListDto dto : chapterList) {
            Chapter chapter = new Chapter();
            chapter.setChapterStatus(dto.isChapterStatus());
            chapter.setProgress(List.of(2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
            chapterRepository.save(chapter);
        }
    }
    private ManageListDto createManageListDto(Long chapterId, boolean chapterStatus, List<Integer> progress) {
        ManageListDto dto = new ManageListDto();
        dto.setChapterId(chapterId);
        dto.setChapterStatus(chapterStatus);
        dto.setProgress(progress);
        return dto;
    }


//    public void saveDummyData() {
//        List<ManageListDto> chapterList = new ArrayList<>();
//        chapterList.add(createManageListDto(1L, false, List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
//        chapterList.add(createManageListDto(2L, false, List.of(5, 15, 25)));
//
//        for (ManageListDto dto : chapterList) {
//            Chapter chapter = new Chapter();
//            chapter.setChapterStatus(dto.isChapterStatus());
//            chapter.setProgress(dto.getProgress());
//            chapterRepository.save(chapter);
//        }
//    }

//      백업
//    public ManageGetDto getChapterData() {
//        List<Chapter> chapters = chapterRepository.findAll();
//        List<ManageListDto> chapterList = new ArrayList<>();
//        for (Chapter chapter : chapters) {
//            ManageListDto dto = new ManageListDto();
//            dto.setChapterId(chapter.getChapterId());
//            dto.setChapterStatus(chapter.isChapterStatus());
//            dto.setProgress(chapter.getProgress());
//            chapterList.add(dto);
//        }
//
//        ManageGetDto manageGetDto = new ManageGetDto();
//        manageGetDto.setChapterList(chapterList);
//        return manageGetDto;
//    }
}

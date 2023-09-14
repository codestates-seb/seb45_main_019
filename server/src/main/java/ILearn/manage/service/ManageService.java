package ILearn.manage.service;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManageListDto;
import ILearn.manage.dto.ManagePatchDto;
import ILearn.manage.entity.Manage;
import ILearn.manage.mapper.ManageMapper;
import ILearn.manage.repository.ManageRepository;
import ILearn.member.dto.MemberPatchDto;
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

    private final ManageRepository manageRepository;
    private final ManageMapper manageMapper;
    private final MemberRepository memberRepository;

//    public Manage findVerifiedManage(Long userId) {
//        Optional<Manage> optionalManage = manageRepository.findById(userId);
//        Manage manage = optionalManage.get();
//
//
//        if (optionalManage.isEmpty()) {
//            ApiResponse<Void> response = new ApiResponse<>(false, 920, "MANAGE_NOT_FOUND");
//            throw new ApiResponseException(response, new RuntimeException());
//        }
//        return manage;
//    }
//
//    //    챕터 진행 상황 전체 조회
//    public ManageGetDto getChapterData(Long userId) {
//        Member member = memberRepository.findById(userId)
//                .orElseThrow(() -> new EntityNotFoundException("User not found for userId: " + userId));
//
//        List<Manage> chapters = manageRepository.findAll();
//
//        List<ManageListDto> chapterList = new ArrayList<>();
//        for (Manage chapter : chapters) {
//            ManageListDto dto = new ManageListDto();
//            dto.setChapterId(chapter.getChapterId());
//            dto.setChapterStatus(chapter.isChapterStatus());
//            dto.setProgress(chapter.getProgress());
//            chapterList.add(dto);
//        }
//
//        ManageGetDto manageGetDto = new ManageGetDto();
//        manageGetDto.setChapterList(chapterList);
//
//        return manageGetDto;
//    }
//
//    // 챕터 진행 상황 상세 조회
//    public ManageGetDto getChapterByUserIdAndChapterId(Long userId, Long chapterId) {
//
//        Member member = memberRepository.findById(userId)
//                .orElseThrow(() -> new EntityNotFoundException("User not found for userId: " + userId));
//
//        List<Manage> chapters = manageRepository.findAll();
//
//        List<ManageListDto> chapterList = new ArrayList<>();
//        for (Manage chapter : chapters) {
//            ManageListDto dto = new ManageListDto();
//            if (chapter.getChapterId().equals(chapterId)) {
//                dto.setChapterId(chapter.getChapterId());
//                dto.setChapterStatus(chapter.isChapterStatus());
//                dto.setProgress(chapter.getProgress());
//                chapterList.add(dto);
//            }
//        }
//
//        ManageGetDto manageGetDto = new ManageGetDto();
//        manageGetDto.setChapterList((chapterList));
//
//        return manageGetDto;
//    }
//
//
//    // 이거 패치로 바꾸면 구현성공
//    public Manage upDateManage(Long userId, Long chapterId, ManagePatchDto patchDto) {
//
//        Manage findManage = findVerifiedManage(userId);
//
//        Optional.ofNullable(patchDto.getProgress())
//                .ifPresent(nickname -> findManage.getChapterList());
//
//        return manageRepository.save(findManage);
//    }

//    public Manage findVerifiedManage(Long userId, Long chapterId) {
//        Optional<Manage> optionalManage = manageRepository.findByMemberAndChapterId(userId, chapterId);
//        return optionalManage.orElseThrow(() -> new EntityNotFoundException("Manage not found for userId: " + userId + " and chapterId: " + chapterId));
//    }

//    public Manage findVerifiedManage(Long userId, Long chapterId) {
//        Optional<Manage> optionalManage = manageRepository.findByMemberAndChapterId(userId, chapterId);
//        return optionalManage.orElseThrow(() -> new EntityNotFoundException("Manage not found for userId: " + userId + " and chapterId: " + chapterId));
//    }
//
//    public Manage upDateManage(Long userId, Long chapterId, ManagePatchDto patchDto) {
//        // 엔티티 조회
//        Manage findManage = findVerifiedManage(userId, chapterId);
//
//        if (patchDto.getProgress() != null && patchDto.getProgress() != null) {
//            findManage.setProgress(patchDto.getProgress());
//        }
//
//        return manageRepository.save(findManage);
//    }

    public ManageGetDto getChapterData(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found for userId: " + userId));

        List<Manage> manages = manageRepository.findByMember(member);

        List<ManageListDto> chapterList = manageMapper.toManageListDtoList(manages);

        ManageGetDto manageGetDto = new ManageGetDto();
        manageGetDto.setChapterList(chapterList);

        return manageGetDto;
    }

    public ManageGetDto getChapterByUserIdAndChapterId(Long userId, Long chapterId) {
        Optional<Manage> optionalManage = manageRepository.findByManageNumAndChapterId(userId, chapterId);

        if (optionalManage.isPresent()) {
            Manage manage = optionalManage.get();
            ManageListDto chapterDto = manageMapper.toManageListDto(manage);

            ManageGetDto manageGetDto = new ManageGetDto();
            manageGetDto.setChapterList(Collections.singletonList(chapterDto));

            return manageGetDto;
        }
        return null;
    }
}
package ILearn.manage.service;

import ILearn.global.exception.GlobalException;
import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManageListDto;
import ILearn.manage.dto.ManagePatchDto;
import ILearn.manage.entity.Manage;
import ILearn.manage.mapper.ManageMapper;
import ILearn.manage.repository.ManageRepository;
import ILearn.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageService {

    private final ManageRepository manageRepository;
    private final ManageMapper manageMapper;
    private final GlobalException globalException;

    // 챕터 진행 상황 전체 조회
    public List<ManageListDto> getAllChapter(Long userId) {

        // 회원이 존재하는지에 대한 유효성검사
        Member member = globalException.findVerifiedMember(userId);

        List<Manage> manages = manageRepository.findByMember(member);
        return manageMapper.toManageListDtoList(manages);

        // ChapterList에 담아서 반환
//        List<Manage> manages = manageRepository.findByMember(member);
//        List<ManageListDto> chapterList = manageMapper.toManageListDtoList(manages);
//
//        ManageGetDto manageGetDto = new ManageGetDto();
//        manageGetDto.setChapterList(chapterList);
//
//        return manageGetDto;
    }


    // 챕터 진행 상황 상세 조회
    public ManageListDto getDetailChapter(Long userId, Long chapterId) {

        // 유저 및 유저의 챕터가 존재하는지에 대한 유효성검사
        globalException.findVerifiedMember(userId);

        Manage manage = globalException.findVerifiedUserChapter(userId, chapterId);
        return manageMapper.toManageListDto(manage);

        // ChapterList에 담아서 반환
//        Manage manage = globalException.findVerifiedUserChapter(userId, chapterId);
//
//        ManageListDto chapterDto = manageMapper.toManageListDto(manage);
//
//        ManageGetDto manageGetDto = new ManageGetDto();
//        manageGetDto.setChapterList(Collections.singletonList(chapterDto));
//
//        return manageGetDto;
    }

    // 챕터 진행 상황 수정
    public Manage updateManage(Long userId, Long chapterId, ManagePatchDto patchDto) {

        // 유저 및 유저의 챕터가 존재하는지에 대한 유효성검사
        Member member = globalException.findVerifiedMember(userId);
        Manage optionalManage = globalException.findVerifiedUserChapter(userId, chapterId);

        // point 필드 정의
        int pointToAdd = patchDto.getPoint();
        int currentPoint = member.getPoint();
        int newPoint = currentPoint + pointToAdd;

        // 필드 업데이트
        Optional.ofNullable(patchDto.getProgress())
                .ifPresent(progress -> optionalManage.setProgress(progress));
        Optional.ofNullable(patchDto.isChapterStatus())
                .ifPresent(chapterStatus -> optionalManage.setChapterStatus(chapterStatus));
        Optional.ofNullable(member.getPoint())
                .ifPresent(point -> member.setPoint(newPoint));

        // 필드 저장
        return manageRepository.save(optionalManage);
    }
}



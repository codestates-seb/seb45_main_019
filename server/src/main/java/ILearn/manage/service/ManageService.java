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

    // 챕터 진행 상황 전체 조회
    public ManageGetDto getChapterData(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found for userId: " + userId));

        List<Manage> manages = manageRepository.findByMember(member);

        List<ManageListDto> chapterList = manageMapper.toManageListDtoList(manages);

        ManageGetDto manageGetDto = new ManageGetDto();
        manageGetDto.setChapterList(chapterList);

        return manageGetDto;
    }

    // 챕터 진행 상황 상세 조회
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

    // 챕터 진행 상황 수정
    public Manage updateManage(Long userId, Long chapterId, ManagePatchDto patchDto) {

        Optional<Manage> optionalManage = manageRepository.findByManageNumAndChapterId(userId, chapterId);
        List<Integer> progress = patchDto.getProgress();
        boolean chapterStatus = patchDto.isChapterStatus();
        int pointToAdd = patchDto.getPoint();

        if (optionalManage.isPresent() && (progress != null || pointToAdd != 0)) {
            Manage manage = optionalManage.get();

            // Progress 및 ChapterStatus 업데이트
            if (progress != null) {
                manage.setProgress(progress);
            }

            if (pointToAdd != 0) {
                Member member = manage.getMember();
                int currentPoint = member.getPoint();
                int newPoint = currentPoint + pointToAdd;
                member.setPoint(newPoint);
            }

            manage.setChapterStatus(chapterStatus);

            return manageRepository.save(manage);
        }
        return null;
    }
}


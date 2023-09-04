package ILearn.member.service;

import ILearn.global.exception.DuplicateFieldException;
import ILearn.global.Response.ApiResponseException;
import ILearn.global.Response.ApiResponse;
import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberService {
    private final Validator validator;
    private final MemberRepository memberRepository;

    public MemberService(Validator validator, MemberRepository memberRepository) {
        this.validator = validator;
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Member createMember(Member member) {
        validateAndCheckDuplicate(member);

        return memberRepository.save(member);
    }

    // 회원조회
    public MemberResponseDto getMember(Long user_id) {
        Member findMember = findVerifiedMember(user_id);
        MemberResponseDto memberResponseDto = MemberMapper.INSTANCE.entityToResponseDto(findMember);

        return memberResponseDto;
    }

    // 회원수정
    public Member updateMember(Long user_id, MemberPatchDto patchDto) {

        Member findMember = findVerifiedMember(user_id);
        patchValidateAndCheckDuplicate(patchDto);

        Optional.ofNullable(patchDto.getNickname())
                .ifPresent(nickname -> findMember.setNickname(nickname));
        Optional.ofNullable(patchDto.getPassword())
                .ifPresent(password -> findMember.setPassword(password));

        return memberRepository.save(findMember);
    }

    // 회원탈퇴
    public void deleteMember(Long user_id) {
        Member findMember = findVerifiedMember(user_id);
        findMember.setMemberStatus(Member.MemberStatus.MEMBER_QUIT);
        memberRepository.save(findMember);
    }

    //////// BusinessLogic ////////

    // [회원가입] 작성 양식에 맞추지 않거나, 중복된 이메일, 아이디, 닉네임에 대한 유효성 검사
    private void validateAndCheckDuplicate(Member member) {
        // Dto의 애너테이션 유효성검사를 실행하고
        Set<ConstraintViolation<Member>> violations = validator.validate(member);

        // message 를 가져오며 ApiResponseException 에 담는 로직
        if (!violations.isEmpty()) {
            String errorMsg = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.joining(", "));

            throw new ApiResponseException(new ApiResponse<>(false, errorMsg), new RuntimeException(errorMsg));
        }
        // 중복검사 로직
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new DuplicateFieldException("이메일");
        }
        if (memberRepository.existsByUsername(member.getUsername())) {
            throw new DuplicateFieldException("아이디");
        }
        if (memberRepository.existsByNickname(member.getNickname())) {
            throw new DuplicateFieldException("닉네임");
        }
    }

    // [회원조회] 존재하지 않는 유저정보 유효성 검사
    public Member findVerifiedMember(Long user_id) {
        Optional<Member> optionalMember = memberRepository.findById(user_id);

        if (optionalMember.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, "유저가 존재하지 않습니다.");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalMember.get();
    }

    // [회원수정] 작성 양식에 맞추지 않거나, 중복된 닉네임에 대한 유효성 검사
    private void patchValidateAndCheckDuplicate(MemberPatchDto patchDto) {
        Set<ConstraintViolation<MemberPatchDto>> violations = validator.validate(patchDto);

        if (!violations.isEmpty()) {
            String errorMsg = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.joining(", "));

            throw new ApiResponseException(new ApiResponse<>(false, errorMsg), new RuntimeException(errorMsg));
        }

        if (memberRepository.existsByNickname(patchDto.getNickname())) {
            throw new DuplicateFieldException("닉네임");
        }
    }
}


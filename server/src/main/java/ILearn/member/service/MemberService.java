package ILearn.member.service;

import ILearn.global.auth.jwt.JwtTokenizer;
import ILearn.global.auth.loginDto.LoginDto;
import ILearn.global.auth.userdetails.MemberDetailsService;
import ILearn.global.auth.utils.CustomAuthorityUtils;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import ILearn.global.exception.DuplicateFieldException;
import ILearn.global.response.ApiResponseException;
import ILearn.global.response.ApiResponse;
import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberService{
    private final Validator validator;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(Validator validator, MemberRepository memberRepository,
                        PasswordEncoder passwordEncoder,
                        CustomAuthorityUtils authorityUtils){
        this.validator = validator;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;

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
    private void validateAndCheckDuplicate(Member member) throws ApiResponseException {
        // Dto의 애너테이션 유효성검사를 실행하고
        Set<ConstraintViolation<Member>> violations = validator.validate(member);

        // message 를 가져오며 ApiResponseException 에 담는 로직
        if (!violations.isEmpty()) {
            String errorMsg = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.joining(", "));

            throw new ApiResponseException(new ApiResponse<>(false, errorMsg), new RuntimeException(errorMsg));
        }
        // 추가: Password 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 추가: DB에 User Role 저장
        List<String> roles = authorityUtils.createRoles(member.getUsername());
        member.setRoles(roles);
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
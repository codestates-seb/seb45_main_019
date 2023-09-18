package ILearn.member.service;

import ILearn.global.auth.utils.CustomAuthorityUtils;
import ILearn.global.exception.GlobalException;
import ILearn.global.init.MemberInitialization;
import ILearn.member.dto.MemberPostResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;
    private final MemberInitialization memberInitialization;
    private final GlobalException globalException;


    // 회원가입
    public Member createMember(Member member) {

        // 입력데이터에 대한 유효성검사
        globalException.checkForValidate(member);

        // password 암호화 및 Roles 저장
        encryptPasswordAndSetRoles(member);

        memberRepository.save(member);

        // 회원가입 시 userId에 해당하는 manage항목 생성
        memberInitialization.initializeData(member);

        return member;
    }

    // 회원조회
    public MemberPostResponseDto getMemberId(Long user_id) {

        // 회원이 존재하는지에 대한 유효성검사
        Member findMember = globalException.findVerifiedMember(user_id);
        MemberPostResponseDto memberPostResponseDto = MemberMapper.INSTANCE.entityToPostResponseDto(findMember);

        return memberPostResponseDto;
    }

    // 회원조회
    public MemberResponseDto getMember(Long user_id) {

        // 회원이 존재하는지에 대한 유효성검사
        Member findMember = globalException.findVerifiedMember(user_id);
        MemberResponseDto memberResponseDto = MemberMapper.INSTANCE.entityToResponseDto(findMember);

        return memberResponseDto;
    }

    // 회원수정
    public Member updateMember(Long user_id, MemberPatchDto patchDto) {

        // 회원이 존재하는지에 대한 유효성검사
        Member findMember = globalException.findVerifiedMember(user_id);

        // 입력 데이터에 대한 유효성검사
        globalException.patchCheckForValidate(patchDto);

        // 필드 업데이트
        Optional.ofNullable(patchDto.getNickname())
                .ifPresent(nickname -> findMember.setNickname(nickname));
        // 비밀번호 인코딩
        Optional.ofNullable(patchDto.getPassword())
                .ifPresent(password -> {
                    // 새 비밀번호를 PasswordEncoder를 사용하여 인코딩
                    String encodedPassword = passwordEncoder.encode(password);
                    findMember.setPassword(encodedPassword);
                });

        return memberRepository.save(findMember);
    }


    // 회원탈퇴
    public void deleteMember(Long user_id) {

        // 회원의 존재유무 및 회원 상태에 대한 유효성검사
        Member findMember = globalException.deleteCheckMemberStatus(user_id);

        // 회원탈퇴 시 MemberStatus false 로 변경
        findMember.setMemberStatus(false);
        memberRepository.save(findMember);
    }

    //////// BusinessLogic ////////

    private void encryptPasswordAndSetRoles(Member member) {
        // 추가: Password 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 추가: DB에 User Role 저장
        List<String> roles = authorityUtils.createRoles(member.getUsername());
        member.setRoles(roles);
    }

    // [회원가입] 작성 양식에 맞추지 않거나, 중복된 이메일, 아이디, 닉네임에 대한 유효성 검사
    // [회원조회] 존재하지 않는 유저정보 유효성 검사
    // [회원수정] 작성 양식에 맞추지 않거나, 중복된 닉네임에 대한 유효성 검사
    // -> GlobalException 클래스로 이동
}
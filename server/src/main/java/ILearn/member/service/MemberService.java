package ILearn.member.service;

import ILearn.global.auth.loginDto.LoginDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Collections;

@Service
public class MemberService {

    public Member performLoginAuthentication(LoginDto loginDto) {
        //사용자명과 비밀번호로 인증을 수행하고 인증된 사용자 정보를 반환
        //데이터베이스에서 사용자를 조회하고 인증되면 사용자 정보를 반환
        Member authenticatedMember = new Member();
        authenticatedMember.setUsername(loginDto.getUsername());
        authenticatedMember.setRoles(Collections.singletonList("USER")); // 예시롤 설정
        return authenticatedMember;
    }
}
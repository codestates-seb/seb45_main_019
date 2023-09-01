package ILearn.member.service;

import ILearn.global.auth.loginDto.LoginDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    public Member performLoginAuthentication(LoginDto loginDto) throws AuthenticationException {
        // 실제 로그인 인증 로직을 여기에 구현
        // 예시: 사용자명과 비밀번호로 인증을 수행하고 인증된 사용자 정보를 반환
        //데이터베이스에서 사용자를 조회하고 인증되면 사용자 정보를 반환
        Member authenticatedMember = memberMapper.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (authenticatedMember == null) {
            throw new AuthenticationException("Authentication failed");
        }
        return authenticatedMember;
    }
}
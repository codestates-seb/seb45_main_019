package ILearn.member.controller;

import ILearn.global.Response.ApiResponse;
import ILearn.global.auth.filter.JwtAuthenticationFilter;
import ILearn.global.auth.filter.JwtVerificationFilter;
import ILearn.global.auth.loginDto.LoginDto;
import ILearn.member.dto.MemberPostDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collections;

@RestController
@Validated
@RequestMapping("/members")
@Slf4j
public class MemberController {
    private final MemberMapper memberMapper;
    private final MemberService memberService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public MemberController(MemberMapper memberMapper,MemberService memberService,
                            JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;

    }

    // 유저 회원가입
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = memberMapper.memberPostDtoToEntity(memberPostDto);
//        memberService.createMember(member);

        ApiResponse<Void> response = new ApiResponse<>(true, "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    //유저 로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Void>> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        //로그인 인증 로직을 수행하고 유효한 경우 JWT 토큰 생성 및 쿠키 추가
        //JWT 토큰을 쿠키로 추가
        Member authenticatedMember = memberService.performLoginAuthentication(loginDto);
        jwtAuthenticationFilter.addTokenToResponse(authenticatedMember, response);

        ApiResponse<Void> response = new ApiResponse<>(true, "로그인 되었습니다.");
        return ResponseEntity.ok(response);
    }

}


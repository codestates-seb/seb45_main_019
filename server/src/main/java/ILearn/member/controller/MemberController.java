package ILearn.member.controller;

import ILearn.global.Response.ApiResponse;
import ILearn.member.dto.MemberPostDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/members")
@Slf4j
public class MemberController {
    private final MemberMapper memberMapper;
    private final MemberService memberService;

    public MemberController(MemberMapper memberMapper,MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    // 유저 회원가입
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = memberMapper.memberPostDtoToEntity(memberPostDto);
//        memberService.createMember(member);

        ApiResponse<Void> response = new ApiResponse<>(true, "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

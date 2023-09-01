package ILearn.member.controller;

import ILearn.global.response.ApiResponseException;
import ILearn.global.response.ApiResponse;
import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberPostDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/members")
@Slf4j
public class MemberController {
    private final MemberMapper memberMapper;
    private final MemberService memberService;

    public MemberController(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    // 유저 회원가입
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        try {
            Member member = memberMapper.memberPostDtoToEntity(memberPostDto);
            memberService.createMember(member);
            ApiResponse<Void> response = new ApiResponse<>(true, "success");

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // 유저 정보조회
    @GetMapping("/{user_id}")
    public ResponseEntity<ApiResponse<?>> getMember(@PathVariable @Positive Long user_id) {
        try {
            MemberResponseDto member = memberService.getMember(user_id);
            ApiResponse<MemberResponseDto> response = new ApiResponse<>(true, "success", member);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // 유저 정보수정
    @PatchMapping("/{user_id}")
    public ResponseEntity updateMember(@Valid @PathVariable Long user_id, @RequestBody MemberPatchDto memberPatchDto) {
        try {
            Member member = memberService.updateMember(user_id, memberPatchDto);

            ApiResponse<Member> response = new ApiResponse<>(true, "success", member);
            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // 유저 탈퇴
    @DeleteMapping("/{user_id}")
    public ResponseEntity<ApiResponse<?>> deleteMember(@PathVariable Long user_id) {
        try {
            memberService.deleteMember(user_id);

            ApiResponse<Void> response = new ApiResponse<>(true, "success");
            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
package ILearn.member.controller;

import ILearn.global.response.ApiResponseException;
import ILearn.global.response.ApiResponse;
import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberPostDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/members")
@Slf4j
@EnableSwagger2
@Api(tags = "Member Controller", description = "Member 관련 API")
public class MemberController {
    private final MemberMapper memberMapper;
    private final MemberService memberService;

    public MemberController(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    // 유저 회원가입
    @PostMapping
    @ApiOperation(value = "유저 회원가입", notes = "새로운 유저를 등록합니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 201, message = "회원가입 성공"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "이메일 중복"),
    })
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
    @ApiOperation(value = "회원 정보조회", notes = "회원의 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "조회 성공"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "유저 정보 조회 실패"),
    })
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
    @ApiOperation(value = "회원 정보수정", notes = "회원의 정보를 수정합니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "회원정보 수정 성공"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "잘못된 요청 형식"),
    })
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
    @ApiOperation(value = "유저 탈퇴", notes = "유저를 탈퇴시킵니다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "탈퇴 성공"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "유저를 찾을 수 없음"),
    })


    public ResponseEntity<ApiResponse<?>> deleteMember(@PathVariable Long user_id) {
        try {
            Member member = memberService.findVerifiedMember(user_id);

            if(member != null){
                if(member.getMemberStatus() == Member.MemberStatus.MEMBER_ACTIVE) {
                    memberService.deleteMember(user_id);
                    ApiResponse<Void> response = new ApiResponse<>(true,0,"success",null);
                    return ResponseEntity.ok(response);
                } else {

                    ApiResponse<Void> response = new ApiResponse<>(false,920,"USER_NOT_FOUND",null);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                }
            } else {
                // 회원을 찾을 수 없는 경우에 대한 예외 처리
                ApiResponse<Void> response = new ApiResponse<>(false, 920, "USER_NOT_FOUND", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (ApiResponseException ex){

            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
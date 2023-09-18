package ILearn.global.auth.handler;

import ILearn.global.response.ApiResponse;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class MemberAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // 인증 성공 후, 로그를 기록하거나 사용자 정보를 response로 전송하는 등의 추가 작업을 할 수 있다.
        log.info("# Authenticated successfully!");

        // Authentication 객체에서 사용자 정보 추출
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        // username을 사용하여 Member 정보 조회
        Optional<Member> memberOptional = memberRepository.findByUsername(username);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();

            // Member 엔티티에서 MemberResponseDto로 변환
            MemberResponseDto memberResponseDto = new MemberResponseDto();
            memberResponseDto.setUserId(member.getUserId());
            memberResponseDto.setUsername(member.getUsername());
            memberResponseDto.setEmail(member.getEmail());
            memberResponseDto.setNickname(member.getNickname());
            memberResponseDto.setPoint(member.getPoint());
            memberResponseDto.setMemberStatus(member.isMemberStatus());
            memberResponseDto.setRoles(member.getRoles());

            // ApiResponse 생성 및 MemberResponseDto를 data로 설정
            ApiResponse<MemberResponseDto> apiResponse = new ApiResponse<>(true, "Login successful", memberResponseDto);

            // ApiResponse를 JSON 형태로 변환하여 응답
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(apiResponse);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonResponse);
            out.flush();
        }
    }
}
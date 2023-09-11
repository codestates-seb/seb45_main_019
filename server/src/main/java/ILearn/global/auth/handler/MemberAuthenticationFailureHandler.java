package ILearn.global.auth.handler;


import ILearn.global.response.ApiResponse;
import ILearn.global.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class MemberAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        // 인증 실패 시, 에러 로그를 기록하거나 error response를 전송할 수 있다.
        log.error("# Authentication failed: {}", exception.getMessage());

        sendMemberNotFoundResponse(response);
    }
    // Todo: 현재 멤버가 존재하지 않을 경우만 예외반환처리 됨, 추가 예외처리 구현 필요(인증이 안된 사용자일 경우 등..)
    private void sendMemberNotFoundResponse(HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponse<String> apiResponse = new ApiResponse<>(false, "Member not found");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(objectMapper.writeValueAsString(apiResponse));
        out.flush();
    }
//    private void sendErrorResponse(HttpServletResponse response) throws IOException {
//        Gson gson = new Gson();
//        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.UNAUTHORIZED);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.getWriter().write(gson.toJson(errorResponse, ErrorResponse.class));
//    }
}
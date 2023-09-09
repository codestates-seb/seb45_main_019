package ILearn.global.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;

// 공통 응답 클래스
@Getter
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean status;
    private int error;
    private String msg;
    private T data;

    // [응답 성공] data 반환이 필요 없는 응답
    public ApiResponse(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    // [응답 성공] data 반환이 필요한 응답 오버로딩
    public ApiResponse(boolean status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // [응답 실패] error 반환이 필요한 응답 오버로딩
    public ApiResponse(boolean status, int error, String msg) {
        this.status = status;
        this.error = error;
        this.msg = msg;
    }

    // [응답 실패] error 및 data 반환이 필요한 응답 오버로딩
    public ApiResponse(boolean status, int error, String msg, T data) {
        this.status = status;
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    // data 반환이 필요 할 경우 사용할 필드
    public void setData(T data) {
        this.data = data;
    }

    public void setError(int error) {
        this.error = error;
    }

    // [리다이렉트] 특정 URL로 리다이렉트
    public static void sendRedirect(String redirectUrl) throws IOException {
        ApiResponse.sendRedirect(redirectUrl);
    }
}
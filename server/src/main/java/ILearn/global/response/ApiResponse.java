package ILearn.global.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 공통 응답 클래스
@Getter
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean status;
    private String msg;
    private T data;

    // data 반환이 필요 없는 응답
    public ApiResponse(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    // data 반환이 필요한 응답 오버로딩
    public ApiResponse(boolean status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // data 반환이 필요 할 경우 사용할 필드
    public void setData(T data) {
        this.data = data;
    }
}
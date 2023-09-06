package ILearn.global.exception;

import ILearn.global.Response.ApiResponse;
import ILearn.global.Response.ApiResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

// DTO 클래스의 예외처리 메세지를 담기 위한 클래스
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> methodArgumentExceptionHandler(MethodArgumentNotValidException e) {
//         = = = = = = 애너테이션 유효성 검사에 대해 모든 예외 메세지를 담아서 반환 = = = = = = =
//        List<String> errorMessages = e.getBindingResult().getFieldErrors().stream()
//                .map(FieldError::getDefaultMessage)
//                .collect(Collectors.toList());
//
//        String errorMessage = String.join(", ", errorMessages);
//
//        return new ApiResponseException(new ApiResponse<>(false, errorMessage), e).getResponse();

//         = = = = = = 애너테이션 유효성 검사에 대해 하나의 예외 메세지를 담아서 반환 = = = = = = =
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("유효성 검사에 실패했습니다(디폴트 메시지)");

        int errorCode = 0;

        if (errorMessage.contains("USERNAME_NOT_BLANK")) {
            errorCode = 903;
        } else if(errorMessage.contains("USERNAME_ERROR")) {
            errorCode = 904;
        } else if (errorMessage.contains("PASSWORD_NOT_BLANK")) {
            errorCode = 905;
        } else if(errorMessage.contains("PASSWORD_ERROR")) {
            errorCode = 906;
        } else if (errorMessage.contains("NICKNAME_NOT_BLANK")) {
            errorCode = 907;
        } else if(errorMessage.contains("NICKNAME_ERROR")) {
            errorCode = 908;
        } else if(errorMessage.contains("EMAIL_NOT_BLANK")) {
            errorCode = 909;
        } else if (errorMessage.contains("EMAIL_ERROR")) {
            errorCode = 910;
        }

        return new ApiResponseException(new ApiResponse<>(false, errorCode, errorMessage), e).getResponse();
    }
}

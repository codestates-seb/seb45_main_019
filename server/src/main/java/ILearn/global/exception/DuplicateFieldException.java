package ILearn.global.exception;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;

public class DuplicateFieldException extends ApiResponseException {
    public DuplicateFieldException(String fieldName, int i) {
        super(new ApiResponse<>(false, "중복된 " + fieldName + " 입니다."), new RuntimeException());

    }
}

package ILearn.global.exception;

import ILearn.global.Response.ApiResponse;
import ILearn.global.Response.ApiResponseException;

public class DuplicateFieldException extends ApiResponseException {
    public DuplicateFieldException(String fieldName) {
        super(new ApiResponse<>(false, "중복된 " + fieldName + " 입니다."), new RuntimeException());

    }
}

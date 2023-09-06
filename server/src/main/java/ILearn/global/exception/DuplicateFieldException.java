package ILearn.global.exception;

import ILearn.global.Response.ApiResponse;
import ILearn.global.Response.ApiResponseException;

public class DuplicateFieldException extends ApiResponseException {
    public DuplicateFieldException(String fieldName, int errorCode) {
        super(new ApiResponse<>(false, errorCode, fieldName + "_EXIST."), new RuntimeException());

    }
}

package ILearn.global.exception;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;

public class DuplicateFieldException extends ApiResponseException {
    public DuplicateFieldException(String fieldName, int i) {
        super(new ApiResponse<>(false, i, fieldName + "_DUPLICATE",""), new RuntimeException());

    }
}

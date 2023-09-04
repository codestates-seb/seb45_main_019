package ILearn.global.Response;

public class ApiResponseException extends RuntimeException{
    private final ApiResponse<?> response;
    public ApiResponseException(ApiResponse<?> response, Throwable cause) {
        super(cause);
        this.response = response;
    }
    public ApiResponse<?> getResponse() {
        return response;
    }
}

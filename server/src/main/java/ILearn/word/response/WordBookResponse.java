package ILearn.word.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "단어 응답")
public class WordBookResponse {

    @ApiModelProperty(value = "성공 여부", example = "true")
    private boolean status;

    @ApiModelProperty(value = "에러 코드", example = "0")
    private int errorCode;

    @ApiModelProperty(value = "응답 메시지", example = "success")
    private String msg;

    @ApiModelProperty(value = "데이터 객체", example = "null")
    private Object data;

    public WordBookResponse(boolean status, int errorCode, String msg, Object data) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }
}
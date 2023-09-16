package ILearn.word.response;

import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(description = "단어 조회 응답")
public class WordApiResponse {

    @ApiModelProperty(value = "성공 여부", example = "true")
    private boolean status;

    @ApiModelProperty(value = "에러 코드", example = "0")
    private int errorCode;

    @ApiModelProperty(value = "응답 메시지", example = "success")
    private String msg;

    @ApiModelProperty(value = "데이터 객체", example = "null")
    private WordGetDto data;

    public WordApiResponse(boolean status, int errorCode, String msg, WordGetDto data) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }
}
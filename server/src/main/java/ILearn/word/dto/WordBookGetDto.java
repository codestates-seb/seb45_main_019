package ILearn.word.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(description = "단어 조회 응답")
public class WordBookGetDto {

    @ApiModelProperty(value = "성공 여부", example = "true")
    private boolean status;

    @ApiModelProperty(value = "응답 메시지", example = "success")
    private String msg;

    @ApiModelProperty(value = "단어 ID 배열", example = "[1, 2, 3]")
    private Long[] wordIds;

    public WordBookGetDto(boolean status, String msg, List<Long> wordIds) {
        this.status = status;
        this.msg = msg;
        if (wordIds != null) {
            this.wordIds = wordIds.toArray(new Long[0]);
        } else {
            this.wordIds = new Long[0];
        }
    }
}
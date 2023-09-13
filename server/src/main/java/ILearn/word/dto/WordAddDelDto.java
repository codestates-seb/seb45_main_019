package ILearn.word.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "단어 추가,삭제 요청")
public class WordAddDelDto {
    @ApiModelProperty(value = "단어 ID", example = "1")
    private Long wordId;

}

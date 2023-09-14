package ILearn.word.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@ApiModel(description = "단어 정보")
public class WordGetDto {
    @ApiModelProperty(value = "단어 ID", example = "1")
    private Long wordId;

    @ApiModelProperty(value = "단어", example = "hello")
    private String word;

    @ApiModelProperty(value = "발음", example = "[hə'ləʊ]")
    private String symbol;

    @ApiModelProperty(value = "단어 의미", example = "[안녕하세요, 안녕]")
    private List<String> wordMeaning;

    @ApiModelProperty(value = "상세 카테고리", example = "[감탄사, 명사]")
    private List<String> detailCategories;

    @ApiModelProperty(value = "상세 설명", example = "[[인사말로 쓰이는 표현, 안부를 묻거나 인사를 할 때 사용]]")
    private List<String> detailDescriptions;

    @ApiModelProperty(value = "단어 예제", example = "[hello! How are you doing today?]")
    private List<String> wordExample;

    @ApiModelProperty(value = "단어 예제 의미", example = "[안녕하세요! 오늘 어떻게 지내세요?]")
    private List<String> wordExampleMeaning;
}

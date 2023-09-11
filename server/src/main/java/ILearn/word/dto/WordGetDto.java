package ILearn.word.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class WordGetDto {
    private Long wordId;
    private String word;
    private String symbol;
    private String wordMeaning;
    private String detailCategories;
    private String detailDescriptions;//다차원 리스트 형태의 데이터, 여러가지 배열이 여러개로 와야하기 때문에
    private String wordExample;
    private String wordExampleMeaning;
}

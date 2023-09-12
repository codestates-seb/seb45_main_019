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
    private String detailDescriptions;
    private String wordExample;
    private String wordExampleMeaning;
}

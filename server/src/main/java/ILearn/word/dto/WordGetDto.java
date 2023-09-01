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
    private List<String> wordMeaning;
    private List<String> detailCategories;
    private List<List<String>> detailDescriptions;
    private List<String> wordExamples;
    private List<String> wordExampleMeanings;
}

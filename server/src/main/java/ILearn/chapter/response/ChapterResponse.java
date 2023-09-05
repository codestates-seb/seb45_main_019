package ILearn.chapter.response;

import ILearn.word.entity.Word;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChapterResponse {
    private String title;
    private Long chapterId;
    private List<Word> words;
}
package ILearn.chapter.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChapterInfo {//Learning에서 사용하는 info dto 클래스
    private String title;
    private Long chapterId;
    private List<Long> wordId;


    public ChapterInfo(String title, Long chapterId, List<Long> wordId) {
        this.title = title;
        this.chapterId = chapterId;
        this.wordId = wordId;
    }
}

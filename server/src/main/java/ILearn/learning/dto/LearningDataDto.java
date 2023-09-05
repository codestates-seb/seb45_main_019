package ILearn.learning.dto;

import ILearn.chapter.response.ChapterResponse;
import ILearn.learning.entity.Learning;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LearningDataDto {
    private String chapterTitle;
    private Long chapterId;

    public LearningDataDto(Learning learning) {
        if (learning != null && learning.getChapter() != null) {
            this.chapterTitle = learning.getChapter().getTitle();
            this.chapterId = learning.getChapter().getChapterId();
        }
    }
}
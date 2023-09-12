package ILearn.learning.dto;



import ILearn.chapter.dto.ChapterInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class LearningDataDto {
    private boolean status;
    private String msg;
    private List<ChapterInfo> chapterList;

    public LearningDataDto(boolean status, String msg,List<ChapterInfo> chapterList) {
        this.status = status;
        this.msg = msg;
        this.chapterList = chapterList;
    }
}
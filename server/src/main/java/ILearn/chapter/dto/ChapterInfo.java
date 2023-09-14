package ILearn.chapter.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(description = "Chapter 정보") // ChapterInfo 클래스에 대한 설명
public class ChapterInfo {//Learning에서 사용하는 info dto 클래스
    @ApiModelProperty(value = "Chapter 제목", example = "인사하기")
    private String title;

    @ApiModelProperty(value = "Chapter ID", example = "1")
    private Long chapterId;

    @ApiModelProperty(value = "Word ID 목록", example = "[1, 2, 3]")
    private List<Long> wordId;



    public ChapterInfo(String title, Long chapterId, List<Long> wordId) {
        this.title = title;
        this.chapterId = chapterId;
        this.wordId = wordId;
    }
}

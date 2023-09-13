package ILearn.manage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageGetDto {
    private Long chapterId;
    private boolean chapterStatus;
    private int progress;
    private int point;
}

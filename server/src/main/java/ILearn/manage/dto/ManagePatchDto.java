package ILearn.manage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagePatchDto {
    private Long manageId;
    private Long chapterId;
    private boolean chapterStatus;
    private int progress;
    private int point;

}

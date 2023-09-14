package ILearn.manage.dto;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ManageResponseDto {
    private Long manageId;
    private boolean chapterStatus;
    private List<Integer> progress;
    private List<String> chapterList;
    private String chapterName;
    private int chapterQuestion;
    private Boolean chapterRecord;
    private Date correctTime;
    private int point;
}

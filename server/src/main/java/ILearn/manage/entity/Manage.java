package ILearn.manage.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Manage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANAGE_ID")
    private Long manageId;

    private Long manageNum;

    private Long chapterId;

    @Column(name = "chapterStatus")
    private boolean chapterStatus = false;

    @ElementCollection
    private List<Integer> progress = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    @Column(name = "chapterName")
    private String chapterName;

    @Column(name = "chapterQuestion")
    private int chapterQuestion;

    @Column(name = "chapterRecord")
    private Boolean chapterRecord;

    @Column(name = "correctTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date correctTime;

    @Column(name = "point")
    private int point;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @OneToMany(mappedBy = "manage")
    private List<Chapter> chapterList;
}
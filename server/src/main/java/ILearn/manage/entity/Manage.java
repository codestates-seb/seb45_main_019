package ILearn.manage.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import ILearn.question.entity.Question;
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
    @Column(name = "manage_Id")
    private Long manageId;

    @Column(name = "chapterName")
    private String chapterName;

    @Column(name = "chapterQuestion")
    private int chapterQuestion;

    @Column(name = "chapterStatus")
    private String chapterStatus;

    @Column(name = "chapterRecord")
    private Boolean chapterRecord;

    @Column(name = "correctTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date correctTime;

    @Column(name = "point")
    private int point;

    @ManyToOne
    @JoinColumn(name = "question_Id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Member member;

    @OneToMany(mappedBy = "manage")
    private List<Chapter> chapters = new ArrayList<>();

}
package ILearn.manage.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "manageNum")
    private Long manageNum;

    @Column(name = "chapterId")
    private Long chapterId;

    @Column(name = "chapterStatus")
    private boolean chapterStatus;

    @ElementCollection
    private List<Integer> progress;

    @Column(name = "point")
    private int point;

    @Column(name = "correctTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date correctTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @OneToMany(mappedBy = "manage")
    private List<Chapter> chapterList;
}
package ILearn.manage.entity;

import ILearn.member.entity.Member;
import ILearn.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Manage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manage_Id")
    private Long manageId;

    @Column(name = "learningName")
    private String learningName;

    @Column(name = "learningNumber")
    private int learningNumber;

    @Column(name = "learningQuestion")
    private int learningQuestion;

    @Column(name = "learningStatus")
    private String learningStatus;

    @Column(name = "learningRecord")
    private Boolean learningRecord;

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

}
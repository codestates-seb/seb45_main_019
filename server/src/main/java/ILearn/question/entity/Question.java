package ILearn.question.entity;

import ILearn.manage.entity.Manage;
import ILearn.member.entity.Member;
import ILearn.word.entity.Word;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_Id")
    private Long questionId;

//    @ManyToOne
//    @JoinColumn(name = "questionType_Id")
//    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "word_Id")
    private Word word;

    @OneToMany(mappedBy = "question") // 여러개의 manage가 하나의 문제를 가질 수 있도록
    private List<Manage> manages;

    @ManyToOne
    @JoinColumn(name = "manege_Id")
    private Manage manage;

}
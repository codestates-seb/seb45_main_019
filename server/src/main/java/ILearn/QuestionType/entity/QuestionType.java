package ILearn.QuestionType.entity;

import ILearn.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questiontype_Id")
    private Long questiontypeId;

    @Column(name = "뜻 보고 영단어 고르기")
    private String questiontype1;

    @Column(name = "영단어 보고 뜻 고르기")
    private String questiontype2;

    @Column(name = "소리 듣고 문제 맞추기")
    private String questiontype3;

    @Column(name = "빈칸에 알맞은 단어 고르기")
    private String questiontype4;

    @OneToMany(mappedBy = "questionType")
    private List<Question>questions;


}

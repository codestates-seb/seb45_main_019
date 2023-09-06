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
    @Column(name = "questionType_Id")
    private Long questionTypeId;

    @Column(name = "questionType1")
    private String questionType1;

    @Column(name = "questionType2")
    private String questionType2;

    @Column(name = "questionType3")
    private String questionType3;

    @Column(name = "questionType4")
    private String questionType4;

    @OneToMany(mappedBy = "questionType")
    private List<Question>questions;
}
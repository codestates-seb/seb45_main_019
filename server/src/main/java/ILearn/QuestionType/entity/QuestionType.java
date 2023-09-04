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

    @Column(name = "questiontype1")
    private String questiontype1;

    @Column(name = "questiontype2")
    private String questiontype2;

    @Column(name = "questiontype3")
    private String questiontype3;

    @Column(name = "questiontype4")
    private String questiontype4;

    @OneToMany(mappedBy = "questionType")
    private List<Question>questions;


}

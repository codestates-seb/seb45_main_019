package ILearn.question.entity;

import ILearn.QuestionType.entity.QuestionType;
import ILearn.chapter.entity.Chapter;
import ILearn.word.entity.Word;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_Id")
    private Long questionId;


    @ManyToOne
    @JoinColumn(name = "chapterId")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "questionTypeId")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "word_Id")
    private Word word;

}
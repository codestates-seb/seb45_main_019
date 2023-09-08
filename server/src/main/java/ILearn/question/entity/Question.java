package ILearn.question.entity;

import ILearn.QuestionType.entity.QuestionType;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.entity.ChapterQuestion;
import ILearn.word.entity.Word;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONID")
    private Long questionId;

    @OneToMany
    private List<ChapterQuestion> chapterQuestions = new ArrayList<>();

    @Column(name = "QUESTIONTYPE")
    private Long questionType;
    private String question;
//    @ElementCollection(fetch = FetchType.EAGER)
    private String examples;
    private String correct;
    private String translation;

    @ManyToOne
    @JoinColumn(name = "CHAPTER_ID")
    private Chapter chapter;


//    @ManyToOne
//    @JoinColumn(name = "questionTypeId")
//    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "word_Id")
    private Word word;

}
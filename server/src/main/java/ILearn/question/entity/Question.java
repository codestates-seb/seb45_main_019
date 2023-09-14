package ILearn.question.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.word.entity.Word;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONID")
    @JsonIgnore
    private Long questionId;
    private Long questionNum;

    @Column(name = "QUESTIONTYPE")
    private Long questionType;
    private String question;
    private String examples;
    private String correct;
    private String translation;
    @JsonIgnore
    private Long wordNum;
    @JsonIgnore
    private Long chapterNum;

    @ManyToOne
    @JoinColumn(name = "CHAPTER_ID")
    @JsonIgnore
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "WORDID")
    @JsonIgnore
    private Word word;

}
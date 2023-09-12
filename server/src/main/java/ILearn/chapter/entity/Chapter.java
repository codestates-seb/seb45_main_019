package ILearn.chapter.entity;

import ILearn.manage.entity.Manage;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAPTER_ID")
    private Long chapterId;

    @Column(name = "CHAPTER_TITLE")
    private String title;

    @OneToMany(mappedBy = "chapter")
    @JsonIgnore
    private List<Question> questions;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.REMOVE)
    private List<Word> words;

    @ManyToOne
    @JoinColumn(name = "manage")
    private Manage manage;

}

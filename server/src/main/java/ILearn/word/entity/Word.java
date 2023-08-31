package ILearn.word.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import ILearn.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_Id")
    private Long wordId;

    @Column(name = "word")
    private String word;

    @Column(name = "wordMeaning")
    private String wordMeaning;

    @Column(name = "wordExample")
    private String wordExample;

    @OneToMany(mappedBy = "word")
    private List<Question> questions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "chapter_Id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Member member;
}

package ILearn.word.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import ILearn.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Word {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORDID")
    private Long wordId;

    @Column(name = "WORD")
    private String word;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "WORDMEANING")
    private String wordMeaning;

    @Column(name = "DETAILCATEGORIES")
    private String detailCategories;

    @Column(name = "WORDEXAMPLE")
    private String wordExample;

    @Column(name = "WORDEXAMPLEMEANING")
    private String wordExampleMeaning;

    @OneToMany(mappedBy = "word")
    private List<Question> questions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "chapter_Id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Member member;
}

package ILearn.word.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import ILearn.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

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

    @Column(name = "DETAILDESCRIPTIONS")
    private String detailDescriptions;

    @Column(name = "WORDEXAMPLE")
    private String wordExample;

    @Column(name = "WORDEXAMPLEMEANING")
    private String wordExampleMeaning;

    @OneToMany(mappedBy = "word", cascade = CascadeType.REMOVE)
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "CHAPTER_ID")
    @JsonIgnore
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Member member;
}
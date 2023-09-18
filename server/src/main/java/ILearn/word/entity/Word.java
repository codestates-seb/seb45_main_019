package ILearn.word.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import ILearn.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORDID")
    private Long wordId;

    @Column(name = "WORD")
    private String word;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "WORDMEANING")
    @ElementCollection
    private List<String> wordMeaning;

    @Column(name = "DETAILDESCRIPTIONS")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordDescription> detailDescriptions;

    @Column(name = "WORDEXAMPLE")
    @ElementCollection
    @CollectionTable(name = "wordArray")
    private List<String> wordExample;

    @Column(name = "WORDEXAMPLEMEANING")
    @ElementCollection
    @CollectionTable(name = "wordArray")
    private List<String> wordExampleMeaning;

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
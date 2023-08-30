package ILearn.word.entity;

import ILearn.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

//    @ManyToOne
//    @JoinColumn(name = "chapter_Id")
//    private Chapter chapter;
//
//    @ManyToOne
//    @JoinColumn(name = "question_Id")
//    private Question question;
//
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Member member;
}

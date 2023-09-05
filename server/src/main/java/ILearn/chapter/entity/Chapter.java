package ILearn.chapter.entity;

import ILearn.manage.entity.Manage;
import ILearn.member.entity.Member;
import ILearn.member.entity.MemberChapter;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Long chapterId;

    @Column(name = "chapter_title")
    private String title;

    @OneToMany(mappedBy = "chapter")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "chapter")
    private List<MemberChapter> memberChapters = new ArrayList<>();

    @OneToMany(mappedBy = "chapter")
    private List<Word> words = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "manage")
    private Manage manage;
}

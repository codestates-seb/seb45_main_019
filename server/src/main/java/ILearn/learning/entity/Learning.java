package ILearn.learning.entity;

import ILearn.chapter.entity.Chapter;
import ILearn.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Learning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "learning_Id")
    private Long learningId;

    @ManyToOne
    @JoinColumn(name = "chapter_Id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Member member;

    @Column(name = "user_Id", insertable = false, updatable = false)
    private Long userId;


}

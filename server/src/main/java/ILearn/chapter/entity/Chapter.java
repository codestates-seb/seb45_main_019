package ILearn.chapter.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_Id")
    private Long chapterId;
}

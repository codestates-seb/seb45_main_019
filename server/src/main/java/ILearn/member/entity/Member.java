package ILearn.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "registration_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Column(name = "point")
    private int point;

    @Column(name = "member_status")
    private String memberStatus;

    @Column(name = "word_book", columnDefinition = "TEXT")
    private String wordBook;

    //유저 권한 부여
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "word_Id")
//    private List<Word> words;
//
//    @OneToMany
//    @JoinColumn(name = "learning_Id")
//    private List<Learning> learnings;
//
//    @OneToMany
//    @JoinColumn(name = "question_Id")
//    private List<Question> questions;
//
//    @OneToOne
//    @JoinColumn(name = "manage_Id")
//    private Manage manage;

}
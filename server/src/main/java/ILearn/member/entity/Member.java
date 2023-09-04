package ILearn.member.entity;

import ILearn.learning.entity.Learning;
import ILearn.manage.entity.Manage;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false) // 유저 네임 중복 컷
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname", unique = true, nullable = false) // 닉네임 중복 컷
    private String nickname;

    @Column(name = "registration_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date registrationDate;
//    public String getFormattedRegistrationDate() { // 가입시간 한국 시간, 연 월 일 분 초
//        TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//        sdf.setTimeZone(timeZone);
//        return sdf.format(registrationDate);
//    }

    @Column(name = "point")
    private int point;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @Column(name = "word_book", columnDefinition = "TEXT")
    private String wordBook;

    @OneToMany
    @JoinColumn(name = "member")
    private List<Word> words;

    @OneToMany
    @JoinColumn(name = "learning_Id")
    private List<Learning> learnings;

    @OneToMany
    @JoinColumn(name = "question_Id")
    private List<Question> questions;

    @OneToOne
    @JoinColumn(name = "manage_Id")
    private Manage manage;

    @OneToMany(mappedBy = "member")
    private List<MemberChapter> memberChapters = new ArrayList<>();


    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_QUIT("회원 탈퇴");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
//package ILearn.member.entity;
//
////import ILearn.chapter.entity.Chapter;
//import ILearn.chapter.entity.Chapter;
//
//import javax.persistence.*;
//
//@Entity
//public class MemberChapter {//member, chapter 중간 테이블
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long memberchapterId;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "chapter_id")
//    private Chapter chapter;
//}

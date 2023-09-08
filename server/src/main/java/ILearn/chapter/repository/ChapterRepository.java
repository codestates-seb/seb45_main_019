package ILearn.chapter.repository;

import ILearn.chapter.entity.Chapter;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    // Chapter 엔티티에서 word와 관련된 정보를 가져오는 쿼리 메서드 정의
    List<Chapter> findByWord(Word word);

    // Chapter 엔티티에서 questions와 관련된 정보를 가져오는 쿼리 메서드 정의
    List<Chapter> findByQuestions(Question question);
}
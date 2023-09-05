package ILearn.learning.repository;

import ILearn.chapter.entity.Chapter;
import ILearn.learning.entity.Learning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningRepository extends JpaRepository<Learning, Long> {
    //사용자 userId를 기반으로 사용자가 이용 가능한 챕터 목록 가저오기
    List<Chapter> findChaptersByUserId(@Param("userId") Long userId);
}
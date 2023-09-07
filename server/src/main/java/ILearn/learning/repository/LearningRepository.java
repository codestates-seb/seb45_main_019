package ILearn.learning.repository;

import ILearn.chapter.entity.Chapter;
import ILearn.learning.entity.Learning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningRepository extends JpaRepository<Learning, Long> {
        List<Learning> findByUserId(Long userId);
}
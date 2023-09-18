package ILearn.chapter.repository;

import ILearn.chapter.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    @Query("SELECT c.chapterId FROM Chapter c")
    List<Long> findAllChapterIds();
}

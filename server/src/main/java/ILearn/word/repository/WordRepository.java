package ILearn.word.repository;

import ILearn.word.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("SELECT w.wordId FROM Word w")
    List<Long> findAllWordIds();

    List<Word> findAllByMemberUserId(Long userId);
}
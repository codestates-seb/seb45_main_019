package ILearn.word.repository;

import ILearn.word.entity.Word;
import ILearn.word.entity.WordDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("SELECT w.wordId FROM Word w")
    List<Long> findAllWordIds();
    List<Word> findAllByMemberUserId(Long userId);
}
package ILearn.question.repository;

import ILearn.question.dto.QuestionGetListDto;
import ILearn.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByWordNum(Long wordId);

    Optional<Question> findByQuestionNum(Long questionId);

    Optional<Question> findByChapterNumAndQuestionNum(Long chapterNum, Long questionNum);
}

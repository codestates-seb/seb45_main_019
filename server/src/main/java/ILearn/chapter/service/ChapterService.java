package ILearn.chapter.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.entity.Manage;
import ILearn.manage.service.ManageService;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import ILearn.member.mapper.MemberMapper;
import ILearn.member.repository.MemberRepository;
import ILearn.question.entity.Question;
import ILearn.question.repository.QuestionRepository;
import ILearn.word.entity.Word;
import ILearn.word.repository.WordRepository;
import ILearn.word.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final QuestionRepository questionRepository;

    // Chapter List 조회
    public List<ChapterInfo> getById() {
        List<Chapter> chapters = chapterRepository.findAll();
        List<ChapterInfo> responseList = new ArrayList<>();

        for (Chapter chapter : chapters) {
            List<Long> wordIds = chapter.getWords().stream()
                    .map(Word::getWordId)
                    .collect(Collectors.toList());

            ChapterInfo response = new ChapterInfo(
                    chapter.getTitle(),
                    chapter.getChapterId(),
                    wordIds
            );
            responseList.add(response);
        }

        return responseList;
    }

    // ChapterNum 에 해당하는 question 을 조회
    public Question getQuestionByChapterAndNum(Long chapterId, Long questionNum) {
        Optional<Question> question = questionRepository.findByChapterNumAndQuestionNum(chapterId, questionNum);

        if (question.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, 941, "QUESTION_NOT_FOUND_IN_CHAPTER");
            throw new ApiResponseException(response, new RuntimeException());
        }

        return question.get();
    }
}
package ILearn.chapter.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.global.exception.GlobalException;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final GlobalException globalException;

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

    // ChapterId에 해당하는 Question을 조회
    public Question getQuestionByChapterAndNum(Long chapterId, Long questionNum) {

        // 챕터가 존재하는지에 대한 유효성검사
        globalException.findVerifiedChapter(chapterId);

        // ChapterId에 해당하는 문제가 존재하지는지에 대한 유효성검사 및 반환
        return globalException.findVerifiedQuestion(chapterId, questionNum);
    }
}
package ILearn.chapter.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public List<ChapterInfo> getChapterInfoByWord(Word word) {
        List<Chapter> chapters = chapterRepository.findByWord(word);
        return chapters.stream()
                .map(chapter -> new ChapterInfo(
                        chapter.getTitle(),
                        chapter.getChapterId(),
                        chapter.getQuestions().stream()
                                .map(Question::getQuestionId)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public List<ChapterInfo> getChapterInfoByQuestions(Question question) {
        List<Chapter> chapters = chapterRepository.findByQuestions(question);
        return chapters.stream()
                .map(chapter -> new ChapterInfo(
                        chapter.getTitle(),
                        chapter.getChapterId(),
                        chapter.getWords().stream()
                                .map(Word::getWordId)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
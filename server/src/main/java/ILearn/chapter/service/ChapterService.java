package ILearn.chapter.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.question.entity.Question;
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
}
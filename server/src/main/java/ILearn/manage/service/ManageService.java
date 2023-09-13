package ILearn.manage.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.word.entity.Word;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManageService {

    private final ChapterRepository chapterRepository;

    public List<ChapterInfo> getChapterListByMemberId(Long userId) {
        List<Chapter> filteredChapters = chapterRepository.findAllByMemberUserId(userId);
        List<ChapterInfo> chapterInfoList = filteredChapters.stream()
                .map(chapter -> new ChapterInfo(
                        chapter.getTitle(),
                        chapter.getChapterId(),
                        chapter.getWords().stream()
                                .map(Word::getWordId)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        return chapterInfoList;
    }
}

package ILearn.learning.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.response.ChapterResponse;
import ILearn.learning.dto.LearningDataDto;
import ILearn.learning.entity.Learning;
import ILearn.learning.repository.LearningRepository;
import ILearn.learning.response.LearningResponse;
import ILearn.word.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningService {

    private final LearningRepository learningRepository;

    @Autowired
    public LearningService(LearningRepository learningRepository) {
        this.learningRepository = learningRepository;
    }

    public List<ChapterInfo> getChapterListForLearning() {
        // 여기에서 챕터 정보를 데이터베이스 또는 다른 소스에서 가져옵니다.
        List<ChapterInfo> chapterList = new ArrayList<>(); // 초기화된 빈 리스트 생성

        // 데이터베이스에서 챕터 정보를 가져오는 코드
        List<Learning> learningList = learningRepository.findAll(); // Learning 엔티티로부터 학습 목록을 가져옴

        // Learning 엔티티에서 ChapterInfo로 변환
        for (Learning learning : learningList) {
            ChapterInfo chapterInfo = new ChapterInfo(
                    learning.getChapter().getTitle(), // 챕터 제목 가져오기
                    learning.getChapter().getChapterId(), // 챕터 ID 가져오기
                    learning.getChapter().getWords().stream()
                            .map(Word::getWordId) // 챕터에 속한 단어 ID 목록 가져오기
                            .collect(Collectors.toList())
            );
            chapterList.add(chapterInfo);
        }

        return chapterList;
    }
}
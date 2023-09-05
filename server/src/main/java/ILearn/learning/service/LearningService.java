package ILearn.learning.service;

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

    public LearningResponse getLearningDetails(Long learningId) {
        // Learning 엔터티를 가져오는 로직
        Learning learning = learningRepository.findById(learningId).orElse(null);

        if (learning != null) {
            // 원하는 형식의 응답 데이터 생성
            LearningDataDto learningData = new LearningDataDto(learning);
            List<ChapterResponse> chapterList = new ArrayList<>();

            // 여러 개의 챕터 정보를 생성하고 리스트에 추가
            ChapterResponse chapterResponse = new ChapterResponse();
            chapterResponse.setTitle(learningData.getChapterTitle());
            chapterResponse.setChapterId(learningData.getChapterId());

            chapterList.add(chapterResponse);

            // LearningResponse 를 생성하여 응답 데이터 반환
            return new LearningResponse(true, "success" );
        } else {
            // 원하는 예외 처리 로직을 추가
            return new LearningResponse(false, "Learning not found", null);
        }
    }
}
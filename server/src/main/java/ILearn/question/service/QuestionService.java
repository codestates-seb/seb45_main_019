package ILearn.question.service;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.dto.QuestionGetListDto;
import ILearn.question.dto.QuestionTypeDto;
import ILearn.question.entity.Question;
import ILearn.question.mapper.QuestionMapper;
import ILearn.question.repository.QuestionRepository;
import ILearn.word.entity.Word;
import ILearn.word.repository.WordRepository;
import ILearn.word.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final WordRepository wordRepository;
    private final WordService wordService;
    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final ChapterRepository chapterRepository;

    /* Todo:
        1. 중복된 wordId가 입력될경우 예외반환
        2. 문제를 풀었을 경우 (정답,오답,미답) 구분(엔티티 하나 추가해서 0,1,2로 관리하면 될듯)
        3. 포인트 가산
        4. 챕터에서 문제를 가져올 수 있는 메서드 추가
        5. 챕터에 chapterStatus, progress 구현(문제를 어디까지 풀었나, 챕터 진행 상황 상세조회)
        6. /learning 에서 chapterList 를 조회
        7. 예외 에러코드 정리

     */

    private int currentQuestionNum = 0;

    public List<Question> generateQuestionsByWordId(Long wordId) {
        List<Question> questions = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            QuestionGetDto questionGetDto;

            switch (i) {
                case 1:
                    questionGetDto = wordToWordMeaningMcq(wordId);
                    break;
                case 2:
                    questionGetDto = wordMeaningToWordMcq(wordId);
                    break;
                case 3:
                    questionGetDto = pronunciationToSpellingSaq(wordId);
                    break;
                case 4:
                    questionGetDto = blankToWordMcq(wordId);
                    break;
                default:
                    questionGetDto = new QuestionGetDto();
                    break;
            }

            Question question = questionMapper.toEntity(questionGetDto);
            questions.add(question);
        }
        List<Question> savedQuestions = new ArrayList<>();

        for (Question question : questions) {
            savedQuestions.add(questionRepository.save(question));
        }
        return savedQuestions;
    }

    // = = = = = = = = = = =
//    [QuestionType 1] 단어를 보고 뜻 맞추기
    public QuestionGetDto wordToWordMeaningMcq(Long wordId) {
        Optional<Word> optionalWord = wordRepository.findById(wordId);
        Word word = optionalWord.orElseThrow(() -> new NoSuchElementException("Word not found with ID: " + wordId));

        Optional<Chapter> optionalChapter = chapterRepository.findById(word.getChapter().getChapterId());
        Chapter chapter = optionalChapter.orElseThrow(() -> new NoSuchElementException("Chapter not found for Word with ID: " + wordId));


        Question question = new Question();

        // examples 에 랜덤한 단어 3개와 정답(WordId) 을 가져오고 shuffle
        List<String> examples = wordService.getRandomWordMeanings(wordId, 3);
        Collections.shuffle(examples);

        QuestionGetDto questionDto = questionMapper.entityToResponseDto(question);
        questionDto.setChapterId(chapter.getChapterId());
        questionDto.setQuestionNum(updateQuestionNum());
        questionDto.setWordNum(word.getWordId());
        questionDto.setChapterNum(chapter.getChapterId());
        questionDto.setQuestionType(1L);
        questionDto.setQuestion(word.getWord());
        questionDto.setExamples(examples);
        questionDto.setTranslation("");
        questionDto.setCorrect(word.getWordMeaning().get(0).toString());

        return questionDto;
    }

    //    [QuestionType 2] 뜻을 보고 단어 맞추기
    public QuestionGetDto wordMeaningToWordMcq(Long wordId) {

        Optional<Word> optionalWord = wordRepository.findById(wordId);
        Word word = optionalWord.orElseThrow(() -> new NoSuchElementException("Word not found with ID: " + wordId));
        Chapter chapter = word.getChapter();

        Question question = new Question();

        List<String> examples = wordService.getRandomWords(wordId, 3);

        // 배열을 문자열로 변경하면서 인덱스 0번의 데이터로 고정
        String wordMeaningAsString = word.getWordMeaning().isEmpty() ? "" : word.getWordMeaning().get(0).toString();


        QuestionGetDto questionDto = questionMapper.entityToResponseDto(question);
        questionDto.setQuestionNum(updateQuestionNum());
        questionDto.setWordNum(word.getWordId());
        questionDto.setChapterNum(chapter.getChapterId());
        questionDto.setQuestionType(2L);
        questionDto.setQuestion(wordMeaningAsString);
        questionDto.setExamples(examples);
        questionDto.setTranslation("");
        questionDto.setCorrect(word.getWord());

        return questionDto;
    }

    //    [QuestionType 3] 발음을 듣고 스펠링 입력하기
    public QuestionGetDto pronunciationToSpellingSaq(Long wordId) {

        Optional<Word> optionalWord = wordRepository.findById(wordId);
        Word word = optionalWord.orElseThrow(() -> new NoSuchElementException("Word not found with ID: " + wordId));
        Chapter chapter = word.getChapter();

        Question question = new Question();

        QuestionGetDto questionDto = questionMapper.entityToResponseDto(question);
        questionDto.setQuestionNum(updateQuestionNum());
        questionDto.setWordNum(word.getWordId());
        questionDto.setChapterNum(chapter.getChapterId());
        questionDto.setQuestionType(3L);
        questionDto.setQuestion(word.getWord());
        questionDto.setExamples(Collections.singletonList(word.getWord())); //
        questionDto.setTranslation("");
        questionDto.setCorrect(word.getWord());

        return questionDto;
    }

    //    [QuestionType 4] 문장 빈칸 채우기
    public QuestionGetDto blankToWordMcq(Long wordId) {

        Optional<Word> optionalWord = wordRepository.findById(wordId);
        Word word = optionalWord.orElseThrow(() -> new NoSuchElementException("Word not found with ID: " + wordId));
        Chapter chapter = word.getChapter();

        Question question = new Question();

        String originalString = word.getWordExample().get(0);
        String replacedString = originalString.replaceAll(word.getWord().toLowerCase(), "_");

        List<String> examples = wordService.getRandomWords(wordId, 3);

        // 배열을 문자열로 변경하면서 인덱스 0번의 데이터로 고정
        String wordExampleMeaningAsString = word.getWordExampleMeaning().isEmpty() ? "" : word.getWordExampleMeaning().get(0);

        QuestionGetDto questionDto = questionMapper.entityToResponseDto(question);
        questionDto.setQuestionNum(updateQuestionNum());
        questionDto.setWordNum(word.getWordId());
        questionDto.setChapterNum(chapter.getChapterId());
        questionDto.setQuestionType(4L);
        questionDto.setQuestion(replacedString);
        questionDto.setExamples(examples);
        questionDto.setTranslation(wordExampleMeaningAsString);
        questionDto.setCorrect(word.getWord());

        return questionDto;
    }

    public int updateQuestionNum() {
        currentQuestionNum++;
        if (currentQuestionNum > 12) {
            currentQuestionNum = 1;
        }
        return currentQuestionNum;
    }

    public QuestionGetListDto getQuestion(Long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);
        QuestionGetListDto questionGetDto = QuestionMapper.INSTANCE.entityListToResponseDto(findQuestion);

        return questionGetDto;
    }

    public Question findVerifiedQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findByQuestionNum(questionId);

        if (optionalQuestion.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, 940, "QUESTION_NOT_FOUND");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalQuestion.get();
    }
}

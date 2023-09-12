package ILearn.word.service;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.mapper.WordMapper;
import ILearn.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public WordGetDto getWords(Long wordId) {
        Word findWord = findVerifiedWord(wordId);
        WordGetDto wordGetDto = WordMapper.INSTANCE.entityToResponseDto(findWord);

        return wordGetDto;
    }
    public Word findVerifiedWord(Long wordId) {
        Optional<Word> optionalWord = wordRepository.findById(wordId);

        if (optionalWord.isEmpty()) {
            ApiResponse<Void> response = new ApiResponse<>(false, 930, "WORD_NOT_FOUND");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalWord.get();
    }

    public List<String> getRandomWords(long wordId, int count) {
        List<Word> allWords = wordRepository.findAll();
        List<String> randomWords = new ArrayList<>();
        Random random = new Random();

//        WordId = 문제Id 에 해당하는 단어를 가져와서 먼저 리스트에 추가
        Optional<Word> wordById = wordRepository.findById(wordId);
        Word word = wordById.get();
        randomWords.add(word.getWord());

//        사지선다형이니 3개의 랜덤한 단어 + wordId 1개의 단어 추가
        while (randomWords.size() < count + 1 && allWords.size() > 0) {
            int randomIndex = random.nextInt(allWords.size());
            Word randomWord = allWords.get(randomIndex);

//            중복 컷
            if (!randomWords.contains(randomWord.getWord())) {
                randomWords.add(randomWord.getWord());
            }
            allWords.remove(randomIndex);
        }

        return randomWords;
    }

    public List<String> getRandomWordMeanings(long wordId, int count) {
        List<Word> allWords = wordRepository.findAll();
        List<String> randomWordMeanings = new ArrayList<>();
        Random random = new Random();

        Optional<Word> wordById = wordRepository.findById(wordId);
        Word word = wordById.get();
        randomWordMeanings.add(word.getWordMeaning());

        while (randomWordMeanings.size() < count + 1 && allWords.size() > 0) {
            int randomIndex = random.nextInt(allWords.size());
            Word randomWord = allWords.get(randomIndex);

//            중복 컷
            if (!randomWordMeanings.contains(randomWord.getWordMeaning())) {
                randomWordMeanings.add(randomWord.getWordMeaning());
            }
            allWords.remove(randomIndex);
        }

        return randomWordMeanings;
    }
}

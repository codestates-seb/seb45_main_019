package ILearn.word.service;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.entity.Member;
import ILearn.member.repository.MemberRepository;
import ILearn.word.dto.WordBookGetDto;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.mapper.WordMapper;
import ILearn.word.repository.WordRepository;
import ILearn.word.response.WordApiResponse;
import ILearn.word.response.WordBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;
    private final MemberRepository memberRepository;


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

    //유저 단어장 추가 로직
    public WordBookResponse addWordToVocabulary(Long userId, Long wordId) {
        if (userId == null) {
            return new WordBookResponse(false, "유저가 존재하지 않습니다", null);
        }

        Member member = memberRepository.findById(userId).orElse(null);
        Word word = wordRepository.findById(wordId).orElse(null);

        if (member != null && word != null) {
            // 사용자의 단어장에 WordId를 추가
            if (word.getMember() == null) {
                word.setMember(member);
                wordRepository.save(word);
                member.getWords().add(word);
                memberRepository.save(member);
            }

            return new WordBookResponse(true, "success", null);
        } else {
            return new WordBookResponse(false, "유저가 존재하지 않습니다", null);
        }
    }

    //유저 단어장 조회 로직
    public WordBookGetDto getUserPostedWordIds(Long userId) {
        if (userId == null) {
            return new WordBookGetDto(false, "UserId is missing", null);
        }

        Member member = memberRepository.findById(userId).orElse(null);
        if (member != null) {
            List<Long> wordIds = wordRepository.findAllByMemberUserId(userId)
                    .stream()
                    .map(Word::getWordId)
                    .collect(Collectors.toList());
            return new WordBookGetDto(true, "success", wordIds);
        } else {
            // 유저가 존재하지 않는 경우 또는 POST한 단어가 없는 경우 등에 대한 처리
            return new WordBookGetDto(false, "유저가 존재하지 않습니다", null);
        }
    }

    //유저 단어장 삭제 로직
    public boolean deleteWordFromVocabulary(Long userId, Long wordId) {
        if (userId == null || wordId == null) {
            return false; // 삭제 실패를 나타내는 값을 반환
        }

        Member member = memberRepository.findById(userId).orElse(null);
        Word word = wordRepository.findById(wordId).orElse(null);

        if (member != null && word != null) {
            // 해당 단어가 사용자의 단어장에 속해 있는 경우 삭제
            if (word.getMember() != null && word.getMember().getUserId().equals(userId)) {
                word.setMember(null);
                wordRepository.save(word);
                member.getWords().remove(word);
                memberRepository.save(member);
                return true; // 삭제 성공을 나타내는 값을 반환
            }
        }

        return false; // 삭제 실패를 나타내는 값을 반환
    }
}
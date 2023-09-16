package ILearn.word.service;

import ILearn.global.exception.GlobalException;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.entity.Member;
import ILearn.member.repository.MemberRepository;
import ILearn.word.dto.WordBookGetDto;
import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import ILearn.word.mapper.WordMapper;
import ILearn.word.repository.WordRepository;
import ILearn.word.response.WordBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;
    private final MemberRepository memberRepository;
    private final GlobalException globalException;


    // 단어 정보 조회
    public WordGetDto getWords(Long wordId) {

        // 단어가 존재하는지에 대한 유효성검사
        Word word = globalException.findVerifiedWord(wordId);

        WordGetDto wordGetDto = WordMapper.INSTANCE.entityToResponseDto(word);

        return wordGetDto;
    }

    // 유저 단어장 추가 로직
    public void addWordToVocabulary(Long userId, Long wordId) {

        // 회원이 존재하는지에 대한 유효성검사
        globalException.findVerifiedMember(userId);
        // 단어가 존재하는지에 대한 유효성검사
        globalException.findVerifiedWord(wordId);

        Member member = memberRepository.findById(userId).orElse(null);
        Word word = wordRepository.findById(wordId).orElse(null);

        word.setMember(member);
        wordRepository.save(word);
        member.getWords().add(word);
        memberRepository.save(member);

    }

    //유저 단어장 조회 로직
    public List<Long> getUserPostedWordIds(Long userId) {

        // 회원이 존재하는지에 대한 유효성검사
        globalException.findVerifiedMember(userId);

        // 회원의 단어장에 단어가 존재하는지에 대한 유효성 검사
        globalException.findVerifiedUserWord(userId);

        List<Long> wordIds = wordRepository.findAllByMemberUserId(userId)
                .stream()
                .map(Word::getWordId)
                .collect(Collectors.toList());

        return wordIds;
        }

    //유저 단어장 삭제 로직
    public void deleteWordFromVocabulary(Long userId, Long wordId) {

        // 회원이 존재하는지에 대한 유효성검사
        globalException.findVerifiedMember(userId);

        // 단어장 내 존재하는 단어가 삭제하려는 단어와 일치하는지에 대한 유효성검사
        globalException.checkVerifiedUserWord(userId, wordId);

        Member member = memberRepository.findById(userId).orElse(null);
        Word word = wordRepository.findById(wordId).orElse(null);

        if (member != null && word != null) {
            // 해당 단어가 사용자의 단어장에 속해 있는 경우 삭제
            if (word.getMember() != null && word.getMember().getUserId().equals(userId)) {
                word.setMember(null);
                wordRepository.save(word);
                member.getWords().remove(word);
                memberRepository.save(member);
            }
        }
    }

    //////// BusinessLogic ////////

    public List<String> getRandomWords(long wordId, int count) {
        List<Word> allWords = wordRepository.findAll();
        List<String> randomWords = new ArrayList<>();
        Random random = new Random();

//        WordId 에 해당하는 단어를 가져와서 먼저 리스트에 추가
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

    public String getRandomWordMeaning(long wordId) {
        Optional<Word> wordById = wordRepository.findById(wordId);
        Word word = wordById.get();

        // word.getWordMeaning() 배열에서 랜덤한 인덱스를 생성
        int randomIndex = new Random().nextInt(word.getWordMeaning().size());

        // 랜덤한 인덱스의 데이터를 반환
        return word.getWordMeaning().get(0);
    }

    public List<String> getRandomWordMeanings(long wordId, int count) {
        List<String> randomWordMeanings = new ArrayList<>();

        // 주어진 wordId에 해당하는 단어의 wordMeaning을 가져옴
        String randomWordMeaning = getRandomWordMeaning(wordId);
        randomWordMeanings.add(randomWordMeaning);

        // 나머지 데이터를 랜덤하게 채움
        List<Word> allWords = wordRepository.findAll();
        Random random = new Random();

        while (randomWordMeanings.size() < count + 1 && allWords.size() > 0) {
            int randomIndex = random.nextInt(allWords.size());
            Word randomWord = allWords.get(randomIndex);

            // 중복 제거
            String randomWordMeaningToAdd = getRandomWordMeaning(randomWord.getWordId());
            if (!randomWordMeanings.contains(randomWordMeaningToAdd)) {
                randomWordMeanings.add(randomWordMeaningToAdd);
            }
            allWords.remove(randomIndex);
        }

        return randomWordMeanings;
    }

}
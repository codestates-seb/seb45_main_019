package ILearn.global.exception;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.global.auth.loginDto.LoginDto;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.manage.entity.Manage;
import ILearn.manage.repository.ManageRepository;
import ILearn.member.dto.MemberPatchDto;
import ILearn.member.entity.Member;
import ILearn.member.repository.MemberRepository;
import ILearn.question.entity.Question;
import ILearn.question.repository.QuestionRepository;
import ILearn.word.entity.Word;
import ILearn.word.repository.WordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@RestControllerAdvice
public class GlobalException {
    private final Validator validator;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    private final ManageRepository manageRepository;
    private final ChapterRepository chapterRepository;
    private final WordRepository wordRepository;

//     = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
//     = = = = = = = = = = 데이터 존재 유무에 대한 유효성검사 = = = = = = = = = =
//     = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    // 회원이 존재하는지에 대한 유효성검사
    public Member findVerifiedMember(Long userId) {
        Optional<Member> optionalMember = memberRepository.findById(userId);

        if (optionalMember.isEmpty()) {
            ApiResponse<?> response = new ApiResponse<>(false, 911, "USER_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalMember.get();
    }

    // 회원의 챕터가 존재하는지에 대한 유효성검사
    public Manage findVerifiedUserChapter(Long userId, Long chapterId) {

        Optional<Manage> optionalManage = manageRepository.findByManageNumAndChapterId(userId, chapterId);

        if (optionalManage.isEmpty()) {
            ApiResponse<?> response = new ApiResponse<>(false, 920, "USER_CHAPTER_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalManage.get();
    }

    // 챕터가 존재하는지에 대한 유효성검사
    public Chapter findVerifiedChapter(Long chapterId) {

        Optional<Chapter> optionalChapter = chapterRepository.findById(chapterId);

        if (optionalChapter.isEmpty()) {
            ApiResponse<?> response = new ApiResponse<>(false, 930, "CHAPTER_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalChapter.get();
    }

    // 챕터에 문제가 존재하는지에 대한 유효성검사
    public Question findVerifiedQuestion(Long chapterId, Long questionNum) {

        Optional<Question> optionalQuestion = questionRepository.findByChapterNumAndQuestionNum(chapterId, questionNum);

        if (optionalQuestion.isEmpty()) {
            ApiResponse<?> response = new ApiResponse<>(false, 931, "QUESTION_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalQuestion.get();
    }

    // 단어가 존재하는지에 대한 유효성검사
    public Word findVerifiedWord(Long wordId) {

        Optional<Word> optionalWord = wordRepository.findById(wordId);

        if (optionalWord.isEmpty()) {
            ApiResponse<?> response = new ApiResponse<>(false, 940, "WORD_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalWord.get();
    }

    // 유저의 단어장에 단어가 존재하는지에 대한 유효성검사
    public List<Word> findVerifiedUserWord(Long userId) {

        List<Word> optionalWord = wordRepository.findAllByMemberUserId(userId);

        if (optionalWord.isEmpty()) {
            ApiResponse<?> response = new ApiResponse<>(false, 941, "USER_WORD_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return optionalWord;
    }

    // 비밀번호 유효성 검사


//     = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
//     = = = = = = = = = = 입력 데이터에 대한 유효성검사 = = = = = = = = = =
//     = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    // 회원가입 입력데이터에 대한 유효성검사
    public void checkForValidate(Member member) {

        // Dto의 애너테이션 유효성검사를 실행하고
        Set<ConstraintViolation<Member>> violations = validator.validate(member);

        // message 를 가져오며 ApiResponseException 에 담는 로직
        if (!violations.isEmpty()) {
            String errorMsg = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.joining(", "));

            throw new ApiResponseException(new ApiResponse<>(false, errorMsg), new RuntimeException(errorMsg));
        }
            if (memberRepository.existsByUsername(member.getUsername())) {
                throw new DuplicateFieldException("USERNAME", 900);
            }
            if (memberRepository.existsByNickname(member.getNickname())) {
                throw new DuplicateFieldException("NICKNAME", 901);
            }
        }


    // 회원수정 입력데이터에 대한 유효성검사
    public void patchCheckForValidate(MemberPatchDto patchDto) {

        // Dto의 애너테이션 유효성검사를 실행하고
        Set<ConstraintViolation<MemberPatchDto>> violations = validator.validate(patchDto);

        // message 를 가져오며 ApiResponseException 에 담는 로직
        if (!violations.isEmpty()) {
            String errorMsg = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .findFirst()
                    .orElse("유효성 검사에 실패했습니다(디폴트 메세지)");

            String replaceErrorMsg = errorMsg
                    .replace("nickname: ", "")
                    .replace("password: ", "");

            // 왜 methodArgumentExceptionHandler 메서드에서 가지고 오질 못할까...
            int errorCode = 0;

            if (replaceErrorMsg.contains("PASSWORD_NOT_BLANK")) {
                errorCode = 905;
            } else if (replaceErrorMsg.contains("PASSWORD_ERROR")) {
                errorCode = 906;
            } else if (replaceErrorMsg.contains("NICKNAME_NOT_BLANK")) {
                errorCode = 907;
            } else if (replaceErrorMsg.contains("NICKNAME_ERROR")) {
                errorCode = 908;
            }

            if (memberRepository.existsByNickname(patchDto.getNickname())) {
                throw new DuplicateFieldException("NICKNAME", 901);
            }
                throw new ApiResponseException(new ApiResponse<>(false, errorCode, replaceErrorMsg,""), new RuntimeException(replaceErrorMsg));
        }
    }

    // 회원탈퇴 시 회원 상태에 대한 유효성검사
    public Member deleteCheckMemberStatus (Long user_id) {

        // 회원이 존재하는지에 대한 유효성검사
        Member member = findVerifiedMember(user_id);

        // 회원상태가 이미 false 경우 예외 반환
        if(!member.isMemberStatus()) {
            ApiResponse<?> response = new ApiResponse<>(false,911,"USER_NOT_FOUND","");
            throw new ApiResponseException(response, new RuntimeException());
        }
        return member;
    }

    // 유저의 단어장에 삭제하려는 단어가 존재하는지에 대한 유효성검사
    public void checkVerifiedUserWord(Long userId, Long wordId) {

        List<Word> userWords = wordRepository.findAllByMemberUserId(userId);

        boolean wordExists = userWords.stream()
                .anyMatch(word -> word.getWordId().equals(wordId));

        if (!wordExists) {
            ApiResponse<?> response = new ApiResponse<>(false, 942, "DELETE_USER_WORD_NOT_FOUND", "");
            throw new ApiResponseException(response, new RuntimeException());
        }
    }


    // 애너테이션 유효성 검사 메세지 필터
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> methodArgumentExceptionHandler(MethodArgumentNotValidException e) {

        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("유효성 검사에 실패했습니다(디폴트 메시지)");

        int errorCode = 0;

        if (errorMessage.contains("USERNAME_NOT_BLANK")) {
            errorCode = 903;
        } else if(errorMessage.contains("USERNAME_ERROR")) {
            errorCode = 904;
        } else if (errorMessage.contains("PASSWORD_NOT_BLANK")) {
            errorCode = 905;
        } else if(errorMessage.contains("PASSWORD_ERROR")) {
            errorCode = 906;
        } else if (errorMessage.contains("NICKNAME_NOT_BLANK")) {
            errorCode = 907;
        } else if(errorMessage.contains("NICKNAME_ERROR")) {
            errorCode = 908;
        }

        return new ApiResponseException(new ApiResponse<>(false, errorCode, errorMessage, ""), e).getResponse();
    }
}

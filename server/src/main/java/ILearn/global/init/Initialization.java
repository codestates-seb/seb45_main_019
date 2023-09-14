package ILearn.global.init;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.question.entity.Question;
import ILearn.question.repository.QuestionRepository;
import ILearn.question.service.QuestionService;
import ILearn.word.entity.Word;
import ILearn.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class Initialization implements CommandLineRunner {
    private final WordRepository wordRepository;
    private final ChapterRepository chapterRepository;
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    public void run(String... args) {

        // 챕터 생성
        Chapter chapter1 = new Chapter();
        chapter1.setTitle("인사와 소통하기");

        Chapter chapter2 = new Chapter();
        chapter2.setTitle("인사와 소통하기");

        Chapter chapter3 = new Chapter();
        chapter3.setTitle("여행 중 도움 요청하기");

        Chapter chapter4 = new Chapter();
        chapter4.setTitle("질문하고 답변하기");

        Chapter chapter5 = new Chapter();
        chapter5.setTitle("날씨와 환경 이야기하기");

        Chapter chapter6 = new Chapter();
        chapter6.setTitle("상황 표현하기");

        Chapter chapter7 = new Chapter();
        chapter7.setTitle("요리하고 음식 만들기");

        Chapter chapter8 = new Chapter();
        chapter8.setTitle("대명사 활용하기");

        Chapter chapter9 = new Chapter();
        chapter9.setTitle("이웃과 대화하기");

        Chapter chapter10 = new Chapter();
        chapter10.setTitle("과거 사건 이야기하기");

        Chapter chapter11 = new Chapter();
        chapter11.setTitle("학교와 교육 공유하기");

        Chapter chapter12 = new Chapter();
        chapter12.setTitle("운동하고 스포츠 즐기기");

        Chapter chapter13 = new Chapter();
        chapter13.setTitle("예술과 문화 탐험하기");

        Chapter chapter14 = new Chapter();
        chapter14.setTitle("건강과 운동 논의하기");

        Chapter chapter15 = new Chapter();
        chapter15.setTitle("기술과 컴퓨터 이야기하기");

        Chapter chapter16 = new Chapter();
        chapter16.setTitle("환경과 지구과학 이해하기");

        Chapter chapter17 = new Chapter();
        chapter17.setTitle("역사와 과거 탐구하기");

        Chapter chapter18 = new Chapter();
        chapter18.setTitle("정치와 정부 이슈 토론하기");

        Chapter chapter19 = new Chapter();
        chapter19.setTitle("경제와 금융 알아보기");

        Chapter chapter20 = new Chapter();
        chapter20.setTitle("과학과 연구 이야기하기");

        Set<Long> existingChapterIds = new HashSet<>();
        List<Long> allChapterIds = chapterRepository.findAllChapterIds();
        existingChapterIds.addAll(allChapterIds);

        Chapter[] chapters = new Chapter[]{
                chapter1, chapter2, chapter3, chapter4, chapter5, chapter6, chapter7, chapter8, chapter9, chapter10,
                chapter11, chapter12, chapter13, chapter14, chapter15, chapter16, chapter17, chapter18, chapter19, chapter20};

        List<Chapter> chapterList = Arrays.asList(chapters);

        for (Chapter chapter : chapterList) {
            if (!existingChapterIds.contains(chapter.getChapterId())) {
                // 데이터베이스에 챕터가 존재하지 않으면 추가
                chapterRepository.save(chapter);
                existingChapterIds.add(chapter.getChapterId());
            }
        }

        // 단어 생성
        Word word1 = new Word();
        word1.setChapter(chapter1);
        word1.setWord("hello");
        word1.setSymbol("[hə''ləʊ]");
        word1.setWordMeaning(Arrays.asList("안녕하세요", "안녕"));
        word1.setDetailCategories(Arrays.asList("감탄사", "명사"));
        word1.setDetailDescriptions(Arrays.asList("인사말로 쓰이는 표현", "안부를 묻거나 인사를 할 때 사용"));
        word1.setWordExample(Arrays.asList("hello! How are you doing today?"));
        word1.setWordExampleMeaning(Arrays.asList("안녕하세요! 오늘 어떻게 지내세요?"));

        Word word2 = new Word();
        word2.setChapter(chapter1);
        word2.setWord("hi");
        word2.setSymbol("[haɪ]");
        word2.setWordMeaning(Arrays.asList("안녕", "안녕하세요"));
        word2.setDetailCategories(Arrays.asList("감탄사"));
        word2.setDetailDescriptions(Arrays.asList("인사말로 주로 비격식으로 사용", "친밀한 상황에서 자주 쓰임"));
        word2.setWordExample(Arrays.asList("hi! How''s it going?"));
        word2.setWordExampleMeaning(Arrays.asList("안녕! 어떻게 지내?"));

        Word word3 = new Word();
        word3.setChapter(chapter1);
        word3.setWord("greetings");
        word3.setSymbol("[ˈɡriːtɪŋz]");
        word3.setWordMeaning(Arrays.asList("인사", "인사말"));
        word3.setDetailCategories(Arrays.asList("명사"));
        word3.setDetailDescriptions(Arrays.asList("인사말이나 환영의 표현, 친절한 환영을 나타낼 때 사용"));
        word3.setWordExample(Arrays.asList("greetings from our team!"));
        word3.setWordExampleMeaning(Arrays.asList("저희 팀에서 인사 드립니다!"));

        Word word4 = new Word();
        word4.setChapter(chapter2);
        word4.setWord("shopping");
        word4.setSymbol("[ˈʃɑːpɪŋ]");
        word4.setWordMeaning(Arrays.asList("쇼핑"));
        word4.setDetailCategories(Arrays.asList("명사"));
        word4.setDetailDescriptions(Arrays.asList("상품을 사거나 찾는 활동, 상점이나 온라인에서 물건을 사거나 찾는 행위"));
        word4.setWordExample(Arrays.asList("I enjoy shopping on weekends."));
        word4.setWordExampleMeaning(Arrays.asList("주말에 쇼핑을 즐깁니다."));

        Word word5 = new Word();
        word5.setChapter(chapter2);
        word5.setWord("purchase");
        word5.setSymbol("[ˈpɜːrtʃəs]");
        word5.setWordMeaning(Arrays.asList("구매", "구입"));
        word5.setDetailCategories(Arrays.asList("동사", "명사"));
        word5.setDetailDescriptions(Arrays.asList("물건을 사다, 구입하다, 구매한 물품"));
        word5.setWordExample(Arrays.asList("I need to purchase some groceries."));
        word5.setWordExampleMeaning(Arrays.asList("식료품을 구매해야 해요."));

        Word word6 = new Word();
        word6.setChapter(chapter2);
        word6.setWord("order");
        word6.setSymbol("[ˈɔːrdər]");
        word6.setWordMeaning(Arrays.asList("주문", "주문하다"));
        word6.setDetailCategories(Arrays.asList("동사", "명사"));
        word6.setDetailDescriptions(Arrays.asList("물건이나 서비스를 요청하거나 구입하기 위해 매장에 보내는 요청, 주문하다, 요청하다"));
        word6.setWordExample(Arrays.asList("I would like to order a pizza."));
        word6.setWordExampleMeaning(Arrays.asList("피자를 주문하려고 해요."));

        Word word7 = new Word();
        word7.setChapter(chapter3);
        word7.setWord("help");
        word7.setSymbol("[help]");
        word7.setWordMeaning(Arrays.asList("도움", "도움말"));
        word7.setDetailCategories(Arrays.asList("동사", "명사"));
        word7.setDetailDescriptions(Arrays.asList("도움이 필요한 상황, 도움을 주다, 돕다"));
        word7.setWordExample(Arrays.asList("Can you help me with my luggage?"));
        word7.setWordExampleMeaning(Arrays.asList("내 짐 좀 도와줄래요?"));

        Word word8 = new Word();
        word8.setChapter(chapter3);
        word8.setWord("assistance");
        word8.setSymbol("[əˈsɪstəns]");
        word8.setWordMeaning(Arrays.asList("지원", "지원을 요청하다"));
        word8.setDetailCategories(Arrays.asList("명사"));
        word8.setDetailDescriptions(Arrays.asList("도움이나 지원을 나타내는 표현, 지원, 도움말"));
        word8.setWordExample(Arrays.asList("I need some assistance with directions."));
        word8.setWordExampleMeaning(Arrays.asList("길 안내를 도와주실 수 있을까요?"));

        Word word9 = new Word();
        word9.setChapter(chapter3);
        word9.setWord("emergency");
        word9.setSymbol("[ɪˈmɜːrdʒənsi]");
        word9.setWordMeaning(Arrays.asList("긴급 상황", "비상"));
        word9.setDetailCategories(Arrays.asList("명사"));
        word9.setDetailDescriptions(Arrays.asList("긴급한 상황이나 위급한 상황을 나타내는 표현, 긴급 사태"));
        word9.setWordExample(Arrays.asList("Call 911 in case of an emergency."));
        word9.setWordExampleMeaning(Arrays.asList("긴급 상황 시 911로 전화하세요."));

        Word word10 = new Word();
        word10.setChapter(chapter4);
        word10.setWord("question");
        word10.setSymbol("[ˈkwɛsʧən]");
        word10.setWordMeaning(Arrays.asList("질문"));
        word10.setDetailCategories(Arrays.asList("명사", "동사"));
        word10.setDetailDescriptions(Arrays.asList("정보를 얻기 위해 묻는 문장, 질문하다"));
        word10.setWordExample(Arrays.asList("Can I ask you a question?"));
        word10.setWordExampleMeaning(Arrays.asList("질문 좀 할 수 있을까요?"));

        Word word11 = new Word();
        word11.setChapter(chapter4);
        word11.setWord("answer");
        word11.setSymbol("[ˈænsər]");
        word11.setWordMeaning(Arrays.asList("대답", "답변"));
        word11.setDetailCategories(Arrays.asList("동사", "명사"));
        word11.setDetailDescriptions(Arrays.asList("질문에 대한 응답, 대답하다"));
        word11.setWordExample(Arrays.asList("I don’t know the answer."));
        word11.setWordExampleMeaning(Arrays.asList("저는 답을 모르겠어요."));

        Word word12 = new Word();
        word12.setChapter(chapter4);
        word12.setWord("query");
        word12.setSymbol("[kwɪri]");
        word12.setWordMeaning(Arrays.asList("조회"));
        word12.setDetailCategories(Arrays.asList("동사", "명사"));
        word12.setDetailDescriptions(Arrays.asList("정보를 얻기 위해 데이터베이스나 검색 엔진에서 입력하는 문장, 질문하다"));
        word12.setWordExample(Arrays.asList("I have a query about my reservation."));
        word12.setWordExampleMeaning(Arrays.asList("예약에 대한 질문이 있어요."));

        Word word13 = new Word();
        word13.setChapter(chapter5);
        word13.setWord("weather");
        word13.setSymbol("[ˈwɛðər]");
        word13.setWordMeaning(Arrays.asList("날씨"));
        word13.setDetailCategories(Arrays.asList("명사"));
        word13.setDetailDescriptions(Arrays.asList("대기 상태, 날씨에 대한 정보"));
        word13.setWordExample(Arrays.asList("The weather is beautiful today."));
        word13.setWordExampleMeaning(Arrays.asList("오늘 날씨가 아주 좋아요."));

        Word word14 = new Word();
        word14.setChapter(chapter5);
        word14.setWord("forecast");
        word14.setSymbol("[ˈfɔːrˌkæst]");
        word14.setWordMeaning(Arrays.asList("예보", "예측"));
        word14.setDetailCategories(Arrays.asList("명사", "동사"));
        word14.setDetailDescriptions(Arrays.asList("날씨에 대한 예상, 예보하다"));
        word14.setWordExample(Arrays.asList("The weather forecast says it will rain tomorrow."));
        word14.setWordExampleMeaning(Arrays.asList("날씨 예보에 따르면 내일 비가 올 것 같아요."));

        Word word15 = new Word();
        word15.setChapter(chapter5);
        word15.setWord("temperature");
        word15.setSymbol("[ˈtɛmpərəʧər]");
        word15.setWordMeaning(Arrays.asList("온도"));
        word15.setDetailCategories(Arrays.asList("명사"));
        word15.setDetailDescriptions(Arrays.asList("기온의 정도, 온도에 대한 정보"));
        word15.setWordExample(Arrays.asList("The temperature is dropping."));
        word15.setWordExampleMeaning(Arrays.asList("기온이 내려가고 있어요."));

        Word word16 = new Word();
        word16.setChapter(chapter6);
        word16.setWord("currently");
        word16.setSymbol("[ˈkʌrəntli]");
        word16.setWordMeaning(Arrays.asList("현재", "현재로서"));
        word16.setDetailCategories(Arrays.asList("부사"));
        word16.setDetailDescriptions(Arrays.asList("지금, 현재 시점에서, 현재 상태에 관한 정보를 전달"));
        word16.setWordExample(Arrays.asList("I am currently working on a project."));
        word16.setWordExampleMeaning(Arrays.asList("지금 저는 프로젝트를 진행 중이에요."));

        Word word17 = new Word();
        word17.setChapter(chapter6);
        word17.setWord("ongoing");
        word17.setSymbol("[ˈɔnˌɡoʊɪŋ]");
        word17.setWordMeaning(Arrays.asList("진행 중인", "계속되는"));
        word17.setDetailCategories(Arrays.asList("형용사"));
        word17.setDetailDescriptions(Arrays.asList("현재 진행 중인, 끊임없이 진행되는, 지속되는"));
        word17.setWordExample(Arrays.asList("The investigation is ongoing."));
        word17.setWordExampleMeaning(Arrays.asList("수사는 계속되고 있어요."));

        Word word18 = new Word();
        word18.setChapter(chapter6);
        word18.setWord("presently");
        word18.setSymbol("[ˈprɛzəntli]");
        word18.setWordMeaning(Arrays.asList("현재", "곧"));
        word18.setDetailCategories(Arrays.asList("부사"));
        word18.setDetailDescriptions(Arrays.asList("지금, 현재 시점에서, 가까운 미래에"));
        word18.setWordExample(Arrays.asList("I will be there presently."));
        word18.setWordExampleMeaning(Arrays.asList("곧 거기 도착할 거에요."));

        Word word19 = new Word();
        word19.setChapter(chapter7);
        word19.setWord("cook");
        word19.setSymbol("[kʊk]");
        word19.setWordMeaning(Arrays.asList("요리하다"));
        word19.setDetailCategories(Arrays.asList("동사"));
        word19.setDetailDescriptions(Arrays.asList("음식을 만들거나 조리하는 행위, 요리하다"));
        word19.setWordExample(Arrays.asList("I love to cook Italian food."));
        word19.setWordExampleMeaning(Arrays.asList("이탈리안 음식을 요리하는 것을 좋아해요."));

        Word word20 = new Word();
        word20.setChapter(chapter7);
        word20.setWord("recipe");
        word20.setSymbol("[ˈrɛsəpi]");
        word20.setWordMeaning(Arrays.asList("레시피", "조리법"));
        word20.setDetailCategories(Arrays.asList("명사"));
        word20.setDetailDescriptions(Arrays.asList("음식을 만들기 위한 지침서, 레시피에 따라 요리하다"));
        word20.setWordExample(Arrays.asList("I found a great recipe for chocolate cake."));
        word20.setWordExampleMeaning(Arrays.asList("초콜릿 케이크를 만들기 위한 훌륭한 레시피를 찾았어요."));

        Word word21 = new Word();
        word21.setChapter(chapter7);
        word21.setWord("taste");
        word21.setSymbol("[teɪst]");
        word21.setWordMeaning(Arrays.asList("맛", "미각"));
        word21.setDetailCategories(Arrays.asList("명사", "동사"));
        word21.setDetailDescriptions(Arrays.asList("음식의 맛, 맛보다, 시식하다"));
        word21.setWordExample(Arrays.asList("The taste of the soup is amazing."));
        word21.setWordExampleMeaning(Arrays.asList("이 스프의 맛은 놀라울 정도로 좋아요."));

        Word word22 = new Word();
        word22.setChapter(chapter8);
        word22.setWord("he");
        word22.setSymbol("[hi]");
        word22.setWordMeaning(Arrays.asList("그", "남자"));
        word22.setDetailCategories(Arrays.asList("대명사"));
        word22.setDetailDescriptions(Arrays.asList("남성을 가리키는 대명사, 그 사람을 나타내는 단어"));
        word22.setWordExample(Arrays.asList("He is my brother."));
        word22.setWordExampleMeaning(Arrays.asList("그는 내 동생이에요."));

        Word word23 = new Word();
        word23.setChapter(chapter8);
        word23.setWord("she");
        word23.setSymbol("[ʃi]");
        word23.setWordMeaning(Arrays.asList("그녀", "여자"));
        word23.setDetailCategories(Arrays.asList("대명사"));
        word23.setDetailDescriptions(Arrays.asList("여성을 가리키는 대명사, 그 여자를 나타내는 단어"));
        word23.setWordExample(Arrays.asList("She is a talented singer."));
        word23.setWordExampleMeaning(Arrays.asList("그녀는 재능 있는 가수에요."));

        Word word24 = new Word();
        word24.setChapter(chapter8);
        word24.setWord("they");
        word24.setSymbol("[ðeɪ]");
        word24.setWordMeaning(Arrays.asList("그들", "그들은"));
        word24.setDetailCategories(Arrays.asList("대명사"));
        word24.setDetailDescriptions(Arrays.asList("여러 사람을 가리키는 대명사, 그들을 나타내는 단어"));
        word24.setWordExample(Arrays.asList("They are going on a vacation."));
        word24.setWordExampleMeaning(Arrays.asList("그들은 휴가를 떠나요."));

        Word word25 = new Word();
        word25.setChapter(chapter9);
        word25.setWord("neighbor");
        word25.setSymbol("[ˈneɪbər]");
        word25.setWordMeaning(Arrays.asList("이웃"));
        word25.setDetailCategories(Arrays.asList("명사"));
        word25.setDetailDescriptions(Arrays.asList("주변에 살고 있는 사람, 인근 거주자"));
        word25.setWordExample(Arrays.asList("My neighbor is very friendly."));
        word25.setWordExampleMeaning(Arrays.asList("내 이웃은 아주 친절해요."));

        Word word26 = new Word();
        word26.setChapter(chapter9);
        word26.setWord("chat");
        word26.setSymbol("[ʧæt]");
        word26.setWordMeaning(Arrays.asList("대화", "이야기"));
        word26.setDetailCategories(Arrays.asList("명사", "동사"));
        word26.setDetailDescriptions(Arrays.asList("무언가에 대해 이야기하거나 대화하는 행위, 대화하다"));
        word26.setWordExample(Arrays.asList("Let's have a chat with our neighbors."));
        word26.setWordExampleMeaning(Arrays.asList("이웃들과 대화를 나눠봐요."));

        Word word27 = new Word();
        word27.setChapter(chapter9);
        word27.setWord("friendly");
        word27.setSymbol("[ˈfrɛndli]");
        word27.setWordMeaning(Arrays.asList("친근한", "친절한"));
        word27.setDetailCategories(Arrays.asList("형용사"));
        word27.setDetailDescriptions(Arrays.asList("친근하고 친절한, 우호적인"));
        word27.setWordExample(Arrays.asList("My neighbor is very friendly and helpful."));
        word27.setWordExampleMeaning(Arrays.asList("내 이웃은 아주 친근하고 도움이 많이 됩니다."));

        Word word28 = new Word();
        word28.setChapter(chapter10);
        word28.setWord("past");
        word28.setSymbol("[pæst]");
        word28.setWordMeaning(Arrays.asList("과거"));
        word28.setDetailCategories(Arrays.asList("명사", "형용사"));
        word28.setDetailDescriptions(Arrays.asList("과거에 있었던 일, 과거의"));
        word28.setWordExample(Arrays.asList("In the past, I used to live in a different city."));
        word28.setWordExampleMeaning(Arrays.asList("과거에는 다른 도시에 살았어요."));

        Word word29 = new Word();
        word29.setChapter(chapter10);
        word29.setWord("recalled");
        word29.setSymbol("[rɪˈkɔːld]");
        word29.setWordMeaning(Arrays.asList("회상하다", "상기하다"));
        word29.setDetailCategories(Arrays.asList("동사"));
        word29.setDetailDescriptions(Arrays.asList("기억하고 다시 떠올리다, 상기하다"));
        word29.setWordExample(Arrays.asList("I recalled the memories of my childhood."));
        word29.setWordExampleMeaning(Arrays.asList("어린 시절의 추억을 회상했어요."));

        Word word30 = new Word();
        word30.setChapter(chapter10);
        word30.setWord("visited");
        word30.setSymbol("[ˈvɪzɪtɪd]");
        word30.setWordMeaning(Arrays.asList("방문하다"));
        word30.setDetailCategories(Arrays.asList("동사"));
        word30.setDetailDescriptions(Arrays.asList("어떤 장소를 방문하거나 갔던 일, 방문하다"));
        word30.setWordExample(Arrays.asList("Last summer, I visited Paris."));
        word30.setWordExampleMeaning(Arrays.asList("지난 여름에 파리를 방문했어요."));

        Word word31 = new Word();
        word31.setChapter(chapter11);
        word31.setWord("homework");
        word31.setSymbol("[ˈhoʊmwɜːrk]");
        word31.setWordMeaning(Arrays.asList("숙제"));
        word31.setDetailCategories(Arrays.asList("명사"));
        word31.setDetailDescriptions(Arrays.asList("학교에서 주어진 과제, 집에서 수행해야 하는 학습 과제"));
        word31.setWordExample(Arrays.asList("I have a lot of homework to do tonight."));
        word31.setWordExampleMeaning(Arrays.asList("오늘 밤에 할 숙제가 많아."));

        Word word32 = new Word();
        word32.setChapter(chapter11);
        word32.setWord("teacher");
        word32.setSymbol("[ˈtiːʧər]");
        word32.setWordMeaning(Arrays.asList("선생님", "교사"));
        word32.setDetailCategories(Arrays.asList("명사"));
        word32.setDetailDescriptions(Arrays.asList("학생을 가르치거나 교육하는 사람, 선생님"));
        word32.setWordExample(Arrays.asList("My teacher is very knowledgeable."));
        word32.setWordExampleMeaning(Arrays.asList("제 선생님은 아주 지식이 풍부해요."));

        Word word33 = new Word();
        word33.setChapter(chapter11);
        word33.setWord("exam");
        word33.setSymbol("[ɪgˈzæm]");
        word33.setWordMeaning(Arrays.asList("시험"));
        word33.setDetailCategories(Arrays.asList("명사"));
        word33.setDetailDescriptions(Arrays.asList("학교나 대학에서 치르는 평가, 시험을 보다"));
        word33.setWordExample(Arrays.asList("I have an important exam next week."));
        word33.setWordExampleMeaning(Arrays.asList("다음 주에 중요한 시험이 있어요."));

        Word word34 = new Word();
        word34.setChapter(chapter12);
        word34.setWord("exercise");
        word34.setSymbol("[ˈɛksərˌsaɪz]");
        word34.setWordMeaning(Arrays.asList("운동"));
        word34.setDetailCategories(Arrays.asList("명사", "동사"));
        word34.setDetailDescriptions(Arrays.asList("신체 활동, 운동을 하다"));
        word34.setWordExample(Arrays.asList("Regular exercise is important for staying healthy."));
        word34.setWordExampleMeaning(Arrays.asList("규칙적인 운동은 건강을 유지하는 데 중요해요."));

        Word word35 = new Word();
        word35.setChapter(chapter12);
        word35.setWord("athlete");
        word35.setSymbol("[ˈæθliːt]");
        word35.setWordMeaning(Arrays.asList("운동선수"));
        word35.setDetailCategories(Arrays.asList("명사"));
        word35.setDetailDescriptions(Arrays.asList("스포츠에서 경기하는 사람, 운동선수"));
        word35.setWordExample(Arrays.asList("She is a talented athlete in swimming."));
        word35.setWordExampleMeaning(Arrays.asList("그녀는 수영에서 재능 있는 운동선수에요."));

        Word word36 = new Word();
        word36.setChapter(chapter12);
        word36.setWord("team");
        word36.setSymbol("[tiːm]");
        word36.setWordMeaning(Arrays.asList("팀", "단체"));
        word36.setDetailCategories(Arrays.asList("명사"));
        word36.setDetailDescriptions(Arrays.asList("한 그룹을 이루는 사람들, 단체 또는 팀"));
        word36.setWordExample(Arrays.asList("Our soccer team won the championship."));
        word36.setWordExampleMeaning(Arrays.asList("우리 축구팀이 챔피언이 되었어요."));

        Word word37 = new Word();
        word37.setChapter(chapter13);
        word37.setWord("art");
        word37.setSymbol("[ɑːrt]");
        word37.setWordMeaning(Arrays.asList("예술"));
        word37.setDetailCategories(Arrays.asList("명사"));
        word37.setDetailDescriptions(Arrays.asList("창작적인 표현, 미술, 예술 작품"));
        word37.setWordExample(Arrays.asList("I appreciate the beauty of art."));
        word37.setWordExampleMeaning(Arrays.asList("나는 예술의 아름다움을 감상해."));

        Word word38 = new Word();
        word38.setChapter(chapter13);
        word38.setWord("music");
        word38.setSymbol("[ˈmjuːzɪk]");
        word38.setWordMeaning(Arrays.asList("음악"));
        word38.setDetailCategories(Arrays.asList("명사"));
        word38.setDetailDescriptions(Arrays.asList("소리로 이루어진 예술 형태, 음악 장르"));
        word38.setWordExample(Arrays.asList("She has a great passion for music."));
        word38.setWordExampleMeaning(Arrays.asList("그녀는 음악에 대한 열정이 커."));

        Word word39 = new Word();
        word39.setChapter(chapter13);
        word39.setWord("culture");
        word39.setSymbol("[ˈkʌlʧər]");
        word39.setWordMeaning(Arrays.asList("문화"));
        word39.setDetailCategories(Arrays.asList("명사"));
        word39.setDetailDescriptions(Arrays.asList("특정 지역 또는 사회 집단의 전통, 예술, 식생활 등, 문화적 특성"));
        word39.setWordExample(Arrays.asList("Learning about different cultures can be fascinating."));
        word39.setWordExampleMeaning(Arrays.asList("다양한 문화에 대해 배우는 것은 매우 흥미로울 수 있어."));

        Word word40 = new Word();
        word40.setChapter(chapter14);
        word40.setWord("health");
        word40.setSymbol("[hɛlθ]");
        word40.setWordMeaning(Arrays.asList("건강"));
        word40.setDetailCategories(Arrays.asList("명사"));
        word40.setDetailDescriptions(Arrays.asList("신체적, 정신적으로 잘 느끼는 상태, 건강에 대한 관심"));
        word40.setWordExample(Arrays.asList("Good health is essential for a happy life."));
        word40.setWordExampleMeaning(Arrays.asList("좋은 건강은 행복한 삶에 필수적이에요."));

        Word word41 = new Word();
        word41.setChapter(chapter14);
        word41.setWord("nutrition");
        word41.setSymbol("[nuˈtrɪʃən]");
        word41.setWordMeaning(Arrays.asList("영양"));
        word41.setDetailCategories(Arrays.asList("명사"));
        word41.setDetailDescriptions(Arrays.asList("음식물로부터 얻는 영양소, 영양 학습"));
        word41.setWordExample(Arrays.asList("A balanced diet is important for proper nutrition."));
        word41.setWordExampleMeaning(Arrays.asList("균형 잡힌 식사는 올바른 영양 공급에 중요해요."));

        Word word42 = new Word();
        word42.setChapter(chapter14);
        word42.setWord("exercise");
        word42.setSymbol("[ˈɛksərˌsaɪz]");
        word42.setWordMeaning(Arrays.asList("운동"));
        word42.setDetailCategories(Arrays.asList("명사", "동사"));
        word42.setDetailDescriptions(Arrays.asList("신체 활동, 운동을 하다"));
        word42.setWordExample(Arrays.asList("Regular exercise helps maintain physical fitness."));
        word42.setWordExampleMeaning(Arrays.asList("규칙적인 운동은 신체 건강을 유지하는 데 도움이 됩니다."));

        Word word43 = new Word();
        word43.setChapter(chapter15);
        word43.setWord("computer");
        word43.setSymbol("[kəmˈpjuːtər]");
        word43.setWordMeaning(Arrays.asList("컴퓨터"));
        word43.setDetailCategories(Arrays.asList("명사"));
        word43.setDetailDescriptions(Arrays.asList("정보를 처리하고 저장하는 전자 장치, 컴퓨터 과학"));
        word43.setWordExample(Arrays.asList("I use a computer for work and entertainment."));
        word43.setWordExampleMeaning(Arrays.asList("나는 업무와 취미에 컴퓨터를 사용해."));

        Word word44 = new Word();
        word44.setChapter(chapter15);
        word44.setWord("software");
        word44.setSymbol("[ˈsɒftwɛr]");
        word44.setWordMeaning(Arrays.asList("소프트웨어"));
        word44.setDetailCategories(Arrays.asList("명사"));
        word44.setDetailDescriptions(Arrays.asList("컴퓨터 프로그램 및 애플리케이션, 소프트웨어 개발"));
        word44.setWordExample(Arrays.asList("I need to install the latest software update."));
        word44.setWordExampleMeaning(Arrays.asList("최신 소프트웨어 업데이트를 설치해야 해요."));

        Word word45 = new Word();
        word45.setChapter(chapter15);
        word45.setWord("internet");
        word45.setSymbol("[ˈɪntərnɛt]");
        word45.setWordMeaning(Arrays.asList("인터넷"));
        word45.setDetailCategories(Arrays.asList("명사"));
        word45.setDetailDescriptions(Arrays.asList("세계 각지의 컴퓨터 네트워크, 인터넷 서비스"));
        word45.setWordExample(Arrays.asList("I browse the internet to find information."));
        word45.setWordExampleMeaning(Arrays.asList("나는 정보를 찾기 위해 인터넷을 둘러봐."));

        Word word46 = new Word();
        word46.setChapter(chapter16);
        word46.setWord("environment");
        word46.setSymbol("[ɪnˈvaɪrənmənt]");
        word46.setWordMeaning(Arrays.asList("환경"));
        word46.setDetailCategories(Arrays.asList("명사"));
        word46.setDetailDescriptions(Arrays.asList("주변 자연과 물리적 조건, 환경 보호"));
        word46.setWordExample(Arrays.asList("We need to protect the environment for future generations."));
        word46.setWordExampleMeaning(Arrays.asList("미래 세대를 위해 환경을 보호해야 해."));

        Word word47 = new Word();
        word47.setChapter(chapter16);
        word47.setWord("climate");
        word47.setSymbol("[klaɪmət]");
        word47.setWordMeaning(Arrays.asList("기후"));
        word47.setDetailCategories(Arrays.asList("명사"));
        word47.setDetailDescriptions(Arrays.asList("특정 지역의 평균 날씨 조건, 기후 연구"));
        word47.setWordExample(Arrays.asList("Climate change is a global concern."));
        word47.setWordExampleMeaning(Arrays.asList("기후 변화는 전 세계적인 문제입니다."));

        Word word48 = new Word();
        word48.setChapter(chapter16);
        word48.setWord("earthquake");
        word48.setSymbol("[ɜːrθˌkweɪk]");
        word48.setWordMeaning(Arrays.asList("지진"));
        word48.setDetailCategories(Arrays.asList("명사"));
        word48.setDetailDescriptions(Arrays.asList("지구의 지각 이동, 지진 발생"));
        word48.setWordExample(Arrays.asList("An earthquake can cause significant damage."));
        word48.setWordExampleMeaning(Arrays.asList("지진은 중대한 피해를 일으킬 수 있어."));

        Word word49 = new Word();
        word49.setChapter(chapter17);
        word49.setWord("history");
        word49.setSymbol("[ˈhɪstəri]");
        word49.setWordMeaning(Arrays.asList("역사"));
        word49.setDetailCategories(Arrays.asList("명사"));
        word49.setDetailDescriptions(Arrays.asList("과거 사건과 사람들의 기록, 역사 공부"));
        word49.setWordExample(Arrays.asList("Studying history helps us understand the past."));
        word49.setWordExampleMeaning(Arrays.asList("역사를 공부하면 과거를 이해하는 데 도움이 돼."));

        Word word50 = new Word();
        word50.setChapter(chapter17);
        word50.setWord("ancient");
        word50.setSymbol("[ˈeɪnʃənt]");
        word50.setWordMeaning(Arrays.asList("고대의"));
        word50.setDetailCategories(Arrays.asList("형용사"));
        word50.setDetailDescriptions(Arrays.asList("오래된 시대의, 고대 문명과 관련된"));
        word50.setWordExample(Arrays.asList("The ancient Egyptians built the pyramids."));
        word50.setWordExampleMeaning(Arrays.asList("고대 이집트인들은 피라미드를 건설했어요."));

        Word word51 = new Word();
        word51.setChapter(chapter17);
        word51.setWord("civilization");
        word51.setSymbol("[ˌsɪvɪlaɪˈzeɪʃən]");
        word51.setWordMeaning(Arrays.asList("문명"));
        word51.setDetailCategories(Arrays.asList("명사"));
        word51.setDetailDescriptions(Arrays.asList("고도의 문화, 사회 발전, 문명 학습"));
        word51.setWordExample(Arrays.asList("The Indus Valley Civilization is one of the oldest in history."));
        word51.setWordExampleMeaning(Arrays.asList("인더스 고원 문명은 역사상 가장 오래된 것 중 하나에 속합니다."));

        Word word52 = new Word();
        word52.setChapter(chapter18);
        word52.setWord("government");
        word52.setSymbol("[ˈɡʌvərmənt]");
        word52.setWordMeaning(Arrays.asList("정부"));
        word52.setDetailCategories(Arrays.asList("명사"));
        word52.setDetailDescriptions(Arrays.asList("나라나 지역을 통치하는 기관, 정부 조직"));
        word52.setWordExample(Arrays.asList("The government is responsible for making laws."));
        word52.setWordExampleMeaning(Arrays.asList("정부는 법을 만드는 역할을 합니다."));

        Word word53 = new Word();
        word53.setChapter(chapter18);
        word53.setWord("politics");
        word53.setSymbol("[ˈpɑːlətɪks]");
        word53.setWordMeaning(Arrays.asList("정치"));
        word53.setDetailCategories(Arrays.asList("명사"));
        word53.setDetailDescriptions(Arrays.asList("정치 활동 및 정부 운영, 정치 과학"));
        word53.setWordExample(Arrays.asList("She has a strong interest in politics."));
        word53.setWordExampleMeaning(Arrays.asList("그녀는 정치에 큰 관심을 가지고 있어요."));

        Word word54 = new Word();
        word54.setChapter(chapter18);
        word54.setWord("democracy");
        word54.setSymbol("[dɪˈmɑːkrəsi]");
        word54.setWordMeaning(Arrays.asList("민주주의"));
        word54.setDetailCategories(Arrays.asList("명사"));
        word54.setDetailDescriptions(Arrays.asList("시민이 투표로 정치적 결정을 내리는 제도, 민주주의 원칙"));
        word54.setWordExample(Arrays.asList("Many countries aspire to establish democracy."));
        word54.setWordExampleMeaning(Arrays.asList("많은 나라가 민주주의를 확립하려고 노력하고 있습니다."));

        Word word55 = new Word();
        word55.setChapter(chapter19);
        word55.setWord("economy");
        word55.setSymbol("[ɪˈkɑːnəmi]");
        word55.setWordMeaning(Arrays.asList("경제"));
        word55.setDetailCategories(Arrays.asList("명사"));
        word55.setDetailDescriptions(Arrays.asList("자원 생산과 분배, 경제학 연구"));
        word55.setWordExample(Arrays.asList("The economy of the country is growing rapidly."));
        word55.setWordExampleMeaning(Arrays.asList("그 나라의 경제는 빠르게 성장하고 있습니다."));

        Word word56 = new Word();
        word56.setChapter(chapter19);
        word56.setWord("business");
        word56.setSymbol("[ˈbɪznɪs]");
        word56.setWordMeaning(Arrays.asList("비즈니스, 사업"));
        word56.setDetailCategories(Arrays.asList("명사"));
        word56.setDetailDescriptions(Arrays.asList("상업 및 거래 활동, 사업 관리"));
        word56.setWordExample(Arrays.asList("She runs her own successful business."));
        word56.setWordExampleMeaning(Arrays.asList("그녀는 자신의 성공한 비즈니스를 운영하고 있어요."));

        Word word57 = new Word();
        word57.setChapter(chapter19);
        word57.setWord("market");
        word57.setSymbol("[ˈmɑːrkɪt]");
        word57.setWordMeaning(Arrays.asList("시장"));
        word57.setDetailCategories(Arrays.asList("명사"));
        word57.setDetailDescriptions(Arrays.asList("상품이나 서비스를 사고 팔 수 있는 장소, 시장 조사"));
        word57.setWordExample(Arrays.asList("The stock market can be unpredictable."));
        word57.setWordExampleMeaning(Arrays.asList("주식 시장은 예측하기 어려울 수 있어."));

        Word word58 = new Word();
        word58.setChapter(chapter20);
        word58.setWord("science");
        word58.setSymbol("[ˈsaɪəns]");
        word58.setWordMeaning(Arrays.asList("과학"));
        word58.setDetailCategories(Arrays.asList("명사"));
        word58.setDetailDescriptions(Arrays.asList("자연 현상을 탐구하고 이해하는 분야, 과학 연구"));
        word58.setWordExample(Arrays.asList("She has a passion for science and discovery."));
        word58.setWordExampleMeaning(Arrays.asList("그녀는 과학과 발견에 대한 열정을 가지고 있어."));

        Word word59 = new Word();
        word59.setChapter(chapter20);
        word59.setWord("experiment");
        word59.setSymbol("[ɪkˈspɛrəmənt]");
        word59.setWordMeaning(Arrays.asList("실험"));
        word59.setDetailCategories(Arrays.asList("명사", "동사"));
        word59.setDetailDescriptions(Arrays.asList("과학적 관찰이나 조사, 실험을 하다"));
        word59.setWordExample(Arrays.asList("The experiment yielded interesting results."));
        word59.setWordExampleMeaning(Arrays.asList("그 실험은 흥미로운 결과를 얻었습니다."));

        Word word60 = new Word();
        word60.setChapter(chapter20);
        word60.setWord("discovery");
        word60.setSymbol("[dɪˈskʌvəri]");
        word60.setWordMeaning(Arrays.asList("발견, 발견물"));
        word60.setDetailCategories(Arrays.asList("명사"));
        word60.setDetailDescriptions(Arrays.asList("새로운 사실이나 물건을 찾아내는 행위, 발견한 것"));
        word60.setWordExample(Arrays.asList("The discovery of penicillin revolutionized medicine."));
        word60.setWordExampleMeaning(Arrays.asList("페니실린의 발견은 의학을 혁신했습니다."));

        Set<Long> existingWordIds = new HashSet<>();
        List<Long> allWordIds = wordRepository.findAllWordIds();
        existingWordIds.addAll(allWordIds);

        Word[] words = new Word[]{
                word1, word2, word3, word4, word5, word6, word7, word8, word9, word10,
                word11, word12, word13, word14, word15, word16, word17, word18, word19, word20,
                word21, word22, word23, word24, word25, word26, word27, word28, word29, word30,
                word31, word32, word33, word34, word35, word36, word37, word38, word39, word40,
                word41, word42, word43, word44, word45, word46, word47, word48, word49, word50,
                word51, word52, word53, word54, word55, word56, word57, word58, word59, word60};

        List<Word> wordList = Arrays.asList(words);

        for (Word word : wordList) {
            if (!existingWordIds.contains(word.getWordId())) {

                wordRepository.save(word);
                existingChapterIds.add(word.getWordId());
            }
        }

        // 문제 생성

        Set<Long> existingQuestionIds = new HashSet<>();
        List<Long> allQuestionIds = questionRepository.findAllQuestionIds();
        existingQuestionIds.addAll(allQuestionIds);

        for (Long wordId = 1L; wordId <= 60L; wordId++) {
            List<Question> generatedQuestions = questionService.generateQuestionsByWordId(wordId);
            for (Question question : generatedQuestions) {
                Long questionId = question.getQuestionId();
                if (!existingQuestionIds.contains(questionId)) {
                    // 데이터베이스에 존재하지 않으면 추가
                    questionRepository.save(question);
                    existingQuestionIds.add(questionId);
                }
            }
        }
    }
}


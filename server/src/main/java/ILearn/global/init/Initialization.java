package ILearn.global.init;

import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;

import ILearn.member.entity.Member;
import ILearn.member.service.MemberService;
import ILearn.question.entity.Question;
import ILearn.question.repository.QuestionRepository;
import ILearn.question.service.QuestionService;
import ILearn.word.entity.Word;
import ILearn.word.entity.WordDescription;
import ILearn.word.repository.WordRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
@RequiredArgsConstructor
@Transactional
public class Initialization implements CommandLineRunner {
    private final WordRepository wordRepository;
    private final ChapterRepository chapterRepository;
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    private final MemberService memberService;

    @Transactional
    public void run(String... args) {

        // 챕터 생성
        Chapter chapter1 = new Chapter();
        chapter1.setTitle("인사와 소통하기");
        chapter1.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter2 = new Chapter();
        chapter2.setTitle("인사와 소통하기");
        chapter2.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter3 = new Chapter();
        chapter3.setTitle("여행 중 도움 요청하기");
        chapter3.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter4 = new Chapter();
        chapter4.setTitle("질문하고 답변하기");
        chapter4.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter5 = new Chapter();
        chapter5.setTitle("날씨와 환경 이야기하기");
        chapter5.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter6 = new Chapter();
        chapter6.setTitle("상황 표현하기");
        chapter6.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter7 = new Chapter();
        chapter7.setTitle("요리하고 음식 만들기");
        chapter7.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter8 = new Chapter();
        chapter8.setTitle("대명사 활용하기");
        chapter8.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter9 = new Chapter();
        chapter9.setTitle("이웃과 대화하기");
        chapter9.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter10 = new Chapter();
        chapter10.setTitle("과거 사건 이야기하기");
        chapter10.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter11 = new Chapter();
        chapter11.setTitle("학교와 교육 공유하기");
        chapter11.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter12 = new Chapter();
        chapter12.setTitle("운동하고 스포츠 즐기기");
        chapter12.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter13 = new Chapter();
        chapter13.setTitle("예술과 문화 탐험하기");
        chapter13.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter14 = new Chapter();
        chapter14.setTitle("건강과 운동 논의하기");
        chapter14.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter15 = new Chapter();
        chapter15.setTitle("기술과 컴퓨터 이야기하기");
        chapter15.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter16 = new Chapter();
        chapter16.setTitle("환경과 지구과학 이해하기");
        chapter16.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter17 = new Chapter();
        chapter17.setTitle("역사와 과거 탐구하기");
        chapter17.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter18 = new Chapter();
        chapter18.setTitle("정치와 정부 이슈 토론하기");
        chapter18.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter19 = new Chapter();
        chapter19.setTitle("경제와 금융 알아보기");
        chapter19.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

        Chapter chapter20 = new Chapter();
        chapter20.setTitle("과학과 연구 이야기하기");
        chapter20.setQuestionId(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);

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

        // 단어1 : hello
        Word word1 = new Word();
        word1.setChapter(chapter1);
        word1.setWord("hello");
        word1.setSymbol("[həˈloʊ]");
        word1.setWordMeaning(Arrays.asList("안녕", "안녕하세요", "안부"));

        word1.setWordExample(Arrays.asList(
                "hello, how are you?",
                "She greeted her friend with a warm hello.",
                "I just wanted to say hello and catch up."
        ));

        word1.setWordExampleMeaning(Arrays.asList(
                "안녕하세요, 어떠세요?",
                "그녀는 친구를 따뜻한 인사로 맞이했습니다.",
                "그냥 인사를 드리고 소식을 나누고 싶었어요."
        ));

        List<WordDescription> detailDescriptions1 = new ArrayList<>();

        WordDescription description1 = new WordDescription();
        description1.setCategory("감탄사");
        description1.setDescriptions(Arrays.asList(
                "인사말로 쓰이는 표현으로, 다른 사람과 친근하게 인사를 나누거나 대화를 시작할 때 사용됩니다.",
                "사람들 간의 소통을 원활하게 하는데 도움을 주며, 상호 간에 안부를 묻거나 인사를 할 때 자주 사용되는 표현입니다.",
                "대화를 시작하거나 상대방과 친근한 분위기를 조성하기 위한 기본적인 인사말입니다."
        ));
        detailDescriptions1.add(description1);

        WordDescription description2 = new WordDescription();
        description2.setCategory("명사");
        description2.setDescriptions(Arrays.asList(
                "사람들 간의 인사 또는 대화를 나타내는 말로, 소통의 시작 또는 끝을 나타내며 상호 간의 친근한 관계 형성에 기여합니다.",
                "친근한 분위기를 조성하기 위한 기본적인 단어로, 상대방과의 소통을 원할하게 만들어주는 역할을 합니다.",
                "이 단어는 다양한 상황에서 사용되며, 누구나 이해할 수 있는 친숙한 표현 중 하나입니다."
        ));
        detailDescriptions1.add(description2);

        word1.setDetailDescriptions(detailDescriptions1);

        // 단어2 : goodbye
        Word word2 = new Word();
        word2.setChapter(chapter1);
        word2.setWord("goodbye");
        word2.setSymbol("[ɡʊdˈbaɪ]");
        word2.setWordMeaning(Arrays.asList("안녕히 가세요", "작별 인사"));

        word2.setWordExample(Arrays.asList(
                "She waved and said goodbye as she left the party.",
                "When it was time to leave, he bid everyone a warm goodbye.",
                "Saying goodbye to her friends at the airport was a bittersweet moment."
        ));

        word2.setWordExampleMeaning(Arrays.asList(
                "그녀는 파티를 떠날 때 손을 흔들며 작별 인사를 했습니다.",
                "떠날 때, 그는 모두에게 따뜻한 작별 인사를 했습니다.",
                "공항에서 친구들에게 작별 인사하는 것은 아쉬운 순간이었습니다."
        ));

        List<WordDescription> detailDescriptions2 = new ArrayList<>();

        WordDescription description3 = new WordDescription();
        description3.setCategory("감탄사");
        description3.setDescriptions(Arrays.asList(
                "떠날 때 또는 작별할 때 사용하는 표현으로, 상대방에게 좋은 인사를 전하는 의미를 가지고 있습니다.",
                "친구, 가족, 동료 등과 작별할 때 사용되며, 안녕히 가세요를 나타내는 인사말 중 하나입니다.",
                "떠날 때 상대방에게 좋은 소원을 전하고자 할 때 사용하는 표현 중 하나입니다."
        ));
        detailDescriptions2.add(description3);

        WordDescription description4 = new WordDescription();
        description4.setCategory("명사");
        description4.setDescriptions(Arrays.asList(
                "작별 또는 떠남을 나타내는 말로, 언제든지 사용될 수 있습니다.",
                "사람들 간의 작별 인사를 나타내는 표현 중 하나입니다.",
                "작별의 순간이나 상황을 지칭할 때 사용되며, 감정을 담을 수 있는 단어 중 하나입니다."
        ));
        detailDescriptions2.add(description4);

        word2.setDetailDescriptions(detailDescriptions2);

        // 단어3 : greetings
        Word word3 = new Word();
        word3.setChapter(chapter1);
        word3.setWord("greetings");
        word3.setSymbol("[ˈɡriːtɪŋz]");
        word3.setWordMeaning(Arrays.asList("인사", "환영", "인사말"));

        word3.setWordExample(Arrays.asList(
                "greetings, everyone! How are you today?",
                "The mayor gave a warm welcome and greetings to the guests.",
                "In many cultures, exchanging greetings is a common social practice."
        ));

        word3.setWordExampleMeaning(Arrays.asList(
                "안녕하세요, 여러분! 오늘은 어떻게 지내세요?",
                "시장은 손님들에게 따뜻한 환영과 인사를 했습니다.",
                "많은 문화에서 인사를 나누는 것은 흔한 사회적 관행입니다."
        ));

        List<WordDescription> detailDescriptions3 = new ArrayList<>();

        WordDescription description5 = new WordDescription();
        description5.setCategory("명사");
        description5.setDescriptions(Arrays.asList(
                "사람들 간의 인사 또는 환영을 나타내는 말로, 소통의 시작 또는 끝을 나타내며 상호 간의 친근한 관계 형성에 기여합니다.",
                "친밀한 모임, 회의, 소셜 이벤트 등에서 자주 사용되는 표현 중 하나이며, 다양한 문화와 언어에서 다양한 형태로 나타납니다."
        ));
        detailDescriptions3.add(description5);

        WordDescription description6 = new WordDescription();
        description6.setCategory("감탄사");
        description6.setDescriptions(Arrays.asList(
                "인사나 환영을 나타내는 감탄사로, 사람들 간의 친근한 관계 형성과 상호 간의 인사를 나타내는 의미를 가지고 있습니다.",
                "다양한 문화와 언어에서 사용되며, 사람들을 환영하거나 인사할 때 자주 들립니다."
        ));
        detailDescriptions3.add(description6);

        word3.setDetailDescriptions(detailDescriptions3);

        // 단어4 : shopping
        Word word4 = new Word();
        word4.setChapter(chapter2);
        word4.setWord("shopping");
        word4.setSymbol("[ˈʃɑːpɪŋ]");
        word4.setWordMeaning(Arrays.asList("쇼핑", "쇼핑하다", "구매"));

        word4.setWordExample(Arrays.asList(
                "She enjoys shopping for clothes at the mall.",
                "I need to go shopping for groceries this weekend.",
                "Online shopping has become increasingly popular."
        ));

        word4.setWordExampleMeaning(Arrays.asList(
                "그녀는 쇼핑몰에서 옷을 사는 것을 즐깁니다.",
                "이번 주말에 식료품 쇼핑을 가야 해요.",
                "온라인 쇼핑은 점점 더 인기를 얻고 있습니다."
        ));

        List<WordDescription> detailDescriptions4 = new ArrayList<>();

        WordDescription description7 = new WordDescription();
        description7.setCategory("명사");
        description7.setDescriptions(Arrays.asList(
                "상품이나 제품을 구매하거나 살 때 사용되는 용어로, 대개 상점, 쇼핑몰, 온라인 플랫폼 등에서 이루어집니다.",
                "쇼핑은 생활 속에서 필수적인 활동 중 하나로, 의류, 식료품, 전자제품 등을 구매할 때 사용되는 표현 중 하나입니다.",
                "쇼핑은 또한 여가나 기분 전환의 일환으로도 즐겨 이루어지는 활동 중 하나입니다."
        ));
        detailDescriptions4.add(description7);

        WordDescription description8 = new WordDescription();
        description8.setCategory("동사");
        description8.setDescriptions(Arrays.asList(
                "상품이나 제품을 구매하거나 살 때 사용되는 동작을 나타내는 용어로, '쇼핑하다'의 동사형입니다.",
                "쇼핑은 대개 상점이나 쇼핑몰에서 이루어지며, 원하는 제품을 찾아 구매하는 행위를 뜻합니다.",
                "사람들은 의류, 신발, 가전제품 등을 구매하기 위해 쇼핑을 하며, 가끔은 물건 찾기와 비교도 하게 됩니다."
        ));
        detailDescriptions4.add(description8);

        word4.setDetailDescriptions(detailDescriptions4);

        // 단어5 : purchase
        Word word5 = new Word();
        word5.setChapter(chapter2);
        word5.setWord("purchase");
        word5.setSymbol("[ˈpɜːrʧəs]");
        word5.setWordMeaning(Arrays.asList("구매", "매입", "구입하다"));

        word5.setWordExample(Arrays.asList(
                "I need to purchase a new laptop for work.",
                "The company made a large purchase of raw materials.",
                "Customers can easily purchase products online."
        ));

        word5.setWordExampleMeaning(Arrays.asList(
                "일을 위해 새 노트북을 구매해야 합니다.",
                "회사가 대량의 원자재를 매입했습니다.",
                "고객들은 쉽게 제품을 온라인으로 구입할 수 있습니다."
        ));

        List<WordDescription> detailDescriptions5 = new ArrayList<>();

        WordDescription description10 = new WordDescription();
        description10.setCategory("동사");
        description10.setDescriptions(Arrays.asList(
                "상품이나 제품을 돈을 주고 구매하거나 매입하는 동작을 나타내는 용어로, '구매하다', '매입하다'의 동사형입니다.",
                "구매는 다양한 물건이나 서비스에 적용되며, 소매점, 온라인 플랫폼 등을 통해 이루어집니다.",
                "구매는 개인적인 필요뿐만 아니라 기업이나 조직의 운영과 관련된 비즈니스 활동에도 사용됩니다."
        ));
        detailDescriptions5.add(description10);

        word5.setDetailDescriptions(detailDescriptions5);


        // 단어6 : order
        Word word6 = new Word();
        word6.setChapter(chapter2);
        word6.setWord("order");
        word6.setSymbol("[ˈɔːrdər]");
        word6.setWordMeaning(Arrays.asList("주문", "명령", "순서"));

        word6.setWordExample(Arrays.asList(
                "I'd like to place an order for a pizza, please.",
                "The general issued an order to the troops to advance.",
                "Please arrange the books on the shelf in alphabetical order."
        ));

        word6.setWordExampleMeaning(Arrays.asList(
                "피자 주문을 하려고 합니다, 부탁합니다.",
                "장군은 군대에 진군 명령을 내렸습니다.",
                "책들을 책장에 알파벳 순으로 정렬해주세요."
        ));

        List<WordDescription> detailDescriptions6 = new ArrayList<>();

        WordDescription description11 = new WordDescription();
        description11.setCategory("명사");
        description11.setDescriptions(Arrays.asList(
                "제품, 음식, 서비스 등을 구매하거나 받기 위해 제공하는 요청 또는 지시로, 주로 상점, 레스토랑, 온라인 플랫폼에서 이루어집니다.",
                "주문은 다양한 형태로 나타날 수 있으며, 고객이 원하는 것을 지정하는데 사용됩니다."
        ));
        detailDescriptions6.add(description11);

        WordDescription description12 = new WordDescription();
        description12.setCategory("동사");
        description12.setDescriptions(Arrays.asList(
                "제품이나 서비스를 주문하거나 요청하는 동작을 나타내는 용어로, '주문하다', '요청하다'의 동사형입니다.",
                "주로 식당에서 음식을 주문하거나 온라인 쇼핑에서 상품을 주문하는 등 다양한 상황에서 사용됩니다."
        ));
        detailDescriptions6.add(description12);

        word6.setDetailDescriptions(detailDescriptions6);

        // 단어7 : help
        Word word7 = new Word();
        word7.setChapter(chapter3);
        word7.setWord("help");
        word7.setSymbol("[help]");
        word7.setWordMeaning(Arrays.asList("도움", "지원", "돕다"));

        word7.setWordExample(Arrays.asList(
                "Can you help me carry these heavy bags?",
                "The lifeguard rushed to help the drowning swimmer in a moment of urgency.",
                "I need some help with my challenging homework assignment."
        ));

        word7.setWordExampleMeaning(Arrays.asList(
                "이 무거운 가방들을 나 좀 도와줄 수 있을까요?",
                "구명원수는 위급한 순간에 의식을 잃은 수영자를 돕기 위해 급히 움직였다.",
                "난 어려운 숙제 과제에 대해 도움이 필요해요."
        ));

        List<WordDescription> detailDescriptions7 = new ArrayList<>();

        WordDescription description13 = new WordDescription();
        description13.setCategory("동사");
        description13.setDescriptions(Arrays.asList(
                "동사 형태로 사용되며, 다른 사람에게 도움이나 지원을 제공하거나 돕는 행위를 나타냅니다.",
                "누군가에게 필요한 지원을 제공하거나 어떤 문제를 해결하는 데 기여할 수 있습니다.",
                "예를 들어, 친구에게 숙제를 돕다, 길을 잃은 사람에게 안내를 해주다, 비상 상황에서 구조 대원으로서 활동하다 등 다양한 상황에서 사용됩니다."
        ));
        detailDescriptions7.add(description13);

        WordDescription description14 = new WordDescription();
        description14.setCategory("명사");
        description14.setDescriptions(Arrays.asList(
                "명사 형태로 사용되며, '도움을 받는 것'을 의미합니다. 다른 사람 또는 단체로부터 지원을 받거나 어려움을 해결하는 데 도움이 되는 것을 가리킵니다.",
                "예를 들어, 친구의 도움을 받아 어려운 과제를 완료하거나, 비상 상황에서 구조 대원의 도움을 받을 수 있습니다.",
                "또한, 일상 생활에서 다양한 상황에서 필요한 지원이나 협력을 나타내는 표현으로 자주 사용됩니다."
        ));
        detailDescriptions7.add(description14);

        word7.setDetailDescriptions(detailDescriptions7);

        // 단어8: assistance // 품사 분기점
        Word word8 = new Word();
        word8.setChapter(chapter3);
        word8.setWord("assistance");
        word8.setSymbol("[əˈsɪstəns]");
        word8.setWordMeaning(Arrays.asList("도움", "지원"));

        word8.setWordExample(Arrays.asList(
                "She offered her assistance to the elderly man in carrying his groceries.",
                "The company provides financial assistance to employees in need.",
                "Please seek medical assistance if you experience any health issues."
        ));

        word8.setWordExampleMeaning(Arrays.asList(
                "그녀는 노인 남자가 장을 들고 가는데 도움을 제안했습니다.",
                "그 회사는 필요한 직원에게 금융 지원을 제공합니다.",
                "건강 문제를 경험하면 의료 지원을 받으십시오."
        ));

        List<WordDescription> detailDescriptions8 = new ArrayList<>();

        WordDescription description15 = new WordDescription();
        description15.setCategory("명사");
        description15.setDescriptions(Arrays.asList(
                "명사 형태로 사용되며, 다른 사람 또는 단체로부터 도움 또는 지원을 제공받는 것을 나타냅니다.",
                "어떤 일을 수행하거나 어려움을 극복하는 데 필요한 외부 도움이나 지원을 가리킵니다."
        ));
        detailDescriptions8.add(description15);

        WordDescription description16 = new WordDescription();
        description16.setCategory("동사");
        description16.setDescriptions(Arrays.asList(
                "동사 형태로 사용되며, 다른 사람에게 도움이나 지원을 제공하거나 돕는 행위를 나타냅니다.",
                "누군가가 도움을 필요로 할 때 그들을 돕는 행동을 가리킵니다."
        ));
        detailDescriptions8.add(description16);

        word8.setDetailDescriptions(detailDescriptions8);


        // 단어9 : emergency
        Word word9 = new Word();
        word9.setChapter(chapter3);
        word9.setWord("emergency");
        word9.setSymbol("[ɪˈmɜːrdʒənsi]");
        word9.setWordMeaning(Arrays.asList("긴급 상황", "비상", "급박한 상태"));

        word9.setWordExample(Arrays.asList(
                "In case of an emergency, please dial 911 for immediate assistance.",
                "The hospital has a dedicated emergency department for critical cases.",
                "We need to address this issue as an emergency."
        ));

        word9.setWordExampleMeaning(Arrays.asList(
                "긴급한 상황이 발생한 경우 즉시 도움을 요청하기 위해 911로 전화하십시오.",
                "병원은 중대한 경우를 위한 별도의 응급실을 갖고 있습니다.",
                "우리는 이 문제를 긴급 상황으로 처리해야 합니다."
        ));

        List<WordDescription> detailDescriptions9 = new ArrayList<>();

        WordDescription description17 = new WordDescription();
        description17.setCategory("명사");
        description17.setDescriptions(Arrays.asList(
                "명사 형태로 사용되며, 갑작스러운 위기 상황이나 긴급한 상황을 나타냅니다.",
                "사소한 문제에서부터 생명이 위험에 처한 상황까지 다양한 상황을 포함합니다.",
                "긴급한 조치나 대처가 필요한 상황을 가리킵니다."
        ));
        detailDescriptions9.add(description17);

        word9.setDetailDescriptions(detailDescriptions9);


        // 단어10 : question
        Word word10 = new Word();
        word10.setChapter(chapter4);
        word10.setWord("question");
        word10.setSymbol("[ˈkwɛsʧən]");
        word10.setWordMeaning(Arrays.asList("질문", "의문", "문제"));

        word10.setWordExample(Arrays.asList(
                "He asked a question about the upcoming project.",
                "The teacher encouraged students to ask questions during the lecture.",
                "There is a question regarding the accuracy of the data."
        ));

        word10.setWordExampleMeaning(Arrays.asList(
                "그는 다가오는 프로젝트에 관한 질문을 했습니다.",
                "선생님은 강의 중에 학생들이 질문을 하도록 장려했습니다.",
                "데이터의 정확성에 관한 의문이 있습니다."
        ));

        List<WordDescription> detailDescriptions10 = new ArrayList<>();

        WordDescription description18 = new WordDescription();
        description18.setCategory("명사");
        description18.setDescriptions(Arrays.asList(
                "명사 형태로 사용되며, 정보를 얻거나 의사 소통을 위해 무엇을 묻거나 조사하는 언어 표현을 나타냅니다.",
                "주로 누군가에게 답변을 얻기 위해 사용되며, 다양한 주제와 의미에 적용됩니다.",
                "질문은 또한 의문이나 불확실성을 나타내는 데에도 사용됩니다."
        ));
        detailDescriptions10.add(description18);

        word10.setDetailDescriptions(detailDescriptions10);

        // 단어11 : answer
        Word word11 = new Word();
        word11.setChapter(chapter4);
        word11.setWord("answer");
        word11.setSymbol("[ˈænsər]");
        word11.setWordMeaning(Arrays.asList("대답", "답변", "해답"));

        word11.setWordExample(Arrays.asList(
                "She provided a detailed answer to the question.",
                "The answer to the puzzle was hidden in the last paragraph.",
                "He couldn't find the right answer to the math problem."
        ));

        word11.setWordExampleMeaning(Arrays.asList(
                "그녀는 그 질문에 자세한 답변을 제공했습니다.",
                "그 퍼즐의 해답은 마지막 단락에 숨겨져 있었습니다.",
                "그는 그 수학 문제에 대한 올바른 대답을 찾지 못했습니다."
        ));

        List<WordDescription> detailDescriptions11 = new ArrayList<>();

        WordDescription description19 = new WordDescription();
        description19.setCategory("동사");
        description19.setDescriptions(Arrays.asList(
                "동사 형태로 사용되며, 질문에 대해 대답하거나 응답하는 행위를 나타냅니다.",
                "질문, 문제 또는 요구에 대한 응답으로 정보나 해결책을 제공하는 행동을 포함합니다."
        ));
        detailDescriptions11.add(description19);

        WordDescription description20 = new WordDescription();
        description20.setCategory("명사");
        description20.setDescriptions(Arrays.asList(
                "명사 형태로 사용되며, 질문 또는 문제에 대한 해답이나 응답을 가리킵니다.",
                "또한 대회나 시험에서 정답을 나타내기 위해 사용되기도 합니다."
        ));
        detailDescriptions11.add(description20);

        word11.setDetailDescriptions(detailDescriptions11);


        // 단어12 : query //  setDescription 문장 수정분기
        Word word12 = new Word();
        word12.setChapter(chapter4);
        word12.setWord("query");
        word12.setSymbol("[ˈkwɪri]");
        word12.setWordMeaning(Arrays.asList("질문하다", "조사하다", "의문을 제기하다"));

        word12.setWordExample(Arrays.asList(
                "She decided to query the results of the survey.",
                "The detective queried the witness for more information.",
                "I'm going to query the manager about the delay in the project."
        ));

        word12.setWordExampleMeaning(Arrays.asList(
                "그녀는 설문 조사 결과에 의문을 제기하기로 결정했습니다.",
                "형사는 더 많은 정보를 얻기 위해 목격자에게 질문을 했습니다.",
                "나는 프로젝트 지연에 대해 관리자에게 질문할 예정입니다."
        ));

        List<WordDescription> detailDescriptions12 = new ArrayList<>();

        WordDescription description21 = new WordDescription();
        description21.setCategory("동사");
        description21.setDescriptions(Arrays.asList(
                "질문하거나 조사하여 정보나 답변을 얻으려는 행동을 나타냅니다.",
                "주로 정보나 데이터를 찾거나 확인하기 위해 사용되며, 의문을 제기하거나 탐구하는 것을 의미합니다."
        ));
        detailDescriptions12.add(description21);

        WordDescription description22 = new WordDescription();
        description22.setCategory("명사");
        description22.setDescriptions(Arrays.asList(
                "명사 형태로 사용되며, 질문 또는 조사에 대한 결과물을 나타내기 위해 사용됩니다.",
                "데이터베이스에서 정보를 검색하거나 특정 질문에 대한 답변을 의미할 수 있습니다."
        ));
        detailDescriptions12.add(description22);

        word12.setDetailDescriptions(detailDescriptions12);

        // 단어13 : weather
        Word word13 = new Word();
        word13.setChapter(chapter5);
        word13.setWord("weather");
        word13.setSymbol("[ˈwɛðər]");
        word13.setWordMeaning(Arrays.asList("날씨", "기상"));

        word13.setWordExample(Arrays.asList(
                "The weather forecast predicts rain for tomorrow.",
                "We should check the weather before planning our outdoor activities.",
                "The weather in this region can be unpredictable."
        ));

        word13.setWordExampleMeaning(Arrays.asList(
                "날씨 예보에 따르면 내일 비가 올 것으로 예상됩니다.",
                "야외 활동을 계획하기 전에 날씨를 확인해야 합니다.",
                "이 지역의 날씨는 예측하기 어려울 수 있습니다."
        ));

        List<WordDescription> detailDescriptions13 = new ArrayList<>();

        WordDescription description23 = new WordDescription();
        description23.setCategory("명사");
        description23.setDescriptions(Arrays.asList(
                "대기 상태와 기후 현상을 나타내는 말로, 특정 장소나 시간에 대한 기상 조건을 의미합니다.",
                "온도, 강수량, 바람의 세기 등을 포함하는 날씨 정보는 일상 생활에서 중요한 역할을 합니다."
        ));
        detailDescriptions13.add(description23);

        word13.setDetailDescriptions(detailDescriptions13);


        // 단어14 : forecast
        Word word14 = new Word();
        word14.setChapter(chapter5);
        word14.setWord("forecast");
        word14.setSymbol("[ˈfɔrˌkæst]");
        word14.setWordMeaning(Arrays.asList("예보", "예측", "예상"));

        word14.setWordExample(Arrays.asList(
                "The weather forecast predicts sunny skies for the weekend.",
                "Economists forecast an increase in consumer spending.",
                "The forecast for the stock market is uncertain."
        ));

        word14.setWordExampleMeaning(Arrays.asList(
                "날씨 예보에 따르면 주말에 맑은 날씨가 예상됩니다.",
                "경제학자들은 소비자 지출의 증가를 예측하고 있습니다.",
                "주식 시장에 대한 예측은 불확실합니다."
        ));

        List<WordDescription> detailDescriptions14 = new ArrayList<>();

        WordDescription description24 = new WordDescription();
        description24.setCategory("동사");
        description24.setDescriptions(Arrays.asList(
                "미래의 사건 또는 현상을 예상하거나 예측하는 행동을 나타냅니다.",
                "날씨, 경제, 시장 동향 등 다양한 분야에서 예측이 중요한 역할을 합니다."
        ));
        detailDescriptions14.add(description24);

        WordDescription description25 = new WordDescription();
        description25.setCategory("명사");
        description25.setDescriptions(Arrays.asList(
                "미래의 사건 또는 상황을 예측하는 결과물을 가리키며, 주로 날씨 예보나 경제 전망을 나타냅니다.",
                "예측된 정보를 기반으로 의사 결정을 내리거나 준비를 하는 데 사용됩니다."
        ));
        detailDescriptions14.add(description25);

        word14.setDetailDescriptions(detailDescriptions14);


        // 단어15 : temperature 예문 길이 수정분기 -> 아마 최종
        Word word15 = new Word();
        word15.setChapter(chapter5);
        word15.setWord("temperature");
        word15.setSymbol("[ˈtɛmpərətʃər]");
        word15.setWordMeaning(Arrays.asList("온도", "기온", "체온"));

        word15.setWordExample(Arrays.asList(
                "The temperature in summer can reach over 30 degrees Celsius.",
                "Please check the room temperature before adjusting the thermostat.",
                "A high fever can cause a rise in body temperature."
        ));

        word15.setWordExampleMeaning(Arrays.asList(
                "여름에는 온도가 섭씨 30도를 넘을 수 있습니다.",
                "온도 조절기를 조정하기 전에 방 온도를 확인해 주세요.",
                "높은 열은 체온 상승을 일으킬 수 있습니다."
        ));

        List<WordDescription> descriptions15 = new ArrayList<>();

        WordDescription description26 = new WordDescription();
        description26.setCategory("명사");
        description26.setDescriptions(Arrays.asList(
                "온도, 기온, 물체나 공간의 열 측정 단위로, 날씨, 환경, 물체의 열적 특성을 나타냅니다.",
                "기온을 나타내는 중요한 지표 중 하나이며, 섭씨(Celsius)나 화씨(Fahrenheit) 등의 체계로 표현됩니다.",
                "날씨 예보, 과학 연구, 기상 관측, 냉난방 시스템 조절 등 다양한 분야에서 사용됩니다."
        ));
        descriptions15.add(description26);

        WordDescription description27 = new WordDescription();
        description27.setCategory("동사");
        description27.setDescriptions(Arrays.asList(
                "온도를 측정하거나 기록하는 행위로, 일반적으로 온도계나 기상 관측 장비를 사용하여 이루어집니다.",
                "냉난방 장치의 설정을 조절하거나 열 관리를 위해 사용되며, 안전 및 편의를 위해 필요한 작업 중 하나입니다."
        ));
        descriptions15.add(description27);

        WordDescription description28 = new WordDescription();
        description28.setCategory("명사구");
        description28.setDescriptions(Arrays.asList(
                "날씨 예보, 기상 관측, 환경 모니터링 등과 관련된 온도 측정 및 기록 작업을 나타내는 말입니다.",
                "냉난방 시스템에서의 온도 설정, 열 관리, 온도에 따른 활동 계획 등에 사용되며, 다양한 응용 분야에서 활용됩니다."
        ));
        descriptions15.add(description28);

        word15.setDetailDescriptions(descriptions15);

        // 단어16 : currently
        Word word16 = new Word();
        word16.setChapter(chapter6);
        word16.setWord("currently");
        word16.setSymbol("[ˈkɜːrəntli]");
        word16.setWordMeaning(Arrays.asList("현재는", "지금은", "현재 상태로"));

        word16.setWordExample(Arrays.asList(
                "I am currently studying for my exams.",
                "The project is currently in progress.",
                "He is currently working at a tech company."
        ));

        word16.setWordExampleMeaning(Arrays.asList(
                "지금 시점에서 나는 시험 공부 중이다.",
                "프로젝트는 현재 진행 중이다.",
                "그는 현재 기술 회사에서 일하고 있다."
        ));

        List<WordDescription> descriptions16 = new ArrayList<>();

        WordDescription description56 = new WordDescription();
        description56.setCategory("부사");
        description56.setDescriptions(Arrays.asList(
                "현재 시점에서, 현재의 상태로, 현재 시간에 대한 상태, 상황 또는 동작을 나타냅니다.",
                "현재의 일이나 상황을 강조하기 위해 사용되며, 현재 진행 중인 활동이나 상태를 나타냅니다."
        ));
        descriptions16.add(description56);

        WordDescription description57 = new WordDescription();
        description57.setCategory("형용사");
        description57.setDescriptions(Arrays.asList(
                "현재의 상태를 나타내는 형용사로, 주어나 명사를 수정하는데 사용됩니다.",
                "때로는 'current'와 유사한 의미로 사용되며, 현재의 상태를 강조합니다."
        ));
        descriptions16.add(description57);

        word16.setDetailDescriptions(descriptions16);

        // 단어17 : ongoing
        Word word17 = new Word();
        word17.setChapter(chapter6);
        word17.setWord("ongoing");
        word17.setSymbol("[ˈɒnˌɡəʊɪŋ]");
        word17.setWordMeaning(Arrays.asList("진행 중인", "계속 진행 중인", "진행 중에 있는"));

        word17.setWordExample(Arrays.asList(
                "The project is still ongoing and should be completed by next month.",
                "ongoing efforts to improve the company's services have been successful.",
                "The investigation into the matter is currently ongoing."
        ));

        word17.setWordExampleMeaning(Arrays.asList(
                "이 프로젝트는 아직 진행 중이며 다음 달에 완료될 예정입니다.",
                "회사의 서비스 개선 노력은 계속되어 성공적으로 진행되고 있습니다.",
                "이 문제와 관련된 조사는 현재 진행 중입니다."
        ));

        List<WordDescription> descriptions17 = new ArrayList<>();

        WordDescription description60 = new WordDescription();
        description60.setCategory("형용사");
        description60.setDescriptions(Arrays.asList(
                "어떤 일, 활동, 상황 등이 현재 진행 중이며, 중단되지 않고 계속 진행 중인 것을 나타냅니다.",
                "계속 진행 중인 일 또는 활동을 강조하는데 사용됩니다."
        ));
        descriptions17.add(description60);

        word17.setDetailDescriptions(descriptions17);

        // 단어18 : presently
        Word word18 = new Word();
        word18.setChapter(chapter6);
        word18.setWord("presently");
        word18.setSymbol("[ˈprɛzəntli]");
        word18.setWordMeaning(Arrays.asList("현재는", "현재 시점에서", "현재 상태로"));

        word18.setWordExample(Arrays.asList(
                "I am presently working on a new project.",
                "The weather is presently quite pleasant.",
                "She is presently the CEO of the company."
        ));

        word18.setWordExampleMeaning(Arrays.asList(
                "나는 현재 새로운 프로젝트에 참여하고 있다.",
                "날씨는 현재 상당히 쾌적하다.",
                "그녀는 현재 그 회사의 CEO이다."
        ));

        List<WordDescription> descriptions18 = new ArrayList<>();

        WordDescription description61 = new WordDescription();
        description61.setCategory("부사");
        description61.setDescriptions(Arrays.asList(
                "현재 시점에서, 현재의 상태나 상황을 나타내는 부사로, 현재의 동작 또는 상태를 강조합니다.",
                "시간적인 관점에서 현재를 강조하며, '현재는' 또는 '현재 시점에서'와 같은 의미로 사용됩니다."
        ));
        descriptions18.add(description61);

        word18.setDetailDescriptions(descriptions18);

        // 단어19 : cook
        Word word19 = new Word();
        word19.setChapter(chapter7);
        word19.setWord("cook");
        word19.setSymbol("[kʊk]");
        word19.setWordMeaning(Arrays.asList("요리하다", "조리하다", "요리사"));

        word19.setWordExample(Arrays.asList(
                "I love to cook Italian dishes.",
                "She can cook a delicious meal in no time.",
                "The cook at the restaurant is known for his culinary skills."
        ));

        word19.setWordExampleMeaning(Arrays.asList(
                "나는 이탈리아 요리를 만드는 것을 좋아한다.",
                "그녀는 빠르게 맛있는 식사를 요리할 수 있다.",
                "그 레스토랑의 요리사는 그의 요리 기술로 유명하다."
        ));

        List<WordDescription> descriptions19 = new ArrayList<>();

        WordDescription description62 = new WordDescription();
        description62.setCategory("동사");
        description62.setDescriptions(Arrays.asList(
                "음식을 조리하거나 요리하는 행위를 나타냅니다.",
                "식재료를 가공하고 조리하여 먹을 수 있는 요리로 만들거나 음식을 만들 때 사용되는 행동입니다.",
                "요리에는 다양한 방법과 기술이 사용될 수 있으며, 다양한 종류의 음식을 만들 수 있습니다."
        ));
        descriptions19.add(description62);

        WordDescription description63 = new WordDescription();
        description63.setCategory("명사");
        description63.setDescriptions(Arrays.asList(
                "음식을 조리하는 사람 또는 요리사를 가리키는 말로, 음식을 전문적으로 만드는 사람을 의미합니다.",
                "레스토랑, 호텔 또는 가정에서 요리를 담당하는 사람으로, 다양한 요리 기술과 레시피를 활용하여 음식을 제공합니다."
        ));
        descriptions19.add(description63);

        word19.setDetailDescriptions(descriptions19);

        // 단어20 : recipe
        Word word20 = new Word();
        word20.setChapter(chapter7);
        word20.setWord("recipe");
        word20.setSymbol("[ˈrɛsəpi]");
        word20.setWordMeaning(Arrays.asList("요리 레시피", "조리법", "레시피"));

        word20.setWordExample(Arrays.asList(
                "I found a great recipe for chocolate cake online.",
                "The recipe calls for fresh ingredients and herbs.",
                "She followed the recipe carefully to make the perfect dish."
        ));

        word20.setWordExampleMeaning(Arrays.asList(
                "나는 온라인에서 훌륭한 초콜릿 케이크 레시피를 찾았다.",
                "이 레시피는 신선한 재료와 허브를 요구한다.",
                "그녀는 완벽한 요리를 만들기 위해 레시피를 주의 깊게 따랐다."
        ));

        List<WordDescription> descriptions20 = new ArrayList<>();

        WordDescription description64 = new WordDescription();
        description64.setCategory("명사");
        description64.setDescriptions(Arrays.asList(
                "요리나 음식을 만들기 위한 지침서 또는 설명서로, 특정 요리나 음식을 만들기 위한 단계별 지침과 재료 목록이 포함됩니다.",
                "다양한 음식 종류와 조리법에 대한 정보를 담은 레시피는 요리사나 요리책에서 찾을 수 있으며, 집에서 요리를 할 때 유용하게 사용됩니다."
        ));
        descriptions20.add(description64);

        word20.setDetailDescriptions(descriptions20);

        // 단어21 : taste
        Word word21 = new Word();
        word21.setChapter(chapter7);
        word21.setWord("taste");
        word21.setSymbol("[teɪst]");
        word21.setWordMeaning(Arrays.asList("맛", "풍미", "미각", "맛보기"));

        word21.setWordExample(Arrays.asList(
                "This soup has a unique and delicious taste.",
                "She has a refined taste in art and music.",
                "I would like to taste a sample of your homemade cookies."
        ));

        word21.setWordExampleMeaning(Arrays.asList(
                "이 수프는 독특하고 맛있는 풍미가 있다.",
                "그녀는 예술과 음악에 세련된 취향을 가지고 있다.",
                "당신의 집에서 만든 쿠키의 샘플을 맛보고 싶습니다."
        ));

        List<WordDescription> descriptions21 = new ArrayList<>();

        WordDescription description65 = new WordDescription();
        description65.setCategory("명사");
        description65.setDescriptions(Arrays.asList(
                "음식이나 음료의 맛이나 풍미를 가리키며, 음식을 먹거나 마실 때 느끼는 감각입니다.",
                "음식의 맛은 다양한 맛과 향을 포함하며, 사람들의 개인 취향에 따라 다를 수 있습니다.",
                "맛은 식품의 조리 방법, 재료 조합, 향신료 사용 등에 영향을 받습니다."
        ));
        descriptions21.add(description65);

        WordDescription description66 = new WordDescription();
        description66.setCategory("동사");
        description66.setDescriptions(Arrays.asList(
                "맛을 봄, 맛을 볼 수 있게 해주는 행동을 나타냅니다.",
                "음식이나 음료를 먹거나 마시면서 그 맛을 평가하거나 느끼는 행위입니다.",
                "맛을 보고 어떤 음식이나 음료가 어떤 느낌인지 판단할 때 사용됩니다."
        ));
        descriptions21.add(description66);

        word21.setDetailDescriptions(descriptions21);

        // 단어22 : he
        Word word22 = new Word();
        word22.setChapter(chapter8);
        word22.setWord("he");
        word22.setSymbol("[hi:]");
        word22.setWordMeaning(Arrays.asList("그(남성)", "그의"));

        word22.setWordExample(Arrays.asList(
                "he is a talented musician.",
                "he loves to read books in his free time."
        ));

        word22.setWordExampleMeaning(Arrays.asList(
                "그는 재능 있는 음악가이다.",
                "그는 여가 시간에 책을 읽는 것을 좋아한다."
        ));

        List<WordDescription> descriptions22 = new ArrayList<>();

        WordDescription description67 = new WordDescription();
        description67.setCategory("대명사");
        description67.setDescriptions(Arrays.asList(
                "남성 대상을 가리키는 인칭 대명사로, 세 번째 인칭 단수인 남성을 나타냅니다.",
                "일반적으로 남성에 대한 언급이나 대화에서 사용되며, 해당 남성이 특정한 사람이나 사물을 가리키는데 사용됩니다."
        ));
        descriptions22.add(description67);

        word22.setDetailDescriptions(descriptions22);

        // 단어23 : she
        Word word23 = new Word();
        word23.setChapter(chapter8);
        word23.setWord("she");
        word23.setSymbol("[ʃi:]");
        word23.setWordMeaning(Arrays.asList("그녀(여성)", "그녀의"));

        word23.setWordExample(Arrays.asList(
                "she is an accomplished scientist.",
                "she enjoys playing the piano in her free time."
        ));

        word23.setWordExampleMeaning(Arrays.asList(
                "그녀는 능숙한 과학자이다.",
                "그녀는 여가 시간에 피아노를 연주하는 것을 즐긴다."
        ));

        List<WordDescription> descriptions23 = new ArrayList<>();

        WordDescription description68 = new WordDescription();
        description68.setCategory("대명사");
        description68.setDescriptions(Arrays.asList(
                "여성 대상을 가리키는 인칭 대명사로, 세 번째 인칭 단수인 여성을 나타냅니다.",
                "일반적으로 여성에 대한 언급이나 대화에서 사용되며, 해당 여성이 특정한 사람이나 사물을 가리키는데 사용됩니다."
        ));
        descriptions23.add(description68);

        word23.setDetailDescriptions(descriptions23);

        // 단어24 : they
        Word word24 = new Word();
        word24.setChapter(chapter8);
        word24.setWord("they");
        word24.setSymbol("[ðeɪ]");
        word24.setWordMeaning(Arrays.asList("그들(복수형)", "그들의"));

        word24.setWordExample(Arrays.asList(
                "they are going on a trip together.",
                "they love to spend time with their friends."
        ));

        word24.setWordExampleMeaning(Arrays.asList(
                "그들은 함께 여행을 떠난다.",
                "그들은 친구들과 시간을 보는 것을 좋아한다."
        ));

        List<WordDescription> descriptions24 = new ArrayList<>();

        WordDescription description69 = new WordDescription();
        description69.setCategory("대명사");
        description69.setDescriptions(Arrays.asList(
                "복수형 대명사로, 세 번째 인칭 복수형을 나타냅니다.",
                "여러 사람 또는 물건들을 가리키는데 사용되며, 일반적으로 성별에 상관없이 여러 사람이나 사물을 가리킬 때 사용됩니다."
        ));
        descriptions24.add(description69);

        word24.setDetailDescriptions(descriptions24);

        // 단어25 : neighbor
        Word word25 = new Word();
        word25.setChapter(chapter9);
        word25.setWord("neighbor");
        word25.setSymbol("[ˈneɪbər]");
        word25.setWordMeaning(Arrays.asList("이웃", "인근 주민", "동네 사람"));

        word25.setWordExample(Arrays.asList(
                "Our neighbor is very friendly.",
                "I borrowed some sugar from my neighbor.",
                "It's important to have a good relationship with your neighbor."
        ));

        word25.setWordExampleMeaning(Arrays.asList(
                "우리 이웃은 매우 친절하다.",
                "나는 이웃으로부터 설탕을 빌렸다.",
                "이웃과 좋은 관계를 유지하는 것은 중요하다."
        ));

        List<WordDescription> descriptions25 = new ArrayList<>();

        WordDescription description70 = new WordDescription();
        description70.setCategory("명사");
        description70.setDescriptions(Arrays.asList(
                "주변 지역에 살고 있는 사람 또는 가구를 가리키는 말로, 일반적으로 집이나 아파트 등 인근 주택에 거주하는 이웃들을 가리킵니다.",
                "이웃들과의 관계는 주로 친절하고 상호 협력적인 분위기를 유지하기를 원하며, 이웃 사이에 커뮤니케이션이 중요합니다."
        ));
        descriptions25.add(description70);

        WordDescription description71 = new WordDescription();
        description71.setCategory("동사");
        description71.setDescriptions(Arrays.asList(
                "이웃과의 관계를 유지하거나 협력하기 위해 노력하는 행동을 나타냅니다.",
                "이웃과의 관계는 서로 돕고 배려하며, 동네 사회의 조화를 유지하기 위해 노력하는 것이 중요합니다."
        ));
        descriptions25.add(description71);

        word25.setDetailDescriptions(descriptions25);

        // 단어26 : chat
        Word word26 = new Word();
        word26.setChapter(chapter9);
        word26.setWord("chat");
        word26.setSymbol("[ʧæt]");
        word26.setWordMeaning(Arrays.asList("잡담하다", "수다 떨다", "담소", "수다"));

        word26.setWordExample(Arrays.asList(
                "Let's have a chat over coffee.",
                "Their chat lasted for hours."
        ));

        word26.setWordExampleMeaning(Arrays.asList(
                "커피를 마시면서 잠시 수다 떨어보자.",
                "그들의 대화는 몇 시간 동안 계속되었다."
        ));

        List<WordDescription> descriptions26 = new ArrayList<>();

        WordDescription description72 = new WordDescription();
        description72.setCategory("동사");
        description72.setDescriptions(Arrays.asList(
                "캐주얼하고 가벼운 대화를 나누는 동작을 나타냅니다.",
                "두 사람 이상이 모여 서로 이야기하고 대화를 즐기며, 주제에 관계없이 가벼운 이야기를 나누는 행위입니다."
        ));
        descriptions26.add(description72);

        WordDescription description73 = new WordDescription();
        description73.setCategory("명사");
        description73.setDescriptions(Arrays.asList(
                "캐주얼한 대화나 수다를 가리키며, 주로 가벼운 주제나 소소한 이야기를 포함합니다.",
                "두 사람 이상이 모여 이야기를 나누거나 온라인에서 채팅하는 것을 의미합니다."
        ));
        descriptions26.add(description73);

        word26.setDetailDescriptions(descriptions26);

        // 단어27 : friendly
        Word word27 = new Word();
        word27.setChapter(chapter9);
        word27.setWord("friendly");
        word27.setSymbol("[ˈfrɛndli]");
        word27.setWordMeaning(Arrays.asList("친근한", "우호적인", "친절한", "분위기 좋은"));

        word27.setWordExample(Arrays.asList(
                "She is a friendly neighbor.",
                "The staff at the hotel are very friendly.",
                "They had a friendly conversation."
        ));

        word27.setWordExampleMeaning(Arrays.asList(
                "그녀는 친근한 이웃입니다.",
                "호텔 직원들은 매우 친절합니다.",
                "그들은 친근한 대화를 나눴습니다."
        ));

        List<WordDescription> descriptions27 = new ArrayList<>();

        WordDescription description74 = new WordDescription();
        description74.setCategory("형용사");
        description74.setDescriptions(Arrays.asList(
                "다른 사람이나 환경에 대한 호의적인 태도나 친절한 성격을 나타냅니다.",
                "사람들 사이의 관계나 분위기를 좋게 만들기 위해 친절하고 우호적으로 행동하는 것을 강조합니다."
        ));
        descriptions27.add(description74);

        word27.setDetailDescriptions(descriptions27);

        // 단어28 : past
        Word word28 = new Word();
        word28.setChapter(chapter10);
        word28.setWord("past");
        word28.setSymbol("[pæst]");
        word28.setWordMeaning(Arrays.asList("과거의", "지나간", "이전의"));

        word28.setWordExample(Arrays.asList(
                "He talked about his past experiences.",
                "The past few years have been challenging.",
                "Let's not dwell on the past."
        ));

        word28.setWordExampleMeaning(Arrays.asList(
                "그는 자신의 과거 경험에 대해 이야기했다.",
                "지난 몇 년 동안은 어려움이 많았다.",
                "과거에 대해 생각하며 시간을 보내지 말자."
        ));

        List<WordDescription> descriptions28 = new ArrayList<>();

        WordDescription description75 = new WordDescription();
        description75.setCategory("명사");
        description75.setDescriptions(Arrays.asList(
                "과거의 시간, 경험, 사건 등을 가리키며, 현재나 미래와 대조되는 시간을 나타냅니다.",
                "과거의 일들은 현재에 영향을 미치며, 생각하고 기억하는 데 사용되는 말입니다."
        ));
        descriptions28.add(description75);

        WordDescription description76 = new WordDescription();
        description76.setCategory("형용사");
        description76.setDescriptions(Arrays.asList(
                "과거와 관련된, 과거에 일어난 또는 과거와 연관된 것을 나타냅니다.",
                "때로는 지난 시간에 일어났거나 지나간 시기와 관련된 형용사로 사용됩니다."
        ));
        descriptions28.add(description76);

        word28.setDetailDescriptions(descriptions28);

        // 단어29 : recalled
         Word word29 = new Word();
        word29.setChapter(chapter10);
        word29.setWord("recalled");
        word29.setSymbol("[rɪˈkɔld]");
        word29.setWordMeaning(Arrays.asList("회상하다", "기억하다", "상기하다"));

        word29.setWordExample(Arrays.asList(
                "She recalled her childhood memories.",
                "The teacher recalled the important points of the lesson.",
                "I recalled our last meeting."
        ));

        word29.setWordExampleMeaning(Arrays.asList(
                "그녀는 어린 시절의 기억을 회상했다.",
                "선생님은 수업의 중요한 부분을 상기시켰다.",
                "나는 우리 마지막 만남을 떠올렸다."
        ));

        List<WordDescription> descriptions29 = new ArrayList<>();

        WordDescription description77 = new WordDescription();
        description77.setCategory("동사");
        description77.setDescriptions(Arrays.asList(
                "과거에 일어난 사건, 경험 또는 정보를 다시 생각하거나 상기하는 동작을 나타냅니다.",
                "기억하거나 상기하려는 의도로 사용되며, 과거에 일어난 일들을 회상하거나 떠올리는 행위를 나타냅니다."
        ));
        descriptions29.add(description77);

        word29.setDetailDescriptions(descriptions29);

        // 단어30 : visited
        Word word30 = new Word();
        word30.setChapter(chapter10);
        word30.setWord("visited");
        word30.setSymbol("[ˈvɪzɪtɪd]");
        word30.setWordMeaning(Arrays.asList("방문한", "찾아간", "방문하다"));

        word30.setWordExample(Arrays.asList(
                "They visited the museum last weekend.",
                "I visited my grandparents during the summer vacation."
        ));

        word30.setWordExampleMeaning(Arrays.asList(
                "그들은 지난 주말에 박물관을 방문했다.",
                "여름 휴가 동안 할머니와 할아버지를 찾아갔다."
        ));

        List<WordDescription> descriptions30 = new ArrayList<>();

        WordDescription description78 = new WordDescription();
        description78.setCategory("동사");
        description78.setDescriptions(Arrays.asList(
                "특정 장소나 사람을 찾아가거나 머무르는 동작을 나타냅니다.",
                "일반적으로 다른 장소나 도시, 집, 기관 등을 방문하거나 친구, 가족, 지인 등을 찾아가는 행동을 의미합니다."
        ));
        descriptions30.add(description78);

        word30.setDetailDescriptions(descriptions30);

        // 단어31 : homework
        Word word31 = new Word();
        word31.setChapter(chapter11);
        word31.setWord("homework");
        word31.setSymbol("[ˈhoʊmwɜrk]");
        word31.setWordMeaning(Arrays.asList("숙제", "과제", "집필"));

        word31.setWordExample(Arrays.asList(
                "I have a lot of homework to do tonight.",
                "The teacher assigned math homework for the weekend.",
                "She finished her homework early."
        ));

        word31.setWordExampleMeaning(Arrays.asList(
                "오늘 밤에 할 숙제가 많아.",
                "선생님이 주말에 수학 숙제를 내주셨어.",
                "그녀는 숙제를 일찍 끝냈다."
        ));

        List<WordDescription> descriptions31 = new ArrayList<>();

        WordDescription description80 = new WordDescription();
        description80.setCategory("명사");
        description80.setDescriptions(Arrays.asList(
                "학교나 교육 기관에서 학습 목적으로 학생들에게 부여하는 과제나 작업을 가리키며, 일반적으로 집에서 수행합니다.",
                "과목 공부나 연습, 리서치, 레포트 작성 등 다양한 형태의 과제가 포함될 수 있습니다."
        ));
        descriptions31.add(description80);

        WordDescription description81 = new WordDescription();
        description81.setCategory("동사");
        description81.setDescriptions(Arrays.asList(
                "과제나 숙제를 수행하거나, 공부를 위해 필요한 작업을 진행하는 동작을 나타냅니다.",
                "학생들은 과제를 완료하거나 숙제를 수행하는 과정에서 지식을 습득하고 학습을 진행합니다."
        ));
        descriptions31.add(description81);

        word31.setDetailDescriptions(descriptions31);

        // 단어32 : teacher
        Word word32 = new Word();
        word32.setChapter(chapter11);
        word32.setWord("teacher");
        word32.setSymbol("[ˈtiːʧər]");
        word32.setWordMeaning(Arrays.asList("선생님", "교사", "교사자", "강사"));

        word32.setWordExample(Arrays.asList(
                "My teacher is very knowledgeable.",
                "teacher play a crucial role in education.",
                "She aspires to become a teacher."
        ));

        word32.setWordExampleMeaning(Arrays.asList(
                "내 선생님은 매우 지식이 풍부하다.",
                "선생님은 교육에서 중요한 역할을 한다.",
                "그녀는 선생님이 되기를 간절히 바란다."
        ));

        List<WordDescription> descriptions32 = new ArrayList<>();

        WordDescription description82 = new WordDescription();
        description82.setCategory("명사");
        description82.setDescriptions(Arrays.asList(
                "학교나 교육 기관에서 학생들에게 교육을 제공하거나 가르치는 사람을 가리킵니다.",
                "선생님은 학생들의 학습을 지도하고 지식을 전달하는 역할을 합니다."
        ));
        descriptions32.add(description82);

        WordDescription description83 = new WordDescription();
        description83.setCategory("직업");
        description83.setDescriptions(Arrays.asList(
                "교육 분야에서 교육을 제공하거나 지식을 전달하는 직업을 나타냅니다.",
                "교사, 강사, 교육자 등 다양한 역할을 수행할 수 있으며, 학생들의 학습을 촉진하고 지원합니다."
        ));
        descriptions32.add(description83);

        word32.setDetailDescriptions(descriptions32);

        // 단어33 : exam
        Word word33 = new Word();
        word33.setChapter(chapter11);
        word33.setWord("exam");
        word33.setSymbol("[ɪɡˈzæm]");
        word33.setWordMeaning(Arrays.asList("시험", "시험지", "검사", "고사"));

        word33.setWordExample(Arrays.asList(
                "I have an important exam tomorrow.",
                "The final exam covers all the material we've studied.",
                "She passed the entrance exam."
        ));

        word33.setWordExampleMeaning(Arrays.asList(
                "내일 중요한 시험이 있다.",
                "기말 시험은 우리가 공부한 모든 내용을 포함한다.",
                "그녀는 입학 시험을 통과했다."
        ));

        List<WordDescription> descriptions33 = new ArrayList<>();

        WordDescription description84 = new WordDescription();
        description84.setCategory("명사");
        description84.setDescriptions(Arrays.asList(
                "학교나 교육 기관에서 학생들의 학력, 지식, 기술 등을 평가하기 위해 실시되는 시험을 가리킵니다.",
                "시험지를 풀거나 특정 주제에 대한 질문에 답하는 것이 일반적이며, 학업 성취도나 능력을 측정하는 목적으로 사용됩니다."
        ));
        descriptions33.add(description84);

        WordDescription description85 = new WordDescription();
        description85.setCategory("동사");
        description85.setDescriptions(Arrays.asList(
                "학생들이 시험을 치르거나 시험지를 작성하는 동작을 나타냅니다.",
                "시험을 보거나 시험에 응시하는 과정을 포함하며, 학업 또는 업무 성과를 측정하는 데 사용됩니다."
        ));
        descriptions33.add(description85);

        word33.setDetailDescriptions(descriptions33);

        // 단어34 : exercise
        Word word34 = new Word();
        word34.setChapter(chapter12);
        word34.setWord("exercise");
        word34.setSymbol("[ˈɛksərˌsaɪz]");
        word34.setWordMeaning(Arrays.asList("운동", "연습", "예제", "수행"));

        word34.setWordExample(Arrays.asList(
                "Regular exercise is important for staying healthy.",
                "She does yoga as part of her daily exercise routine.",
                "The math exercise was challenging."
        ));

        word34.setWordExampleMeaning(Arrays.asList(
                "규칙적인 운동은 건강을 유지하는 데 중요하다.",
                "그녀는 일상적인 운동 루틴으로 요가를 한다.",
                "수학 문제 풀기는 어려웠다."
        ));

        List<WordDescription> descriptions34 = new ArrayList<>();

        WordDescription description86 = new WordDescription();
        description86.setCategory("명사");
        description86.setDescriptions(Arrays.asList(
                "체력을 향상하거나 건강을 유지하기 위해 실시하는 활동을 가리킵니다.",
                "육체적 활동이나 운동 동작을 포함하며, 스포츠, 체조, 걷기, 수영 등 다양한 형태가 있습니다."
        ));
        descriptions34.add(description86);

        WordDescription description87 = new WordDescription();
        description87.setCategory("동사");
        description87.setDescriptions(Arrays.asList(
                "활동을 실시하거나 특정 동작을 수행하는 동작을 나타냅니다.",
                "일반적으로 운동을 하거나, 활동적으로 몸을 움직이거나, 연습을 통해 스킬을 향상시키는 행위를 의미합니다."
        ));
        descriptions34.add(description87);

        word34.setDetailDescriptions(descriptions34);

        // 단어35 : athlete
        Word word35 = new Word();
        word35.setChapter(chapter12);
        word35.setWord("athlete");
        word35.setSymbol("[ˈæθliːt]");
        word35.setWordMeaning(Arrays.asList("운동선수", "체육인", "스포츠 선수"));

        word35.setWordExample(Arrays.asList(
                "She is a professional athlete and competes in track and field.",
                "The athlete set a new world record in swimming."
        ));

        word35.setWordExampleMeaning(Arrays.asList(
                "그녀는 프로 운동선수로 육상 경기에서 경쟁합니다.",
                "그 운동선수는 수영에서 새로운 세계 기록을 세웠다."
        ));

        List<WordDescription> descriptions35 = new ArrayList<>();

        WordDescription description88 = new WordDescription();
        description88.setCategory("명사");
        description88.setDescriptions(Arrays.asList(
                "스포츠나 체육 활동을 수행하고 경쟁하는 개인 또는 선수단을 가리킵니다.",
                "스포츠 경기에 참여하고 스포츠에 대한 훈련을 받는 사람들을 포함하며, 프로 운동선수부터 아마추어 선수까지 다양한 수준의 운동선수가 있습니다."
        ));
        descriptions35.add(description88);

        WordDescription description89 = new WordDescription();
        description89.setCategory("동사");
        description89.setDescriptions(Arrays.asList(
                "체육 활동이나 스포츠를 수행하는 동작을 나타냅니다.",
                "운동선수들은 일반적으로 훈련하고 스포츠 경기에 참여하여 경쟁합니다."
        ));
        descriptions35.add(description89);

        WordDescription description90 = new WordDescription();
        description90.setCategory("형용사");
        description90.setDescriptions(Arrays.asList(
                "운동선수와 관련된 형용사로, 스포츠 또는 체육 활동과 관련된 특성을 나타냅니다.",
                "운동선수들이 가지고 있는 뛰어난 체력, 스포츠 경기에서의 역량 등을 표현하는 데 사용됩니다."
        ));
        descriptions35.add(description90);

        word35.setDetailDescriptions(descriptions35);

        // 단어36 : team
        Word word36 = new Word();
        word36.setChapter(chapter12);
        word36.setWord("team");
        word36.setSymbol("[tiːm]");
        word36.setWordMeaning(Arrays.asList("팀", "단체", "그룹", "집단"));

        word36.setWordExample(Arrays.asList(
                "Our team won the championship.",
                "She is a valuable member of the team."
        ));

        word36.setWordExampleMeaning(Arrays.asList(
                "우리 팀은 선수권 대회에서 우승했습니다.",
                "그녀는 팀의 소중한 구성원입니다."
        ));

        List<WordDescription> descriptions36 = new ArrayList<>();

        WordDescription description91 = new WordDescription();
        description91.setCategory("명사");
        description91.setDescriptions(Arrays.asList(
                "일정한 목표를 달성하기 위해 협력하고 협동하는 그룹을 가리킵니다.",
                "팀은 일반적으로 다양한 역할과 임무를 수행하며, 스포츠, 업무, 프로젝트 등 다양한 분야에서 활동할 수 있습니다."
        ));
        descriptions36.add(description91);

        WordDescription description92 = new WordDescription();
        description92.setCategory("동사");
        description92.setDescriptions(Arrays.asList(
                "팀을 구성하거나 팀원들과 협력하여 일을 수행하는 동작을 나타냅니다.",
                "팀을 결성하거나 조직하고, 팀원 간의 조화와 협력을 도모하는 것을 의미합니다."
        ));
        descriptions36.add(description92);

        word36.setDetailDescriptions(descriptions36);

        // 단어37 : art
        Word word37 = new Word();
        word37.setChapter(chapter13);
        word37.setWord("art");
        word37.setSymbol("[ɑːrt]");
        word37.setWordMeaning(Arrays.asList("미술", "예술", "작품", "조각"));

        word37.setWordExample(Arrays.asList(
                "She has a deep appreciation for art.",
                "The museum features a vast collection of art.",
                "Creating art is a form of self-expression."
        ));

        word37.setWordExampleMeaning(Arrays.asList(
                "그녀는 미술에 대한 깊은 감사함을 가지고 있습니다.",
                "이 박물관은 다양한 미술 작품을 소장하고 있습니다.",
                "예술 작품을 만드는 것은 자아 표현의 한 형태입니다."
        ));

        List<WordDescription> descriptions37 = new ArrayList<>();

        WordDescription description93 = new WordDescription();
        description93.setCategory("명사");
        description93.setDescriptions(Arrays.asList(
                "예술적 표현을 통해 창작된 작품이나 조각 등을 가리킵니다.",
                "미술은 다양한 형태와 스타일로 표현되며, 회화, 조각, 설치 미술 등이 포함됩니다."
        ));
        descriptions37.add(description93);

        WordDescription description94 = new WordDescription();
        description94.setCategory("형용사");
        description94.setDescriptions(Arrays.asList(
                "예술과 관련된, 예술적인 특성이나 속성을 가진 것을 나타냅니다.",
                "예를 들어, 'artistic talent'는 예술적 재능을 가리키며, 'artistic expression'은 예술적 표현을 의미합니다."
        ));
        descriptions37.add(description94);

        word37.setDetailDescriptions(descriptions37);

        // 단어38 : music
        Word word38 = new Word();
        word38.setChapter(chapter13);
        word38.setWord("music");
        word38.setSymbol("[ˈmjuːzɪk]");
        word38.setWordMeaning(Arrays.asList("음악", "음악 작품", "음악성", "악곡"));

        word38.setWordExample(Arrays.asList(
                "I enjoy listening to classical music.",
                "The concert featured a variety of music genres."
        ));

        word38.setWordExampleMeaning(Arrays.asList(
                "나는 고전 음악을 듣는 것을 즐깁니다.",
                "콘서트는 다양한 음악 장르를 선보였습니다."
        ));

        List<WordDescription> descriptions38 = new ArrayList<>();

        WordDescription description95 = new WordDescription();
        description95.setCategory("명사");
        description95.setDescriptions(Arrays.asList(
                "소리와 음파를 통해 표현되는 예술 형태로, 음악 작품이나 곡을 포함합니다.",
                "음악은 다양한 장르와 스타일로 존재하며, 클래식, 팝, 재즈, 락 등이 있습니다."
        ));
        descriptions38.add(description95);

        WordDescription description96 = new WordDescription();
        description96.setCategory("동사");
        description96.setDescriptions(Arrays.asList(
                "악기를 연주하거나 음악을 만드는 행위를 나타냅니다.",
                "음악을 공연하거나 작곡하는 과정을 포함하며, 음악가들이 음악을 창작하고 연주합니다."
        ));
        descriptions38.add(description96);

        word38.setDetailDescriptions(descriptions38);

        // 단어39 : culture
        Word word39 = new Word();
        word39.setChapter(chapter13);
        word39.setWord("culture");
        word39.setSymbol("[ˈkʌltʃər]");
        word39.setWordMeaning(Arrays.asList("문화", "문화적 특성", "관습", "유산"));

        word39.setWordExample(Arrays.asList(
                "The city has a rich culture with a long history.",
                "Learning about different culture can be very enlightening.",
                "culture exchange programs promote understanding among nations."
        ));

        word39.setWordExampleMeaning(Arrays.asList(
                "이 도시는 긴 역사를 가진 풍부한 문화를 가지고 있습니다.",
                "다른 문화에 대해 배우는 것은 매우 깨달음을 주는 경험이 될 수 있습니다.",
                "문화 교류 프로그램은 국가 간의 이해 증진을 촉진합니다."
        ));

        List<WordDescription> descriptions39 = new ArrayList<>();

        WordDescription description97 = new WordDescription();
        description97.setCategory("명사");
        description97.setDescriptions(Arrays.asList(
                "특정 지역, 공동체, 또는 사회의 생활 방식, 예술, 관습, 언어, 식생활 등을 포함하는 개념입니다.",
                "문화는 그룹의 정체성을 형성하며, 그룹 간의 차이와 다양성을 나타냅니다."
        ));
        descriptions39.add(description97);

        WordDescription description98 = new WordDescription();
        description98.setCategory("동사");
        description98.setDescriptions(Arrays.asList(
                "문화를 형성하거나 전파하는 과정을 나타냅니다.",
                "특정 지역이나 공동체의 문화를 보존하거나 전통을 이어가는 데 중요한 역할을 합니다."
        ));
        descriptions39.add(description98);

        word39.setDetailDescriptions(descriptions39);

        // 단어40 : health
        Word word40 = new Word();
        word40.setChapter(chapter14);
        word40.setWord("health");
        word40.setSymbol("[helθ]");
        word40.setWordMeaning(Arrays.asList("건강", "건강 상태", "건강 관리"));

        word40.setWordExample(Arrays.asList(
                "Regular exercise is important for maintaining good health.",
                "Mental health is just as important as physical health.",
                "A balanced diet is essential for overall health."
        ));

        word40.setWordExampleMeaning(Arrays.asList(
                "규칙적인 운동은 좋은 건강을 유지하는 데 중요합니다.",
                "정신 건강은 신체 건강만큼 중요합니다.",
                "균형 잡힌 식사는 전반적인 건강에 필수적입니다."
        ));

        List<WordDescription> descriptions40 = new ArrayList<>();

        WordDescription description99 = new WordDescription();
        description99.setCategory("명사");
        description99.setDescriptions(Arrays.asList(
                "신체와 정신적인 면에서의 웰빙을 나타내며, 질병이나 부상 없이 기능을 원활히 수행할 수 있는 상태를 가리킵니다.",
                "건강은 생활 습관, 영양, 운동, 스트레스 관리 등에 영향을 받을 수 있으며, 적절한 관리가 필요합니다."
        ));
        descriptions40.add(description99);

        WordDescription description100 = new WordDescription();
        description100.setCategory("동사");
        description100.setDescriptions(Arrays.asList(
                "건강을 유지하거나 회복시키기 위해 다양한 조치를 취하는 행위를 나타냅니다.",
                "예를 들어, 식사를 규칙적으로 하거나 운동을 하여 건강을 챙기는 것이 건강 관리에 해당합니다."
        ));
        descriptions40.add(description100);

        word40.setDetailDescriptions(descriptions40);

        // 단어41 : nutrition
        Word word41 = new Word();
        word41.setChapter(chapter14);
        word41.setWord("nutrition");
        word41.setSymbol("[njuːˈtrɪʃən]");
        word41.setWordMeaning(Arrays.asList("영양", "영양소", "식이"));

        word41.setWordExample(Arrays.asList(
                "Proper nutrition is essential for growth and development.",
                "This product contains all the necessary nutrition for a healthy diet.",
                "nutrition labels on food packaging provide valuable information."
        ));

        word41.setWordExampleMeaning(Arrays.asList(
                "적절한 영양은 성장과 발달에 필수적입니다.",
                "이 제품은 건강한 식단을 위한 모든 필요한 영양소를 함유하고 있습니다.",
                "식품 포장에 있는 영양 정보 레이블은 중요한 정보를 제공합니다."
        ));

        List<WordDescription> descriptions41 = new ArrayList<>();

        WordDescription description101 = new WordDescription();
        description101.setCategory("명사");
        description101.setDescriptions(Arrays.asList(
                "음식이나 식품을 통해 체내로 공급되는 영양소의 섭취와 관련된 개념입니다.",
                "영양은 단백질, 지방, 탄수화물, 비타민, 미네랄 등의 다양한 성분으로 구성되며, 식사를 통해 섭취됩니다."
        ));
        descriptions41.add(description101);

        WordDescription description102 = new WordDescription();
        description102.setCategory("동사");
        description102.setDescriptions(Arrays.asList(
                "영양소를 효과적으로 공급하거나 섭취하는 행위를 나타냅니다.",
                "영양을 고려하여 식사를 계획하거나 영양제를 복용하는 것이 영양 관리에 해당합니다."
        ));

        descriptions41.add(description102);

        word41.setDetailDescriptions(descriptions41);

        // 단어42 : exercise
        Word word42 = new Word();
        word42.setChapter(chapter14);
        word42.setWord("exercise");
        word42.setSymbol("[ˈɛksərsaɪz]");
        word42.setWordMeaning(Arrays.asList("운동", "운동 활동", "운동하다"));

        word42.setWordExample(Arrays.asList(
                "Regular exercise is important for maintaining good health.",
                "She enjoys outdoor exercise like jogging and hiking.",
                "Many people exercise to stay fit and relieve stress."
        ));

        word42.setWordExampleMeaning(Arrays.asList(
                "규칙적인 운동은 좋은 건강을 유지하는 데 중요합니다.",
                "그녀는 조깅과 하이킹과 같은 야외 운동을 즐깁니다.",
                "많은 사람들이 체력을 유지하고 스트레스를 해소하기 위해 운동을 합니다."
        ));

        List<WordDescription> descriptions42 = new ArrayList<>();

        WordDescription description103 = new WordDescription();
        description103.setCategory("명사");
        description103.setDescriptions(Arrays.asList(
                "체력을 키우거나 건강을 유지하기 위해 수행되는 활동으로, 신체적인 노력이 필요한 활동을 가리킵니다.",
                "운동은 다양한 형태로 이루어질 수 있으며, 육체적인 건강을 증진하고 몸의 기능을 향상시키는데 기여합니다."
        ));
        descriptions42.add(description103);

        WordDescription description104 = new WordDescription();
        description104.setCategory("동사");
        description104.setDescriptions(Arrays.asList(
                "신체적 활동을 수행하거나 운동 활동을 꾸준히 하다를 나타냅니다.",
                "운동은 종종 체력 향상, 체중 감량, 스트레스 감소 등의 목적으로 수행됩니다."
        ));
        descriptions42.add(description104);

        word42.setDetailDescriptions(descriptions42);

        // 단어43 : computer
        Word word43 = new Word();
        word43.setChapter(chapter15);
        word43.setWord("computer");
        word43.setSymbol("[kəmˈpjuːtər]");
        word43.setWordMeaning(Arrays.asList("컴퓨터", "전자계산기", "컴퓨팅 장치"));

        word43.setWordExample(Arrays.asList(
                "I use my computer for work and entertainment.",
                "This laptop is a portable computer."
        ));

        word43.setWordExampleMeaning(Arrays.asList(
                "나는 업무와 오락을 위해 컴퓨터를 사용합니다.",
                "이 노트북은 휴대용 컴퓨터입니다."
        ));

        List<WordDescription> descriptions43 = new ArrayList<>();

        WordDescription description105 = new WordDescription();
        description105.setCategory("명사");
        description105.setDescriptions(Arrays.asList(
                "정보를 저장하고 처리하는데 사용되는 전자 기기로, 계산, 데이터 처리, 정보 검색 등 다양한 작업을 수행할 수 있습니다.",
                "컴퓨터는 소프트웨어와 하드웨어로 구성되며, 현대 사회에서 필수적인 도구 중 하나입니다."
        ));
        descriptions43.add(description105);

        WordDescription description106 = new WordDescription();
        description106.setCategory("동사");
        description106.setDescriptions(Arrays.asList(
                "컴퓨터를 사용하여 데이터를 입력, 수정, 처리하는 행위를 나타냅니다.",
                "컴퓨터를 활용하여 정보를 분석하거나 작업을 수행하는 것이 일상적입니다."
        ));
        descriptions43.add(description106);

        word43.setDetailDescriptions(descriptions43);

        // 단어44 : software
        Word word44 = new Word();
        word44.setChapter(chapter15);
        word44.setWord("software");
        word44.setSymbol("[ˈsɒftwɛə]");
        word44.setWordMeaning(Arrays.asList("소프트웨어", "컴퓨터 소프트웨어", "프로그램"));

        word44.setWordExample(Arrays.asList(
                "Operating systems and applications are types of software.",
                "software development is a rapidly growing field.",
                "To run this program, you need the right software installed."
        ));

        word44.setWordExampleMeaning(Arrays.asList(
                "운영 체제와 응용 프로그램은 소프트웨어의 종류입니다.",
                "소프트웨어 개발은 빠르게 성장하는 분야입니다.",
                "이 프로그램을 실행하려면 적절한 소프트웨어가 설치되어 있어야 합니다."
        ));

        List<WordDescription> descriptions44 = new ArrayList<>();

        WordDescription description107 = new WordDescription();
        description107.setCategory("명사");
        description107.setDescriptions(Arrays.asList(
                "컴퓨터 프로그램, 응용 소프트웨어 및 운영 체제와 같은 컴퓨터 관련 소프트웨어를 가리킵니다.",
                "소프트웨어는 컴퓨터 하드웨어와 상호 작용하여 사용자가 작업을 수행하고 데이터를 처리할 수 있게 합니다."
        ));
        descriptions44.add(description107);

        WordDescription description108 = new WordDescription();
        description108.setCategory("동사");
        description108.setDescriptions(Arrays.asList(
                "컴퓨터 프로그램을 설치하고 실행하며 컴퓨터 작업을 수행하는 행위를 나타냅니다.",
                "소프트웨어를 개발하거나 업데이트하는 과정도 소프트웨어와 관련된 작업입니다."
        ));
        descriptions44.add(description108);

        word44.setDetailDescriptions(descriptions44);


        // 단어45 : internet
        Word word45 = new Word();
        word45.setChapter(chapter15);
        word45.setWord("internet");
        word45.setSymbol("[ˈɪntənɛt]");
        word45.setWordMeaning(Arrays.asList("인터넷"));

        word45.setWordExample(Arrays.asList(
                "The internet has transformed the way we communicate and access information.",
                "Most people rely on the internet for various tasks and entertainment.",
                "You can find a wealth of knowledge on the internet."
        ));

        word45.setWordExampleMeaning(Arrays.asList(
                "인터넷은 우리의 의사 소통 방식과 정보 접근 방법을 변화시켰습니다.",
                "대부분의 사람들은 다양한 작업과 엔터테인먼트를 위해 인터넷을 의존합니다.",
                "인터넷에서는 다양한 지식을 찾을 수 있습니다."
        ));

        List<WordDescription> descriptions45 = new ArrayList<>();

        WordDescription description109 = new WordDescription();
        description109.setCategory("명사");
        description109.setDescriptions(Arrays.asList(
                "세계적인 컴퓨터 네트워크로, 전 세계의 컴퓨터가 연결되어 정보를 공유하고 통신할 수 있도록 합니다.",
                "인터넷은 웹 사이트, 이메일, 온라인 비디오 스트리밍 등을 통해 다양한 서비스를 제공합니다."
        ));
        descriptions45.add(description109);

        word45.setDetailDescriptions(descriptions45);

        // 단어46 : environment
        Word word46 = new Word();
        word46.setChapter(chapter16);
        word46.setWord("environment");
        word46.setSymbol("[ɪnˈvaɪrənmənt]");
        word46.setWordMeaning(Arrays.asList("환경", "자연 환경", "주위 환경"));

        word46.setWordExample(Arrays.asList(
                "We must protect the environment for future generations.",
                "Pollution is a major threat to the environment.",
                "Her job involves studying the local environment."
        ));

        word46.setWordExampleMeaning(Arrays.asList(
                "우리는 미래 세대를 위해 환경을 보호해야 합니다.",
                "오염은 환경에 대한 주요한 위협 요인입니다.",
                "그녀의 직업은 현지 환경을 연구하는 것을 포함합니다."
        ));

        List<WordDescription> descriptions46 = new ArrayList<>();

        WordDescription description110 = new WordDescription();
        description110.setCategory("명사");
        description110.setDescriptions(Arrays.asList(
                "생태계나 자연 환경을 가리키며, 생물학적 및 지질학적인 측면에서 다양한 영역을 포함합니다.",
                "환경은 대기, 수, 토양, 동식물 등으로 구성되며, 지구 생태계의 일부입니다."
        ));
        descriptions46.add(description110);

        WordDescription description111 = new WordDescription();
        description111.setCategory("동사");
        description111.setDescriptions(Arrays.asList(
                "환경을 보호하거나 유지하는 데 기여하는 활동을 수행하는 것을 나타냅니다.",
                "환경을 개선하거나 오염을 줄이기 위해 노력하는 것이 중요합니다."
        ));
        descriptions46.add(description111);

        word46.setDetailDescriptions(descriptions46);

        // 단어47 : climate
        Word word47 = new Word();
        word47.setChapter(chapter16);
        word47.setWord("climate");
        word47.setSymbol("[ˈklaɪmət]");
        word47.setWordMeaning(Arrays.asList("기후", "기후 조건", "날씨 패턴"));

        word47.setWordExample(Arrays.asList(
                "The climate in this region is characterized by hot summers and mild winters.",
                "climate change is a global concern with far-reaching consequences.",
                "Local flora and fauna have adapted to the unique climate of the desert."
        ));

        word47.setWordExampleMeaning(Arrays.asList(
                "이 지역의 기후는 더운 여름과 온화한 겨울로 특징지어집니다.",
                "기후 변화는 전 세계적인 우려사항으로, 멀리 미치는 결과를 가져옵니다.",
                "현지의 식물과 동물은 사막의 독특한 기후에 적응해 왔습니다."
        ));

        List<WordDescription> descriptions47 = new ArrayList<>();

        WordDescription description112 = new WordDescription();
        description112.setCategory("명사");
        description112.setDescriptions(Arrays.asList(
                "특정 지역 또는 지구 전반의 평균 기상 조건 및 날씨 패턴을 나타냅니다.",
                "기후는 온도, 습도, 강수량 및 기상 조건과 관련된 다양한 요소로 결정됩니다."
        ));
        descriptions47.add(description112);

        WordDescription description113 = new WordDescription();
        description113.setCategory("동사");
        description113.setDescriptions(Arrays.asList(
                "기후 변화에 대응하거나 기후를 연구하는 과정을 나타냅니다.",
                "기후 조건을 평가하고 예측하는 것이 기후 과학의 중요한 부분입니다."
        ));
        descriptions47.add(description113);

        word47.setDetailDescriptions(descriptions47);


        // 단어48 : earthquake - "s" 테스트  earthquakes-prone, 문제유형4 조회
        Word word48 = new Word();
        word48.setChapter(chapter16);
        word48.setWord("earthquake");
        word48.setSymbol("[ˈɜːrθˌkweɪk]");
        word48.setWordMeaning(Arrays.asList("지진"));

        word48.setWordExample(Arrays.asList(
                "The earthquake shook the entire city, causing widespread damage.",
                "Seismologists study the causes and effects of earthquake.",
                "Residents in earthquakes-prone areas are prepared for seismic activity."
        ));

        word48.setWordExampleMeaning(Arrays.asList(
                "지진은 전체 도시를 흔들어 넓은 피해를 일으켰습니다.",
                "지진학자들은 지진의 원인과 영향을 연구합니다.",
                "지진이 발생하기 쉬운 지역의 주민들은 지진 활동에 대비하고 있습니다."
        ));

        List<WordDescription> descriptions48 = new ArrayList<>();

        WordDescription description114 = new WordDescription();
        description114.setCategory("명사");
        description114.setDescriptions(Arrays.asList(
                "지구 내부에서 발생하는 지진파 및 지진 활동을 나타냅니다.",
                "지진은 흔히 지구 표면에서 지각되며 흔히 지진계를 통해 측정됩니다."
        ));
        descriptions48.add(description114);

        WordDescription description115 = new WordDescription();
        description115.setCategory("동사");
        description115.setDescriptions(Arrays.asList(
                "지진이나 지진 활동을 일으키다를 나타냅니다.",
                "지진 예측 및 모니터링은 지진의 영향을 줄이기 위한 중요한 활동입니다."
        ));
        descriptions48.add(description115);

        word48.setDetailDescriptions(descriptions48);


        // 단어49 : history
        Word word49 = new Word();
        word49.setChapter(chapter17);
        word49.setWord("history");
        word49.setSymbol("[ˈhɪstəri]");
        word49.setWordMeaning(Arrays.asList("역사", "역사적 사건", "과거"));

        word49.setWordExample(Arrays.asList(
                "The history of ancient civilizations is fascinating.",
                "Our country has a rich history of cultural diversity."
        ));

        word49.setWordExampleMeaning(Arrays.asList(
                "고대 문명의 역사는 매우 매혹적입니다.",
                "우리 나라는 문화 다양성에 관한 풍부한 역사를 가지고 있습니다."
        ));

        List<WordDescription> descriptions49 = new ArrayList<>();

        WordDescription description116 = new WordDescription();
        description116.setCategory("명사");
        description116.setDescriptions(Arrays.asList(
                "과거의 사건, 사람들, 문화, 정치 등의 역사적인 측면을 나타냅니다.",
                "역사는 과거에 대한 기록과 연구를 통해 이해하고 배울 수 있는 중요한 주제 중 하나입니다."
        ));
        descriptions49.add(description116);

        WordDescription description117 = new WordDescription();
        description117.setCategory("동사");
        description117.setDescriptions(Arrays.asList(
                "과거의 사건이나 사람들에 대해 연구하거나 이야기하는 행위를 나타냅니다.",
                "역사는 인류의 진화와 발전에 대한 통찰력을 제공합니다."
        ));
        descriptions49.add(description117);

        word49.setDetailDescriptions(descriptions49);


        // 단어50 : ancient
        Word word50 = new Word();
        word50.setChapter(chapter17);
        word50.setWord("ancient");
        word50.setSymbol("[ˈeɪnʃənt]");
        word50.setWordMeaning(Arrays.asList("고대의", "오래된", "옛날의"));

        word50.setWordExample(Arrays.asList(
                "The ancient city of Rome is a popular tourist destination.",
                "ancient civilizations left behind fascinating artifacts and monuments.",
                "People are still studying the languages of ancient cultures."
        ));

        word50.setWordExampleMeaning(Arrays.asList(
                "로마의 고대 도시는 인기 있는 관광 명소입니다.",
                "고대 문명은 매혹적인 유물과 기념물을 남겼습니다.",
                "사람들은 아직도 고대 문화의 언어를 연구하고 있습니다."
        ));

        List<WordDescription> descriptions50 = new ArrayList<>();

        WordDescription description118 = new WordDescription();
        description118.setCategory("형용사");
        description118.setDescriptions(Arrays.asList(
                "오랜 세월이 지난 또는 고대의 시대에 속하는 것을 나타냅니다.",
                "고대 문명, 유물, 건축물 등을 묘사할 때 사용됩니다."
        ));
        descriptions50.add(description118);

        WordDescription description119 = new WordDescription();
        description119.setCategory("명사");
        description119.setDescriptions(Arrays.asList(
                "고대의 것 또는 오래된 것을 나타내며, 주로 역사나 과거와 관련된 맥락에서 사용됩니다.",
                "고대의 예술, 역사, 문화 등에 대한 연구가 진행 중입니다."
        ));
        descriptions50.add(description119);

        word50.setDetailDescriptions(descriptions50);


        // 단어51 : civilization "s"
        Word word51 = new Word();
        word51.setChapter(chapter17);
        word51.setWord("civilization");
        word51.setSymbol("[ˌsɪvəlaɪˈzeɪʃən]");
        word51.setWordMeaning(Arrays.asList("문명", "사회", "문화"));

        word51.setWordExample(Arrays.asList(
                "The Indus Valley civilization is one of the oldest known civilizations.",
                "civilization have contributed to the advancement of human knowledge and technology.",
                "The study of ancient civilizations provides insights into human history."
        ));

        word51.setWordExampleMeaning(Arrays.asList(
                "인더스 계곡 문명은 알려진 역사상 가장 오래된 문명 중 하나입니다.",
                "문명은 인간 지식과 기술의 발전에 기여했습니다.",
                "고대 문명의 연구는 인간 역사에 대한 통찰력을 제공합니다."
        ));

        List<WordDescription> descriptions51 = new ArrayList<>();

        WordDescription description120 = new WordDescription();
        description120.setCategory("명사");
        description120.setDescriptions(Arrays.asList(
                "인간 사회의 고도로 발전한 형태로, 문화, 기술, 정치체제 등을 포함하는 개념을 나타냅니다.",
                "문명은 복잡한 사회 조직과 발전한 기술을 특징으로 합니다."
        ));
        descriptions51.add(description120);

        WordDescription description121 = new WordDescription();
        description121.setCategory("동사");
        description121.setDescriptions(Arrays.asList(
                "문명을 형성하거나 개발하다를 나타냅니다.",
                "사회적, 문화적 발전을 통해 인간 사회가 문명을 건설하게 되었습니다."
        ));
        descriptions51.add(description121);

        word51.setDetailDescriptions(descriptions51);


        // 단어52 : government
        Word word52 = new Word();
        word52.setChapter(chapter18);
        word52.setWord("government");
        word52.setSymbol("[ˈɡʌvərnmənt]");
        word52.setWordMeaning(Arrays.asList("정부", "정치", "행정"));

        word52.setWordExample(Arrays.asList(
                "The government is responsible for maintaining law and order in the country.",
                "Different forms of government, such as democracy and monarchy, exist worldwide.",
                "government policies can have a significant impact on the economy."
        ));

        word52.setWordExampleMeaning(Arrays.asList(
                "정부는 나라의 법과 질서를 유지하는 역할을 담당합니다.",
                "민주주의와 군주제와 같은 다양한 형태의 정부가 전 세계적으로 존재합니다.",
                "정부 정책은 경제에 중요한 영향을 미칠 수 있습니다."
        ));

        List<WordDescription> descriptions52 = new ArrayList<>();

        WordDescription description122 = new WordDescription();
        description122.setCategory("명사");
        description122.setDescriptions(Arrays.asList(
                "국가 또는 지역을 행정하고 통제하기 위해 구성된 정치적 기관을 나타냅니다.",
                "정부는 법률을 제정하고 집행하며, 국가의 사회 및 경제를 관리하는 주체입니다."
        ));
        descriptions52.add(description122);

        WordDescription description123 = new WordDescription();
        description123.setCategory("동사");
        description123.setDescriptions(Arrays.asList(
                "정부가 행정을 하거나 통치를 하는 행위를 나타냅니다.",
                "정부는 국가의 안전과 공공 복지를 위해 다양한 정책을 시행합니다."
        ));
        descriptions52.add(description123);

        WordDescription description124 = new WordDescription();
        description124.setCategory("형용사");
        description124.setDescriptions(Arrays.asList(
                "정부에 관련된, 정부의 특성이나 활동과 관련된 형용사로 사용될 수 있습니다.",
                "정부 간의 협력은 국제 정치에서 중요한 역할을 합니다."
        ));
        descriptions52.add(description124);

        word52.setDetailDescriptions(descriptions52);


        // 단어53 : politics
        Word word53 = new Word();
        word53.setChapter(chapter18);
        word53.setWord("politics");
        word53.setSymbol("[ˈpɒlɪtɪks]");
        word53.setWordMeaning(Arrays.asList("정치", "정치학", "정치 활동"));

        word53.setWordExample(Arrays.asList(
                "He has a keen interest in politics and follows current events closely.",
                "The study of politics helps us understand the workings of government."
        ));

        word53.setWordExampleMeaning(Arrays.asList(
                "그는 정치에 큰 흥미를 가지고 현재의 사건들을 밀접하게 따릅니다.",
                "정치학의 연구는 정부의 작동을 이해하는 데 도움을 줍니다."
        ));

        List<WordDescription> descriptions53 = new ArrayList<>();

        WordDescription description125 = new WordDescription();
        description125.setCategory("명사");
        description125.setDescriptions(Arrays.asList(
                "정치 및 정치 활동에 관련된 모든 측면을 나타냅니다.",
                "정치는 정부의 형성, 정책 결정, 선거, 정치 인물 및 정치 체계와 관련된 주제를 다룹니다."
        ));
        descriptions53.add(description125);

        WordDescription description126 = new WordDescription();
        description126.setCategory("동사");
        description126.setDescriptions(Arrays.asList(
                "정치적 활동이나 정치에 관련된 주제에 대해 논하거나 토론하는 행위를 나타냅니다.",
                "정치적 입장을 표명하거나 정치에 참여하는 것은 시민의 권리 중 하나입니다."
        ));
        descriptions53.add(description126);

        WordDescription description127 = new WordDescription();
        description127.setCategory("형용사");
        description127.setDescriptions(Arrays.asList(
                "정치와 관련된, 정치적 활동 또는 정치 체계와 관련된 형용사로 사용됩니다.",
                "정치적 변화는 국가나 사회에 영향을 미칠 수 있습니다."
        ));
        descriptions53.add(description127);

        word53.setDetailDescriptions(descriptions53);


        // 단어54 : democracy
        Word word54 = new Word();
        word54.setChapter(chapter18);
        word54.setWord("democracy");
        word54.setSymbol("[dɪˈmɒkrəsi]");
        word54.setWordMeaning(Arrays.asList("민주주의", "대의주의", "국민 주권"));

        word54.setWordExample(Arrays.asList(
                "democracy allows citizens to participate in the decision-making process.",
                "The principles of democracy include equality and individual rights."
        ));

        word54.setWordExampleMeaning(Arrays.asList(
                "민주주의는 시민들이 의사 결정 과정에 참여할 수 있게 합니다.",
                "민주주의의 원칙에는 평등과 개인 권리가 포함되어 있습니다."
        ));

        List<WordDescription> descriptions54 = new ArrayList<>();

        WordDescription description128 = new WordDescription();
        description128.setCategory("명사");
        description128.setDescriptions(Arrays.asList(
                "국가나 사회의 행정을 국민이 직접 또는 대표를 통해 결정하는 정치 체제를 나타냅니다.",
                "민주주의는 다수의 의견을 존중하고 국민 주권을 중시하는 체제입니다."
        ));
        descriptions54.add(description128);

        WordDescription description129 = new WordDescription();
        description129.setCategory("형용사");
        description129.setDescriptions(Arrays.asList(
                "민주주의와 관련된, 민주주의 체제나 원칙과 관련된 형용사로 사용됩니다.",
                "민주주의적 원칙은 공정하고 개별 권리를 존중하는 데 중요합니다."
        ));
        descriptions54.add(description129);

        word54.setDetailDescriptions(descriptions54);


        // 단어55 : economy
        Word word55 = new Word();
        word55.setChapter(chapter19);
        word55.setWord("economy");
        word55.setSymbol("[ɪˈkɒnəmi]");
        word55.setWordMeaning(Arrays.asList("경제", "경제학", "경제체제"));

        word55.setWordExample(Arrays.asList(
                "During the recession, the country's economy contracted, leading to job losses.",
                "A stable economy is essential for the well-being of the citizens."
        ));

        word55.setWordExampleMeaning(Arrays.asList(
                "경제 침체 기간 동안 해당 국가의 경제는 축소되어 일자리가 감소하였습니다.",
                "안정된 경제는 시민의 복지에 필수적입니다."
        ));

        List<WordDescription> descriptions55 = new ArrayList<>();

        WordDescription description130 = new WordDescription();
        description130.setCategory("명사");
        description130.setDescriptions(Arrays.asList(
                "국가나 지역의 자원, 생산 및 분배와 관련된 모든 측면을 나타냅니다.",
                "경제는 고용, 가계소비, 투자, 인플레이션 등과 관련된 주제를 다룹니다."
        ));
        descriptions55.add(description130);

        WordDescription description131 = new WordDescription();
        description131.setCategory("동사");
        description131.setDescriptions(Arrays.asList(
                "경제적 활동이나 경제와 관련된 주제에 대해 논하거나 연구하는 행위를 나타냅니다.",
                "경제학자들은 경제 문제에 대한 연구와 분석을 수행합니다."
        ));
        descriptions55.add(description131);

        WordDescription description132 = new WordDescription();
        description132.setCategory("형용사");
        description132.setDescriptions(Arrays.asList(
                "경제와 관련된, 경제 활동 또는 경제 상태와 관련된 형용사로 사용됩니다.",
                "경제적 예측은 비즈니스와 투자 결정에 영향을 미칩니다."
        ));
        descriptions55.add(description132);

        word55.setDetailDescriptions(descriptions55);


        // 단어56 : business - "s"
        Word word56 = new Word();
        word56.setChapter(chapter19);
        word56.setWord("business");
        word56.setSymbol("[ˈbɪznɪs]");
        word56.setWordMeaning(Arrays.asList("사업", "비즈니스", "업무"));

        word56.setWordExample(Arrays.asList(
                "Starting a small business can be a challenging but rewarding endeavor.",
                "She has a background in business management and entrepreneurship.",
                "Globalization has transformed the way businesses operate."
        ));

        word56.setWordExampleMeaning(Arrays.asList(
                "소규모 사업을 시작하는 것은 어려운 도전이지만 보람 있는 노력일 수 있습니다.",
                "그녀는 비즈니스 관리와 기업가정신에 대한 배경을 가지고 있습니다.",
                "세계화는 비즈니스 운영 방식을 변화시켰습니다."
        ));

        List<WordDescription> descriptions56 = new ArrayList<>();

        WordDescription description133 = new WordDescription();
        description133.setCategory("명사");
        description133.setDescriptions(Arrays.asList(
                "상품 또는 서비스를 생산하고 판매하기 위한 활동을 나타냅니다.",
                "사업은 이윤을 추구하거나 사회적 목표를 달성하기 위해 다양한 형태로 수행될 수 있습니다."
        ));
        descriptions56.add(description133);

        WordDescription description134 = new WordDescription();
        description134.setCategory("동사");
        description134.setDescriptions(Arrays.asList(
                "상업 활동을 수행하거나 사업을 경영하는 행위를 나타냅니다.",
                "그 회사는 세계적으로 사업을 확장하고 있습니다."
        ));
        descriptions56.add(description134);

        WordDescription description135 = new WordDescription();
        description135.setCategory("형용사");
        description135.setDescriptions(Arrays.asList(
                "사업과 관련된, 비즈니스 활동 또는 사업 분야와 관련된 형용사로 사용됩니다.",
                "비즈니스 전략은 시장에서 경쟁력을 확보하는 데 중요합니다."
        ));
        descriptions56.add(description135);

        word56.setDetailDescriptions(descriptions56);

        // 단어57 : market
        Word word57 = new Word();
        word57.setChapter(chapter19);
        word57.setWord("market");
        word57.setSymbol("[ˈmɑːrkɪt]");
        word57.setWordMeaning(Arrays.asList("시장", "마켓", "경제적 거래 장소"));

        word57.setWordExample(Arrays.asList(
                "The stock market experienced a sudden drop in prices.",
                "Local farmers bring their produce to the farmers' market every weekend.",
                "Companies conduct market research to understand consumer preferences."
        ));

        word57.setWordExampleMeaning(Arrays.asList(
                "주식 시장은 가격이 갑자기 하락한 경험을 했습니다.",
                "지역 농부들은 매주 농산물을 시장에 가져옵니다.",
                "기업은 소비자 선호도를 이해하기 위해 시장 조사를 수행합니다."
        ));

        List<WordDescription> descriptions57 = new ArrayList<>();

        WordDescription description139 = new WordDescription();
        description139.setCategory("명사");
        description139.setDescriptions(Arrays.asList(
                "상품이나 서비스의 거래가 이루어지는 장소를 나타냅니다.",
                "시장은 소비자와 생산자 간의 경제적 상호 작용의 중심 역할을 합니다."
        ));
        descriptions57.add(description139);

        WordDescription description140 = new WordDescription();
        description140.setCategory("동사");
        description140.setDescriptions(Arrays.asList(
                "상품이나 서비스를 홍보하거나 판매하기 위해 노력하는 행위를 나타냅니다.",
                "그 회사는 제품을 글로벌 시장에 소개하려고 합니다.",
                "소매업체는 고객에게 제품을 시장 가격에 판매합니다."
        ));
        descriptions57.add(description140);

        word57.setDetailDescriptions(descriptions57);


        // 단어58 : science
        Word word58 = new Word();
        word58.setChapter(chapter20);
        word58.setWord("science");
        word58.setSymbol("[ˈsaɪəns]");
        word58.setWordMeaning(Arrays.asList("과학", "과학 분야", "학문"));

        word58.setWordExample(Arrays.asList(
                "science has made significant advancements in understanding the universe.",
                "She is pursuing a degree in computer science."
        ));

        word58.setWordExampleMeaning(Arrays.asList(
                "과학은 우주를 이해하는 데 중요한 발전을 이루었습니다.",
                "그녀는 컴퓨터 과학 학위를 취득하려고 하고 있습니다."
        ));

        List<WordDescription> descriptions58 = new ArrayList<>();

        WordDescription description142 = new WordDescription();
        description142.setCategory("명사");
        description142.setDescriptions(Arrays.asList(
                "자연 현상과 현상에 대한 지식을 탐구하고 설명하는 학문을 나타냅니다.",
                "과학은 실험, 관찰 및 이론을 통해 정보를 수집하고 분석하는 프로세스를 포함합니다."
        ));
        descriptions58.add(description142);

        WordDescription description143 = new WordDescription();
        description143.setCategory("형용사");
        description143.setDescriptions(Arrays.asList(
                "과학 분야와 관련된, 과학적인 원리나 방법을 사용하는 형용사로 사용됩니다.",
                "과학적 연구는 현대 사회의 발전에 중요한 역할을 합니다."
        ));
        descriptions58.add(description143);

        word58.setDetailDescriptions(descriptions58);


        // 단어59 : experiment - "s"
        Word word59 = new Word();
        word59.setChapter(chapter20);
        word59.setWord("experiment");
        word59.setSymbol("[ɪkˈsperɪmənt]");
        word59.setWordMeaning(Arrays.asList("실험", "실험 연구", "시험"));

        word59.setWordExample(Arrays.asList(
                "The scientist conducted an experiment to test his hypothesis.",
                "Students were asked to write a report on their chemistry experiments.",
                "The success of the new product was the result of careful market experiments."
        ));

        word59.setWordExampleMeaning(Arrays.asList(
                "과학자는 자신의 가설을 테스트하기 위해 실험을 수행했습니다.",
                "학생들은 자신들의 화학 실험에 대한 보고서를 작성하도록 요청받았습니다.",
                "새로운 제품의 성공은 신중한 시장 실험의 결과였습니다."
        ));

        List<WordDescription> descriptions59 = new ArrayList<>();

        WordDescription description144 = new WordDescription();
        description144.setCategory("명사");
        description144.setDescriptions(Arrays.asList(
                "목적 또는 가설을 확인하거나 데이터를 수집하기 위해 특정한 조건에서 수행되는 과학적 또는 체계적인 행위를 나타냅니다.",
                "실험은 과학 연구의 중요한 부분이며 새로운 지식을 얻는 데 기여합니다."
        ));
        descriptions59.add(description144);

        WordDescription description145 = new WordDescription();
        description145.setCategory("동사");
        description145.setDescriptions(Arrays.asList(
                "실험을 수행하거나 시험을 진행하는 행위를 나타냅니다.",
                "연구자들은 새로운 약물을 실험하고 효과를 확인하기 위해 시험합니다."
        ));
        descriptions59.add(description145);

        word59.setDetailDescriptions(descriptions59);


        // 단어60 : discovery
        Word word60 = new Word();
        word60.setChapter(chapter20);
        word60.setWord("discovery");
        word60.setSymbol("[dɪˈskʌvəri]");
        word60.setWordMeaning(Arrays.asList("발견", "발굴", "발명"));

        word60.setWordExample(Arrays.asList(
                "The discovery of penicillin revolutionized medicine.",
                "Archaeologists made a significant discovery in the ancient tomb.",
                "Her invention was a groundbreaking discovery in the field of technology."
        ));

        word60.setWordExampleMeaning(Arrays.asList(
                "페니실린의 발견은 의학을 혁명화했습니다.",
                "고고학자들은 고대 무덤에서 중요한 발견을 했습니다.",
                "그녀의 발명품은 기술 분야에서 혁신적인 발견이었습니다."
        ));

        List<WordDescription> descriptions60 = new ArrayList<>();

        WordDescription description146 = new WordDescription();
        description146.setCategory("명사");
        description146.setDescriptions(Arrays.asList(
                "새로운 정보, 사실, 물건, 현상 등을 처음으로 발견하는 행위나 결과를 나타냅니다.",
                "발견은 지식의 확장과 혁신에 중요한 역할을 합니다."
        ));
        descriptions60.add(description146);

        WordDescription description147 = new WordDescription();
        description147.setCategory("동사");
        description147.setDescriptions(Arrays.asList(
                "새로운 정보, 사실, 물건, 현상 등을 발견하거나 발굴하는 행위를 나타냅니다.",
                "과학자들은 행성 탐사 중에 새로운 천체를 발견했습니다."
        ));
        descriptions60.add(description147);

        word60.setDetailDescriptions(descriptions60);


        Set<Long> existingWordIds = new HashSet<>();
        List<Long> allWordIds = wordRepository.findAllWordIds();
        existingWordIds.addAll(allWordIds);

        Word[] words = new Word[]{
                word1, word2, word3, word4, word5, word6, word7, word8, word9, word10,
                word11, word12, word13, word14, word15, word16, word17, word18, word19, word20,
                word21, word22, word23, word24, word25, word26, word27, word28, word29, word30,
                word31, word32, word33, word34, word35, word36, word37, word38, word39, word40,
                word41, word42, word43, word44, word45, word46, word47, word48, word49, word50,
                word51, word52, word53, word54, word55, word56, word57, word58, word59, word60
        };

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


CREATE TABLE IF NOT EXISTS WordTest (
       wordId INT AUTO_INCREMENT PRIMARY KEY,
       word VARCHAR(255),
       symbol VARCHAR(255),
       wordMeaning VARCHAR(255),
       detailCategories VARCHAR(255),
       wordExample VARCHAR(255),
       wordExampleMeanings VARCHAR(255)
);

INSERT INTO WordTest (wordId, word, symbol, wordMeaning, detailCategories, wordExample, wordExampleMeanings)
VALUES (1, 'hello', 'həˈloʊ', '안녕하세요, 안부, 여보세요', '감탄사, 명사', 'Hello John, how are you?', '안녕하세요, 존. 어떻게 지내세요?'),
       (2, 'bye', 'baɪ', '안녕, 부전승', '감탄사', 'Bye! See you next week.', '안녕! 다음주에 봐.'),
       (3, 'hi', 'haɪ', '안녕', '감탄사', 'Hi guys!', '안녕, 친구들!'),
       (4, 'Shopaholic', 'ˌʃɑːpəˈhɒlɪk', '쇼핑 중독자, 쇼핑 중독의', '명사', 'She''s a shopaholic and cant resist buying new clothes.', '그녀는 쇼핑 중독자로 새 옷을 사지 않을 수 없어.'),
       (5, 'Discount', 'ˈdɪskaʊnt', '할인, 할인가', '명사', 'I got a 20% discount on these shoes.', '이 신발을 20% 할인받았어.'),
       (6, 'Checkout', 'ˈtʃekaʊt', '계산, 계산대', '명사', 'Let''s head to the checkout to pay for our items.', '우리 물건 계산하러 계산대로 가자.'),
       (7, 'Directions', 'daɪˈrɛkʃənz', '길 안내, 방향', '명사', 'Can you give me directions to the nearest train station?', '가장 가까운 기차역까지 길 안내해줄 수 있나요?'),
       (8, 'Assistance', 'əˈsɪstəns', '도움, 지원', '명사', 'I need assistance with my luggage, please.', '제 짐을 들어주실 수 있을까요?'),
       (9,  'Map', 'mæp', '지도, 지도를 보다', '명사', 'I''ll check the map to find our way to the hotel.', '호텔로 가는 길을 찾기 위해 지도를 확인하겠어.'),
       (10, 'Inquiry', 'ɪnˈkwaɪəri', '질문, 조사', '명사', 'I sent an inquiry to the customer service department.', '고객 서비스 부서에 질문을 보냈습니다.'),
       (11, 'Response', 'rɪˈspɒns', '답변, 대답', '명사', 'I''m waiting for a response from the company regarding my complaint.', '회사로부터 제 불만에 대한 답변을 기다리고 있습니다.'),
       (12, 'Interrogate', 'ɪnˈtɛrəˌɡeɪt', '심문하다, 질문하다', '동사', 'The detective will interrogate the suspect to gather more information.', '형사는 더 많은 정보를 수집하기 위해 용의자를 심문할 것입니다.'),
       (13, 'Sunny', 'ˈsʌni', '맑은, 해가 뜨는', '형용사', 'It''s a sunny day, perfect for a picnic.', '오늘은 맑은 날씨로 피크닉하기 딱 좋아.'),
       (14, 'Overcast', 'ˌoʊvərˈkæst', '흐린, 구름이 끼인', '형용사', 'The sky is overcast, so it might rain later.', '하늘이 흐리니까 나중에 비 올 수도 있어.'),
       (15, 'Breezy', 'ˈbri:zi', '바람이 부는, 바람 부는', '형용사', 'It''s quite breezy today, so be sure to bring a jacket.', '오늘은 바람이 꽤 불어서 자켓을 가져오는 것이 좋겠어.'),
       (16, 'Working', 'ˈwɜrkɪŋ', '작업 중, 일하는', '형용사', 'I''m sorry, I can''t talk right now; I''m working on a project.', '미안해요, 지금 말할 수 없어요. 프로젝트를 작업 중이에요.'),
       (17, 'Studying', 'ˈstʌdiɪŋ', '공부 중, 공부하는', '형용사', 'He can''t join us for dinner because he''s studying for an exam.', '시험 공부 중이라서 저녁에 우리와 함께 가입할 수 없어요.'),
       (18, 'Eating', 'ˈitɪŋ', '먹는 중, 식사 중인', '형용사', 'Please don''t disturb me while I''m eating my lunch.', '점심 먹는 중에는 방해하지 마세요.'),
       (19, 'Ingredients', 'ɪnˈɡriːdiənts', '재료, 성분', '명사', 'The recipe calls for a list of specific ingredients.', '이 레시피에는 특정한 재료 목록이 필요해.'),
       (20, 'Simmer', 'ˈsɪmər', '느린 끓임, 약한 끓음', '동사', 'Let the soup simmer on low heat for 30 minutes.', '30분 동안 낮은 불로 수프를 약한 끓임 상태로 끓여 두세요.'),
       (21, 'Seasoning', 'ˈsiːzənɪŋ', '조미료, 양념', '명사', 'You can add some extra seasoning to enhance the flavor.', '맛을 높이기 위해 약간의 추가적인 양념을 넣을 수 있어.'),
       (22, 'He', 'hiː', '그는, 그가', '대명사', 'He is my brother, and he is coming to visit us tomorrow.', '그는 내 동생이고, 그가 내일 우리를 방문할 거야.'),
       (23, 'She', 'ʃiː', '그녀는, 그녀가', '대명사', 'She is a talented musician, and she will perform tonight.', '그녀는 재능 있는 음악가이고, 그녀가 오늘 밤에 공연할 거야.'),
       (24, 'They', 'ðeɪ', '그들은, 그들이', '대명사', 'They are my friends, and they are going on a trip together.', '그들은 내 친구들이고, 그들이 함께 여행 갈 거야.'),
       (25, 'Neighbor', 'ˈneɪbər', '이웃, 이웃 사람', '명사', 'I met my new neighbor yesterday.', '어제 새 이웃을 만났어.'),
       (26, 'Chat', 'ʧæt', '잡담하다, 대화하다', '동사', 'I like to chat with my neighbors when I see them outside.', '이웃들을 밖에서 만날 때 대화하는 걸 좋아해.'),
       (27, 'Friendly', 'ˈfrɛndli', '친근한, 친절한', '형용사', 'My neighbor is very friendly and always says hello.', '내 이웃은 매우 친근하고 항상 인사해.'),
       (28, 'Visited', 'ˈvɪzɪtɪd', '방문한, 찾아갔던', '과거분사', 'I visited my grandparents last weekend.', '저번 주말에 할아버지와 할머니를 방문했습니다.'),
       (29, 'Ate', 'eɪt', '먹었던, 먹은', '과거형', 'I ate sushi for dinner last night.', '어젠 저녁에 초밥을 먹었어요.'),
       (30, 'Traveled', 'ˈtrævəld', '여행했던, 여행한', '과거분사', 'We traveled to Europe last summer.', '저희는 지난 여름에 유럽으로 여행했어요.')

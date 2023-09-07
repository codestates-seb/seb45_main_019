CREATE TABLE IF NOT EXISTS WORD (
       wordId bigint NOT NULL,
       word VARCHAR(255),
       symbol VARCHAR(255),
       wordMeaning VARCHAR(255),
       detailCategories VARCHAR(255),
       wordExample VARCHAR(255),
       wordExampleMeaning VARCHAR(255),
       PRIMARY KEY (wordId)
);

CREATE TABLE IF NOT EXISTS QUESTION (
       questionId bigint NOT NULL,
       chapterId BIGINT,
       questionType BIGINT,
       question VARCHAR(255),
       examples VARCHAR(255),
       correct VARCHAR(255),
       translation VARCHAR(255),
       PRIMARY KEY (questionId)
);
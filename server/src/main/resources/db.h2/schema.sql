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
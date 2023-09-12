CREATE TABLE IF NOT EXISTS WORD (
       wordId bigint NOT NULL,
       chapter_Id BIGINT,
       word VARCHAR(255),
       symbol VARCHAR(255),
       wordMeaning VARCHAR(255),
       detailCategories VARCHAR(255),
       detailDescriptions VARCHAR(255),
       wordExample VARCHAR(255),
       wordExampleMeaning VARCHAR(255),
       PRIMARY KEY (wordId)
);

CREATE TABLE IF NOT EXISTS CHAPTER (
    chapter_Id bigint NOT NULL,
    chapter_Title varchar(255),
    PRIMARY KEY (chapter_Id)
);
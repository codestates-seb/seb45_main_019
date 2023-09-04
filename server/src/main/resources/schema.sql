CREATE TABLE IF NOT EXISTS word (
    wordId INT AUTO_INCREMENT PRIMARY KEY,
    word VARCHAR(255),
    symbol VARCHAR(255),
    wordMeaning VARCHAR(255),
    detailCategories VARCHAR(255),
    wordExample VARCHAR(255),
    wordExampleMeanings VARCHAR(255)
    );
package ILearn.word.mapper;

import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T16:37:36+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class WordMapperImpl implements WordMapper {

    @Override
    public WordGetDto entityToResponseDto(Word word) {
        if ( word == null ) {
            return null;
        }

        Long wordId = null;
        String word1 = null;
        String symbol = null;
        String wordMeaning = null;
        String detailCategories = null;
        String wordExample = null;
        String wordExampleMeaning = null;

        wordId = word.getWordId();
        word1 = word.getWord();
        symbol = word.getSymbol();
        wordMeaning = word.getWordMeaning();
        detailCategories = word.getDetailCategories();
        wordExample = word.getWordExample();
        wordExampleMeaning = word.getWordExampleMeaning();

        String detailDescriptions = null;

        WordGetDto wordGetDto = new WordGetDto( wordId, word1, symbol, wordMeaning, detailCategories, detailDescriptions, wordExample, wordExampleMeaning );

        return wordGetDto;
    }
}

package ILearn.word.mapper;

import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T10:17:26+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class WordMapperImpl implements WordMapper {

    @Override
    public WordGetDto entityToResponseDto(Word word) {
        if ( word == null ) {
            return null;
        }

        List<String> wordMeaning = null;
        List<String> detailCategories = null;
        List<String> detailDescriptions = null;
        List<String> wordExample = null;
        List<String> wordExampleMeaning = null;
        Long wordId = null;
        String word1 = null;
        String symbol = null;

        List<String> list = word.getWordMeaning();
        if ( list != null ) {
            wordMeaning = new ArrayList<String>( list );
        }
        List<String> list1 = word.getDetailCategories();
        if ( list1 != null ) {
            detailCategories = new ArrayList<String>( list1 );
        }
        List<String> list2 = word.getDetailDescriptions();
        if ( list2 != null ) {
            detailDescriptions = new ArrayList<String>( list2 );
        }
        List<String> list3 = word.getWordExample();
        if ( list3 != null ) {
            wordExample = new ArrayList<String>( list3 );
        }
        List<String> list4 = word.getWordExampleMeaning();
        if ( list4 != null ) {
            wordExampleMeaning = new ArrayList<String>( list4 );
        }
        wordId = word.getWordId();
        word1 = word.getWord();
        symbol = word.getSymbol();

        WordGetDto wordGetDto = new WordGetDto( wordId, word1, symbol, wordMeaning, detailCategories, detailDescriptions, wordExample, wordExampleMeaning );

        return wordGetDto;
    }
}

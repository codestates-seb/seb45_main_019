package ILearn.word.response;

import ILearn.word.dto.WordGetDto;
import ILearn.word.entity.Word;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WordApiResponse {
    private boolean status;
    private String msg;
    private WordGetDto data;
}
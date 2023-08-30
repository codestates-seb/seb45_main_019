package ILearn.word.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WordApiResponse {
    private boolean status;
    private String msg;
    private Object data;
}
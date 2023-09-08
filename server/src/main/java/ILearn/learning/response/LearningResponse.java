package ILearn.learning.response;

import ILearn.learning.dto.LearningDataDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LearningResponse {

    private boolean status;
    private String msg;
    private List<LearningDataDto> data;

    public LearningResponse(boolean status, String msg, List<LearningDataDto> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
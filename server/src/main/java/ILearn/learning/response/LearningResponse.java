package ILearn.learning.response;

import ILearn.learning.dto.LearningDataDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LearningResponse {

    private boolean status;
    private String msg;
    private LearningDataDto data;

    public LearningResponse(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public LearningResponse(boolean status, String msg, LearningDataDto data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public void setData(LearningDataDto data) {
        this.data = data;
    }
}
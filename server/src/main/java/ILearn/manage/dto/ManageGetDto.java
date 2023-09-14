package ILearn.manage.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ManageGetDto {
    private List<ManageListDto> chapterList;
}

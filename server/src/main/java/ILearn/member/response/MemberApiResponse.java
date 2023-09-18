package ILearn.member.response;

import ILearn.member.dto.MemberResponseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "회원 정보 조회")
public class MemberApiResponse {
    @ApiModelProperty(value = "성공 여부", example = "false")
    private boolean status;

    @ApiModelProperty(value = "에러 코드", example = "940")
    private int errorCode;

    @ApiModelProperty(value = "응답 메시지", example = "success")
    private String msg;

    @ApiModelProperty(value = "데이터 객체", example = "null")
    private MemberResponseDto data;
}

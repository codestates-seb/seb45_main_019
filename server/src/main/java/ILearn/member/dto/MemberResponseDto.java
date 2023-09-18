package ILearn.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "회원 정보")
public class MemberResponseDto { //회원 정보 조회 응답 형식
        private Long userId;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private String username;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private String email;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private String nickname;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private int point;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private int rank;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private boolean memberStatus;
        @ApiModelProperty(value = "유저 이름", example = "Test1")
        private List<String> roles;
}
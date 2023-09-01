package ILearn.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@NoArgsConstructor
public class MemberPatchDto {

    @NotBlank(message = "닉네임을 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9$@!%*#?&]{5,20}$",
            message = "닉네임은 5~20글자로 이루어져야 하며, 특수문자도 포함 가능합니다.")
    private String nickname;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]$@!%*#?&]{8,20}$",
            message = "비밀번호는 영문, 숫자를 포함하여 8~20자리여야 합니다.")
    private String password;
}
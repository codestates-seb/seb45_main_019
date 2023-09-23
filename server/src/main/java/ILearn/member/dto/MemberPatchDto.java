package ILearn.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberPatchDto {

    @Pattern(regexp = "^[A-Za-z0-9가-힣$@!%*#?&]{5,20}$",
            message = "NICKNAME_ERROR") // 닉네임은 5~20글자로 이루어져야 하며, 특수문자도 포함 가능합니다.
    private String nickname;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$",
            message = "PASSWORD_ERROR") // 비밀번호는 하나 이상의 영문, 숫자, 특수 문자를 포함, 8~20자리 입니다.
    private String password;
}
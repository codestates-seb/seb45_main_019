package ILearn.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto { //회원 정보 조회 응답 형식

    private boolean status;
    private String msg;
    private Data data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private Long userId;
        private String username;
        private String email;
        private String nickname;
        private int point;
        private String memberStatus;
    }
}
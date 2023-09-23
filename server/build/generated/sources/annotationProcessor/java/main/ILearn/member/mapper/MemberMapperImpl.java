package ILearn.member.mapper;

import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberPostDto;
import ILearn.member.dto.MemberPostResponseDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-23T16:51:41+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToEntity(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setUsername( memberPostDto.getUsername() );
        member.setPassword( memberPostDto.getPassword() );
        member.setNickname( memberPostDto.getNickname() );

        return member;
    }

    @Override
    public Member memberPatchDtoToEntity(MemberPatchDto memberPatchDto) {
        if ( memberPatchDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setPassword( memberPatchDto.getPassword() );
        member.setNickname( memberPatchDto.getNickname() );

        return member;
    }

    @Override
    public MemberResponseDto entityToResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        memberResponseDto.setUserId( member.getUserId() );
        memberResponseDto.setUsername( member.getUsername() );
        memberResponseDto.setNickname( member.getNickname() );
        memberResponseDto.setPoint( member.getPoint() );
        memberResponseDto.setUserRank( member.getUserRank() );
        memberResponseDto.setMemberStatus( member.isMemberStatus() );
        List<String> list = member.getRoles();
        if ( list != null ) {
            memberResponseDto.setRoles( new ArrayList<String>( list ) );
        }

        return memberResponseDto;
    }

    @Override
    public MemberPostResponseDto entityToPostResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberPostResponseDto memberPostResponseDto = new MemberPostResponseDto();

        memberPostResponseDto.setUserId( member.getUserId() );

        return memberPostResponseDto;
    }
}

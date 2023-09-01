package ILearn.member.mapper;

import ILearn.member.dto.MemberPatchDto;
import ILearn.member.dto.MemberPostDto;
import ILearn.member.dto.MemberResponseDto;
import ILearn.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper(componentModel = "spring")
public interface MemberMapper extends JpaRepository<Member, Long> {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "point", ignore = true)
    @Mapping(target = "memberStatus", ignore = true)
    @Mapping(target = "wordBook", ignore = true)
    Member memberPostDtoToEntity(MemberPostDto memberPostDto);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "point", ignore = true)
    @Mapping(target = "memberStatus", ignore = true)
    @Mapping(target = "wordBook", ignore = true)
    Member memberPatchDtoToEntity(MemberPatchDto memberPatchDto);

    MemberResponseDto entityToResponseDto(Member member);
}
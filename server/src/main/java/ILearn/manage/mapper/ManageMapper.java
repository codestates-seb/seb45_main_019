package ILearn.manage.mapper;

import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManageListDto;
import ILearn.manage.dto.ManageResponseDto;
import ILearn.manage.entity.Manage;

import ILearn.member.mapper.MemberMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManageMapper {

    ManageMapper INSTANCE = Mappers.getMapper(ManageMapper.class);

    ManageGetDto entityToResponseDto(Manage manage);

    ManageListDto toManageListDto(Manage manage);

    List<ManageListDto> toManageListDtoList(List<Manage> manages);
}

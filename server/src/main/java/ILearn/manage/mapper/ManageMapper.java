package ILearn.manage.mapper;

import ILearn.manage.dto.ManageGetDto;
import ILearn.manage.dto.ManageListDto;
import ILearn.manage.entity.Manage;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManageMapper {
    ManageGetDto entityToResponseDto(Manage manage);

    ManageListDto toManageListDto(Manage manage);

    List<ManageListDto> toManageListDtoList(List<Manage> manages);
}

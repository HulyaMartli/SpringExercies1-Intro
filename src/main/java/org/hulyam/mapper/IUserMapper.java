package org.hulyam.mapper;

import org.hulyam.dto.request.UserSaveRequestDto;
import org.hulyam.dto.response.UserFindAllResponseDto;
import org.hulyam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
    /* This is the standart use up to this point.
    After that, it depends on our structure
    The methods for the classes that we want to convert
    will be written after that point. */

    UserFindAllResponseDto toUserFindAllResponseDto(final User user);

    User fromSaveRequestDto(final UserSaveRequestDto dto);

}

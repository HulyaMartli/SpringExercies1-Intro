package org.hulyam.mapper;

import javax.annotation.processing.Generated;
import org.hulyam.dto.request.UserSaveRequestDto;
import org.hulyam.dto.response.UserFindAllResponseDto;
import org.hulyam.repository.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T17:02:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserFindAllResponseDto toUserFindAllResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserFindAllResponseDto.UserFindAllResponseDtoBuilder userFindAllResponseDto = UserFindAllResponseDto.builder();

        userFindAllResponseDto.username( user.getUsername() );
        userFindAllResponseDto.name( user.getName() );
        userFindAllResponseDto.profilePicture( user.getProfilePicture() );

        return userFindAllResponseDto.build();
    }

    @Override
    public User fromSaveRequestDto(UserSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.address( dto.getAddress() );
        user.tel( dto.getTel() );

        return user.build();
    }
}

package org.hulyam.service;

import org.hulyam.dto.request.UserSaveRequestDto;
import org.hulyam.dto.response.UserFindAllResponseDto;
import org.hulyam.mapper.IUserMapper;
import org.hulyam.repository.IUserRepository;
import org.hulyam.repository.entity.User;
import org.hulyam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findByAddress(String address) {
        return userRepository.findByAddress(address);
    }

    public User findByNameAndAddress(String name, String address) {
        return userRepository.findByNameAndAddress(name, address);
    }

    public List<User> findByNameOrAddress(String name, String address) {
        return userRepository.findByNameOrAddress(name, address);
    }

    public User findByNameAndAddressAndTel(String name, String address, String tel) {
        return userRepository.findByNameAndAddressAndTel(name, address, tel);
    }

    public List<User> findAllByCity(String city) {
        return userRepository.findAllByCity(city);
    }

    public List<User> findAllByNameStartsWith(String word) {
        return userRepository.findAllByNameStartsWith(word);
    }

    public Optional<User> findOptionalByNameAndTel(String name, String tel) {
        return userRepository.findOptionalByNameAndTel(name, tel);
    }

    public List<User> findAllByNameOrderByIdDesc(String name) {
        return userRepository.findAllByNameOrderByIdDesc(name);
    }

    public List<User> findTop3ByNameOrderById(String name) {
        return userRepository.findTop3ByNameOrderById(name);
    }

    public void saveDto(UserSaveRequestDto dto) {
        /*
            User user = User.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .tel(dto.getTel())
                .build();
        */
        // Instead of the code above,
        // thanks to MapStruct we can do it in one line:
        save(IUserMapper.INSTANCE.fromSaveRequestDto(dto));
    }

    public List<UserFindAllResponseDto> findAllResponseDto() {
        List<UserFindAllResponseDto> list = new ArrayList<>();
        /*
        findAll().forEach(user -> {
            list.add(UserFindAllResponseDto.builder()
                            .name(user.getName())
                            .username(user.getUsername())
                            .profilePicture(user.getProfilePicture())
                    .build());
        });
        */
        findAll().forEach(user -> {
            list.add(IUserMapper.INSTANCE.toUserFindAllResponseDto(user));
        });
        return list;
    }
}

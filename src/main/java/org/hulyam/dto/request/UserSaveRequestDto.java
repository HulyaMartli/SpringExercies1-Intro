package org.hulyam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Only the data required from the user while saving a user.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {
    String name;
    String address;
    String tel;
    String token;
    String ip;
    String userComputerModel;

}

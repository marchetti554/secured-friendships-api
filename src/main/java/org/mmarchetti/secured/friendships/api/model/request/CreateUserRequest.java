package org.mmarchetti.secured.friendships.api.model.request;

import lombok.Data;
import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.util.MappableRequest;

import java.time.LocalDate;

/**
 *  Request model to create a new user.
 *
 * @author Marco Marchetti
 */
@Data
public class CreateUserRequest implements MappableRequest<UserDto> {

    private String documentID;
    private String name;
    private String email;
    private LocalDate birthDate;

    @Override
    public UserDto toDTO() {
        return UserDto.builder()
                .documentID(this.documentID)
                .name(this.name)
                .email(this.email)
                .birthDate(this.birthDate)
                .build();
    }
}

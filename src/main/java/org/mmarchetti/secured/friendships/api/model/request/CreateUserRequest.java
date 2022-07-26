package org.mmarchetti.secured.friendships.api.model.request;

import lombok.Data;
import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.util.MappableRequest;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateUserRequest implements MappableRequest<UserDto> {

    private String documentID;
    private String name;
    private LocalDate birthDate;
    private Set<String> friendsList;

    @Override
    public UserDto toDTO() {
        return UserDto.builder()
                .documentID(this.documentID)
                .name(this.name)
                .birthDate(this.birthDate)
                .friendsList(this.friendsList)
                .build();
    }
}

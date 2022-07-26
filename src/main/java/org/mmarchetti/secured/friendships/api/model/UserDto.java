package org.mmarchetti.secured.friendships.api.model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class UserDto {

    @Id
    public ObjectId _id;

    private String documentID;
    private String name;
    private LocalDate birthDate;
    private Set<String> friendsList;
}

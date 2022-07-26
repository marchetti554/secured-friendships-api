package org.mmarchetti.secured.friendships.api.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Document(collection = "users")
@Data
public class UserDto {

    @Id
    public ObjectId _id;

    private String documentID;
    private String name;
    private LocalDate birthDate;
    private Set<String> friendsList;
}

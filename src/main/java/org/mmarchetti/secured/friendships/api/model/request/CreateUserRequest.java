package org.mmarchetti.secured.friendships.api.model.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateUserRequest {

    private String documentID;
    private String name;
    private LocalDate birthDate;
    private Set<String> friendsList;
}

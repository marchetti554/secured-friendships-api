package org.mmarchetti.secured.friendships.api.service;

import org.mmarchetti.secured.friendships.api.model.request.CreateUserRequest;
import org.mmarchetti.secured.friendships.api.model.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getAllUsers();
    UserDto getUserByDocumentID(String documentID);
    UserDto addNewUser(CreateUserRequest request);
}

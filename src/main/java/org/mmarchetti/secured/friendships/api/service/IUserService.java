package org.mmarchetti.secured.friendships.api.service;

import org.mmarchetti.secured.friendships.api.model.request.CreateUserRequest;
import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.model.request.UpdateUserRequest;

import java.util.List;

/**
 *  Interface defining all user methods.
 *
 * @author Marco Marchetti
 */
public interface IUserService {

    List<UserDto> getAllUsers();
    UserDto getUserByDocumentID(String documentID);
    UserDto addNewUser(CreateUserRequest request);
    UserDto updateUser(UpdateUserRequest request);
    UserDto deleteUserByDocumentID(String documentID);
}

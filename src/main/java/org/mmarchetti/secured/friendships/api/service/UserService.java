package org.mmarchetti.secured.friendships.api.service;

import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.model.request.CreateUserRequest;
import org.mmarchetti.secured.friendships.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserByDocumentID(String documentID) {
        return userRepository.findByDocumentID(documentID);
    }

    @Override
    public UserDto addNewUser(CreateUserRequest request) {
        return userRepository.save(request.toDTO());
    }
}

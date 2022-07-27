package org.mmarchetti.secured.friendships.api.service;

import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.model.request.CreateUserRequest;
import org.mmarchetti.secured.friendships.api.model.request.UpdateUserRequest;
import org.mmarchetti.secured.friendships.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link IUserService}.
 *
 * @author Marco Marchetti
 */
@Service
public class UserService implements IUserService {

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    /**
     *
     * @return
     */
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     *
     * @param documentID
     * @return
     */
    @Override
    public UserDto getUserByDocumentID(String documentID) {
        return userRepository.findByDocumentID(documentID);
    }

    /**
     *
     * @param request
     * @return
     */
    @Override
    public UserDto updateUser(UpdateUserRequest request) {
        return userRepository.save(request.toDTO());
    }

    /**
     *
     * @param request
     * @return
     */
    @Override
    public UserDto addNewUser(CreateUserRequest request) {
        return userRepository.save(request.toDTO());
    }

    /**
     *
     * @param documentID
     * @return
     */
    @Override
    public UserDto deleteUserByDocumentID(String documentID) {
        return userRepository.deleteByDocumentID(documentID);
    }
}

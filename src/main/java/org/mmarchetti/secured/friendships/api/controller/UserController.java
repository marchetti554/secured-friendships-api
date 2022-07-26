package org.mmarchetti.secured.friendships.api.controller;

import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.model.request.CreateUserRequest;
import org.mmarchetti.secured.friendships.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User controller.
 *
 * @author Marco Marchetti
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    /**
     * Gets a user by its documentID.
     * @param documentID
     *  user's documentID
     * @return
     *  if found, the user
     */
    @GetMapping(value = "/{documentID}", produces = "application/json")
    public UserDto getUserByDocumentID(@PathVariable("documentID") String documentID) {
        return userService.getUserByDocumentID(documentID);
    }

    /**
     * Gets all users
     *
     * @return
     *  a list with all users
     */
    @GetMapping(value = "/all", produces = "application/json")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/new", produces = "application/json")
    public UserDto addNewUser(@RequestBody CreateUserRequest request) {
        return userService.addNewUser(request);
    }
}

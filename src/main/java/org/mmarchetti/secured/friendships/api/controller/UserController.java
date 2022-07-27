package org.mmarchetti.secured.friendships.api.controller;

import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.mmarchetti.secured.friendships.api.model.request.CreateUserRequest;
import org.mmarchetti.secured.friendships.api.model.request.UpdateUserRequest;
import org.mmarchetti.secured.friendships.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<UserDto> getUserByDocumentID(@PathVariable("documentID") String documentID) {
        return ResponseEntity
                .ok(userService.getUserByDocumentID(documentID));
    }

    /**
     * Gets all users
     *
     * @return
     *  a list with all users
     */
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity
                .ok(userService.getAllUsers());
    }

    /**
     * Updates an existing user
     * @param request
     *  user update request
     * @return
     *  a list with all users
     */
    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUserRequest request) {
        return ResponseEntity
                .ok(userService.updateUser(request));
    }

    /**
     * Creates a new user
     * @param request
     *  user creation request
     * @return
     *  the new user
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> addNewUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity
                .ok(userService.addNewUser(request));
    }

    /**
     * Removes a user by its documentID.
     * @param documentID
     *  user's documentID
     * @return
     *  delete confirmation
     */
    @DeleteMapping(value = "/{documentID}", produces = "application/json")
    public ResponseEntity<UserDto> deleteUserByDocumentID(@PathVariable("documentID") String documentID) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(userService.deleteUserByDocumentID(documentID));
    }
}

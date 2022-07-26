package org.mmarchetti.secured.friendships.api.repository;

import org.mmarchetti.secured.friendships.api.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *
 *
 * @author Marco Marchetti
 */
public interface UserRepository extends MongoRepository<UserDto, String> {

    UserDto findByDocumentID(String documentID);

    List<UserDto> findAll();
}

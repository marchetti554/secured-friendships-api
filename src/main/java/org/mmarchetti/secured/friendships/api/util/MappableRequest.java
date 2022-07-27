package org.mmarchetti.secured.friendships.api.util;

/**
 * Permits a Class to be Mappable and transformed to a DTO.
 *
 * @param <T>
 *     target type
 *
 * @author Marco Marchetti
 */
public interface MappableRequest<T> {

    T toDTO();
}

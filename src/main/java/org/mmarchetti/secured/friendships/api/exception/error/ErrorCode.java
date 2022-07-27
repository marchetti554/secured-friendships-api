package org.mmarchetti.secured.friendships.api.exception.error;

/**
 *  Contains error codes and descriptions.
 *
 * @author Marco Marchetti
 */
public enum ErrorCode {

    //RuntimeErrors
    //100 to 199
    NULL_REFERENCE(100, "A null reference has been found"),
    //BusinessErrors
    //200 to 299
    DUPLICATE_KEY(200, "One or more primary keys or indexes already exist");
    //OtherErrors
    //300 to 399

    private final int code;
    private final String description;

    private ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}

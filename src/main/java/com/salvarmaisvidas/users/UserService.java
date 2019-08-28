package com.salvarmaisvidas.users;

import org.springframework.data.domain.Page;

public interface UserService {

    /**
     * Get all users in the database
     *
     * @return list of users
     */
    Page<User> getAllUsers(int pageSize, int page, String sort);

    /**
     * Get a specific user
     *
     * @return requested user
     */
    User getUser(int userId);

    /**
     * Inserts a new user in database
     *
     * @return inserted user
     */
    User newUser(User newUser);

    /**
     * Replaces a user if it exists, if not inserts the new user
     *
     * @return replaced user
     */
    User replaceUser(User newUser, int userId);

    /**
     * Deletes the specified user from the database
     */
    void deleteUser(int userId);
}


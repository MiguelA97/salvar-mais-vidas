package com.salvarmaisvidas.users;

import com.salvarmaisvidas.exceptions.GeneralException;

public class UserNotFoundException extends GeneralException {
    public UserNotFoundException(int userId){
        super("user.not.found",new String[]{Integer.toString(userId)});
    }
}


package com.salvarmaisvidas.user;

import com.salvarmaisvidas.exception.GeneralException;

public class UserNotFoundException extends GeneralException {
    public UserNotFoundException(int userId){
        super("user.not.found",new String[]{Integer.toString(userId)});
    }
}


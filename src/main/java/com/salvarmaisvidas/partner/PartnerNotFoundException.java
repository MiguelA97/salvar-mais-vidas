package com.salvarmaisvidas.partner;

import com.salvarmaisvidas.exception.GeneralException;

public class PartnerNotFoundException extends GeneralException {
    public PartnerNotFoundException(int id) {
        super("partner.not.found", new String[]{Integer.toString(id)});
    }
}

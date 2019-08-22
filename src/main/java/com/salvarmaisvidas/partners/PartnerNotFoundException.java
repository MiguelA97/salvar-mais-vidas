package com.salvarmaisvidas.partners;

import com.salvarmaisvidas.exceptions.GeneralException;

public class PartnerNotFoundException extends GeneralException {
    public PartnerNotFoundException(int id) {
        super("partner.not.found", new String[]{Integer.toString(id)});
    }
}

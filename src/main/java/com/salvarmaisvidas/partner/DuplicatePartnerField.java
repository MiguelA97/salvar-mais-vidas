package com.salvarmaisvidas.partner;

import com.salvarmaisvidas.exception.GeneralException;

public class DuplicatePartnerField extends GeneralException {
    public DuplicatePartnerField() {
        super("partner.duplicate.fields");
    }
}

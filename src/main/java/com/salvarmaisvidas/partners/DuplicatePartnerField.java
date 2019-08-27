package com.salvarmaisvidas.partners;

import com.salvarmaisvidas.exceptions.GeneralException;

public class DuplicatePartnerField extends GeneralException {
    public DuplicatePartnerField() {
        super("partner.duplicate.fields");
    }
}

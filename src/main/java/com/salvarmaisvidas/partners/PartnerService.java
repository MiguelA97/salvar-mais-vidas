package com.salvarmaisvidas.partners;

import org.springframework.data.domain.Page;

public interface PartnerService {

    /**
     * Get all Partners in the database
     *
     * @return list of Partner
     */
    Page<Partner> getAllPartners(int size, int page);

    /**
     * Get a specific Partner
     *
     * @return requested Partner
     */
    Partner getPartner(int id);

    /**
     * Inserts a new Partner in the database
     *
     * @return inserted Partner
     */
    Partner newPartner(Partner newPartner);

    /**
     * Replaces a Partner if it exists, if not inserts the new Partner
     *
     * @return replaced Partner
     */
    Partner replacePartner(Partner newPartner, int id);

    /**
     * Deletes the specified Partner from the database
     */
    void deletePartner(int id);
}
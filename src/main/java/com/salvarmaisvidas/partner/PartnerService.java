package com.salvarmaisvidas.partner;

import org.springframework.data.domain.Page;

public interface PartnerService {

    /**
     * Get all Partners in the database
     *
     * @return list of Partner
     */
    Page<Partner> getAllPartners(int pageSize, int page, PartnerFilter filter, String sort, String dir);

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

    /**
     * Finds and returns the partner with the specified cc.
     */
    Partner findByCc(String cc);
}

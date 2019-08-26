package com.salvarmaisvidas.partners;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    Page<Partner> getAllPartners(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "0") int page, PartnerFilter filter){
        return partnerService.getAllPartners(size, page, filter);
    }

    @GetMapping("/{id}")
    Partner getPartner(@PathVariable int id){
        return partnerService.getPartner(id);
    }

    @PostMapping
    Partner newPartner(@RequestBody Partner newPartner){
        return partnerService.newPartner(newPartner);
    }

    @PutMapping("/{id}")
    Partner replacePartner(@RequestBody Partner newPartner, @PathVariable int id){
        return partnerService.replacePartner(newPartner, id);
    }

    @DeleteMapping("/{id}")
    void deletePartner(@PathVariable int id){
        partnerService.deletePartner(id);
    }
}

package com.salvarmaisvidas.partner;

import com.salvarmaisvidas.util.PageWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    PageWrapper<Partner> getAllPartners(@RequestParam(defaultValue = "15") int pageSize, @RequestParam(defaultValue = "0") int page, PartnerFilter filter, @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "ASC") String dir){
        return new PageWrapper<>(partnerService.getAllPartners(pageSize, page, filter, sort, dir));
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
        return partnerService.replacePartner(newPartner, id, false);
    }

    @DeleteMapping("/{id}")
    void deletePartner(@PathVariable int id){
        partnerService.deletePartner(id);
    }
}

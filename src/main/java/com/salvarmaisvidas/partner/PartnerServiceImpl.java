package com.salvarmaisvidas.partner;

import com.salvarmaisvidas.collaborator.Collaborator;
import com.salvarmaisvidas.collaborator.CollaboratorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService{

    private final String PARTICULAR_PARTNER = "particular";

    private final PartnerRepository partnerRepository;
    private final CollaboratorService collaboratorService;

    public PartnerServiceImpl(PartnerRepository partnerRepository, CollaboratorService collaboratorService) {
        this.partnerRepository = partnerRepository;
        this.collaboratorService = collaboratorService;
    }

    @Override
    public Page<Partner> getAllPartners(int pageSize, int page, PartnerFilter filter, String sort, String dir) {
        return partnerRepository.findAll(PartnerSpec.filter(filter), PageRequest.of(page, pageSize, Sort.Direction.fromString(dir), sort));
    }

    @Override
    public Partner getPartner(int id) {
        return partnerRepository.findById(id).orElseThrow(() -> new PartnerNotFoundException(id));
    }

    @Override
    public Partner newPartner(Partner newPartner) {

        if (newPartner.getPartnerType().equals(PARTICULAR_PARTNER))
            if (partnerRepository.findByCc(newPartner.getCc()) != null)
                throw new DuplicatePartnerField();

        if (partnerRepository.findByEmail(newPartner.getEmail()) != null || partnerRepository.findByPhone(newPartner.getPhone()) != null || partnerRepository.findByNif(newPartner.getNif()) != null)
            throw new DuplicatePartnerField();

        if (newPartner.getPartnerType().equals(PARTICULAR_PARTNER) && newPartner.isCollaborator()) {
                Collaborator collaborator = new Collaborator();
                collaborator.setName(newPartner.getName());
                collaborator.setEmail(newPartner.getEmail());
                collaborator.setBirthDate(newPartner.getBirthDate());
                collaborator.setCc(newPartner.getCc());
                collaborator.setAddress(newPartner.getAddress());
                collaborator.setPostal_code(newPartner.getPostalCode());
                collaborator.setLocality(newPartner.getLocality());
                collaborator.setPhone(newPartner.getPhone());
                collaborator.setJob(newPartner.getJob());
                collaborator.setTrainer(newPartner.isTrainer());
                collaborator.setRegistrationDate(newPartner.getRegistrationDate());
                collaboratorService.newCollaborator(collaborator);
        }
        return partnerRepository.save(newPartner);
    }

    @Override
    public Partner replacePartner(Partner newPartner, int id) {
        return partnerRepository.findById(id).map(partner -> {
            if (newPartner.getPartnerType().equals(PARTICULAR_PARTNER))
                if (partnerRepository.findByCc(newPartner.getCc()) != null && !newPartner.getCc().equals(partner.getCc()))
                    throw new DuplicatePartnerField();

            if (partnerRepository.findByEmail(newPartner.getEmail()) != null && !newPartner.getEmail().equals(partner.getEmail()) ||
                    partnerRepository.findByPhone(newPartner.getPhone()) != null && newPartner.getPhone() != partner.getPhone() ||
                    partnerRepository.findByNif(newPartner.getNif()) != null && newPartner.getNif() != partner.getNif()){
                throw new DuplicatePartnerField();
            }

            partner.setName(newPartner.getName());
            partner.setCc(newPartner.getCc());
            partner.setJob(newPartner.getJob());
            partner.setBirthDate(newPartner.getBirthDate());
            partner.setEmail(newPartner.getEmail());
            partner.setAddress(newPartner.getAddress());
            partner.setPostalCode(newPartner.getPostalCode());
            partner.setLocality(newPartner.getLocality());
            partner.setPhone(newPartner.getPhone());
            partner.setRegistrationDate(newPartner.getRegistrationDate());
            partner.setNif(newPartner.getNif());
            partner.setTrainer(newPartner.isTrainer());
            partner.setCollaborator(newPartner.isCollaborator());
            partner.setSub23(newPartner.isSub23());
            partner.setPartnerType(newPartner.getPartnerType());
            partner.setQuota(newPartner.getQuota());
            partner.setStatus(newPartner.isStatus());
            return partnerRepository.save(partner);
        }).orElseThrow(() -> new PartnerNotFoundException(id));
    }

    @Override
    public void deletePartner(int id) {
        partnerRepository.deleteById(id);
    }
}

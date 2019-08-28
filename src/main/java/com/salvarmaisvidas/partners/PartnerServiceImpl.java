package com.salvarmaisvidas.partners;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService{

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Page<Partner> getAllPartners(int size, int page, PartnerFilter filter, String sort, String dir) {
        return partnerRepository.findAll(PartnerSpec.filter(filter), PageRequest.of(page, size, Sort.Direction.fromString(dir), sort));
    }

    @Override
    public Partner getPartner(int id) {
        return partnerRepository.findById(id).orElseThrow(() -> new PartnerNotFoundException(id));
    }

    @Override
    public Partner newPartner(Partner newPartner) {
        if (partnerRepository.findByCc(newPartner.getCc()) != null ||
                partnerRepository.findByEmail(newPartner.getEmail()) != null ||
                partnerRepository.findByPhone(newPartner.getPhone()) != null ||
                partnerRepository.findByNif(newPartner.getNif()) != null){
            throw new DuplicatePartnerField();
        }
        return partnerRepository.save(newPartner);
    }

    @Override
    public Partner replacePartner(Partner newPartner, int id) {
        return partnerRepository.findById(id).map(partner -> {
            if (partnerRepository.findByCc(newPartner.getCc()) != null && !newPartner.getCc().equals(partner.getCc()) ||
                    partnerRepository.findByEmail(newPartner.getEmail()) != null && !newPartner.getEmail().equals(partner.getEmail()) ||
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
            partner.setPartner_type(newPartner.getPartner_type());
            partner.setQuota(newPartner.getQuota());
            partner.setStatus(newPartner.isStatus());
            return partnerRepository.save(partner);
        }).orElseGet(() -> {
            if (partnerRepository.findByCc(newPartner.getCc()) != null ||
                    partnerRepository.findByEmail(newPartner.getEmail()) != null ||
                    partnerRepository.findByPhone(newPartner.getPhone()) != null ||
                    partnerRepository.findByNif(newPartner.getNif()) != null){
                throw new DuplicatePartnerField();
            }
            newPartner.setId(id);
            return partnerRepository.save(newPartner);
        });
    }

    @Override
    public void deletePartner(int id) {
        partnerRepository.deleteById(id);
    }
}

package com.salvarmaisvidas.collaborator;

import com.salvarmaisvidas.partner.Partner;
import com.salvarmaisvidas.partner.PartnerController;
import com.salvarmaisvidas.partner.PartnerService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;
    private final PartnerService partnerService;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository, @Lazy PartnerService partnerService) {
        this.collaboratorRepository = collaboratorRepository;
        this.partnerService = partnerService;
    }

    @Override
    public Page<Collaborator> getAllCollaborators(int pageSize, int page, CollaboratorFilter filter, String sort, String dir) {
        return collaboratorRepository.findAll(CollaboratorSpec.filter(filter), PageRequest.of(page, pageSize, Sort.Direction.fromString(dir), sort));
    }

    @Override
    public Collaborator getCollaborator(int id) {
        return collaboratorRepository.findById(id).orElseThrow(() -> new CollaboratorNotFoundException(id));
    }

    @Override
    public Collaborator newCollaborator(Collaborator newCollaborator) {
        if (collaboratorRepository.findByCc(newCollaborator.getCc()) != null || collaboratorRepository.findByEmail(newCollaborator.getEmail()) != null ||
                collaboratorRepository.findByPhone(newCollaborator.getPhone()) != null)
            throw new DuplicateCollaboratorField();
        return collaboratorRepository.save(newCollaborator);
    }

    @Override
    public Collaborator replaceCollaborator(Collaborator newCollaborator, int id) {
        return collaboratorRepository.findById(id).map(collaborator -> {
            if (collaboratorRepository.findByCc(newCollaborator.getCc()) != null && !newCollaborator.getCc().equals(collaborator.getCc()) ||
                collaboratorRepository.findByEmail(newCollaborator.getEmail()) != null && !newCollaborator.getEmail().equals(collaborator.getEmail()) ||
                collaboratorRepository.findByPhone(newCollaborator.getPhone()) != null && newCollaborator.getPhone() != collaborator.getPhone()){
                throw new DuplicateCollaboratorField();
            }

            String oldCc = collaborator.getCc();

            collaborator.setBirthDate(newCollaborator.getBirthDate());
            collaborator.setCc(newCollaborator.getCc());
            collaborator.setJob(newCollaborator.getJob());
            collaborator.setTrainer(newCollaborator.isTrainer());
            collaborator.setName(newCollaborator.getName());
            collaborator.setEmail(newCollaborator.getEmail());
            collaborator.setAddress(newCollaborator.getAddress());
            collaborator.setPostalCode(newCollaborator.getPostalCode());
            collaborator.setLocality(newCollaborator.getLocality());
            collaborator.setPhone(newCollaborator.getPhone());
            collaborator.setRegistrationDate(newCollaborator.getRegistrationDate());
            collaborator.setEvents(newCollaborator.getEvents());

            /*update partner if it exists*/
            Partner partner = partnerService.findByCc(oldCc);
            if (partner != null){
                partner.setBirthDate(newCollaborator.getBirthDate());
                partner.setCc(newCollaborator.getCc());
                partner.setJob(newCollaborator.getJob());
                partner.setTrainer(newCollaborator.isTrainer());
                partner.setName(newCollaborator.getName());
                partner.setEmail(newCollaborator.getEmail());
                partner.setAddress(newCollaborator.getAddress());
                partner.setPostalCode(newCollaborator.getPostalCode());
                partner.setLocality(newCollaborator.getLocality());
                partner.setPhone(newCollaborator.getPhone());
                partner.setRegistrationDate(newCollaborator.getRegistrationDate());
                //TODO FALTA DAR UPDATE AO PARTNER, MAS COMO?!
            }

            return collaboratorRepository.save(collaborator);
        }).orElseThrow(() -> new CollaboratorNotFoundException(id));
    }

    @Override
    public void deleteCollaborator(int id) {
        collaboratorRepository.deleteById(id);
    }

    @Override
    public Collaborator findByCc(String cc){
        return collaboratorRepository.findByCc(cc);
    }
}

package com.salvarmaisvidas.collaborator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
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
        if (collaboratorRepository.findByCc(newCollaborator.getCc()) != null ||
            collaboratorRepository.findByEmail(newCollaborator.getEmail()) != null ||
            collaboratorRepository.findByPhone(newCollaborator.getPhone()) != null){
            throw new DuplicateCollaboratorField();
        }
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
            collaborator.setBirthDate(newCollaborator.getBirthDate());
            collaborator.setCc(newCollaborator.getCc());
            collaborator.setJob(newCollaborator.getJob());
            collaborator.setTrainer(newCollaborator.isTrainer());
            collaborator.setName(newCollaborator.getName());
            collaborator.setEmail(newCollaborator.getEmail());
            collaborator.setAddress(newCollaborator.getAddress());
            collaborator.setPostal_code(newCollaborator.getPostal_code());
            collaborator.setLocality(newCollaborator.getLocality());
            collaborator.setPhone(newCollaborator.getPhone());
            collaborator.setRegistrationDate(newCollaborator.getRegistrationDate());
            collaborator.setEvents(newCollaborator.getEvents());
            return collaboratorRepository.save(collaborator);
        }).orElseGet(() -> {
            if (collaboratorRepository.findByCc(newCollaborator.getCc()) != null ||
                    collaboratorRepository.findByEmail(newCollaborator.getEmail()) != null ||
                    collaboratorRepository.findByPhone(newCollaborator.getPhone()) != null){
                throw new DuplicateCollaboratorField();
            }
            newCollaborator.setId(id);
            return collaboratorRepository.save(newCollaborator);
        });
    }

    @Override
    public void deleteCollaborator(int id) {
        collaboratorRepository.deleteById(id);
    }
}

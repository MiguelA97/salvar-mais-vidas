package com.salvarmaisvidas.collaborators;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    @Override
    public Page<Collaborator> getAllCollaborators(int size, int page) {
        return collaboratorRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public Collaborator getCollaborator(int id) {
        return collaboratorRepository.findById(id).orElseThrow(() -> new CollaboratorNotFoundException(id));
    }

    @Override
    public Collaborator newCollaborator(Collaborator newCollaborator) {
        return collaboratorRepository.save(newCollaborator);
    }

    @Override
    public Collaborator replaceCollaborator(Collaborator newCollaborator, int id) {
        return collaboratorRepository.findById(id).map(collaborator -> {
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
            return collaboratorRepository.save(collaborator);
        }).orElseGet(() -> {
            newCollaborator.setId(id);
            return collaboratorRepository.save(newCollaborator);
        });
    }

    @Override
    public void deleteCollaborator(int id) {
        collaboratorRepository.deleteById(id);
    }
}

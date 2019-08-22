package com.salvarmaisvidas.collaboratorevents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorEventServiceImpl implements CollaboratorEventService {

    private final CollaboratorEventRepository collaboratorEventRepository;

    public CollaboratorEventServiceImpl(CollaboratorEventRepository collaboratorEventRepository) {
        this.collaboratorEventRepository = collaboratorEventRepository;
    }

    @Override
    public Page<CollaboratorEvent> getAllCollaboratorEvents(int size, int page) {
        return collaboratorEventRepository.findAll(PageRequest.of(page, size, Sort.by("collaborator_id")));
    }

    @Override
    public CollaboratorEvent getCollaboratorEvent(int collaborator_id, int event_id) {
        CollaboratorEventId collaboratorEventId = new CollaboratorEventId(collaborator_id, event_id);
        return collaboratorEventRepository.findById(collaboratorEventId).orElseThrow(() -> new CollaboratorEventNotFoundException(collaborator_id, event_id));
    }

    @Override
    public CollaboratorEvent newCollaboratorEvent(CollaboratorEvent newCollaboratorEvent) {
        return collaboratorEventRepository.save(newCollaboratorEvent);
    }

    @Override
    public CollaboratorEvent replaceCollaboratorEvent(CollaboratorEvent newCollaboratorEvent, CollaboratorEventId collaboratorEventId) {
        return collaboratorEventRepository.findById(collaboratorEventId).map(collaboratorEvent -> collaboratorEventRepository.save(collaboratorEvent)).orElseGet(() -> {
            newCollaboratorEvent.setCollaboratorId(collaboratorEventId.getCollaboratorId());
            newCollaboratorEvent.setEventid(collaboratorEventId.getEventId());
            return collaboratorEventRepository.save(newCollaboratorEvent);
        });
    }

    @Override
    public void deleteCollaboratorEvent(CollaboratorEventId collaboratorEventId) {
        collaboratorEventRepository.deleteById(collaboratorEventId);
    }
}

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
    public Page<CollaboratorEvent> getAllCollaboratorEvents(int size, int page, CollaboratorEventFilter filter) {
        return collaboratorEventRepository.findAll(CollaboratorEventSpec.filter(filter) ,PageRequest.of(page, size, Sort.by("collaborator_id.id")));
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
    public CollaboratorEvent replaceCollaboratorEvent(CollaboratorEvent newCollaboratorEvent, int collaborator_id, int event_id) {
        CollaboratorEventId collaboratorEventId = new CollaboratorEventId(collaborator_id, event_id);
        return collaboratorEventRepository.findById(collaboratorEventId).map(collaboratorEvent -> collaboratorEventRepository.save(collaboratorEvent)).orElseGet(() -> {
            newCollaboratorEvent.setCollaborator_id(collaboratorEventId.getCollaborator());
            newCollaboratorEvent.setEvent_id(collaboratorEventId.getEvent());
            return collaboratorEventRepository.save(newCollaboratorEvent);
        });

    }

    @Override
    public void deleteCollaboratorEvent(int collaborator_id, int event_id) {
        CollaboratorEventId collaboratorEventId = new CollaboratorEventId(collaborator_id, event_id);
        collaboratorEventRepository.deleteById(collaboratorEventId);
    }
}

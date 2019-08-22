package com.salvarmaisvidas.collaboratorevents;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collaboratorEvents")
public class CollaboratorEventController {

    private final CollaboratorEventService collaboratorEventService;

    public CollaboratorEventController(CollaboratorEventService collaboratorEventService) {
        this.collaboratorEventService = collaboratorEventService;
    }

    @GetMapping
    Page< CollaboratorEvent> getAllCollaboratorEvent(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "0") int page){
        return collaboratorEventService.getAllCollaboratorEvents(size, page);
    }

    @GetMapping("/{collaborator_id}/{event_id}")
    CollaboratorEvent getCollaboratorEvent(@PathVariable int collaborator_id, @PathVariable int event_id){
        return collaboratorEventService.getCollaboratorEvent(collaborator_id, event_id);
    }

    @PostMapping
    CollaboratorEvent newCollaboratorEvent(@RequestBody  CollaboratorEvent newCollaboratorEvent){
        return collaboratorEventService.newCollaboratorEvent(newCollaboratorEvent);
    }

    @PutMapping("/{collaboratorEventsId}")
    CollaboratorEvent replaceCollaboratorEvent(@RequestBody  CollaboratorEvent newCollaboratorEvent, @PathVariable CollaboratorEventId collaboratorEventId){
        return collaboratorEventService.replaceCollaboratorEvent(newCollaboratorEvent, collaboratorEventId);
    }

    @DeleteMapping("/{collaboratorEventsId}")
    void deleteCollaboratorEvent(@PathVariable CollaboratorEventId collaboratorEventId){
        collaboratorEventService.deleteCollaboratorEvent(collaboratorEventId);
    }
}

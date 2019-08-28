package com.salvarmaisvidas.collaboratorevents;

import com.salvarmaisvidas.util.PageWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collaboratorEvents")
public class CollaboratorEventController {

    private final CollaboratorEventService collaboratorEventService;

    public CollaboratorEventController(CollaboratorEventService collaboratorEventService) {
        this.collaboratorEventService = collaboratorEventService;
    }

    @GetMapping
    PageWrapper<CollaboratorEvent> getAllCollaboratorEvent(@RequestParam(defaultValue = "5") int pageSize, @RequestParam(defaultValue = "0") int page, CollaboratorEventFilter filter){
        return new PageWrapper<>(collaboratorEventService.getAllCollaboratorEvents(pageSize, page, filter));
    }

    @GetMapping("/{collaborator_id}/{event_id}")
    CollaboratorEvent getCollaboratorEvent(@PathVariable int collaborator_id, @PathVariable int event_id){
        return collaboratorEventService.getCollaboratorEvent(collaborator_id, event_id);
    }

    @PostMapping
    CollaboratorEvent newCollaboratorEvent(@RequestBody  CollaboratorEvent newCollaboratorEvent){
        return collaboratorEventService.newCollaboratorEvent(newCollaboratorEvent);
    }

    @PutMapping("/{collaborator_id}/{event_id}")
    CollaboratorEvent replaceCollaboratorEvent(@RequestBody  CollaboratorEvent newCollaboratorEvent, @PathVariable int collaborator_id, @PathVariable int event_id){
        return collaboratorEventService.replaceCollaboratorEvent(newCollaboratorEvent, collaborator_id, event_id);
    }

    @DeleteMapping("/{collaborator_id}/{event_id}")
    void deleteCollaboratorEvent(@PathVariable int collaborator_id, @PathVariable int event_id){
        collaboratorEventService.deleteCollaboratorEvent(collaborator_id, event_id);
    }
}

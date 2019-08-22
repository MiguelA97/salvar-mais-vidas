package com.salvarmaisvidas.collaborators;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaborators")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @GetMapping
    Page<Collaborator> getAllCollaborators(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "0") int page){
        return collaboratorService.getAllCollaborators(size, page);
    }

    @GetMapping("/{id}")
    Collaborator getCollaborator(@PathVariable int id){
        return collaboratorService.getCollaborator(id);
    }

    @PostMapping
    Collaborator newCollaborator(@RequestBody Collaborator newCollaborator){
        return collaboratorService.newCollaborator(newCollaborator);
    }

    @PutMapping("/{id}")
    Collaborator replaceCollaborator(@RequestBody Collaborator newCollaborator, @PathVariable int id){
        return collaboratorService.replaceCollaborator(newCollaborator, id);
    }

    @DeleteMapping("/{id}")
    void deleteCollaborator(@PathVariable int id){
        collaboratorService.deleteCollaborator(id);
    }
}

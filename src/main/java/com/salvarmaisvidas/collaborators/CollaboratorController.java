package com.salvarmaisvidas.collaborators;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collaborators")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;
    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorController(CollaboratorService collaboratorService, CollaboratorRepository collaboratorRepository) {
        this.collaboratorService = collaboratorService;
        this.collaboratorRepository = collaboratorRepository;
    }

    @GetMapping
    Page<Collaborator> getAllCollaborators(@RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "0") int page, CollaboratorFilter filter){
        return collaboratorService.getAllCollaborators(size, page, filter);
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

    @GetMapping("/findCollabPartners")
    Page<FindCollabPartners> collabPartners(@RequestParam(defaultValue = "20") int size, @RequestParam(defaultValue = "0") int page){
        return collaboratorRepository.findCollabPartners(PageRequest.of(page, size, Sort.by("name")));
    }
}

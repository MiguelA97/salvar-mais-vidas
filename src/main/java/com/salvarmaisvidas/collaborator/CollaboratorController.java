package com.salvarmaisvidas.collaborator;

import com.salvarmaisvidas.util.PageWrapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    PageWrapper<Collaborator> getAllCollaborators(@RequestParam(defaultValue = "15") int pageSize, @RequestParam(defaultValue = "0") int page, CollaboratorFilter filter, @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "ASC") String dir){
        return new PageWrapper<>(collaboratorService.getAllCollaborators(pageSize, page, filter, sort, dir));
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
        return collaboratorService.replaceCollaborator(newCollaborator, id, false);
    }

    @DeleteMapping("/{id}")
    void deleteCollaborator(@PathVariable int id){
        collaboratorService.deleteCollaborator(id);
    }

    @GetMapping("/findCollabPartners")
    PageWrapper<FindCollabPartners> collabPartners(@RequestParam(defaultValue = "20") int pageSize, @RequestParam(defaultValue = "0") int page){
        return  new PageWrapper<>(collaboratorRepository.findCollabPartners(PageRequest.of(page, pageSize, Sort.by("name"))));
    }

//    @GetMapping("/events/{id}")
//    List<Event> getEvents(@PathVariable int id){
//        Collaborator collaborator = collaboratorRepository.findById(id).get();
//        return collaborator.getEvents();
//    }

    @GetMapping("/collabEvents")
    List<Collaborator> getCollabEventsParticipations(@RequestParam(defaultValue = "more") String sort){
        List<Collaborator> collaborators = collaboratorRepository.findAll();
        List<Collaborator> res = new ArrayList<>();

        if (sort.equals("more")){
            collaborators.sort(Comparator.comparing(Collaborator::getEventsSize, Comparator.reverseOrder()));
            int max = collaborators.get(0).getEventsSize();
            for (Collaborator collab : collaborators){
                if (collab.getEventsSize() != max) {
                    break;
                }
                res.add(collab);
            }
        }
        else if (sort.equals("less")){
            collaborators.sort(Comparator.comparing(Collaborator::getEventsSize));
            int min = collaborators.get(0).getEventsSize();
            for (Collaborator collab : collaborators) {
                if (collab.getEventsSize() != min) {
                    break;
                }
                res.add(collab);
            }
        }
        return res;
    }
}

package com.enterprise.Collaborator.controller;

import com.enterprise.Collaborator.entity.Collaborator;
import com.enterprise.Collaborator.service.ICollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/collaborators")
public class CollaboratorController {

    @Autowired
    private ICollaboratorService service;

    @GetMapping
    public ResponseEntity<List<Collaborator>> getCollaborators(){
        List<Collaborator> collaborators = service.getObjects();

        return new ResponseEntity<List<Collaborator>>(collaborators,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collaborator> getCollaborator(@PathVariable("id") int id){
        Collaborator collaborator = service.getOject(id);
        return collaborator !=null ?  new ResponseEntity<Collaborator>(collaborator, HttpStatus.OK) : new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Object> registerCollaborator(@RequestBody Collaborator collaborator){

        Collaborator newCollaborator = service.registerObject(collaborator);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCollaborator.getIdCollaborator()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<Object> updateCollaborator(@RequestBody Collaborator collaborator){
        Collaborator newCollaborator = service.updateObject(collaborator);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCollaborator(@PathVariable("id") int id){
        Collaborator collaborator = service.getOject(id);
        if(collaborator == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.deleteObject(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

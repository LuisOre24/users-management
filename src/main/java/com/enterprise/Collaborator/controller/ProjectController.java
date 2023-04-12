package com.enterprise.Collaborator.controller;

import com.enterprise.Collaborator.entity.Project;
import com.enterprise.Collaborator.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/projects")
public class ProjectController {

    @Autowired
    private IProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> projects = service.getObjects();

        return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") int id){
        Project project = service.getOject(id);
        return project !=null ?  new ResponseEntity<Project>(project, HttpStatus.OK) : new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Object> registerProject(@RequestBody Project project){

        Project newProject = service.registerObject(project);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProject.getIdProject()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<Object> updateProject(@RequestBody Project project){
        Project newProject = service.updateObject(project);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable("id") int id){
        Project project = service.getOject(id);
        if(project == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.deleteObject(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

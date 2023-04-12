package com.enterprise.Collaborator.controller;

import com.enterprise.Collaborator.entity.Document;
import com.enterprise.Collaborator.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/documents")
public class DocumentController {

    @Autowired
    private IDocumentService service;

    @GetMapping
    public ResponseEntity<List<Document>> getDocuments(){
        List<Document> documents = service.getObjects();

        return new ResponseEntity<List<Document>>(documents,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable("id") int id){
        Document document = service.getOject(id);
        return document !=null ?  new ResponseEntity<Document>(document, HttpStatus.OK) : new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Object> registerDocument(@RequestBody Document document){

        Document newDocument = service.registerObject(document);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDocument.getIdDocument()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<Object> updateDocument(@RequestBody Document document){
        Document newDocument = service.updateObject(document);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDocument(@PathVariable("id") int id){
        Document document = service.getOject(id);
        if(document == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.deleteObject(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

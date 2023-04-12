package com.enterprise.Collaborator.controller;

import com.enterprise.Collaborator.entity.Position;
import com.enterprise.Collaborator.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/positions")
public class PositionController {

    @Autowired
    private IPositionService service;

    @GetMapping
    public ResponseEntity<List<Position>> getPositions(){
        List<Position> positions = service.getObjects();

        return new ResponseEntity<List<Position>>(positions,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable("id") int id){
        Position position = service.getOject(id);
        return position !=null ?  new ResponseEntity<Position>(position, HttpStatus.OK) : new ResponseEntity<Position>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Object> registerPosition(@RequestBody Position position){

        Position newPosition = service.registerObject(position);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPosition.getIdPosition()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<Object> updatePosition(@RequestBody Position position){
        Position newPosition = service.updateObject(position);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePosition(@PathVariable("id") int id){
        Position position = service.getOject(id);
        if(position == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.deleteObject(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

package com.enterprise.Collaborator.controller;

import com.enterprise.Collaborator.entity.Company;
import com.enterprise.Collaborator.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/companies")
public class CompanyController {

    @Autowired
    private ICompanyService service;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies(){
        List<Company> companies = service.getObjects();
        return new ResponseEntity<List<Company>>(companies,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id") int id){
        Company company = service.getOject(id);
        return company !=null ?  new ResponseEntity<Company>(company, HttpStatus.OK) : new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Object> registerCompany(@RequestBody Company company){

        Company newCompany = service.registerObject(company);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCompany.getIdCompany()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<Object> updateCompany(@RequestBody Company company){
        Company newCompany = service.updateObject(company);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCompany(@PathVariable("id") int id){
        Company company = service.getOject(id);
        if(company == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.deleteObject(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

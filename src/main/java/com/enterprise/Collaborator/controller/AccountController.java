package com.enterprise.Collaborator.controller;

import com.enterprise.Collaborator.entity.Account;
import com.enterprise.Collaborator.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/accounts")
public class AccountController {

    @Autowired
    private IAccountService service;

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        List<Account> accounts = service.getObjects();

        return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") int id){
        Account account = service.getOject(id);
        return account !=null ?  new ResponseEntity<Account>(account, HttpStatus.OK) : new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Object> registerAccount(@RequestBody Account account){

        Account newAccount = service.registerObject(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAccount.getIdAccount()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<Object> updateAccount(@RequestBody Account account){
        Account newAccount = service.updateObject(account);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable("id") int id){
        Account account = service.getOject(id);
        if(account == null){
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        service.deleteObject(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}

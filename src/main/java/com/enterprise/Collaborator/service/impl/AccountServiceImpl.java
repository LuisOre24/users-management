package com.enterprise.Collaborator.service.impl;

import com.enterprise.Collaborator.entity.Account;
import com.enterprise.Collaborator.repo.IAccountRepo;
import com.enterprise.Collaborator.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepo repoAccount;

    @Override
    public Account registerObject(Account entity) {
        return repoAccount.save(entity);
    }

    @Override
    public Account updateObject(Account entity) {
        return repoAccount.save(entity);
    }

    @Override
    public Account getOject(int id) {
        Optional<Account> op = repoAccount.findById(id);
        return op.isPresent() ? op.get() : new Account();
    }

    @Override
    public List<Account> getObjects() {
        return repoAccount.findAll();
    }

    @Override
    public void deleteObject(int id) {
        repoAccount.deleteById(id);
    }
}

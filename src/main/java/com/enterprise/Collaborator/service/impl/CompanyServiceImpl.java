package com.enterprise.Collaborator.service.impl;

import com.enterprise.Collaborator.entity.Company;
import com.enterprise.Collaborator.repo.ICompanyRepo;
import com.enterprise.Collaborator.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepo repoCompany;

    @Override
    public Company registerObject(Company entity) {
        return repoCompany.save(entity);
    }

    @Override
    public Company updateObject(Company entity) {
        return repoCompany.save(entity);
    }

    @Override
    public Company getOject(int id) {
        Optional<Company> op = repoCompany.findById(id);
        return op.isPresent() ? op.get() : new Company();
    }

    @Override
    public List<Company> getObjects() {
        return repoCompany.findAll();
    }

    @Override
    public void deleteObject(int id) {
        repoCompany.deleteById(id);
    }
}

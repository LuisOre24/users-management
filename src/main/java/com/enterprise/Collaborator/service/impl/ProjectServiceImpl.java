package com.enterprise.Collaborator.service.impl;

import com.enterprise.Collaborator.entity.Project;
import com.enterprise.Collaborator.repo.IProjectRepo;
import com.enterprise.Collaborator.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepo repoProject;

    @Override
    public Project registerObject(Project entity) {
        return repoProject.save(entity);
    }

    @Override
    public Project updateObject(Project entity) {
        return repoProject.save(entity);
    }

    @Override
    public Project getOject(int id) {
        Optional<Project> op = repoProject.findById(id);
        return op.isPresent() ? op.get() : new Project();
    }

    @Override
    public List<Project> getObjects() {
        return repoProject.findAll();
    }

    @Override
    public void deleteObject(int id) {
        repoProject.deleteById(id);
    }
}

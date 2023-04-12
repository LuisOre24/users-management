package com.enterprise.Collaborator.service.impl;

import com.enterprise.Collaborator.entity.Collaborator;
import com.enterprise.Collaborator.repo.ICollaboratorRepo;
import com.enterprise.Collaborator.service.ICollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.Optional;

@Service
public class CollaboratorServiceImpl implements ICollaboratorService {

    @Autowired
    private ICollaboratorRepo repoCollaborator;

    @Override
    public Collaborator registerObject(Collaborator entity) {

        return repoCollaborator.save(entity);

    }

    @Override
    public Collaborator updateObject(Collaborator entity) {
        return repoCollaborator.save(entity);
    }

    @Override
    public Collaborator getOject(int id) {
        Optional<Collaborator> op = repoCollaborator.findById(id);
        return op.isPresent() ? op.get() : new Collaborator();
    }

    @Override
    public List<Collaborator> getObjects() {
        return repoCollaborator.findAll();
    }

    @Override
    public void deleteObject(int id) {
        repoCollaborator.deleteById(id);
    }
}

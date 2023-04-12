package com.enterprise.Collaborator.service.impl;

import com.enterprise.Collaborator.entity.Position;
import com.enterprise.Collaborator.repo.IPositionRepo;
import com.enterprise.Collaborator.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepo repoPosition;

    @Override
    public Position registerObject(Position entity) {
        return repoPosition.save(entity);
    }

    @Override
    public Position updateObject(Position entity) {
        return repoPosition.save(entity);
    }

    @Override
    public Position getOject(int id) {
        Optional<Position> op = repoPosition.findById(id);
        return op.isPresent() ? op.get() : new Position();
    }

    @Override
    public List<Position> getObjects() {
        return repoPosition.findAll();
    }

    @Override
    public void deleteObject(int id) {
        repoPosition.deleteById(id);
    }
}

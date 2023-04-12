package com.enterprise.Collaborator.service.impl;

import com.enterprise.Collaborator.entity.Document;
import com.enterprise.Collaborator.repo.IDocumentRepo;
import com.enterprise.Collaborator.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private IDocumentRepo repoDocument;

    @Override
    public Document registerObject(Document entity) {
        return repoDocument.save(entity);
    }

    @Override
    public Document updateObject(Document entity) {
        return repoDocument.save(entity);
    }

    @Override
    public Document getOject(int id) {
        Optional<Document> op = repoDocument.findById(id);
        return op.isPresent() ? op.get() : new Document();
    }

    @Override
    public List<Document> getObjects() {
        return repoDocument.findAll();
    }

    @Override
    public void deleteObject(int id) {
        repoDocument.deleteById(id);
    }
}

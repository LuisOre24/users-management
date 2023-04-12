package com.enterprise.Collaborator.repo;

import com.enterprise.Collaborator.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepo extends JpaRepository<Document, Integer> {
}

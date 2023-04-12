package com.enterprise.Collaborator.repo;

import com.enterprise.Collaborator.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICollaboratorRepo extends JpaRepository<Collaborator, Integer> {
}

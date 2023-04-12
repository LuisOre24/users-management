package com.enterprise.Collaborator.repo;

import com.enterprise.Collaborator.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepo extends JpaRepository<Project,Integer> {
}

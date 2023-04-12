package com.enterprise.Collaborator.repo;

import com.enterprise.Collaborator.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepo extends JpaRepository<Position, Integer> {
}

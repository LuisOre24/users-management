package com.enterprise.Collaborator.repo;

import com.enterprise.Collaborator.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepo extends JpaRepository<Company, Integer> {
}

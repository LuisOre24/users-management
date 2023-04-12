package com.enterprise.Collaborator.repo;

import com.enterprise.Collaborator.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account,Integer> {
}

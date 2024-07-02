package org.example.spring_mvc_without_boot.repository;

import org.example.spring_mvc_without_boot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
}

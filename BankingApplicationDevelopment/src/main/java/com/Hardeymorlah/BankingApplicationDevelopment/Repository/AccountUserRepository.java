package com.Hardeymorlah.BankingApplicationDevelopment.Repository;

import com.Hardeymorlah.BankingApplicationDevelopment.Model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Integer> {
    AccountUser getAccountUserByUsername(String username);
}

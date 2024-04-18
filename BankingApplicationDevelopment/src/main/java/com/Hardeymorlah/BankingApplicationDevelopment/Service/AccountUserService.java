package com.Hardeymorlah.BankingApplicationDevelopment.Service;

import com.Hardeymorlah.BankingApplicationDevelopment.Model.AccountUser;
import com.Hardeymorlah.BankingApplicationDevelopment.Repository.AccountUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserService {
    private final AccountUserRepository accountUserRepository;

    public AccountUserService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    public ResponseEntity<List<AccountUser>> getAllAccountUsers() {
        return new ResponseEntity<>(accountUserRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<AccountUser> getAccountUserById(int id) {
        return new ResponseEntity<>(accountUserRepository.findById(id).get(), HttpStatus.OK);
    }

        public ResponseEntity<AccountUser> getAccountUserByUsername(String Username){
        return new ResponseEntity<>(accountUserRepository.getAccountUserByUsername(Username),HttpStatus.OK);
    }
    public ResponseEntity<AccountUser> createAccountUser(AccountUser newAccountUser) {
        return new ResponseEntity<>(accountUserRepository.save(newAccountUser), HttpStatus.CREATED);
    }

    public ResponseEntity<AccountUser> updateAccountUser(int id, AccountUser updateAccountUserDetails) {
        AccountUser user = accountUserRepository.findById(id).get();
        user.setFirstName(updateAccountUserDetails.getFirstName());
        user.setLastName(updateAccountUserDetails.getLastName());
        user.setMiddleName(updateAccountUserDetails.getMiddleName());
        user.setUsername(updateAccountUserDetails.getUsername());
        user.setPhoneNumber(updateAccountUserDetails.getPhoneNumber());
        user.setPassword(updateAccountUserDetails.getPassword());
        return new ResponseEntity<>(accountUserRepository.save(user), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<AccountUser> deleteAccountUserById(int id) {
        AccountUser userId = accountUserRepository.findById(id).get();
        accountUserRepository.deleteById(id);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    public ResponseEntity<AccountUser> deleteAccountUserByUsername(String Username){
        AccountUser emailUsername = getAccountUserByUsername(Username).getBody();
        assert emailUsername != null;
        accountUserRepository.deleteById(emailUsername.getId());
        return new ResponseEntity<>(emailUsername, HttpStatus.OK);
    }
}

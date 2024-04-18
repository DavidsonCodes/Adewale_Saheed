package com.Hardeymorlah.BankingApplicationDevelopment.Controller;

import com.Hardeymorlah.BankingApplicationDevelopment.Model.AccountUser;
import com.Hardeymorlah.BankingApplicationDevelopment.Service.AccountUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountUser")
public class AccountUserController {
    private final AccountUserService accountUserService;

    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }
    @GetMapping("/allAccountUsers")
    public ResponseEntity<List<AccountUser>> getAllAccountUsers(){
        return accountUserService.getAllAccountUsers();
    }
    @GetMapping("/getAccountUserById")
    public ResponseEntity<AccountUser> getAccountUserById(@RequestParam int id){
        return accountUserService.getAccountUserById(id);
    }
    @GetMapping("/getAccountUserByUsername/{username}")
    public ResponseEntity<AccountUser> getAccountUserByUsername(@PathVariable String username){
        return accountUserService.getAccountUserByUsername(username);
    }
    @PostMapping("/createAccountUser")
    public ResponseEntity<AccountUser> createAccountUser(@RequestBody @Valid AccountUser newAccountUser){
        return accountUserService.createAccountUser(newAccountUser);
    }
    @PutMapping("/updateAccountUser")
    public ResponseEntity<AccountUser> updateAccountUser(@RequestParam int id,@Valid @RequestBody AccountUser updateAccountUserDetails){
        return accountUserService.updateAccountUser(id, updateAccountUserDetails);
    }
    @DeleteMapping("/deleteAccountUserById/{id}")
    public ResponseEntity<AccountUser> deleteAccountUserById(@PathVariable int id){
        return accountUserService.deleteAccountUserById(id);
    }
    @DeleteMapping("/deleteAccountUserByUsername{username}")
    public ResponseEntity<AccountUser> deleteAccountUserByUsername(@PathVariable String username){
        return accountUserService.deleteAccountUserByUsername(username);
    }


}

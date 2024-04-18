package com.Hardeymorlah.BankingApplicationDevelopment.Controller;

import com.Hardeymorlah.BankingApplicationDevelopment.Model.AccountUser;
import com.Hardeymorlah.BankingApplicationDevelopment.Model.AccountResource;
import com.Hardeymorlah.BankingApplicationDevelopment.Service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accountResource")
public class ResourceController {
    private String username;
    private AccountUser newAccountUser;
    private AccountUser updateUser;

    @Autowired
    private AccountUserService accountUserService;

    @GetMapping("/{id}")
public ResponseEntity<AccountResource> getAccountUserResource(@PathVariable int id){
    AccountUser accountUser = accountUserService.getAccountUserById(id).getBody();
    AccountResource accountResource = new AccountResource();
    accountResource.setAccountUser(accountUser);
    Link getById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).getAccountUserById(id)).withSelfRel();
    Link getAllAccountUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).getAllAccountUsers()).withRel("allAccountUsers");
    Link getByUsername = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).getAccountUserByUsername(username)).withRel("getByUsername");
    Link createAccountUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).createAccountUser(newAccountUser)).withRel("createAccountUser");
    Link updateAccountUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).updateAccountUser(id, updateUser)).withRel("updateUserDetails");
    Link deleteAccountUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).deleteAccountUserById(id)).withRel("deleteAccountUser");
    Link del = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).getAccountUserByUsername(username)).withRel("deleteUsername");
    accountResource.add(getAllAccountUsers,getById,getByUsername,createAccountUser,updateAccountUser, del, deleteAccountUser);
    return new ResponseEntity<>(accountResource, HttpStatus.OK);
}
}

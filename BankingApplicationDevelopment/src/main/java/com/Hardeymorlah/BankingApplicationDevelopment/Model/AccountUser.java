package com.Hardeymorlah.BankingApplicationDevelopment.Model;

import com.Hardeymorlah.BankingApplicationDevelopment.CustomAnnotaion.EmailOrUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "account_user", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "phone_number,", "password"}))
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank(message = "First Name cannot be blank")
    @Length(min = 3, max = 25, message = "First Name can't be less than 3 characters")
    private String firstName;
    @NotNull
    @NotBlank(message = "Last Name cannot be blank")
    @Length(min = 3, max = 25, message = "Last Name can't be less than 3 characters")
    private String lastName;
    private String middleName;
    @NotNull
    @NotBlank(message = "Field cannot be blank")
    @EmailOrUsername
    private String username;
    @NotNull
    @NotBlank(message = "Password Field cannot be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%+=^*?&]).{8,20}$")

    private String password;
    @NotNull
    @NotBlank(message = "Phone Number cannot be blank")
    @Pattern(regexp = "[0-9]{11}", message = "Phone number must be numbers between 0 and 9 and must be 11 digits")
    private String phoneNumber;

    public  AccountUser(){}

    public AccountUser(int id, String firstName, String lastName, String middleName, String username, String password, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
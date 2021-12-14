package com.example.mainPackage.controller;

import com.example.mainPackage.entity.Account;
import com.example.mainPackage.service.AccountServices;
import com.example.mainPackage.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path = "accounts/")
@CrossOrigin(origins = "http://localhost:9000")
public class AccountController {

      private AccountServices accountServices;
      private UserServices userServices;






      @Autowired
      public AccountController(AccountServices accountServices, UserServices userServices) {
            this.accountServices = accountServices;
            this.userServices = userServices;
      }




      @PostMapping(path = "register",consumes = "application/json",produces ="application/json")
      Account register(@RequestBody Account account){

            return accountServices.register(account);


      }

      @PostMapping(path = "login",consumes = "application/json",produces ="application/json")
      Account login(@RequestBody Account account){

            return accountServices.login(account);
      }


      @GetMapping(path = "logout")
       void logout(@RequestParam(name = "id") Long id){

            new Thread(){



            };
            accountServices.logout(id);


      }



      @GetMapping(path ="all")

      List<Account>getAllAccounts(){

            return accountServices.getAllAccounts();

      }


      @GetMapping(path = "getOne")
      Account getOneAccount(@RequestParam(name = "id") Long id){

            return accountServices.getOneAccount(id);

      }






}


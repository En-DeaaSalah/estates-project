package com.example.mainPackage.service;


import com.example.mainPackage.entity.Account;
import com.example.mainPackage.entity.System_User;
import com.example.mainPackage.repository.AccountRepository;
import com.example.mainPackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServices {

      private AccountRepository accountRepository;
      private UserRepository userRepository;
      @Autowired
      public AccountServices(AccountRepository accountRepository, UserRepository userRepository) {
            this.accountRepository = accountRepository;
            this.userRepository = userRepository;
      }

      public AccountServices(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
      }

      public Account register(Account account) {

            if(accountRepository.existsAccountByEmail(account.getEmail())){

                  throw new IllegalStateException("account exist");

            }

                  PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();


                  account.setPassword(passwordEncoder.encode(account.getPassword()));



                  return accountRepository.save(account);


      }



      @Transactional
      public Account login(Account account){


            if(accountRepository.existsAccountById(account.getId())) {


                  Account storedAccount = accountRepository.getAccountById(account.getId());

                  PasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();


                  if(storedAccount.getEmail().equals(account.getEmail())&&bCryptPasswordEncoder.matches(account.getPassword(),storedAccount.getPassword())){



                        storedAccount.setIs_login(true);
                        return storedAccount;


                  }else{

                        throw new IllegalStateException("not match email");

                  }



            }

            throw new IllegalStateException("account is not exist");

      }

      @Transactional
      public void logout(Long account_id){

            Account storedAccount = accountRepository.getAccountById(account_id);
            storedAccount.setIs_login(false);


      }

      public List<Account> getAllAccounts(){


            return  accountRepository.findAll();

      }

      public Account getOneAccount(Long id){


            if(!accountRepository.existsAccountById(id)){

                  throw new IllegalStateException("user not exits");

            }


            return accountRepository.getAccountById(id);


      }


      public Account getOneByOwner(String owner) {


            return accountRepository.getAccountByOwner(userRepository.findByFirstName(owner));

      }
}

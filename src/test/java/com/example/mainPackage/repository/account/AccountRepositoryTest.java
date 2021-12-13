package com.example.mainPackage.repository.account;

import com.example.mainPackage.entity.Account;
import com.example.mainPackage.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
class AccountRepositoryTest {


      @Autowired
      private AccountRepository accountRepository;



      @Test
      void existsAccountByEmail() {

            Account account=new Account();
            String email = "diaa@email.com";
            account.setEmail(email);
            account.setPassword("0000");


            accountRepository.save(account);

            boolean expected = accountRepository.existsAccountByEmail(email);

            assertThat(expected).isTrue();



      }

      @Test
      void NotExistsAccountByEmail() {


            String email = "diaa@email.com";

            boolean expected = accountRepository.existsAccountByEmail(email);

            assertThat(expected).isFalse();


      }



      @Test
      void getAccountById() {


            Account account=new Account();

            String email = "diaa@email.com";

            account.setEmail(email);

            account.setPassword("0000");

            accountRepository.save(account);

            Account storedAccount = accountRepository.getAccountById(1L);

            assertThat(storedAccount).isNotNull();



      }


      @Test
      void NotGetAccountById() {




            Account storedAccount = accountRepository.getAccountById(1L);

            assertThat(storedAccount).isNull();



      }



}
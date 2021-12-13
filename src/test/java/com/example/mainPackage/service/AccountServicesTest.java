package com.example.mainPackage.service;

import com.example.mainPackage.entity.Account;
import com.example.mainPackage.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServicesTest {

      @Mock
      private AccountRepository accountRepository;

      private AccountServices underTest;


      @BeforeEach
      void setUp() {
            underTest=new AccountServices(accountRepository);
      }

      @AfterEach
      void tearDown() {
            accountRepository.deleteAll();
      }

      @Test
      void register() {


            Account account=new Account();
            String email = "diaa@email.com";
            account.setEmail(email);
            account.setPassword("0000");


            underTest.register(account);

            ArgumentCaptor<Account> accountArgumentCaptor=ArgumentCaptor.forClass(Account.class);

            verify(accountRepository).save(accountArgumentCaptor.capture());

            Account accountCaptor = accountArgumentCaptor.getValue();

            assertThat(accountCaptor).isEqualTo(account);



      }

      @Test
      @Disabled
      void login() {


//            Account account=new Account();
//
//            String email = "diaa@email.com";
//
//            account.setEmail(email);
//
//            account.setPassword("0000");
//
//
//            Account storedAccount = accountRepository.save(account);
//
//            underTest.login(storedAccount);
//
//            Account logAccount=accountRepository.getAccountById(1L);
//
//            assertThat(logAccount.isIs_login()).isTrue();



      }

      @Test
      @Disabled
      void logout() {
      }

      @Test
      @Disabled
      void getAllAccounts() {

      }

      @Test
      @Disabled
      void getOneAccount() {
      }

      @Test
      @Disabled
      void getOneByOwner() {
      }
}
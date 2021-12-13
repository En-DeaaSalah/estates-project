package com.example.mainPackage.repository;


import com.example.mainPackage.entity.Account;
import com.example.mainPackage.entity.System_User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


      boolean existsAccountByEmail(String email);

      boolean existsAccountById(Long id);

      Account getAccountById(Long id);

      Account getAccountByOwner(System_User owner);


}

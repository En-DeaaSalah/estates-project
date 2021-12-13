package com.example.mainPackage.repository;

import com.example.mainPackage.entity.System_User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<System_User,Long> {


      System_User findByFirstName(String name);


}

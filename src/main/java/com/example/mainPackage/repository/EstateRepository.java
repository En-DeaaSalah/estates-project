package com.example.mainPackage.repository;

import com.example.mainPackage.entity.Estate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EstateRepository extends JpaRepository<Estate,Long> {

      @Transactional
      @Modifying
      @Query(value = "FROM Estate  WHERE available=true")
      List<Estate> findAll();



      List<Estate> findAllByOwnerId(Long id);


      void deleteById(Long id);


      boolean existsByName(String Name);






}

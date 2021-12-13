package com.example.mainPackage.repository;


import com.example.mainPackage.entity.AddDeleteLog;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<AddDeleteLog,Long> {


}

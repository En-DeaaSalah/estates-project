package com.example.mainPackage.repository.estate;

import com.example.mainPackage.entity.Estate;
import com.example.mainPackage.repository.EstateRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EstateRepositoryTest {

      @Autowired
      private EstateRepository underTest;

      @AfterEach
      void tearDown() {


            underTest.deleteAll();
      }

      @BeforeEach
      void setUp() {

      }

      @Test
      void existsByName() {



            Estate estate=new Estate();

            String estateName = "estateName";
            estate.setName(estateName);

            estate.setPrice(10000);

            underTest.save(estate);

            boolean expected=underTest.existsByName(estateName);


            assertThat(expected).isTrue();



      }

      @Test
      void NotExistsByName() {





            String estateName = "estateTest";


            boolean expected=underTest.existsByName(estateName);


            assertThat(expected).isFalse();



      }




}
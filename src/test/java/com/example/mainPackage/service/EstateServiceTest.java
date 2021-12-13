package com.example.mainPackage.service;

import com.example.mainPackage.entity.Estate;
import com.example.mainPackage.repository.EstateRepository;
import com.example.mainPackage.requestBodyClassis.AddEstateRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EstateServiceTest {


      private EstateService underTest;

      @Mock
      private EstateRepository estateRepository;

//      private AutoCloseable autoCloseable;

      @BeforeEach
      void setUp() {
//            autoCloseable = MockitoAnnotations.openMocks(this);

            underTest = new EstateService(estateRepository, null, null, null, null, null);

      }

//      @AfterEach
//      void tearDown() {
//
//            try {
//                  autoCloseable.close();
//            } catch (Exception e) {
//                  e.printStackTrace();
//            }
//
//      }

      @Test
      @Disabled
      void addEstate() {


            Estate estate=new Estate();

            String estateName = "estateName";
            estate.setName(estateName);

            estate.setPrice(10000);

            AddEstateRequest request=new AddEstateRequest();

            request.estate=estate;

            request.ownerId=1L;

            underTest.addEstate(request);


      }

      @Test
      @Disabled
      void updateEstate() {

      }

      @Test
      @Disabled
      void deleteEstate() {

      }

      @Test
      void availableEstates() {

            underTest.availableEstates();


            verify(estateRepository).findAll();
      }
}
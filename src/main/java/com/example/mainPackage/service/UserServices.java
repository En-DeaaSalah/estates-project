package com.example.mainPackage.service;

import com.example.mainPackage.entity.System_User;
import com.example.mainPackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

      private UserRepository userRepository;

      @Autowired
      public UserServices(UserRepository userRepository) {
            this.userRepository = userRepository;
      }


      System_User getOneById(Long id){

            return userRepository.getOne(id);


      }


}

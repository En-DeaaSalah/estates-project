package com.example.mainPackage.service;


import com.example.mainPackage.entity.Account;
import com.example.mainPackage.entity.AddDeleteLog;
import com.example.mainPackage.entity.Estate;
import com.example.mainPackage.repository.AccountRepository;
import com.example.mainPackage.repository.EstateRepository;
import com.example.mainPackage.repository.LogRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {


      private LogRepository addDeleteLogR;

      @Autowired
      public LogService(LogRepository addDeleteLogR) {
            this.addDeleteLogR = addDeleteLogR;
      }



      void registerToLog(Account user, Estate estate,String ActionName){

            AddDeleteLog log= new AddDeleteLog();



            switch (ActionName){

                  case "ADD":{
                        log.setAction("ADD");
                        break;
                  }
                  case "DELETE":{
                        log.setAction("DELETE");
                        break;
                  }


            }



            log.setActionDate(new Date());

            log.setUser_id(user.getId());

            log.setEstate_id(estate.getId());


            log.setEstateName(estate.getName());

            log.setUserEmail(user.getEmail());

            log.setUserName(user.getOwner().getFirstName());

            addDeleteLogR.save(log);

      }














}

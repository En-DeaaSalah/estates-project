package com.example.mainPackage.controller;


import com.example.mainPackage.entity.AddDeleteLog;
import com.example.mainPackage.entity.Contract;
import com.example.mainPackage.entity.UpdateLog;
import com.example.mainPackage.repository.ContactRepository;
import com.example.mainPackage.repository.LogRepository;
import com.example.mainPackage.repository.UpdateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping(path = "log/")
public class LogController {


      private UpdateLogRepository updateLog;
      private LogRepository addDeleteLog;
      private ContactRepository contractLog;

      @Autowired
      public LogController(UpdateLogRepository updateLog, LogRepository addDeleteLog, ContactRepository contractLog) {
            this.updateLog = updateLog;
            this.addDeleteLog = addDeleteLog;
            this.contractLog = contractLog;
      }


      @GetMapping(path = "add_delete",produces = "application/json")
      List<AddDeleteLog> addDeleteLogList(){

            return addDeleteLog.findAll();


      }



      @GetMapping(path = "update",produces = "application/json")
      List<UpdateLog> updateLogList(){

            return updateLog.findAll();


      }


      @GetMapping(path = "contract",produces = "application/json")
      List<Contract> contractLogList(){

            return contractLog.findAll();


      }

}

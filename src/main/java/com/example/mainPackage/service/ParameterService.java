package com.example.mainPackage.service;


import com.example.mainPackage.entity.Parameter;
import com.example.mainPackage.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParameterService {

      private ParameterRepository parameterRepository;

      private int Shares=10;

      private double Ratio=0.2;

      public int getShares() {
            return Shares;
      }

      public void setShares(int shares) {
            Shares = shares;
      }

      public double getRatio() {
            return Ratio;
      }

      public void setRatio(double ratio) {
            Ratio = ratio;
      }

      @Autowired
      public ParameterService(ParameterRepository parameterRepository) {
            this.parameterRepository = parameterRepository;
      }



      Parameter getParameters(){

            if(parameterRepository.findAll().size()==0){


                  Parameter parameter=new Parameter();

                  parameter.setNumber_of_Shares(Shares);

                  parameter.setProfit_Ratio(Ratio);

                  parameterRepository.save(parameter);

            }



            return parameterRepository.findAll().get(0);


      }

      @Transactional
      Parameter updateShares(int shares){

            getParameters().setNumber_of_Shares(shares);

            return getParameters();


      }
      @Transactional
      Parameter updateRatio(double Ratio){

            getParameters().setProfit_Ratio(Ratio);

            return getParameters();


      }




}

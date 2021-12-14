package com.example.mainPackage.service;


import com.example.mainPackage.entity.Account;
import com.example.mainPackage.entity.Contract;
import com.example.mainPackage.entity.Estate;
import com.example.mainPackage.entity.UpdateLog;
import com.example.mainPackage.repository.ContactRepository;
import com.example.mainPackage.repository.EstateRepository;
import com.example.mainPackage.repository.UpdateLogRepository;
import com.example.mainPackage.requestBodyClassis.AddEstateRequest;
import com.example.mainPackage.requestBodyClassis.SaleRequest;
import com.example.mainPackage.requestBodyClassis.UpdateEstateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class EstateService {

      private EstateRepository estateRepository;

      private AccountServices accountServices;

      private ParameterService parameterService;

      private LogService log;

      private ContactRepository contactRepository;


      private UpdateLogRepository updateLogRepository;

      @Autowired
      public EstateService(EstateRepository estateRepository, AccountServices accountServices, ParameterService parameterService, LogService log, ContactRepository contactRepository, UpdateLogRepository updateLogRepository) {
            this.estateRepository = estateRepository;
            this.accountServices = accountServices;
            this.parameterService = parameterService;
            this.log = log;
            this.contactRepository = contactRepository;
            this.updateLogRepository = updateLogRepository;
      }



      public Estate addEstate(AddEstateRequest addEstateRequest) {

                  Account owner;
                  try {
                        owner=accountServices.getOneAccount(addEstateRequest.ownerId);
                  }catch (IllegalStateException e){

                        throw new IllegalStateException("user not exit");
                  }


                  addEstateRequest.estate.setOwner(owner);

                  addEstateRequest.estate.setAvailable(true);


                  System.err.println(addEstateRequest.estate.getNumber_of_Shares());


                 if(addEstateRequest.estate.getNumber_of_Shares()==0){


                      addEstateRequest.estate.setNumber_of_Shares(parameterService.getParameters().getNumber_of_Shares());

                 }


                  addEstateRequest.estate.setPublishDate(new Date());
                  estateRepository.save(addEstateRequest.estate);

                  log.registerToLog(owner,addEstateRequest.estate,"ADD");



                  return addEstateRequest.estate;


      }

      public List<Estate> availableEstates() {


            return estateRepository.findAll();


      }


      public List<Estate>getEstateByOwnerId(Long id){

            return estateRepository.findAllByOwnerId(id);


      }


      public Estate getOneById(Long id) {


            if(estateRepository.findById(id).isPresent()){

                  return estateRepository.findById(id).get();
            }else{

                  throw new IllegalStateException("Estate not  exist");
            }
      }
      @Transactional
      public Estate updateEstate(UpdateEstateRequest request) {

            Estate newEstate =request.estate;


            if(estateRepository.findById(newEstate.getId()).isEmpty()){


                  throw new IllegalStateException("Estate not  exist");
            }

                  Estate oldEstate=estateRepository.findById(newEstate.getId()).get();




                  UpdateLog updateLog=new UpdateLog();


                  updateLog.setEstateID(oldEstate.getId());

                  updateLog.setEstateName(newEstate.getName());

                  updateLog.setUpdateDate(new Date());

                  updateLog.setUserEmail(oldEstate.getOwner().getEmail());

                  String description="";

                  if(!oldEstate.getName().equals(newEstate.getName())){


                        description+="name is changed : (old) "+oldEstate.getName()+" => (new) "+
                                    newEstate.getName()+"  \n";


                  }
                  if(oldEstate.getPrice()!=newEstate.getPrice()){

                        description+="Price is changed : (old) "+oldEstate.getPrice()+" => (new) "+
                                newEstate.getPrice()+"  \n";

                  }

                  if(oldEstate.getNumber_of_Shares()!=newEstate.getNumber_of_Shares()){

                        description+="Shares is changed : (old) "+oldEstate.getNumber_of_Shares()+" => (new) "+
                                newEstate.getNumber_of_Shares()+"  \n";


                  }

                  oldEstate.setPrice(newEstate.getPrice()*parameterService.getParameters().getProfit_Ratio());

                  oldEstate.setName(newEstate.getName());

                  oldEstate.setNumber_of_Shares(newEstate.getNumber_of_Shares());



                  updateLog.setDescription(description);

                  updateLogRepository.save(updateLog);





                  return newEstate;


      }

      public Estate deleteEstate(Long estate_id, Long owner_id) {

            if(estateRepository.findById(estate_id).isEmpty()){

                  throw new IllegalStateException("estate not exist");
            }
            Estate estate=estateRepository.findById(estate_id).get();

            if(!estate.getOwner().getId().equals(owner_id)){

                  throw new IllegalStateException("permission error");
            }

            log.registerToLog(estate.getOwner(),estate,"DELETE");


            estateRepository.deleteById(estate.getId());



            return estate;

      }

      @Transactional
      public Estate saleEstate(SaleRequest request) {



            Estate estate=estateRepository.findById(request.estateId).get();

            Account seller=accountServices.getOneAccount(request.sellerId);

            Account buyer=accountServices.getOneByOwner(request.buyerName);


            estate.setOwner(buyer);



            Contract contract=new Contract();

            contract.setBuyerEmail(buyer.getEmail());

            contract.setSellerEmail(seller.getEmail());

            contract.setEstate_id(estate.getId());

            contract.setEstateName(estate.getName());

            contract.setSelling_price(estate.getPrice());

            contract.setDate_of_sale(new Date());




            contactRepository.save(contract);


            return estate;


      }


}

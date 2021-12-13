package com.example.mainPackage.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AddDeleteLog {

      @Id
      @SequenceGenerator(
              name = "log_sequence",
              sequenceName = "log_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="log_sequence"

      )
      @Column(name = "log_id")
      private Long id;




      private String action;


      private Long user_id;


      private String userEmail;


      private String userName;


      private Long estate_id;


      private String estateName;


      private Date actionDate;





      public Long getUser_id() {
            return user_id;
      }

      public void setUser_id(Long user_id) {
            this.user_id = user_id;
      }

      public Long getEstate_id() {
            return estate_id;
      }

      public void setEstate_id(Long estate_id) {
            this.estate_id = estate_id;
      }


      public AddDeleteLog(String action, Long user_id, String userEmail, String userName, Long estate_id, String estateName, Date actionDate) {
            this.action = action;
            this.user_id = user_id;
            this.userEmail = userEmail;
            this.userName = userName;
            this.estate_id = estate_id;
            this.estateName = estateName;
            this.actionDate = actionDate;
      }

      public String getUserEmail() {
            return userEmail;
      }

      public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
      }

      public String getUserName() {
            return userName;
      }

      public void setUserName(String userName) {
            this.userName = userName;
      }

      public String getEstateName() {
            return estateName;
      }

      public void setEstateName(String estateName) {
            this.estateName = estateName;
      }

      public AddDeleteLog() {
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }


      public String getAction() {
            return action;
      }

      public void setAction(String action) {
            this.action = action;
      }

      public Date getActionDate() {
            return actionDate;
      }

      public void setActionDate(Date actionDate) {
            this.actionDate = actionDate;
      }
















      //      @OneToOne(cascade = CascadeType.ALL)
//      @JoinColumn(name = "fk_user")
//        private Account user;


//      @OnDelete(action = OnDeleteAction.CASCADE)
//      @OneToOne(cascade = CascadeType.ALL)
//      @JoinColumn(name = "fk_estate")
//      private Estate estate;

}

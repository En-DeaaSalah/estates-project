package com.example.mainPackage.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class UpdateLog {

      @Id
      @SequenceGenerator(
              name = "updateLog_sequence",
              sequenceName = "updateLog_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="updateLog_sequence"

      )
      @Column(
              updatable = false
      )
      private Long id;



      private String userEmail;

      private Date updateDate;

      private Long estateID;

      private String estateName;

      @Column(columnDefinition = "TEXT")
      private String description;


      public UpdateLog(String userEmail, Date updateDate, Long estateID, String estateName, String description) {
            this.userEmail = userEmail;
            this.updateDate = updateDate;
            this.estateID = estateID;
            this.estateName = estateName;
            this.description = description;
      }


      public UpdateLog() {
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getUserEmail() {
            return userEmail;
      }

      public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
      }

      public Date getUpdateDate() {
            return updateDate;
      }

      public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
      }

      public Long getEstateID() {
            return estateID;
      }

      public void setEstateID(Long estateID) {
            this.estateID = estateID;
      }

      public String getEstateName() {
            return estateName;
      }

      public void setEstateName(String estateName) {
            this.estateName = estateName;
      }

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }
}

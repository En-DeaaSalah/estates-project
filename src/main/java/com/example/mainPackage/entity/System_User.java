package com.example.mainPackage.entity;


import javax.persistence.*;

@Entity
public class System_User {

      @Id
      @SequenceGenerator(
              name = "user_sequence",
              sequenceName = "user_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="user_sequence"

      )
      @Column(
              updatable = false
      )
      private Long id;
      @Column(

              columnDefinition = "TEXT"
      )
      private String firstName;
      @Column(
              columnDefinition = "TEXT"
      )
      private String secondName;


      @OneToOne(mappedBy = "owner")
      private Account account;

      public System_User() {
      }

      public System_User(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getFirstName() {
            return firstName;
      }

      public void setFirstName(String firstName) {
            this.firstName = firstName;
      }

      public String getSecondName() {
            return secondName;
      }

      public void setSecondName(String secondName) {
            this.secondName = secondName;
      }
}

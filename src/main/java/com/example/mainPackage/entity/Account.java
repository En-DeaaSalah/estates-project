package com.example.mainPackage.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Account {


      @Id
      @SequenceGenerator(
              name = "account_sequence",
              sequenceName = "account_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="account_sequence"

      )
      @Column(name = "account_id")
      private Long id;

      private String email;

      private String password;

      private boolean Is_login;

      private int type;

      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "fk_user")
      private System_User owner;


      @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "owner")
      private List<Estate>estates;

      public Account() {
      }

      public Account(String email, String password, boolean is_login, int type, System_User owner) {
            this.email = email;
            this.password = password;
            Is_login = is_login;
            this.type = type;
            this.owner = owner;
      }

      public System_User getOwner() {
            return owner;
      }

      public void setOwner(System_User owner) {
            this.owner = owner;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public boolean isIs_login() {
            return Is_login;
      }

      public void setIs_login(boolean is_login) {
            Is_login = is_login;
      }

      public int getType() {
            return type;
      }

      public void setType(int type) {
            this.type = type;
      }


      @Override
      public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", Is_login=" + Is_login +
                    ", type=" + type +
                    ", owner=" + owner +
                    ", estates=" + estates +
                    '}';
      }
}

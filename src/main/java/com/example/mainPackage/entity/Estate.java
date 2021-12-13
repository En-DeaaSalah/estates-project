package com.example.mainPackage.entity;

import javax.persistence.*;

@Entity
public class Estate {
      @Id
      @SequenceGenerator(
              name = "estate_sequence",
              sequenceName = "estate_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="estate_sequence"

      )
      private Long id;

      private String name;

      private double price;

      private int Number_of_Shares;

      @Column(columnDefinition = "Boolean default 'true'")
      private boolean available=true;

      @ManyToOne()
      @JoinColumn(name = "owner_id")
      private Account owner;




      public Estate(String name, double price, int number_of_Shares, boolean available, Account owner) {
            this.name = name;
            this.price = price;
            Number_of_Shares = number_of_Shares;
            this.available = available;
            this.owner = owner;
      }

      public Estate() {
      }


      public int getNumber_of_Shares() {
            return Number_of_Shares;
      }

      public void setNumber_of_Shares(int number_of_Shares) {
            Number_of_Shares = number_of_Shares;
      }

      public Account getOwner() {
            return owner;
      }

      public void setOwner(Account owner) {
            this.owner = owner;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public double getPrice() {
            return price;
      }

      public void setPrice(double price) {
            this.price = price;
      }

      public boolean isAvailable() {
            return available;
      }

      public void setAvailable(boolean available) {
            this.available = available;
      }


      @Override
      public String toString() {
            return "Estate{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", Number_of_Shares=" + Number_of_Shares +
                    ", available=" + available +
                    ", owner=" + owner +
                    '}';
      }
}

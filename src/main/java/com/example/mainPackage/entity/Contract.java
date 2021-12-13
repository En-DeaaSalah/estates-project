package com.example.mainPackage.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contract {



      @Id
      @SequenceGenerator(
              name = "contract_sequence",
              sequenceName = "contract_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="contract_sequence"

      )

      private Long id;

      private Date date_of_sale;

      private double selling_price;

      private Long estate_id;

      private String estateName;

      private String sellerEmail;

      private String buyerEmail;


      public Contract(Date date_of_sale, double selling_price, Long estate_id, String estateName, String sellerEmail, String buyerEmail) {
            this.date_of_sale = date_of_sale;
            this.selling_price = selling_price;
            this.estate_id = estate_id;
            this.estateName = estateName;
            this.sellerEmail = sellerEmail;
            this.buyerEmail = buyerEmail;
      }

      public Contract() {
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public Date getDate_of_sale() {
            return date_of_sale;
      }

      public void setDate_of_sale(Date date_of_sale) {
            this.date_of_sale = date_of_sale;
      }

      public double getSelling_price() {
            return selling_price;
      }

      public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
      }

      public Long getEstate_id() {
            return estate_id;
      }

      public void setEstate_id(Long estate_id) {
            this.estate_id = estate_id;
      }

      public String getEstateName() {
            return estateName;
      }

      public void setEstateName(String estateName) {
            this.estateName = estateName;
      }

      public String getSellerEmail() {
            return sellerEmail;
      }

      public void setSellerEmail(String sellerEmail) {
            this.sellerEmail = sellerEmail;
      }

      public String getBuyerEmail() {
            return buyerEmail;
      }

      public void setBuyerEmail(String buyerEmail) {
            this.buyerEmail = buyerEmail;
      }
}

package com.example.mainPackage.entity;

import javax.persistence.*;

@Entity
public class Parameter {

      @Id
      @SequenceGenerator(
              name = "Parameter_sequence",
              sequenceName = "Parameter_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy = GenerationType.SEQUENCE,
              generator ="Parameter_sequence"

      )
      private Long id;

      private double Profit_Ratio;

      private int Number_of_Shares;

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public double getProfit_Ratio() {
            return Profit_Ratio;
      }

      public void setProfit_Ratio(double Profit_Ratio) {
            this.Profit_Ratio = Profit_Ratio;
      }

      public int getNumber_of_Shares() {
            return Number_of_Shares;
      }

      public void setNumber_of_Shares(int Number_of_Shares) {
            this.Number_of_Shares = Number_of_Shares;
      }
}

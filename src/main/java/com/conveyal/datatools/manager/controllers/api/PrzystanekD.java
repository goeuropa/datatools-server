package com.conveyal.datatools.manager.controllers.api;

import java.util.HashMap;
public class PrzystanekD {
  public PrzystanekD(){
    uwagi = new String[3];
    uwagi[0] = "x - nie kursuje od 1 lipca do 31 sierpnia";
    uwagi[1] = "S - kurs w dni nauki szkolnej";
    uwagi[2] = "D - kurs do Dębiec Wieś";
  }
  String nazwa;
  String kierunek;
  String waznyod;
  String linia;
  String[][] odjazdy1 = new String[24][60];
  String[][] odjazdy2 = new String[24][60];
  String[][] odjazdy3 = new String[24][60];
  String[] przystanki = new String[20];
  public String[] uwagi;
  public String toString(){
    return "Przystanek: " + this.nazwa;
  }
  public void main(String[] args){
    PrzystanekD p = new PrzystanekD();
    odjazdy1[3][20] = "O";
    odjazdy1[3][40] = "O";
    odjazdy1[4][20] = "K";


  }
  public String showMinute(String kod, int j){
    if ( kod == "O"){
      return new Integer(j).toString();
    }
    if ( kod == "x"){
      return new Integer(j).toString()+"x";
    }
    if ( kod == "SD"){
      return new Integer(j).toString()+"S,D";
    }
    return "E";
  }
}


/*
O - kurs normalny
K - kurs wydłużony
*/

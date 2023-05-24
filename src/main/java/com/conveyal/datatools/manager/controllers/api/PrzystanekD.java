package com.conveyal.datatools.manager.controllers.api;

import java.util.HashMap;
public class PrzystanekD {
  public PrzystanekD(String number){
    this.waznyod = "16-05-2023";
    if ( number.equals("3") == true ){//582
    this.nazwa = "Kórnik Szkoła";
    this.kierunek = "Środa Wlkp PKS";

    this.linia = "582";
    this.odjazdy1[13][11] = "SD";
    this.odjazdy1[13][57] = "x";
    this.odjazdy1[15][37] = "x";

    uwagi = new String[3];
    uwagi[0] = "x - nie kursuje od 1 lipca do 31 sierpnia";
    uwagi[1] = "e - kurs w dni nauki szkolnej i kurs do Dębiec Wieś";

    this.przystanki[0] = "Kórnik - Szkoła";
    this.przystanki[1] = "Kórnik - Pl. Niepodległości";
    this.przystanki[2] = "Trzebisławki Wieś";
    this.przystanki[3] = "Trzebisławki";
    this.przystanki[4] = "Dębiec Wieś";
    this.przystanki[5] = "Dębiec";
    this.przystanki[6] = "Koszuty";
    this.przystanki[7] = "Słupia Wielka/Szkoła";
    this.przystanki[8] = "Słupia Wielka";
    this.przystanki[9] = "Pętkowo";
    this.przystanki[10] = "Niedziałkowskiego Działki";
    this.przystanki[11] = "Środa Wlkp Nied. Biedronka";
    this.przystanki[12] = "Środa Wlkp PKS";
    }
    if ( number.equals("4") == true ){
    this.nazwa = "Kórnik Szkoła";
    this.kierunek = "Kórnik Dworzec PKP";

    this.linia = "590";
    this.odjazdy1[4][6] = "O";
    this.odjazdy1[5][11] = "D";
    this.odjazdy1[6][3] = "O";
    this.odjazdy1[6][25] = "X";
    this.odjazdy1[7][22] = "t";
    this.odjazdy1[8][3] = "t";
    this.odjazdy1[10][47] = "R";
    this.odjazdy1[15][29] = "t";
    this.odjazdy1[16][54] = "y";
    this.odjazdy1[19][53] = "X";

    this.odjazdy2[6][7] = "O";
    this.odjazdy2[7][21] = "O";
    this.odjazdy2[9][44] = "P";
    this.odjazdy2[10][56] = "O";

    this.odjazdy3[6][7] = "O";
    this.odjazdy3[10][56] = "O";

    uwagi = new String[5];
    uwagi[0] = "D - kurs wydłużony do Dachowa";
    uwagi[1] = "P - kurs do Szczodrzykowo Poznańska";
    uwagi[2] = "t - kurs do SP Szczydrzykowo";
    uwagi[3] = "X - bez wjazdu do Kórnik Szkoła";
    uwagi[4] = "R - kurs do Kórnik Plac Niepodległości";

    this.przystanki[0] = "Kórnik - Pl. Niepodległości";
    this.przystanki[1] = "Kórnik - Szkoła";
    this.przystanki[2] = "Kórnik - Reja";
    this.przystanki[3] = "Dźiećmierowo - TFP";
    this.przystanki[4] = "Dźiećmierowo - Polna";
    this.przystanki[5] = "Dźiećmierowo - Słoneczna";
    this.przystanki[6] = "Dźiećmierowo - Leśna";
    this.przystanki[7] = "Szczodrzykowo - Kolejowa";
    this.przystanki[8] = "Szczodrzykowo - Dworzec PKP";
    }
    if ( number.equals("2") == true ){//582
    this.nazwa = "Kórnik Szkoła";
    this.kierunek = "Kórnik Rynek końcowy";

    this.linia = "580";
    }



    if ( number.equals("5") == true ){//582
    this.nazwa = "Kórnik Szkoła";
    this.kierunek = "Kromolice Pętla";

    this.linia = "591";
    }
    if ( number.equals("6") == true ){//582
    this.nazwa = "Robakowo Gimnazjum";
    this.kierunek = "Kórnik Rynek";

    this.linia = "592";
    }
    if ( number.equals("7") == true ){//582
    this.nazwa = "Borówiec";
    this.kierunek = "Kamionki";

    this.linia = "593";
    }
    if ( number.equals("8") == true ){//582
    this.nazwa = "Koninko";
    this.kierunek = "Szczodrzykowo";

    this.linia = "594";
    }
    if ( number.equals("9") == true ){//582
    this.nazwa = "Radzewo - Rynek";
    this.kierunek = "Rynek - Radzewo";

    this.linia = "595";
    }
    if ( number.equals("10") == true ){//582
    this.nazwa = "Kórnik";
    this.kierunek = "Rynek Czołowo";

    this.linia = "596";
    }
    if ( number.equals("11") == true ){//582
    this.nazwa = "Bnin Osiedle";
    this.kierunek = "Jaryszki Składowa";

    this.linia = "597";
    }
    if ( number.equals("12") == true ){//582
    this.nazwa = "Kórnik Plac Niepodległości";
    this.kierunek = "Szczytniki Pętla";

    this.linia = "599";
    }
    //uwagi[2] = "D - kurs do Dębiec Wieś";
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
      return new Integer(j).toString()+"e";
    }
    if ( kod == "D"){
      return new Integer(j).toString()+"D";
    }
    if ( kod == "X"){
      return new Integer(j).toString()+"e";
    }
    if ( kod == "f"){
      return new Integer(j).toString()+"f";
    }
    if ( kod == "R"){
      return new Integer(j).toString()+"R";
    }
    if ( kod == "y"){
      return new Integer(j).toString()+"y";
    }
    if ( kod == "P"){
      return new Integer(j).toString()+"P";
    }


    return "E";
  }
}


/*
O - kurs normalny
K - kurs wydłużony
*/

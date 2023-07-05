package com.conveyal.datatools.manager.controllers.api;

import java.util.HashMap;
public class PrzystanekD {
  public PrzystanekD(){
  }
  /*  public PrzystanekD(String number, String databaseUrl){

    }*/
    public PrzystanekD[] generujRozklad(String number){
      PrzystanekD[] przystanki = null;
      int n;
      if ( number.equals("3") == true ){//582
//TODO this itp all rozklad for 3
      n = 13;
      przystanki = new PrzystanekD[n];
      for ( int k = 0 ; k < n ; k++ ){
        przystanki[k] = new PrzystanekD();
        przystanki[k].waznyod = "16-05-2023";
        przystanki[k].kierunek = "Środa Wlkp PKS";

        przystanki[k].przystanki[0] = "Kórnik - Szkoła";
        przystanki[k].przystanki[1] = "Kórnik - Pl. Niepodległości";
        przystanki[k].przystanki[2] = "Trzebisławki Wieś";
        przystanki[k].przystanki[3] = "Trzebisławki";
        przystanki[k].przystanki[4] = "Dębiec Wieś";
        przystanki[k].przystanki[5] = "Dębiec";
        przystanki[k].przystanki[6] = "Koszuty";
        przystanki[k].przystanki[7] = "Słupia Wielka/Szkoła";
        przystanki[k].przystanki[8] = "Słupia Wielka";
        przystanki[k].przystanki[9] = "Pętkowo";
        przystanki[k].przystanki[10] = "Niedziałkowskiego Działki";
        przystanki[k].przystanki[11] = "Środa Wlkp Nied. Biedronka";
        przystanki[k].przystanki[12] = "Środa Wlkp PKS";

        przystanki[k].linia = "582";


        przystanki[k].uwagi = new String[3];
        przystanki[k].uwagi[0] = "x - nie kursuje od 1 lipca do 31 sierpnia";
        przystanki[k].uwagi[1] = "e - kurs w dni nauki szkolnej i kurs do Dębiec Wieś";

      }

      przystanki[0].nazwa = "Kórnik Szkoła";
      przystanki[0].odjazdy1[13][57] = "x";
      przystanki[0].odjazdy1[15][37] = "x";

      przystanki[1].nazwa = "Kórnik - Pl. Niepodległości";
      przystanki[1].odjazdy1[14][00] = "x";
      przystanki[1].odjazdy1[15][40] = "x";

      przystanki[2].nazwa = "Trzebisławki Wieś";
      przystanki[2].odjazdy1[14][07] = "x";
      przystanki[2].odjazdy1[15][47] = "x";


  /*    przystanki[1].przystanki[0] = "Środa Wlkp PKS";
      przystanki[1].przystanki[1] = "Środa Wlkp Nied. Biedronka";
      przystanki[1].przystanki[2] = "Niedziałkowskiego Działki";
      przystanki[1].przystanki[3] = "Pętkowo";
      przystanki[1].przystanki[4] = "Słupia Wielka";
      przystanki[1].przystanki[5] = "Słupia Wielka/Szkoła";
      przystanki[1].przystanki[6] = "Koszuty";
      przystanki[1].przystanki[7] = "Dębiec";
      przystanki[1].przystanki[8] = "Dębiec Wieś";
      przystanki[1].przystanki[9] = "Trzebisławki";
      przystanki[1].przystanki[10] = "Trzebisławki Wieś";
      przystanki[1].przystanki[11] = "Kórnik - Pl. Niepodległości";
      przystanki[1].przystanki[12] = "Kórnik - Szkoła";
*/

przystanki[3].nazwa = "Trzebisławki";
przystanki[3].odjazdy1[14][10] = "x";
przystanki[3].odjazdy1[15][50] = "x";

przystanki[4].nazwa = "Dębiec Wieś";
przystanki[4].odjazdy1[14][14] = "x";
przystanki[4].odjazdy1[15][54] = "x";

przystanki[5].nazwa = "Dębiec";
przystanki[5].odjazdy1[14][17] = "x";
przystanki[5].odjazdy1[15][57] = "x";

przystanki[6].nazwa = "Koszuty";
przystanki[6].odjazdy1[14][20] = "x";
przystanki[6].odjazdy1[16][00] = "x";


przystanki[7].nazwa = "Słupia Wielka/Szkoła";
przystanki[7].odjazdy1[14][21] = "x";
przystanki[7].odjazdy1[16][01] = "x";


przystanki[8].nazwa = "Słupia Wielka";
przystanki[8].odjazdy1[14][23] = "x";
przystanki[8].odjazdy1[16][03] = "x";


przystanki[9].nazwa = "Pętkowo";
przystanki[9].odjazdy1[14][26] = "x";
przystanki[9].odjazdy1[16][06] = "x";


przystanki[10].nazwa = "Niedziałkowskiego Działki";
przystanki[10].odjazdy1[14][31] = "x";
przystanki[10].odjazdy1[16][11] = "x";


przystanki[11].nazwa = "Środa Wlkp Niedziałkowskiego Biedronka";
przystanki[11].odjazdy1[14][33] = "x";
przystanki[11].odjazdy1[16][13] = "x";


przystanki[12].nazwa = "Środa Wlkp PKS";
przystanki[12].odjazdy1[14][35] = "x";
przystanki[12].odjazdy1[16][15] = "x";
      }

      return przystanki;
    }
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
    this.odjazdy1[15][22] = "O";

    uwagi = new String[0];

    this.przystanki[0] = "Kórnik - Pl. Niepodległości";
    this.przystanki[1] = "Kórnik - Prowent";
    this.przystanki[2] = "Kórnik - Bnin A.Krajowej";
    this.przystanki[3] = "Bnin - Biernacka";
    this.przystanki[4] = "Biernatki - Biernatki";
    this.przystanki[5] = "Biernatki - Laskowa";
    this.przystanki[6] = "Biernatki - Ośrodek";
    this.przystanki[7] = "Biernatki - Folwark";
    this.przystanki[8] = "Prusinowo - Wieś";
    this.przystanki[9] = "Prusinowo - Prusinowo";
    this.przystanki[10] = "Jeziory Wielkie - Jeziory Wielkie";
    this.przystanki[11] = "Jeziory Wielkie- Wieś";
    this.przystanki[12] = "Błażejewko - Błażejewko Pętla";
    this.przystanki[13] = "Błażejewko - Błażejewko";
    this.przystanki[14] = "Błażejewko - Wieś";
    this.przystanki[15] = "Błażejewko - Las";
    this.przystanki[16] = "Kórnik - Dom Dziecka";
    this.przystanki[17] = "Kórnik - Błażejewska";
    this.przystanki[18] = "Kórnik - Bnin Rynek";
    this.przystanki[19] = "Kórnik - Bnin A.Krajowej";
    this.przystanki[20] = "Kórnik - Prowent";
    this.przystanki[21] = "Kórnik - Pl.Niepodległości";
    }



    if ( number.equals("5") == true ){//582
    this.nazwa = "Kórnik Szkoła";
    this.kierunek = "Kromolice Pętla";

    this.linia = "591";
    this.odjazdy1[7][53] = "S";
    this.odjazdy1[10][12] = "O";
    this.odjazdy1[11][36] = "s";
    this.odjazdy1[12][45] = "s";
    this.odjazdy1[13][46] = "S";
    this.odjazdy1[14][53] = "s";
    this.odjazdy1[16][25] = "S";

    uwagi = new String[1];
    uwagi[0] = "S - kursuje w dni nauki szkolnej";

    this.przystanki[0] = "Szczodrzykowo - Szkoła";
    this.przystanki[1] = "Dachowa - Cisowa";
    this.przystanki[2] = "Robakowo Nowina";
    this.przystanki[3] = "Robakowo - Przyjazna";
    this.przystanki[4] = "Robakowo - Polna";
    this.przystanki[5] = "Robakowo - Szkoła";
  }
    if ( number.equals("6") == true ){//582
    this.nazwa = "Robakowo Gimnazjum";
    this.kierunek = "Kórnik Rynek";

    this.linia = "592";
    this.odjazdy1[9][30] = "O";
    this.odjazdy1[14][5] = "S";

    uwagi = new String[1];
    uwagi[0] = "S - kursuje w dni nauki szkolnej";

    this.przystanki[0] = "Szczodrzykowo - Szkoła";
    this.przystanki[1] = "Runowo - Wieś";
    this.przystanki[2] = "Runowo - Runowo";
    this.przystanki[3] = "Pierzchno I";
    this.przystanki[4] = "Pierzchno - Jagrol";
    this.przystanki[5] = "Pierzchno - PKP";
    }
    if ( number.equals("7") == true ){//582
    this.nazwa = "Borówiec Dębowa";
    this.kierunek = "Kamionki Szkoła";

    this.linia = "593";
    this.odjazdy1[6][45] = "O";
    this.odjazdy1[7][35] = "O";
    this.odjazdy1[8][10] = "O";
    this.odjazdy1[10][10] = "O";
    this.odjazdy1[11][16] = "O";

    uwagi = new String[0];

    this.przystanki[0] = "Borówiec Dębowa";
    this.przystanki[1] = "Borówiec Rekreacyjna";
    this.przystanki[2] = "Borówiec Łąkowa";
    this.przystanki[3] = "Borówiec,Szkoła";
    this.przystanki[4] = "Borówiec Deszczowa";
    this.przystanki[5] = "Borówiec Pod Borem";
    this.przystanki[6] = "Borówiec Kurkowa";
    this.przystanki[7] = "Borówiec Borówkowa";
    this.przystanki[8] = "Kamionki Lisia";
    this.przystanki[9] = "Kamionki Lotnicza";
    this.przystanki[10] = "Kamionki Pętla";
    this.przystanki[11] = "Kamionki Szkoła";
    }
    if ( number.equals("8") == true ){//582
    this.nazwa = "Koninko";
    this.kierunek = "Szczodrzykowo";

    this.linia = "594";
    this.odjazdy1[7][23] = "O";

    this.przystanki[0] = "Koninko Dziennikarska";
    this.przystanki[1] = "Koninko Pisarska";
    this.przystanki[2] = "Szczytniki Pętla";
    this.przystanki[3] = "Kamionki nad Koplą";
    this.przystanki[4] = "Szczytniki Szczelinka";
    this.przystanki[5] = "Szczytniki Sarnia";
    this.przystanki[6] = "Szczytniki Nad Wodą";
    this.przystanki[7] = "Koninko Las";
    this.przystanki[8] = "Borówiec Las";
    this.przystanki[9] = "Borówiec Dębowa";
    this.przystanki[10] = "Borówiec Rekreacyjna";
    this.przystanki[11] = "Borówiec Łąkowa";
    this.przystanki[12] = "Borówiec Deszczowa";
    this.przystanki[13] = "Borówiec Pod Borem";
    this.przystanki[14] = "Borówiec Kurkowa";
    this.przystanki[15] = "Borówiec Borówkowa";
    this.przystanki[16] = "Kamionki Lisia";
    this.przystanki[17] = "Kamionki Lotnicza";
    this.przystanki[18] = "Kamionki Pętla";
    this.przystanki[19] = "Kamionki Klonowa";
    this.przystanki[20] = "Kamionki Łąkowa";
    this.przystanki[21] = "Kamionki Polna";
    this.przystanki[22] = "Kamionki Szkoła";
    }
    if ( number.equals("9") == true ){//582
    this.nazwa = "Radzewo - Rynek";
    this.kierunek = "Rynek - Radzewo";

    this.linia = "595";

    this.odjazdy1[7][15] = "O";
    this.odjazdy1[9][0] = "O";

    this.uwagi = new String[0];

    this.przystanki[0] = "Kórnik - Pl. Niepodległ";
    this.przystanki[1] = "Kórnik - Prowent";
    this.przystanki[2] = "Kórnik Bnin A. Krajowej";
    this.przystanki[3] = "Kórnik - Bnin Rynek";
    this.przystanki[4] = "Kórnik Bnin Konarska";
    this.przystanki[5] = "Konarskie Wieś";
    this.przystanki[6] = "Konarskie Świetlica";
    this.przystanki[7] = "Konarskie Pętla";
    this.przystanki[8] = "Konarskie Skrzyżowanie";
    this.przystanki[9] = "Radzewo Strażnica";
    this.przystanki[10] = "Radzewo SP";
    this.przystanki[11] = "Trzykolne Młyny Radzewska";
    this.przystanki[12] = "Trzyklne Młyny Rogalińska";
    this.przystanki[13] = "Czmoniec Rumiankowa";
    this.przystanki[14] = "Czmoniec Miętowa";
    this.przystanki[15] = "Czmoniec Piwoniowa";
    this.przystanki[16] = "Czmoniec Stokrotkowa";
    this.przystanki[17] = "Czmoniec Marzymięta";
    this.przystanki[18] = "Czmoń Leśna";
    this.przystanki[19] = "Czmoń Strażacka";
    this.przystanki[20] = "Czmoń Lipowa";
    this.przystanki[21] = "Czmoń Os Radosne";
    this.przystanki[22] = "Radzewo Pomorska";
    this.przystanki[23] = "Radzewo Strażnica";
    this.przystanki[24] = "Radzewo SP";
    this.przystanki[25] = "Dworzyska";
    this.przystanki[26] = "Radzewo SP";
    this.przystanki[27] = "Radzewo Strażnica";
    this.przystanki[28] = "Konarskie Skrzyżowanie";
    this.przystanki[29] = "Konarskie Wieś";
    this.przystanki[30] = "Konarskie Świetlica";
    this.przystanki[31] = "Konarskie Pętla";
    this.przystanki[32] = "Czołowo Kórnicka";
    this.przystanki[33] = "Kórnik - Bnin Rynek";
    this.przystanki[34] = "Kórnik Bnin A.Krajowej";
    this.przystanki[35] = "Kórnik Prowent";
    this.przystanki[36] = "Kórnik - Pl. Niepodległ";

    }
    if ( number.equals("10") == true ){//582
    this.nazwa = "Kórnik";
    this.kierunek = "Rynek Czołowo";

    this.linia = "596";

    this.odjazdy1[12][45] = "S";
    this.odjazdy1[14][42] = "S";

    this.uwagi = new String[0];

    this.przystanki[0] = "Kórnik - Pl. Niepodległ";
    this.przystanki[1] = "Kórnik - Reja";
    this.przystanki[2] = "Mościennica - Mościennica";
    this.przystanki[3] = "Czołowo - Czołowo";
    }
    if ( number.equals("11") == true ){//582
    this.nazwa = "Bnin Osiedle";
    this.kierunek = "Jaryszki Składowa";

    this.linia = "597";
    this.odjazdy1[6][37] = "O";

    this.uwagi = new String[0];
    this.przystanki[0] = "Błażejewo - Przylesie";
    this.przystanki[1] = "Kórnik - Bnin Osiedle";
    this.przystanki[2] = "Kórnik - Bnin Rynek";
    this.przystanki[3] = "Kórnik Bnin Armii Krajowej";
    this.przystanki[4] = "Kórnik - Pl. Niepodległ";
    this.przystanki[5] = "Kórnik Reja";
    this.przystanki[6] = "Skrzynki Jeziorna";
    this.przystanki[7] = "Gądki - Gądki";
    this.przystanki[8] = "Gądki - Węzeł";
    this.przystanki[9] = "Jaryszki Składowa";
    }
    if ( number.equals("12") == true ){//582
    this.nazwa = "Kórnik Plac Niepodległości";
    this.kierunek = "Szczytniki Pętla";

    this.linia = "599";
    this.odjazdy1[5][25] = "O";
    this.odjazdy1[6][10] = "O";
    this.odjazdy1[9][13] = "O";
    this.odjazdy1[11][0] = "O";
    this.odjazdy1[14][17] = "X";
    this.odjazdy1[15][9] = "z";
    this.odjazdy1[16][18] = "X";
    this.odjazdy1[19][24] = "w";

    uwagi = new String[3];
    uwagi[0] = "X - kurs przez Kórnik Szkoła";
    uwagi[1] = "z - kurs przez Dziećmierowo Owocowe Wzgórze i Kórnik Szkoła";
    uwagi[2] = "w - kursuje w dni nauki szkolnej";

    this.przystanki[0] = "Kórnik - Pl. Niepodległ";
    this.przystanki[1] = "Kórnik Poprzeczna";
    this.przystanki[2] = "Kórnik - Reja";
    this.przystanki[3] = "Skrzynki Jeziorna";
    this.przystanki[4] = "Gądki PKP";
    this.przystanki[5] = "Borówiec Las";
    this.przystanki[6] = "Koninko Las";
    this.przystanki[7] = "Koninko Granatowa";
    this.przystanki[8] = "Koninko Dziennikarska";
    this.przystanki[9] = "Koninko Pisarska";
    this.przystanki[10] = "Szczytniki Pętla";
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
  String[] przystanki = new String[40];
  public String[] uwagi;
  public String toString(){
    return "Przystanek: " + this.nazwa;
  }
  public void main(String[] args){
    PrzystanekD p = new PrzystanekD("3");
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
    if ( kod == "S"){
      return new Integer(j).toString()+"S";
    }
    if ( kod == "s"){
      return new Integer(j).toString()+"s";
    }

    return "E";
  }
}


/*
O - kurs normalny
K - kurs wydłużony
*/

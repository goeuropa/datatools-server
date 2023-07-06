przystanki[przystanki[k].przystanki[przystanki[k].przystanki[package com.conveyal.datatools.manager.controllers.api;

import java.util.HashMap;
public class PrzystanekD {

  private PrzystanekD[] reverse(PrzystanekD[] p) {
     int length = p.length;
     PrzystanekD[] reversedArray = new PrzystanekD[length];

     for (int i = 0; i < length; i++) {
         reversedArray[length - i - 1] = p[i];
     }

     return reversedArray;
 }

 private PrzystanekD[] merge(PrzystanekD[] a, PrzystanekD[] b) {
        int lengthA = a.length;
        int lengthB = b.length;
        PrzystanekD[] mergedArray = new PrzystanekD[lengthA + lengthB];

        for (int i = 0; i < lengthA; i++) {
            mergedArray[i] = a[i];
        }

        for (int i = 0; i < lengthB; i++) {
            mergedArray[lengthA + i] = b[i];
        }

        return mergedArray;
    }
  public PrzystanekD(){
  }
  /*  public PrzystanekD(String number, String databaseUrl){

    }*/
    public PrzystanekD[] generujRozklad(String number){
      PrzystanekD[] przystanki = null;
      PrzystanekD[] przystanki2 = null;
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

//od tylu wpisuemy rozklady
n = 14
przystanki2 = new PrzystanekD[n];
for ( int k = 0 ; k < n ; k++ ){
  przystanki2[k] = new PrzystanekD();
  przystanki2[k].waznyod = "16-05-2023";
  przystanki2[k].kierunek = "Kórnik Rynek końcowy";

  przystanki2[k].przystanki[0] = "Błażejewo, Przylesie";
  przystanki2[k].przystanki[1] = "Kórnik - Bnin Osiedle";
  przystanki2[k].przystanki[2] = "Kórnik - Bnin Rynek";
  przystanki2[k].przystanki[3] = "Kórnik - A. Krajowej";
  przystanki2[k].przystanki[4] = "Kórnik - Prowent";
  przystanki2[k].przystanki[5] = "Kórnik - Pl. Niepodległości";
  przystanki2[k].przystanki[6] = "Trzebisławki";
  przystanki2[k].przystanki[7] = "Dębiec";
  przystanki2[k].przystanki[8] = "Koszuty";
  przystanki2[k].przystanki[9] = "Słupia Wielka - Szkoła";
  przystanki2[k].przystanki[10] = "Słupia Wielka";
  przystanki2[k].przystanki[11] = "Pętkowo";
  przystanki2[k].przystanki[12] = "Środa Wlkp Almarco";
  przystanki2[k].przystanki[13] = "Środa Wlkp PKS";

  przystanki2[k].linia = "582";


  przystanki2[k].uwagi = new String[3];
  przystanki2[k].uwagi[0] = "x - nie kursuje od 1 lipca do 31 sierpnia";
  przystanki2[k].uwagi[1] = "e - kurs w dni nauki szkolnej i kurs do Dębiec Wieś";

}

przystanki2[0].nazwa = "Błażejewo, Przylesie";
przystanki2[0].odjazdy1[16][53] = "x";

przystanki2[1].nazwa = "Kórnik - Bnin Osiedle";
przystanki2[1].odjazdy1[16][52] = "x";

przystanki2[2].nazwa = "Kórnik - Bnin Rynek";
przystanki2[2].odjazdy1[16][50] = "x";


przystanki2[3].nazwa = "Kórnik - A. Krajowej";
przystanki2[3].odjazdy1[16][48] = "x";

przystanki2[4].nazwa = "Kórnik - Prowent";
przystanki2[4].odjazdy1[16][46] = "x";

przystanki2[5].nazwa = "Kórnik - Pl. Niepodległości";
przystanki2[5].odjazdy1[16][44] = "x";

przystanki2[6].nazwa = "Trzebisławki";
przystanki2[6].odjazdy1[16][39] = "x";


przystanki2[7].nazwa = "Dębiec";
przystanki2[7].odjazdy1[16][37] = "x";


przystanki2[8].nazwa = "Koszuty";
przystanki2[8].odjazdy1[16][34] = "x";

przystanki2[9].nazwa = "Słupia Wielka - Szkoła";
przystanki2[9].odjazdy1[16][30] = "x";

przystanki2[10].nazwa = "Słupia Wielka";
przystanki2[10].odjazdy1[16][29] = "x";


przystanki2[11].nazwa = "Pętkowo";
przystanki2[11].odjazdy1[16][28] = "x";


przystanki2[12].nazwa = "Środa Wlkp Almarco";
przystanki2[12].odjazdy1[16][22] = "x";


przystanki2[13].nazwa = "Środa Wlkp PKS";
przystanki2[13].odjazdy1[16][20] = "x";

      }
      if ( number.equals("2") == true ){//582
//TODO this itp all rozklad for 3
      n = 22;
      przystanki = new PrzystanekD[n];
      for ( int k = 0 ; k < n ; k++ ){
        przystanki[k] = new PrzystanekD();
        przystanki[k].waznyod = "16-05-2023";
        przystanki[k].kierunek = "Kórnik - Pl.Niepodległości";

        przystanki[k].przystanki[0] = "Kórnik - Pl. Niepodległości";
        przystanki[k].przystanki[1] = "Kórnik - Prowent";
        przystanki[k].przystanki[2] = "Kórnik - Bnin A.Krajowej";
        przystanki[k].przystanki[3] = "Bnin - Biernacka";
        przystanki[k].przystanki[4] = "Biernatki - Biernatki";
        przystanki[k].przystanki[5] = "Biernatki - Laskowa";
        przystanki[k].przystanki[6] = "Biernatki - Ośrodek";
        przystanki[k].przystanki[7] = "Biernatki - Folwark";
        przystanki[k].przystanki[8] = "Prusinowo - Wieś";
        przystanki[k].przystanki[9] = "Prusinowo - Prusinowo";
        przystanki[k].przystanki[10] = "Jeziory Wielkie - Jeziory Wielkie";
        przystanki[k].przystanki[11] = "Jeziory Wielkie- Wieś";
        przystanki[k].przystanki[12] = "Błażejewko - Błażejewko Pętla";
        przystanki[k].przystanki[13] = "Błażejewko - Błażejewko";
        przystanki[k].przystanki[14] = "Błażejewko - Wieś";
        przystanki[k].przystanki[15] = "Błażejewko - Las";
        przystanki[k].przystanki[16] = "Kórnik - Dom Dziecka";
        przystanki[k].przystanki[17] = "Kórnik - Błażejewska";
        przystanki[k].przystanki[18] = "Kórnik - Bnin Rynek";
        przystanki[k].przystanki[19] = "Kórnik - Bnin A.Krajowej";
        przystanki[k].przystanki[20] = "Kórnik - Prowent";
        przystanki[k].przystanki[21] = "Kórnik - Pl.Niepodległości";

        przystanki[k].linia = "580";


        przystanki[k].uwagi = new String[0];

      }

      przystanki[0].nazwa = "Kórnik - Pl. Niepodległości"";
      przystanki[0].odjazdy1[7][21] = "O";
      przystanki[0].odjazdy1[8][25] = "O";
      przystanki[0].odjazdy1[9][00] = "O";
      przystanki[0].odjazdy1[10][45] = "O";
      przystanki[0].odjazdy1[12][57] = "O";
      przystanki[0].odjazdy1[13][45] = "O";

      przystanki[1].nazwa = "Kórnik - Prowent";
      przystanki[1].odjazdy1[7][23] = "O";
      przystanki[1].odjazdy1[8][27] = "O";
      przystanki[1].odjazdy1[9][02] = "O";
      przystanki[1].odjazdy1[10][47] = "O";
      przystanki[1].odjazdy1[12][59] = "O";
      przystanki[1].odjazdy1[13][47] = "O";

      przystanki[2].nazwa = "Kórnik - Bnin A.Krajowej";
      przystanki[2].odjazdy1[7][24] = "O";
      przystanki[2].odjazdy1[8][28] = "O";
      przystanki[2].odjazdy1[9][03] = "O";
      przystanki[2].odjazdy1[10][48] = "O";
      przystanki[2].odjazdy1[13][00] = "O";
      przystanki[2].odjazdy1[13][48] = "O";

      przystanki[3].nazwa = "Bnin - Biernacka";
      przystanki[3].odjazdy1[7][25] = "O";
      przystanki[3].odjazdy1[8][29] = "O";
      przystanki[3].odjazdy1[9][04] = "O";
      przystanki[3].odjazdy1[10][49] = "O";
      przystanki[3].odjazdy1[13][01] = "O";
      przystanki[3].odjazdy1[13][49] = "O";

      przystanki[4].nazwa = "Biernatki - Biernatki";
      przystanki[4].odjazdy1[7][26] = "O";
      przystanki[4].odjazdy1[8][30] = "O";
      przystanki[4].odjazdy1[9][05] = "O";
      przystanki[4].odjazdy1[10][50] = "O";
      przystanki[4].odjazdy1[13][02] = "O";
      przystanki[4].odjazdy1[13][50] = "O";

      przystanki[5].nazwa = "Biernatki - Laskowa";
      przystanki[5].odjazdy1[7][27] = "O";
      przystanki[5].odjazdy1[8][31] = "O";
      przystanki[5].odjazdy1[9][06] = "O";
      przystanki[5].odjazdy1[10][51] = "O";
      przystanki[5].odjazdy1[13][03] = "O";
      przystanki[5].odjazdy1[13][51] = "O";

      przystanki[6].nazwa = "Biernatki - Ośrodek";
      przystanki[6].odjazdy1[7][28] = "O";
      przystanki[6].odjazdy1[8][32] = "O";
      przystanki[6].odjazdy1[9][07] = "O";
      przystanki[6].odjazdy1[10][52] = "O";
      przystanki[6].odjazdy1[13][04] = "O";
      przystanki[6].odjazdy1[13][52] = "O";

      przystanki[7].nazwa = "Biernatki - Folwark";
      przystanki[7].odjazdy1[7][29] = "O";
      przystanki[7].odjazdy1[8][33] = "O";
      przystanki[7].odjazdy1[9][08] = "O";
      przystanki[7].odjazdy1[10][53] = "O";
      przystanki[7].odjazdy1[13][05] = "O";
      przystanki[7].odjazdy1[13][53] = "O";

      przystanki[8].nazwa = "Prusinowo - Wieś";
      przystanki[8].odjazdy1[7][31] = "O";
      przystanki[8].odjazdy1[8][35] = "O";
      przystanki[8].odjazdy1[9][10] = "O";
      przystanki[8].odjazdy1[10][55] = "O";
      przystanki[8].odjazdy1[13][07] = "O";
      przystanki[8].odjazdy1[13][55] = "O";

      przystanki[9].nazwa = "Prusinowo - Prusinowo";
      przystanki[9].odjazdy1[7][32] = "O";
      przystanki[9].odjazdy1[8][36] = "O";
      przystanki[9].odjazdy1[9][11] = "O";
      przystanki[9].odjazdy1[10][56] = "O";
      przystanki[9].odjazdy1[13][08] = "O";
      przystanki[9].odjazdy1[13][56] = "O";

//
      przystanki[10].nazwa = "Jeziory Wielkie - Jeziory Wielkie";
      przystanki[10].odjazdy1[7][34] = "O";
      przystanki[10].odjazdy1[8][38] = "O";
      przystanki[10].odjazdy1[9][13] = "O";
      przystanki[10].odjazdy1[10][58] = "O";
      przystanki[10].odjazdy1[13][10] = "O";
      przystanki[10].odjazdy1[13][58] = "O";

      przystanki[11].nazwa = "Jeziory Wielkie- Wieś";
      przystanki[11].odjazdy1[7][35] = "O";
      przystanki[11].odjazdy1[8][39] = "O";
      przystanki[11].odjazdy1[9][14] = "O";
      przystanki[11].odjazdy1[10][59] = "O";
      przystanki[11].odjazdy1[13][11] = "O";
      przystanki[11].odjazdy1[13][59] = "O";

      przystanki[12].nazwa = "Błażejewko - Błażejewko Pętla";
      przystanki[12].odjazdy1[7][38] = "O";
      przystanki[12].odjazdy1[8][42] = "O";
      przystanki[12].odjazdy1[9][17] = "O";
      przystanki[12].odjazdy1[11][2] = "O";
      przystanki[12].odjazdy1[13][14] = "O";
      przystanki[12].odjazdy1[14][2] = "O";

      przystanki[13].nazwa = "Błażejewko - Błażejewko";
      przystanki[13].odjazdy1[7][39] = "O";
      przystanki[13].odjazdy1[8][43] = "O";
      przystanki[13].odjazdy1[9][18] = "O";
      przystanki[13].odjazdy1[11][3] = "O";
      przystanki[13].odjazdy1[13][15] = "O";
      przystanki[13].odjazdy1[14][3] = "O";

      przystanki[14].nazwa = "Błażejewko - Wieś";
      przystanki[14].odjazdy1[7][40] = "O";
      przystanki[14].odjazdy1[8][44] = "O";
      przystanki[14].odjazdy1[9][19] = "O";
      przystanki[14].odjazdy1[11][4] = "O";
      przystanki[14].odjazdy1[13][16] = "O";
      przystanki[14].odjazdy1[14][4] = "O";

      przystanki[15].nazwa = "Błażejewko - Las";
      przystanki[15].odjazdy1[7][41] = "O";
      przystanki[15].odjazdy1[8][45] = "O";
      przystanki[15].odjazdy1[9][20] = "O";
      przystanki[15].odjazdy1[11][5] = "O";
      przystanki[15].odjazdy1[13][17] = "O";
      przystanki[15].odjazdy1[14][5] = "O";

      przystanki[16].nazwa = "Kórnik - Dom Dziecka";
      przystanki[16].odjazdy1[7][42] = "O";
      przystanki[16].odjazdy1[8][46] = "O";
      przystanki[16].odjazdy1[9][21] = "O";
      przystanki[16].odjazdy1[11][6] = "O";
      przystanki[16].odjazdy1[13][18] = "O";
      przystanki[16].odjazdy1[14][6] = "O";

      przystanki[17].nazwa = "Kórnik - Błażejewska";
      przystanki[17].odjazdy1[7][44] = "O";
      przystanki[17].odjazdy1[8][48] = "O";
      przystanki[17].odjazdy1[9][23] = "O";
      przystanki[17].odjazdy1[11][8] = "O";
      przystanki[17].odjazdy1[13][20] = "O";
      przystanki[17].odjazdy1[14][8] = "O";

      przystanki[18].nazwa = "Kórnik - Bnin Rynek";
      przystanki[18].odjazdy1[7][46] = "O";
      przystanki[18].odjazdy1[8][50] = "O";
      przystanki[18].odjazdy1[9][25] = "O";
      przystanki[18].odjazdy1[11][10] = "O";
      przystanki[18].odjazdy1[13][22] = "O";
      przystanki[18].odjazdy1[14][10] = "O";

      przystanki[19].nazwa = "Kórnik - Bnin A.Krajowej";
      przystanki[19].odjazdy1[7][48] = "O";
      przystanki[19].odjazdy1[8][52] = "O";
      przystanki[19].odjazdy1[9][27] = "O";
      przystanki[19].odjazdy1[11][12] = "O";
      przystanki[19].odjazdy1[13][24] = "O";
      przystanki[19].odjazdy1[14][12] = "O";

      przystanki[20].nazwa = "Kórnik - Prowent";
      przystanki[20].odjazdy1[7][49] = "O";
      przystanki[20].odjazdy1[8][53] = "O";
      przystanki[20].odjazdy1[9][28] = "O";
      przystanki[20].odjazdy1[11][13] = "O";
      przystanki[20].odjazdy1[13][25] = "O";
      przystanki[20].odjazdy1[14][13] = "O";

      przystanki[21].nazwa = "Kórnik - Pl.Niepodległości";
      przystanki[21].odjazdy1[7][51] = "O";
      przystanki[21].odjazdy1[8][55] = "O";
      przystanki[21].odjazdy1[9][30] = "O";
      przystanki[21].odjazdy1[11][15] = "O";
      przystanki[21].odjazdy1[13][27] = "O";
      przystanki[21].odjazdy1[14][15] = "O";

//
      przystanki2 = new PrzystanekD[n];
      for ( int k = 0 ; k < n ; k++ ){
        przystanki2[k] = new PrzystanekD();
        przystanki2[k].waznyod = "16-05-2023";
        przystanki2[k].kierunek = "Kórnik - Pl.Niepodległości";

        przystanki2[k].przystanki[0] = "Kórnik - Pl. Niepodległości";
        przystanki2[k].przystanki[1] = "Kórnik - Prowent";
        przystanki2[k].przystanki[2] = "Kórnik - Bnin A.Krajowej";
        przystanki2[k].przystanki[3] = "Bnin - Biernacka";
        przystanki2[k].przystanki[4] = "Biernatki - Biernatki";
        przystanki2[k].przystanki[5] = "Biernatki - Laskowa";
        przystanki2[k].przystanki[6] = "Biernatki - Ośrodek";
        przystanki2[k].przystanki[7] = "Biernatki - Folwark";
        przystanki2[k].przystanki[8] = "Prusinowo - Wieś";
        przystanki2[k].przystanki[9] = "Prusinowo - Prusinowo";
        przystanki2[k].przystanki[10] = "Jeziory Wielkie - Jeziory Wielkie";
        przystanki2[k].przystanki[11] = "Jeziory Wielkie- Wieś";
        przystanki2[k].przystanki[12] = "Błażejewko - Błażejewko Pętla";
        przystanki2[k].przystanki[13] = "Błażejewko - Błażejewko";
        przystanki2[k].przystanki[14] = "Błażejewko - Wieś";
        przystanki2[k].przystanki[15] = "Błażejewko - Las";
        przystanki2[k].przystanki[16] = "Kórnik - Dom Dziecka";
        przystanki2[k].przystanki[17] = "Kórnik - Błażejewska";
        przystanki2[k].przystanki[18] = "Kórnik - Bnin Rynek";
        przystanki2[k].przystanki[19] = "Kórnik - Bnin A.Krajowej";
        przystanki2[k].przystanki[20] = "Kórnik - Prowent";
        przystanki2[k].przystanki[21] = "Kórnik - Pl.Niepodległości";

        przystanki2[k].linia = "580";


        przystanki2[k].uwagi = new String[0];

      }

      przystanki2[0].nazwa = "Kórnik - Pl. Niepodległości"";
      przystanki2[0].odjazdy1[7][21] = "O";
      przystanki2[0].odjazdy1[8][25] = "O";
      przystanki2[0].odjazdy1[9][00] = "O";
      przystanki2[0].odjazdy1[10][45] = "O";
      przystanki2[0].odjazdy1[12][57] = "O";
      przystanki2[0].odjazdy1[13][45] = "O";

      przystanki2[1].nazwa = "Kórnik - Prowent";
      przystanki2[1].odjazdy1[7][23] = "O";
      przystanki2[1].odjazdy1[8][27] = "O";
      przystanki2[1].odjazdy1[9][02] = "O";
      przystanki2[1].odjazdy1[10][47] = "O";
      przystanki2[1].odjazdy1[12][59] = "O";
      przystanki2[1].odjazdy1[13][47] = "O";

      przystanki2[2].nazwa = "Kórnik - Bnin A.Krajowej";
      przystanki2[2].odjazdy1[7][24] = "O";
      przystanki2[2].odjazdy1[8][28] = "O";
      przystanki2[2].odjazdy1[9][03] = "O";
      przystanki2[2].odjazdy1[10][48] = "O";
      przystanki2[2].odjazdy1[13][00] = "O";
      przystanki2[2].odjazdy1[13][48] = "O";

      przystanki2[3].nazwa = "Bnin - Biernacka";
      przystanki2[3].odjazdy1[7][25] = "O";
      przystanki2[3].odjazdy1[8][29] = "O";
      przystanki2[3].odjazdy1[9][04] = "O";
      przystanki2[3].odjazdy1[10][49] = "O";
      przystanki2[3].odjazdy1[13][01] = "O";
      przystanki2[3].odjazdy1[13][49] = "O";

      przystanki2[4].nazwa = "Biernatki - Biernatki";
      przystanki2[4].odjazdy1[7][26] = "O";
      przystanki2[4].odjazdy1[8][30] = "O";
      przystanki2[4].odjazdy1[9][05] = "O";
      przystanki2[4].odjazdy1[10][50] = "O";
      przystanki2[4].odjazdy1[13][02] = "O";
      przystanki2[4].odjazdy1[13][50] = "O";

      przystanki2[5].nazwa = "Biernatki - Laskowa";
      przystanki2[5].odjazdy1[7][27] = "O";
      przystanki2[5].odjazdy1[8][31] = "O";
      przystanki2[5].odjazdy1[9][06] = "O";
      przystanki2[5].odjazdy1[10][51] = "O";
      przystanki2[5].odjazdy1[13][03] = "O";
      przystanki2[5].odjazdy1[13][51] = "O";

      przystanki2[6].nazwa = "Biernatki - Ośrodek";
      przystanki2[6].odjazdy1[7][28] = "O";
      przystanki2[6].odjazdy1[8][32] = "O";
      przystanki2[6].odjazdy1[9][07] = "O";
      przystanki2[6].odjazdy1[10][52] = "O";
      przystanki2[6].odjazdy1[13][04] = "O";
      przystanki2[6].odjazdy1[13][52] = "O";

      przystanki2[7].nazwa = "Biernatki - Folwark";
      przystanki2[7].odjazdy1[7][29] = "O";
      przystanki2[7].odjazdy1[8][33] = "O";
      przystanki2[7].odjazdy1[9][08] = "O";
      przystanki2[7].odjazdy1[10][53] = "O";
      przystanki2[7].odjazdy1[13][05] = "O";
      przystanki2[7].odjazdy1[13][53] = "O";

      przystanki2[8].nazwa = "Prusinowo - Wieś";
      przystanki2[8].odjazdy1[7][31] = "O";
      przystanki2[8].odjazdy1[8][35] = "O";
      przystanki2[8].odjazdy1[9][10] = "O";
      przystanki2[8].odjazdy1[10][55] = "O";
      przystanki2[8].odjazdy1[13][07] = "O";
      przystanki2[8].odjazdy1[13][55] = "O";

      przystanki2[9].nazwa = "Prusinowo - Prusinowo";
      przystanki2[9].odjazdy1[7][32] = "O";
      przystanki2[9].odjazdy1[8][36] = "O";
      przystanki2[9].odjazdy1[9][11] = "O";
      przystanki2[9].odjazdy1[10][56] = "O";
      przystanki2[9].odjazdy1[13][08] = "O";
      przystanki2[9].odjazdy1[13][56] = "O";

    //
      przystanki2[10].nazwa = "Jeziory Wielkie - Jeziory Wielkie";
      przystanki2[10].odjazdy1[7][34] = "O";
      przystanki2[10].odjazdy1[8][38] = "O";
      przystanki2[10].odjazdy1[9][13] = "O";
      przystanki2[10].odjazdy1[10][58] = "O";
      przystanki2[10].odjazdy1[13][10] = "O";
      przystanki2[10].odjazdy1[13][58] = "O";

      przystanki2[11].nazwa = "Jeziory Wielkie- Wieś";
      przystanki2[11].odjazdy1[7][35] = "O";
      przystanki2[11].odjazdy1[8][39] = "O";
      przystanki2[11].odjazdy1[9][14] = "O";
      przystanki2[11].odjazdy1[10][59] = "O";
      przystanki2[11].odjazdy1[13][11] = "O";
      przystanki2[11].odjazdy1[13][59] = "O";

      przystanki2[12].nazwa = "Błażejewko - Błażejewko Pętla";
      przystanki2[12].odjazdy1[7][38] = "O";
      przystanki2[12].odjazdy1[8][42] = "O";
      przystanki2[12].odjazdy1[9][17] = "O";
      przystanki2[12].odjazdy1[11][2] = "O";
      przystanki2[12].odjazdy1[13][14] = "O";
      przystanki2[12].odjazdy1[14][2] = "O";

      przystanki2[13].nazwa = "Błażejewko - Błażejewko";
      przystanki2[13].odjazdy1[7][39] = "O";
      przystanki2[13].odjazdy1[8][43] = "O";
      przystanki2[13].odjazdy1[9][18] = "O";
      przystanki2[13].odjazdy1[11][3] = "O";
      przystanki2[13].odjazdy1[13][15] = "O";
      przystanki2[13].odjazdy1[14][3] = "O";

      przystanki2[14].nazwa = "Błażejewko - Wieś";
      przystanki2[14].odjazdy1[7][40] = "O";
      przystanki2[14].odjazdy1[8][44] = "O";
      przystanki2[14].odjazdy1[9][19] = "O";
      przystanki2[14].odjazdy1[11][4] = "O";
      przystanki2[14].odjazdy1[13][16] = "O";
      przystanki2[14].odjazdy1[14][4] = "O";

      przystanki2[15].nazwa = "Błażejewko - Las";
      przystanki2[15].odjazdy1[7][41] = "O";
      przystanki2[15].odjazdy1[8][45] = "O";
      przystanki2[15].odjazdy1[9][20] = "O";
      przystanki2[15].odjazdy1[11][5] = "O";
      przystanki2[15].odjazdy1[13][17] = "O";
      przystanki2[15].odjazdy1[14][5] = "O";

      przystanki2[16].nazwa = "Kórnik - Dom Dziecka";
      przystanki2[16].odjazdy1[7][42] = "O";
      przystanki2[16].odjazdy1[8][46] = "O";
      przystanki2[16].odjazdy1[9][21] = "O";
      przystanki2[16].odjazdy1[11][6] = "O";
      przystanki2[16].odjazdy1[13][18] = "O";
      przystanki2[16].odjazdy1[14][6] = "O";

      przystanki2[17].nazwa = "Kórnik - Błażejewska";
      przystanki2[17].odjazdy1[7][44] = "O";
      przystanki2[17].odjazdy1[8][48] = "O";
      przystanki2[17].odjazdy1[9][23] = "O";
      przystanki2[17].odjazdy1[11][8] = "O";
      przystanki2[17].odjazdy1[13][20] = "O";
      przystanki2[17].odjazdy1[14][8] = "O";

      przystanki2[18].nazwa = "Kórnik - Bnin Rynek";
      przystanki2[18].odjazdy1[7][46] = "O";
      przystanki2[18].odjazdy1[8][50] = "O";
      przystanki2[18].odjazdy1[9][25] = "O";
      przystanki2[18].odjazdy1[11][10] = "O";
      przystanki2[18].odjazdy1[13][22] = "O";
      przystanki2[18].odjazdy1[14][10] = "O";

      przystanki2[19].nazwa = "Kórnik - Bnin A.Krajowej";
      przystanki2[19].odjazdy1[7][48] = "O";
      przystanki2[19].odjazdy1[8][52] = "O";
      przystanki2[19].odjazdy1[9][27] = "O";
      przystanki2[19].odjazdy1[11][12] = "O";
      przystanki2[19].odjazdy1[13][24] = "O";
      przystanki2[19].odjazdy1[14][12] = "O";

      przystanki2[20].nazwa = "Kórnik - Prowent";
      przystanki2[20].odjazdy1[7][49] = "O";
      przystanki2[20].odjazdy1[8][53] = "O";
      przystanki2[20].odjazdy1[9][28] = "O";
      przystanki2[20].odjazdy1[11][13] = "O";
      przystanki2[20].odjazdy1[13][25] = "O";
      przystanki2[20].odjazdy1[14][13] = "O";

      przystanki2[21].nazwa = "Kórnik - Pl.Niepodległości";
      przystanki2[21].odjazdy1[7][51] = "O";
      przystanki2[21].odjazdy1[8][55] = "O";
      przystanki2[21].odjazdy1[9][30] = "O";
      przystanki2[21].odjazdy1[11][15] = "O";
      przystanki2[21].odjazdy1[13][27] = "O";
      przystanki2[21].odjazdy1[14][15] = "O";
//TODO: do not print this
    }

    if ( number.equals("4") == true ){//582
//TODO this itp all rozklad for 3
    n = 9;
    przystanki = new PrzystanekD[n];
    for ( int k = 0 ; k < n ; k++ ){
      przystanki[k] = new PrzystanekD();
      przystanki[k].waznyod = "16-05-2023";
      przystanki[k].kierunek = "Szczodrzykowo - Dworzec PKP";

      przystanki[k].linia = "590";

      przystanki[k].przystanki[0] = "Kórnik - Pl. Niepodległości";
      przystanki[k].przystanki[1] = "Kórnik - Reja";
      przystanki[k].przystanki[2] = "Dźiećmierowo - TFP";
      przystanki[k].przystanki[3] = "Dźiećmierowo - Polna";
      przystanki[k].przystanki[4] = "Dźiećmierowo - Słoneczna";
      przystanki[k].przystanki[5] = "Dźiećmierowo - Leśna";
      przystanki[k].przystanki[6] = "Szczodrzykowo - Kolejowa";
      przystanki[k].przystanki[7] = "Szczodrzykowo - Dworzec PKP";


      przystanki[k].uwagi = new String[5];
      przystanki[k].uwagi[0] = "D - kurs wydłużony do Dachowa";
      przystanki[k].uwagi[1] = "P - kurs do Szczodrzykowo Poznańska";
      przystanki[k].uwagi[2] = "t - kurs do SP Szczydrzykowo";
      przystanki[k].uwagi[3] = "X - bez wjazdu do Kórnik Szkoła";
      przystanki[k].uwagi[4] = "R - kurs do Kórnik Plac Niepodległości";


    }
    przystanki[0].nazwa = "Kórnik - Pl. Niepodległości";
    przystanki[0].odjazdy1[20][44] = "O";
    przystanki[0].odjazdy1[21][10] = "O";
    przystanki[0].odjazdy2[16][48] = "O";
    przystanki[0].odjazdy2[19][46] = "O";
    przystanki[0].odjazdy3[16][48] = "O";
    przystanki[0].odjazdy3[19][46] = "O";

    przystanki[1].nazwa = "Kórnik - Reja";
    przystanki[1].odjazdy1[20][46] = "O";
    przystanki[1].odjazdy1[21][12] = "O";
    przystanki[1].odjazdy2[16][50] = "O";
    przystanki[1].odjazdy2[19][48] = "O";
    przystanki[1].odjazdy3[16][50] = "O";
    przystanki[1].odjazdy3[19][48] = "O";

    przystanki[2].nazwa = "Dźiećmierowo - TFP";
    przystanki[2].odjazdy1[20][49] = "O";
    przystanki[2].odjazdy1[21][15] = "O";
    przystanki[2].odjazdy2[16][53] = "O";
    przystanki[2].odjazdy2[19][51] = "O";
    przystanki[2].odjazdy3[16][53] = "O";
    przystanki[2].odjazdy3[19][51] = "O";

    przystanki[3].nazwa = "Dźiećmierowo - Polna";
    przystanki[3].odjazdy1[20][51] = "O";
    przystanki[3].odjazdy1[21][17] = "O";
    przystanki[3].odjazdy2[16][55] = "O";
    przystanki[3].odjazdy2[19][53] = "O";
    przystanki[3].odjazdy3[16][55] = "O";
    przystanki[3].odjazdy3[19][53] = "O";

    przystanki[4].nazwa = "Dźiećmierowo - Słoneczna";
    przystanki[4].odjazdy1[20][52] = "O";
    przystanki[4].odjazdy1[21][18] = "O";
    przystanki[4].odjazdy2[16][56] = "O";
    przystanki[4].odjazdy2[19][54] = "O";
    przystanki[4].odjazdy3[16][56] = "O";
    przystanki[4].odjazdy3[19][54] = "O";

    przystanki[5].nazwa = "Dźiećmierowo - Leśna";
    przystanki[5].odjazdy1[20][53] = "O";
    przystanki[5].odjazdy1[21][19] = "O";
    przystanki[5].odjazdy2[16][57] = "O";
    przystanki[5].odjazdy2[19][55] = "O";
    przystanki[5].odjazdy3[16][57] = "O";
    przystanki[5].odjazdy3[19][55] = "O";

    przystanki[6].nazwa = "Szczodrzykowo - Kolejowa";
    przystanki[6].odjazdy1[20][55] = "O";
    przystanki[6].odjazdy1[21][21] = "O";
    przystanki[6].odjazdy2[16][59] = "O";
    przystanki[6].odjazdy2[19][57] = "O";
    przystanki[6].odjazdy3[16][59] = "O";
    przystanki[6].odjazdy3[19][57] = "O";

    przystanki[7].nazwa = "Szczodrzykowo - Dworzec PKP";
    przystanki[7].odjazdy1[20][56] = "O";
    przystanki[7].odjazdy1[21][22] = "O";
    przystanki[7].odjazdy2[17][00] = "O";
    przystanki[7].odjazdy2[19][58] = "O";
    przystanki[7].odjazdy3[17][00] = "O";
    przystanki[7].odjazdy3[19][58] = "O";

    n = 8;
    przystanki2 = new PrzystanekD[n];
    for ( int k = 0 ; k < n ; k++ ){
      przystanki2[k] = new PrzystanekD();
      przystanki2[k].waznyod = "16-05-2023";
      przystanki2[k].kierunek = "Kórnik Bnin Osiedle";

      przystanki2[k].linia = "590";

      przystanki2[k].przystanki[0] = "Kórnik - Pl. Niepodległości";
      przystanki2[k].przystanki[1] = "Kórnik - Reja";
      przystanki2[k].przystanki[2] = "Dźiećmierowo - TFP";
      przystanki2[k].przystanki[3] = "Dźiećmierowo - Polna";
      przystanki2[k].przystanki[4] = "Dźiećmierowo - Słoneczna";
      przystanki2[k].przystanki[5] = "Dźiećmierowo - Leśna";
      przystanki2[k].przystanki[6] = "Szczodrzykowo - Kolejowa";
      przystanki2[k].przystanki[7] = "Szczodrzykowo - Dworzec PKP";


      przystanki2[k].uwagi = new String[5];
      przystanki2[k].uwagi[0] = "D - kurs wydłużony do Dachowa";
      przystanki2[k].uwagi[1] = "P - kurs do Szczodrzykowo Poznańska";
      przystanki2[k].uwagi[2] = "t - kurs do SP Szczydrzykowo";
      przystanki2[k].uwagi[3] = "X - bez wjazdu do Kórnik Szkoła";
      przystanki2[k].uwagi[4] = "R - kurs do Kórnik Plac Niepodległości";


    }
    przystanki2[0].nazwa = "Kórnik - Pl. Niepodległości";
    przystanki2[0].odjazdy1[17][5] = "O";
    przystanki2[0].odjazdy1[20][42] = "O";
    przystanki2[0].odjazdy2[17][17] = "O";
    przystanki2[0].odjazdy2[20][12] = "O";
    przystanki2[0].odjazdy3[17][17] = "O";
    przystanki2[0].odjazdy3[20][12] = "O";

    przystanki2[1].nazwa = "Kórnik - Reja";
    przystanki2[1].odjazdy1[17][3] = "O";
    przystanki2[1].odjazdy1[20][40] = "O";
    przystanki2[1].odjazdy2[17][15] = "O";
    przystanki2[1].odjazdy2[20][10] = "O";
    przystanki2[1].odjazdy3[17][15] = "O";
    przystanki2[1].odjazdy3[20][10] = "O";

    przystanki2[2].nazwa = "Dźiećmierowo - TFP";
    przystanki2[2].odjazdy1[17][0] = "O";
    przystanki2[2].odjazdy1[20][37] = "O";
    przystanki2[2].odjazdy2[17][12] = "O";
    przystanki2[2].odjazdy2[20][7] = "O";
    przystanki2[2].odjazdy3[17][12] = "O";
    przystanki2[2].odjazdy3[20][7] = "O";

    przystanki2[3].nazwa = "Dźiećmierowo - Polna";
    przystanki2[3].odjazdy1[16][58] = "O";
    przystanki2[3].odjazdy1[20][35] = "O";
    przystanki2[3].odjazdy2[17][10] = "O";
    przystanki2[3].odjazdy2[20][5] = "O";
    przystanki2[3].odjazdy3[17][10] = "O";
    przystanki2[3].odjazdy3[20][5] = "O";

    przystanki2[4].nazwa = "Dźiećmierowo - Słoneczna";
    przystanki2[4].odjazdy1[16][57] = "O";
    przystanki2[4].odjazdy1[20][34] = "O";
    przystanki2[4].odjazdy2[17][9] = "O";
    przystanki2[4].odjazdy2[20][4] = "O";
    przystanki2[4].odjazdy3[17][9] = "O";
    przystanki2[4].odjazdy3[20][4] = "O";

    przystanki2[5].nazwa = "Dźiećmierowo - Leśna";
    przystanki2[5].odjazdy1[16][56] = "O";
    przystanki2[5].odjazdy1[20][33] = "O";
    przystanki2[5].odjazdy2[17][8] = "O";
    przystanki2[5].odjazdy2[20][3] = "O";
    przystanki2[5].odjazdy3[17][8] = "O";
    przystanki2[5].odjazdy3[20][3] = "O";

    przystanki2[6].nazwa = "Szczodrzykowo - Kolejowa";
    przystanki2[6].odjazdy1[16][54] = "O";
    przystanki2[6].odjazdy1[20][31] = "O";
    przystanki2[6].odjazdy2[17][6] = "O";
    przystanki2[6].odjazdy2[20][1] = "O";
    przystanki2[6].odjazdy3[17][6] = "O";
    przystanki2[6].odjazdy3[20][1] = "O";

    przystanki2[7].nazwa = "Szczodrzykowo - Dworzec PKP";
    przystanki2[7].odjazdy1[16][53] = "O";
    przystanki2[7].odjazdy1[20][30] = "O";
    przystanki2[7].odjazdy2[17][5] = "O";
    przystanki2[7].odjazdy2[20][0] = "O";
    przystanki2[7].odjazdy3[17][5] = "O";
    przystanki2[7].odjazdy3[20][0] = "O";

  }
  if ( number.equals("5") == true ){//582
    n = 9;
    przystanki = new PrzystanekD[n];
    for ( int k = 0 ; k < n ; k++ ){
      przystanki[k] = new PrzystanekD();
      przystanki[k].waznyod = "16-05-2023";
      przystanki[k].kierunek = "Kromolice Pętla";

      przystanki[k].przystanki[0] = "Szczodrzykowo - Szkoła";
      przystanki[k].przystanki[1] = "Runowo - Wieś";
      przystanki[k].przystanki[2] = "Runowo - Runowo";
      przystanki[k].przystanki[3] = "Pierzchno I";
      przystanki[k].przystanki[4] = "Pierzchno - Jagrol";
      przystanki[k].przystanki[5] = "Pierzchno - PKP";
      przystanki[k].przystanki[6] = "Trzebisławki - Skrzyżowanie";
      przystanki[k].przystanki[7] = "Kromolice - Kromolice";
      przystanki[k].przystanki[8] = "Kromolice - Pętla końcowy";

      przystanki[k].linia = "591";


      przystanki[k].uwagi = new String[1];
      przystanki[k].uwagi[0] = "S - kursuje w dni nauki szkolnej";

    }

  przystanki[0].nazwa = "Szczodrzykowo - Szkoła";
  przystanki[0].odjazdy1[7][53] = "O";
  przystanki[0].odjazdy1[10][12] = "O";
  przystanki[0].odjazdy1[12][45] = "O";
  przystanki[0].odjazdy1[14][53] = "O";
  przystanki[0].odjazdy1[16][25] = "O";

  przystanki[1].nazwa = "Runowo - Wieś";
  przystanki[1].odjazdy1[7][54] = "O";
  przystanki[1].odjazdy1[10][13] = "O";
  przystanki[1].odjazdy1[12][48] = "O";
  przystanki[1].odjazdy1[14][56] = "O";
  przystanki[1].odjazdy1[16][26] = "O";

  przystanki[2].nazwa = "Runowo - Runowo";
  przystanki[2].odjazdy1[7][56] = "O";
  przystanki[2].odjazdy1[10][15] = "O";
  przystanki[2].odjazdy1[12][50] = "O";
  przystanki[2].odjazdy1[14][58] = "O";
  przystanki[2].odjazdy1[16][28] = "O";

  przystanki[3].nazwa = "Pierzchno I";
  przystanki[3].odjazdy1[7][57] = "O";
  przystanki[3].odjazdy1[10][16] = "O";
  przystanki[3].odjazdy1[12][51] = "O";
  przystanki[3].odjazdy1[14][59] = "O";
  przystanki[3].odjazdy1[16][29] = "O";

  przystanki[4].nazwa = "Pierzchno - Jagrol";
  przystanki[4].odjazdy1[7][58] = "O";
  przystanki[4].odjazdy1[10][17] = "O";
  przystanki[4].odjazdy1[12][52] = "O";
  przystanki[4].odjazdy1[15][00] = "O";
  przystanki[4].odjazdy1[16][30] = "O";

  przystanki[5].nazwa = "Pierzchno - PKP";
  przystanki[5].odjazdy1[8][0] = "O";
  przystanki[5].odjazdy1[10][19] = "O";
  przystanki[5].odjazdy1[12][54] = "O";
  przystanki[5].odjazdy1[15][2] = "O";
  przystanki[5].odjazdy1[16][32] = "O";

  przystanki[6].nazwa = "Trzebisławki - Skrzyżowanie";
  przystanki[6].odjazdy1[8][1] = "O";
  przystanki[6].odjazdy1[10][20] = "O";
  przystanki[6].odjazdy1[12][55] = "O";
  przystanki[6].odjazdy1[15][3] = "O";
  przystanki[6].odjazdy1[16][33] = "O";

  przystanki[7].nazwa = "Kromolice - Kromolice";
  przystanki[7].odjazdy1[8][2] = "O";
  przystanki[7].odjazdy1[10][21] = "O";
  przystanki[7].odjazdy1[12][56] = "O";
  przystanki[7].odjazdy1[15][4] = "O";
  przystanki[7].odjazdy1[16][34] = "O";

  przystanki[8].nazwa = "Kromolice - Pętla końcowy";
  przystanki[8].odjazdy1[8][3] = "O";
  przystanki[8].odjazdy1[10][22] = "O";
  przystanki[8].odjazdy1[12][57] = "O";
  przystanki[8].odjazdy1[15][5] = "O";
  przystanki[8].odjazdy1[16][35] = "O";

    n = 9;
    przystanki2 = new PrzystanekD[n];
    for ( int k = 0 ; k < n ; k++ ){
      przystanki2[k] = new PrzystanekD();
      przystanki2[k].waznyod = "16-05-2023";
      przystanki2[k].kierunek = "Szczodrzykowo SP";

      przystanki2[k].przystanki[0] = "Szczodrzykowo - Szkoła";
      przystanki2[k].przystanki[1] = "Runowo - Wieś";
      przystanki2[k].przystanki[2] = "Runowo - Runowo";
      przystanki2[k].przystanki[3] = "Pierzchno I";
      przystanki2[k].przystanki[4] = "Pierzchno - Jagrol";
      przystanki2[k].przystanki[5] = "Pierzchno - PKP";
      przystanki2[k].przystanki[6] = "Trzebisławki - Skrzyżowanie";
      przystanki2[k].przystanki[7] = "Kromolice - Kromolice";
      przystanki2[k].przystanki[8] = "Kromolice - Pętla";

      przystanki2[k].linia = "591";


      przystanki2[k].uwagi = new String[1];
      przystanki2[k].uwagi[0] = "S - kursuje w dni nauki szkolnej";

    }

  przystanki2[0].nazwa = "Szczodrzykowo - Szkoła";
  przystanki2[0].odjazdy1[7][29] = "O";
  przystanki2[0].odjazdy1[8][14] = "O";
  przystanki2[0].odjazdy1[13][10] = "O";
  przystanki2[0].odjazdy1[15][17] = "O";

  przystanki2[1].nazwa = "Runowo - Wieś";
  przystanki2[1].odjazdy1[7][26] = "O";
  przystanki2[1].odjazdy1[8][11] = "O";
  przystanki2[1].odjazdy1[13][7] = "O";
  przystanki2[1].odjazdy1[15][14] = "O";

  przystanki2[2].nazwa = "Runowo - Runowo";
  przystanki2[2].odjazdy1[7][24] = "O";
  przystanki2[2].odjazdy1[8][9] = "O";
  przystanki2[2].odjazdy1[13][5] = "O";
  przystanki2[2].odjazdy1[15][12] = "O";

  przystanki2[3].nazwa = "Pierzchno I";
  przystanki2[3].odjazdy1[7][23] = "O";
  przystanki2[3].odjazdy1[8][8] = "O";
  przystanki2[3].odjazdy1[13][4] = "O";
  przystanki2[3].odjazdy1[15][11] = "O";

  przystanki2[4].nazwa = "Pierzchno - Jagrol";
  przystanki2[4].odjazdy1[7][22] = "O";
  przystanki2[4].odjazdy1[8][7] = "O";
  przystanki2[4].odjazdy1[13][3] = "O";
  przystanki2[4].odjazdy1[15][10] = "O";

  przystanki2[5].nazwa = "Pierzchno - PKP";
  przystanki2[5].odjazdy1[7][21] = "O";
  przystanki2[5].odjazdy1[8][6] = "O";
  przystanki2[5].odjazdy1[13][2] = "O";
  przystanki2[5].odjazdy1[15][9] = "O";

  przystanki2[6].nazwa = "Trzebisławki - Skrzyżowanie";
  przystanki2[6].odjazdy1[7][19] = "O";
  przystanki2[6].odjazdy1[8][4] = "O";
  przystanki2[6].odjazdy1[13][0] = "O";
  przystanki2[6].odjazdy1[15][7] = "O";

  przystanki2[7].nazwa = "Kromolice - Kromolice";
  przystanki2[7].odjazdy1[7][18] = "O";
  przystanki2[7].odjazdy1[8][3] = "O";
  przystanki2[7].odjazdy1[12][59] = "O";
  przystanki2[7].odjazdy1[15][6] = "O";

  przystanki2[8].nazwa = "Kromolice - Pętla";
  przystanki2[8].odjazdy1[7][17] = "O";
  przystanki2[8].odjazdy1[8][2] = "O";
  przystanki2[8].odjazdy1[12][58] = "O";
  przystanki2[8].odjazdy1[15][5] = "O";
}

        if ( number.equals("6") == true ){//582
          n = 17;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Robakowo Gimnazjum";

            przystanki[k].przystanki[0] = "Kórnik Pl. Niepodległości";
            przystanki[k].przystanki[1] = "Kórnik - Szkoła";
            przystanki[k].przystanki[2] = "Kórnik - Reja";
            przystanki[k].przystanki[3] = "Dziećmierowo - Polna";
            przystanki[k].przystanki[4] = "Dziećmierowo - Słoneczna";
            przystanki[k].przystanki[5] = "Dziećmierowo - Leśna";
            przystanki[k].przystanki[6] = "Szczodrzykowo - Kolejowa";
            przystanki[k].przystanki[7] = "Szczodrzykowo I";
            przystanki[k].przystanki[8] = "Szczodrzykowo - Szkoła";
            przystanki[k].przystanki[9] = "Szczodrzykowo - Poznańska";
            przystanki[k].przystanki[10] = "Dachowa - Klonowa";
            przystanki[k].przystanki[11] = "Dachowa Okrężna";
            przystanki[k].przystanki[12] = "Dachowa - Wiatrakowa";
            przystanki[k].przystanki[13] = "Dachowa - Kręta";
            przystanki[k].przystanki[14] = "Robakowo - Szeroka";
            przystanki[k].przystanki[15] = "Robakowo - Wiejska";
            przystanki[k].przystanki[16] = "Robakowo - Szkoła";

            przystanki[k].linia = "592";


            przystanki[k].uwagi = null;

          }

        przystanki[0].nazwa = "Kórnik Pl. Niepodległości";
        przystanki[0].odjazdy1[9][30] = "O";

        przystanki[1].nazwa = "Kórnik - Szkoła";
        przystanki[1].odjazdy1[9][32] = "O";

        przystanki[2].nazwa = "Kórnik - Reja";
        przystanki[2].odjazdy1[9][35] = "O";

        przystanki[3].nazwa = "Dziećmierowo - Polna";
        przystanki[3].odjazdy1[9][40] = "O";

        przystanki[4].nazwa = "Dziećmierowo - Słoneczna";
        przystanki[4].odjazdy1[9][41] = "O";

        przystanki[5].nazwa = "Dziećmierowo - Leśna";
        przystanki[5].odjazdy1[9][42] = "O";

        przystanki[6].nazwa = "Szczodrzykowo - Kolejowa";
        przystanki[6].odjazdy1[9][44] = "O";

        przystanki[7].nazwa = "Szczodrzykowo I";
        przystanki[7].odjazdy1[9][45] = "O";

        przystanki[8].nazwa = "Szczodrzykowo - Szkoła";
        przystanki[8].odjazdy1[9][46] = "O";

        przystanki[9].nazwa = "Szczodrzykowo - Poznańska";
        przystanki[9].odjazdy1[9][50] = "O";

        przystanki[10].nazwa = "Dachowa - Klonowa";
        przystanki[10].odjazdy1[9][52] = "O";

        przystanki[11].nazwa = "Dachowa Okrężna";
        przystanki[11].odjazdy1[9][53] = "O";

        przystanki[12].nazwa = "Dachowa - Wiatrakowa";
        przystanki[12].odjazdy1[9][54] = "O";

        przystanki[13].nazwa = "Dachowa - Kręta";
        przystanki[13].odjazdy1[9][55] = "O";

        przystanki[14].nazwa = "Robakowo - Szeroka";
        przystanki[14].odjazdy1[9][56] = "O";

        przystanki[15].nazwa = "Robakowo - Wiejska";
        przystanki[15].odjazdy1[9][57] = "O";

        przystanki[16].nazwa = "Robakowo - Szkoła";
        przystanki[16].odjazdy1[9][59] = "O";

        n = 16;
        przystanki2 = new PrzystanekD[n];
        for ( int k = 0 ; k < n ; k++ ){
          przystanki2[k] = new PrzystanekD();
          przystanki2[k].waznyod = "16-05-2023";
          przystanki2[k].kierunek = "Robakowo Gimnazjum";

          przystanki2[k].przystanki[0] = "Kórnik Pl. Niepodległości";
          przystanki2[k].przystanki[1] = "Kórnik - Reja";
          przystanki2[k].przystanki[2] = "Dziećmierowo - Polna";
          przystanki2[k].przystanki[3] = "Dziećmierowo - Słoneczna";
          przystanki2[k].przystanki[4] = "Dziećmierowo - Leśna";
          przystanki2[k].przystanki[5] = "Szczodrzykowo - Kolejowa";
          przystanki2[k].przystanki[6] = "Szczodrzykowo I";
          przystanki2[k].przystanki[7] = "Szczodrzykowo - Szkoła";
          przystanki2[k].przystanki[8] = "Szczodrzykowo - Poznańska";
          przystanki2[k].przystanki[9] = "Dachowa - Klonowa";
          przystanki2[k].przystanki[10] = "Dachowa Okrężna";
          przystanki2[k].przystanki[11] = "Dachowa - Wiatrakowa";
          przystanki2[k].przystanki[12] = "Dachowa - Kręta";
          przystanki2[k].przystanki[13] = "Robakowo - Szeroka";
          przystanki2[k].przystanki[14] = "Robakowo - Wiejska";
          przystanki2[k].przystanki[15] = "Robakowo - Szkoła";

          przystanki2[k].linia = "592";


          przystanki2[k].uwagi = null;

        }

      przystanki2[0].nazwa = "Kórnik Pl. Niepodległości";
      przystanki2[0].odjazdy1[14][3] = "O";

      przystanki2[1].nazwa = "Kórnik - Reja";
      przystanki2[1].odjazdy1[13][59] = "O";

      przystanki2[2].nazwa = "Dziećmierowo - Polna";
      przystanki2[2].odjazdy1[13][55] = "O";

      przystanki2[3].nazwa = "Dziećmierowo - Słoneczna";
      przystanki2[3].odjazdy1[13][54] = "O";

      przystanki2[4].nazwa = "Dziećmierowo - Leśna";
      przystanki2[4].odjazdy1[13][53] = "O";

      przystanki2[5].nazwa = "Szczodrzykowo - Kolejowa";
      przystanki2[5].odjazdy1[13][52] = "O";

      przystanki2[6].nazwa = "Szczodrzykowo I";
      przystanki2[6].odjazdy1[13][51] = "O";

      przystanki2[7].nazwa = "Szczodrzykowo - Szkoła";
      przystanki2[7].odjazdy1[13][50] = "O";

      przystanki2[8].nazwa = "Szczodrzykowo - Poznańska";
      przystanki2[8].odjazdy1[13][46] = "O";

      przystanki2[9].nazwa = "Dachowa - Klonowa";
      przystanki2[9].odjazdy1[13][44] = "O";

      przystanki2[10].nazwa = "Dachowa Okrężna";
      przystanki2[10].odjazdy1[13][42] = "O";

      przystanki2[11].nazwa = "Dachowa - Wiatrakowa";
      przystanki2[11].odjazdy1[13][41] = "O";

      przystanki2[12].nazwa = "Dachowa - Kręta";
      przystanki2[12].odjazdy1[13][39] = "O";

      przystanki2[13].nazwa = "Robakowo - Szeroka";
      przystanki2[13].odjazdy1[13][38] = "O";

      przystanki2[14].nazwa = "Robakowo - Wiejska";
      przystanki2[14].odjazdy1[13][37] = "O";

      przystanki2[15].nazwa = "Robakowo - Szkoła";
      przystanki2[15].odjazdy1[13][34] = "O";
        }
        if ( number.equals("7") == true ){//582
          n = 12;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Kamionki Szkoła";

            przystanki[k].przystanki[0] = "Borówiec Dębowa";
            przystanki[k].przystanki[1] = "Borówiec Rekreacyjna";
            przystanki[k].przystanki[2] = "Borówiec Łąkowa";
            przystanki[k].przystanki[3] = "Borówiec,Szkoła";
            przystanki[k].przystanki[4] = "Borówiec Deszczowa";
            przystanki[k].przystanki[5] = "Borówiec Pod Borem";
            przystanki[k].przystanki[6] = "Borówiec Kurkowa";
            przystanki[k].przystanki[7] = "Borówiec Borówkowa";
            przystanki[k].przystanki[8] = "Kamionki Lisia";
            przystanki[k].przystanki[9] = "Kamionki Lotnicza";
            przystanki[k].przystanki[10] = "Kamionki Pętla";
            przystanki[k].przystanki[11] = "Kamionki Szkoła";

            przystanki[k].linia = "593";


            przystanki[k].uwagi = null;

          }

          przystanki[0].nazwa = "Borówiec Dębowa";
          przystanki[0].odjazdy1[6][45] = "O";
          przystanki[0].odjazdy1[7][35] = "O";
          przystanki[0].odjazdy1[8][10] = "O";
          przystanki[1].nazwa = "Borówiec Rekreacyjna";
          przystanki[1].odjazdy1[6][46] = "O";
          przystanki[1].odjazdy1[7][36] = "O";
          przystanki[1].odjazdy1[8][11] = "O";
          przystanki[2].nazwa = "Borówiec Łąkowa";
          przystanki[2].odjazdy1[6][47] = "O";
          przystanki[2].odjazdy1[7][37] = "O";
          przystanki[2].odjazdy1[8][12] = "O";
          przystanki[3].nazwa = "Borówiec,Szkoła";
          przystanki[3].odjazdy1[6][49] = "O";
          przystanki[3].odjazdy1[7][39] = "O";
          przystanki[3].odjazdy1[8][14] = "O";
          przystanki[4].nazwa = "Borówiec Deszczowa";
          przystanki[4].odjazdy1[6][51] = "O";
          przystanki[4].odjazdy1[7][41] = "O";
          przystanki[4].odjazdy1[8][16] = "O";
          przystanki[5].nazwa = "Borówiec Pod Borem";
          przystanki[5].odjazdy1[6][52] = "O";
          przystanki[5].odjazdy1[7][42] = "O";
          przystanki[5].odjazdy1[8][17] = "O";
          przystanki[6].nazwa = "Borówiec Kurkowa";
          przystanki[6].odjazdy1[6][53] = "O";
          przystanki[6].odjazdy1[7][43] = "O";
          przystanki[6].odjazdy1[8][19] = "O";
          przystanki[7].nazwa = "Borówiec Borówkowa";
          przystanki[7].odjazdy1[6][54] = "O";
          przystanki[7].odjazdy1[7][44] = "O";
          przystanki[7].odjazdy1[8][19] = "O";
          przystanki[8].nazwa = "Kamionki Lisia";
          przystanki[8].odjazdy1[6][55] = "O";
          przystanki[8].odjazdy1[7][45] = "O";
          przystanki[8].odjazdy1[8][20] = "O";
          przystanki[9].nazwa = "Kamionki Lotnicza";
          przystanki[9].odjazdy1[6][56] = "O";
          przystanki[9].odjazdy1[7][46] = "O";
          przystanki[9].odjazdy1[8][21] = "O";
          przystanki[10].nazwa = "Kamionki Pętla";
          przystanki[10].odjazdy1[6][58] = "O";
          przystanki[10].odjazdy1[7][48] = "O";
          przystanki[10].odjazdy1[8][23] = "O";
          przystanki[11].nazwa = "Kamionki Szkoła";
          przystanki[11].odjazdy1[7][0] = "O";
          przystanki[11].odjazdy1[7][50] = "O";
          przystanki[11].odjazdy1[8][25] = "O";

          n = 11;
          przystanki2 = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki2[k] = new PrzystanekD();
            przystanki2[k].waznyod = "16-05-2023";
            przystanki2[k].kierunek = "Borówiec Dębowa";

            przystanki2[k].przystanki[0] = "Borówiec Dębowa";
            przystanki2[k].przystanki[1] = "Borówiec Rekreacyjna";
            przystanki2[k].przystanki[2] = "Borówiec Łąkowa";
            przystanki2[k].przystanki[3] = "Borówiec,Szkoła";
            przystanki2[k].przystanki[4] = "Borówiec Deszczowa";
            przystanki2[k].przystanki[5] = "Borówiec Pod Borem";
            przystanki2[k].przystanki[6] = "Borówiec Kurkowa";
            przystanki2[k].przystanki[7] = "Borówiec Borówkowa";
            przystanki2[k].przystanki[8] = "Kamionki Lisia";
            przystanki2[k].przystanki[9] = "Kamionki Lotnicza";
            przystanki2[k].przystanki[10] = "Kamionki Szkoła";

            przystanki2[k].linia = "593";


            przystanki2[k].uwagi = null;

          }

          przystanki2[0].nazwa = "Borówiec Dębowa";
          przystanki2[0].odjazdy1[14][5] = "O";
          przystanki2[0].odjazdy1[15][4] = "O";
          przystanki2[0].odjazdy1[16][4] = "O";
          przystanki2[1].nazwa = "Borówiec Rekreacyjna";
          przystanki2[1].odjazdy1[14][4] = "O";
          przystanki2[1].odjazdy1[15][3] = "O";
          przystanki2[1].odjazdy1[16][3] = "O";
          przystanki2[2].nazwa = "Borówiec Łąkowa";
          przystanki2[2].odjazdy1[14][3] = "O";
          przystanki2[2].odjazdy1[15][2] = "O";
          przystanki2[2].odjazdy1[16][2] = "O";
          przystanki2[3].nazwa = "Borówiec,Szkoła";
          przystanki2[3].odjazdy1[14][1] = "O";
          przystanki2[3].odjazdy1[15][0] = "O";
          przystanki2[3].odjazdy1[16][0] = "O";
          przystanki2[4].nazwa = "Borówiec Deszczowa";
          przystanki2[4].odjazdy1[13][59] = "O";
          przystanki2[4].odjazdy1[14][58] = "O";
          przystanki2[4].odjazdy1[15][58] = "O";
          przystanki2[5].nazwa = "Borówiec Pod Borem";
          przystanki2[5].odjazdy1[13][58] = "O";
          przystanki2[5].odjazdy1[14][57] = "O";
          przystanki2[5].odjazdy1[15][57] = "O";
          przystanki2[6].nazwa = "Borówiec Kurkowa";
          przystanki2[6].odjazdy1[13][57] = "O";
          przystanki2[6].odjazdy1[14][56] = "O";
          przystanki2[6].odjazdy1[15][56] = "O";
          przystanki2[7].nazwa = "Borówiec Borówkowa";
          przystanki2[7].odjazdy1[13][56] = "O";
          przystanki2[7].odjazdy1[14][55] = "O";
          przystanki2[7].odjazdy1[15][55] = "O";
          przystanki2[8].nazwa = "Kamionki Lisia";
          przystanki2[8].odjazdy1[13][55] = "O";
          przystanki2[8].odjazdy1[14][54] = "O";
          przystanki2[8].odjazdy1[15][54] = "O";
          przystanki2[9].nazwa = "Kamionki Lotnicza";
          przystanki2[9].odjazdy1[13][54] = "O";
          przystanki2[9].odjazdy1[14][53] = "O";
          przystanki2[9].odjazdy1[15][53] = "O";
          przystanki2[10].nazwa = "Kamionki Szkoła";
          przystanki2[10].odjazdy1[13][51] = "O";
          przystanki2[10].odjazdy1[14][50] = "O";
          przystanki2[10].odjazdy1[15][50] = "O";

        }
        if ( number.equals("8") == true ){//582
          n = 23;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Kamionki Szkoła";

            przystanki[k].przystanki[0] = "Koninko Dziennikarska";
            przystanki[k].przystanki[1] = "Koninko Pisarska";
            przystanki[k].przystanki[2] = "Szczytniki Pętla";
            przystanki[k].przystanki[3] = "Kamionki nad Koplą";
            przystanki[k].przystanki[4] = "Szczytniki Szczelinka";
            przystanki[k].przystanki[5] = "Szczytniki Sarnia";
            przystanki[k].przystanki[6] = "Szczytniki Nad Wodą";
            przystanki[k].przystanki[7] = "Koninko Las";
            przystanki[k].przystanki[8] = "Borówiec Las";
            przystanki[k].przystanki[9] = "Borówiec Dębowa";
            przystanki[k].przystanki[10] = "Borówiec Rekreacyjna";
            przystanki[k].przystanki[11] = "Borówiec Łąkowa";
            przystanki[k].przystanki[12] = "Borówiec Deszczowa";
            przystanki[k].przystanki[13] = "Borówiec Pod Borem";
            przystanki[k].przystanki[14] = "Borówiec Kurkowa";
            przystanki[k].przystanki[15] = "Borówiec Borówkowa";
            przystanki[k].przystanki[16] = "Kamionki Lisia";
            przystanki[k].przystanki[17] = "Kamionki Lotnicza";
            przystanki[k].przystanki[18] = "Kamionki Pętla";
            przystanki[k].przystanki[19] = "Kamionki Klonowa";
            przystanki[k].przystanki[20] = "Kamionki Łąkowa";
            przystanki[k].przystanki[21] = "Kamionki Polna";
            przystanki[k].przystanki[22] = "Kamionki Szkoła";

            przystanki[k].linia = "594";


            przystanki[k].uwagi = null;

          }

        przystanki[0].nazwa ="Koninko Dziennikarska";
        przystanki[0].odjazdy1[6][35] = "O";
        przystanki[0].odjazdy1[11][0] = "O";
        przystanki[1].nazwa ="Koninko Pisarska";
        przystanki[1].odjazdy1[6][36] = "O";
        przystanki[1].odjazdy1[11][1] = "O";
        przystanki[2].nazwa ="Szczytniki Pętla";
        przystanki[2].odjazdy1[6][37] = "O";
        przystanki[2].odjazdy1[11][2] = "O";
        przystanki[3].nazwa ="Kamionki nad Koplą";
        przystanki[3].odjazdy1[6][40] = "O";
        przystanki[3].odjazdy1[11][5] = "O";
        przystanki[4].nazwa ="Szczytniki Szczelinka";
        przystanki[4].odjazdy1[6][41] = "O";
        przystanki[4].odjazdy1[11][6] = "O";
        przystanki[5].nazwa ="Szczytniki Sarnia";
        przystanki[5].odjazdy1[6][42] = "O";
        przystanki[5].odjazdy1[11][7] = "O";
        przystanki[6].nazwa ="Szczytniki Nad Wodą";
        przystanki[6].odjazdy1[6][43] = "O";
        przystanki[6].odjazdy1[11][8] = "O";
        przystanki[7].nazwa ="Koninko Las";
        przystanki[7].odjazdy1[6][45] = "O";
        przystanki[7].odjazdy1[11][10] = "O";
        przystanki[8].nazwa ="Borówiec Las";
        przystanki[8].odjazdy1[6][47] = "O";
        przystanki[8].odjazdy1[11][12] = "O";
        przystanki[9].nazwa ="Borówiec Dębowa";
        przystanki[9].odjazdy1[6][48] = "O";
        przystanki[9].odjazdy1[11][13] = "O";
        przystanki[10].nazwa ="Borówiec Rekreacyjna";
        przystanki[10].odjazdy1[6][49] = "O";
        przystanki[10].odjazdy1[11][14] = "O";
        przystanki[11].nazwa ="Borówiec Łąkowa";
        przystanki[11].odjazdy1[6][50] = "O";
        przystanki[11].odjazdy1[11][15] = "O";
        przystanki[12].nazwa ="Borówiec Deszczowa";
        przystanki[12].odjazdy1[6][51] = "O";
        przystanki[12].odjazdy1[11][16] = "O";
        przystanki[13].nazwa ="Borówiec Pod Borem";
        przystanki[13].odjazdy1[6][52] = "O";
        przystanki[13].odjazdy1[11][17] = "O";
        przystanki[14].nazwa ="Borówiec Kurkowa";
        przystanki[14].odjazdy1[6][53] = "O";
        przystanki[14].odjazdy1[11][18] = "O";
        przystanki[15].nazwa ="Borówiec Borówkowa";
        przystanki[15].odjazdy1[6][54] = "O";
        przystanki[15].odjazdy1[11][19] = "O";
        przystanki[16].nazwa ="Kamionki Lisia";
        przystanki[16].odjazdy1[6][55] = "O";
        przystanki[16].odjazdy1[11][20] = "O";
        przystanki[17].nazwa ="Kamionki Lotnicza";
        przystanki[17].odjazdy1[6][56] = "O";
        przystanki[17].odjazdy1[11][21] = "O";
        przystanki[18].nazwa ="Kamionki Pętla";
        przystanki[18].odjazdy1[6][57] = "O";
        przystanki[18].odjazdy1[11][22] = "O";
        przystanki[19].nazwa ="Kamionki Klonowa";
        przystanki[19].odjazdy1[6][59] = "O";
        przystanki[19].odjazdy1[11][24] = "O";
        przystanki[20].nazwa ="Kamionki Łąkowa";
        przystanki[20].odjazdy1[7][0] = "O";
        przystanki[20].odjazdy1[11][25] = "O";
        przystanki[21].nazwa ="Kamionki Polna";
        przystanki[21].odjazdy1[7][1] = "O";
        przystanki[21].odjazdy1[11][26] = "O";
        przystanki[22].nazwa = "Kamionki Szkoła";
        przystanki[22].odjazdy1[7][3] = "O";
        przystanki[22].odjazdy1[11][28] = "O";

        n = 23;
        przystanki2 = new PrzystanekD[n];
        for ( int k = 0 ; k < n ; k++ ){
          przystanki2[k] = new PrzystanekD();
          przystanki2[k].waznyod = "16-05-2023";
          przystanki2[k].kierunek = "Koninko Dziennikarska";

          przystanki2[k].przystanki[0] = "Koninko Dziennikarska";
          przystanki2[k].przystanki[1] = "Koninko Pisarska";
          przystanki2[k].przystanki[2] = "Szczytniki Pętla";
          przystanki2[k].przystanki[3] = "Kamionki nad Koplą";
          przystanki2[k].przystanki[4] = "Szczytniki Szczelinka";
          przystanki2[k].przystanki[5] = "Szczytniki Sarnia";
          przystanki2[k].przystanki[6] = "Szczytniki Nad Wodą";
          przystanki2[k].przystanki[7] = "Koninko Las";
          przystanki2[k].przystanki[8] = "Borówiec Las";
          przystanki2[k].przystanki[9] = "Borówiec Dębowa";
          przystanki2[k].przystanki[10] = "Borówiec Rekreacyjna";
          przystanki2[k].przystanki[11] = "Borówiec Łąkowa";
          przystanki2[k].przystanki[12] = "Borówiec Deszczowa";
          przystanki2[k].przystanki[13] = "Borówiec Pod Borem";
          przystanki2[k].przystanki[14] = "Borówiec Kurkowa";
          przystanki2[k].przystanki[15] = "Borówiec Borówkowa";
          przystanki2[k].przystanki[16] = "Kamionki Lisia";
          przystanki2[k].przystanki[17] = "Kamionki Lotnicza";
          przystanki2[k].przystanki[18] = "Kamionki Pętla";
          przystanki2[k].przystanki[19] = "Kamionki Klonowa";
          przystanki2[k].przystanki[20] = "Kamionki Łąkowa";
          przystanki2[k].przystanki[21] = "Kamionki Polna";
          przystanki2[k].przystanki[22] = "Kamionki Szkoła";

          przystanki2[k].linia = "594";


          przystanki2[k].uwagi = null;

        }

      przystanki2[0].nazwa ="Koninko Dziennikarska";
      przystanki2[0].odjazdy1[12][25] = "O";
      przystanki2[0].odjazdy1[14][15] = "O";
      przystanki2[1].nazwa ="Koninko Pisarska";
      przystanki2[1].odjazdy1[12][24] = "O";
      przystanki2[1].odjazdy1[14][14] = "O";
      przystanki2[2].nazwa ="Szczytniki Pętla";
      przystanki2[2].odjazdy1[12][23] = "O";
      przystanki2[2].odjazdy1[14][13] = "O";
      przystanki2[3].nazwa ="Kamionki nad Koplą";
      przystanki2[3].odjazdy1[12][19] = "O";
      przystanki2[3].odjazdy1[14][9] = "O";
      przystanki2[4].nazwa ="Szczytniki Szczelinka";
      przystanki2[4].odjazdy1[12][19] = "O";
      przystanki2[4].odjazdy1[14][9] = "O";
      przystanki2[5].nazwa ="Szczytniki Sarnia";
      przystanki2[5].odjazdy1[12][18] = "O";
      przystanki2[5].odjazdy1[14][8] = "O";
      przystanki2[6].nazwa ="Szczytniki Nad Wodą";
      przystanki2[6].odjazdy1[12][17] = "O";
      przystanki2[6].odjazdy1[14][7] = "O";
      przystanki2[7].nazwa ="Koninko Las";
      przystanki2[7].odjazdy1[12][15] = "O";
      przystanki2[7].odjazdy1[14][5] = "O";
      przystanki2[8].nazwa ="Borówiec Las";
      przystanki2[8].odjazdy1[12][13] = "O";
      przystanki2[8].odjazdy1[14][3] = "O";
      przystanki2[9].nazwa ="Borówiec Dębowa";
      przystanki2[9].odjazdy1[12][12] = "O";
      przystanki2[9].odjazdy1[14][2] = "O";
      przystanki2[10].nazwa ="Borówiec Rekreacyjna";
      przystanki2[10].odjazdy1[12][11] = "O";
      przystanki2[10].odjazdy1[14][1] = "O";
      przystanki2[11].nazwa ="Borówiec Łąkowa";
      przystanki2[11].odjazdy1[12][10] = "O";
      przystanki2[11].odjazdy1[14][0] = "O";
      przystanki2[12].nazwa ="Borówiec Deszczowa";
      przystanki2[12].odjazdy1[12][9] = "O";
      przystanki2[12].odjazdy1[13][59] = "O";
      przystanki2[13].nazwa ="Borówiec Pod Borem";
      przystanki2[13].odjazdy1[12][8] = "O";
      przystanki2[13].odjazdy1[13][58] = "O";
      przystanki2[14].nazwa ="Borówiec Kurkowa";
      przystanki2[14].odjazdy1[12][7] = "O";
      przystanki2[14].odjazdy1[13][57] = "O";
      przystanki2[15].nazwa ="Borówiec Borówkowa";
      przystanki2[15].odjazdy1[12][6] = "O";
      przystanki2[15].odjazdy1[13][56] = "O";
      przystanki2[16].nazwa ="Kamionki Lisia";
      przystanki2[16].odjazdy1[12][5] = "O";
      przystanki2[16].odjazdy1[13][55] = "O";
      przystanki2[17].nazwa ="Kamionki Lotnicza";
      przystanki2[17].odjazdy1[12][4] = "O";
      przystanki2[17].odjazdy1[13][54] = "O";
      przystanki2[18].nazwa ="Kamionki Pętla";
      przystanki2[18].odjazdy1[12][3] = "O";
      przystanki2[18].odjazdy1[13][53] = "O";
      przystanki2[19].nazwa ="Kamionki Klonowa";
      przystanki2[19].odjazdy1[12][0] = "O";
      przystanki2[19].odjazdy1[13][50] = "O";
      przystanki2[20].nazwa ="Kamionki Łąkowa";
      przystanki2[20].odjazdy1[11][58] = "O";
      przystanki2[20].odjazdy1[13][48] = "O";
      przystanki2[21].nazwa ="Kamionki Polna";
      przystanki2[21].odjazdy1[11]57] = "O";
      przystanki2[21].odjazdy1[13][47] = "O";
      przystanki2[22].nazwa = "Kamionki Szkoła";
      przystanki2[22].odjazdy1[11][55] = "O";
      przystanki2[22].odjazdy1[13][45] = "O";
        }

        if ( number.equals("9") == true ){
          n = 37;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Kórnik Plac Niepodległości"

            przystanki[k].przystanki[0] = "Kórnik - Pl. Niepodległ";
            przystanki[k].przystanki[1] = "Kórnik - Prowent";
            przystanki[k].przystanki[2] = "Kórnik Bnin A. Krajowej";
            przystanki[k].przystanki[3] = "Kórnik - Bnin Rynek";
            przystanki[k].przystanki[4] = "Kórnik Bnin Konarska";
            przystanki[k].przystanki[5] = "Konarskie Wieś";
            przystanki[k].przystanki[6] = "Konarskie Świetlica";
            przystanki[k].przystanki[7] = "Konarskie Pętla";
            przystanki[k].przystanki[8] = "Konarskie Skrzyżowanie";
            przystanki[k].przystanki[9] = "Radzewo Strażnica";
            przystanki[k].przystanki[10] = "Radzewo SP";
            przystanki[k].przystanki[11] = "Trzykolne Młyny Radzewska";
            przystanki[k].przystanki[12] = "Trzyklne Młyny Rogalińska";
            przystanki[k].przystanki[13] = "Czmoniec Rumiankowa";
            przystanki[k].przystanki[14] = "Czmoniec Miętowa";
            przystanki[k].przystanki[15] = "Czmoniec Piwoniowa";
            przystanki[k].przystanki[16] = "Czmoniec Stokrotkowa";
            przystanki[k].przystanki[17] = "Czmoniec Marzymięta";
            przystanki[k].przystanki[18] = "Czmoń Leśna";
            przystanki[k].przystanki[19] = "Czmoń Strażacka";
            przystanki[k].przystanki[20] = "Czmoń Lipowa";
            przystanki[k].przystanki[21] = "Czmoń Os Radosne";
            przystanki[k].przystanki[22] = "Radzewo Pomorska";
            przystanki[k].przystanki[23] = "Radzewo Strażnica";
            przystanki[k].przystanki[24] = "Radzewo SP";
            przystanki[k].przystanki[25] = "Dworzyska";
            przystanki[k].przystanki[26] = "Radzewo SP";
            przystanki[k].przystanki[27] = "Radzewo Strażnica";
            przystanki[k].przystanki[28] = "Konarskie Skrzyżowanie";
            przystanki[k].przystanki[29] = "Konarskie Wieś";
            przystanki[k].przystanki[30] = "Konarskie Świetlica";
            przystanki[k].przystanki[31] = "Konarskie Pętla";
            przystanki[k].przystanki[32] = "Czołowo Kórnicka";
            przystanki[k].przystanki[33] = "Kórnik - Bnin Rynek";
            przystanki[k].przystanki[34] = "Kórnik Bnin A.Krajowej";
            przystanki[k].przystanki[35] = "Kórnik Prowent";
            przystanki[k].przystanki[36] = "Kórnik - Pl. Niepodległ";

            przystanki[k].linia = "595";


            przystanki[k].uwagi = null;

          }

        przystanki[0].nazwa = "Kórnik - Pl. Niepodległ";
        przystanki[0].odjazdy1[7][15] = "O";
        przystanki[0].odjazdy1[9][0] = "O";
        przystanki[1].nazwa = "Kórnik - Prowent";
        przystanki[1].odjazdy1[7][17] = "O";
        przystanki[1].odjazdy1[9][2] = "O";
        przystanki[2].nazwa = "Kórnik Bnin A. Krajowej";
        przystanki[2].odjazdy1[7][19] = "O";
        przystanki[2].odjazdy1[9][4] = "O";
        przystanki[3].nazwa = "Kórnik - Bnin Rynek";
        przystanki[3].odjazdy1[7][22] = "O";
        przystanki[3].odjazdy1[9][7] = "O";
        przystanki[4].nazwa = "Kórnik Bnin Konarska";
        przystanki[4].odjazdy1[7][24] = "O";
        przystanki[4].odjazdy1[9][9] = "O";
        przystanki[5].nazwa = "Konarskie Wieś";
        przystanki[5].odjazdy1[7][29] = "O";
        przystanki[5].odjazdy1[9][14] = "O";
        przystanki[6].nazwa = "Konarskie Świetlica";
        przystanki[6].odjazdy1[7][30] = "O";
        przystanki[6].odjazdy1[9][15] = "O";
        przystanki[7].nazwa = "Konarskie Pętla";
        przystanki[7].odjazdy1[7][31] = "O";
        przystanki[7].odjazdy1[9][16] = "O";
        przystanki[8].nazwa = "Konarskie Skrzyżowanie";
        przystanki[8].odjazdy1[7][33] = "O";
        przystanki[8].odjazdy1[9][18] = "O";
        przystanki[9].nazwa = "Radzewo Strażnica";
        przystanki[9].odjazdy1[7][36] = "O";
        przystanki[9].odjazdy1[9][21] = "O";
        przystanki[10].nazwa = "Radzewo SP";
        przystanki[10].odjazdy1[7][37] = "O";
        przystanki[10].odjazdy1[9][22] = "O";
        przystanki[11].nazwa = "Trzykolne Młyny Radzewska";
        przystanki[11].odjazdy1[7][42] = "O";
        przystanki[11].odjazdy1[9][27] = "O";
        przystanki[12].nazwa = "Trzyklne Młyny Rogalińska";
        przystanki[12].odjazdy1[7][44] = "O";
        przystanki[12].odjazdy1[9][29] = "O";
        przystanki[13].nazwa = "Czmoniec Rumiankowa";
        przystanki[13].odjazdy1[7][47] = "O";
        przystanki[13].odjazdy1[9][32] = "O";
        przystanki[14].nazwa = "Czmoniec Miętowa";
        przystanki[14].odjazdy1[7][50] = "O";
        przystanki[14].odjazdy1[9][35] = "O";
        przystanki[15].nazwa = "Czmoniec Piwoniowa";
        przystanki[15].odjazdy1[7][51] = "O";
        przystanki[15].odjazdy1[9][36] = "O";
        przystanki[16].nazwa = "Czmoniec Stokrotkowa";
        przystanki[16].odjazdy1[7][52] = "O";
        przystanki[16].odjazdy1[9][37] = "O";
        przystanki[17].nazwa = "Czmoniec Marzymięta";
        przystanki[17].odjazdy1[7][53] = "O";
        przystanki[17].odjazdy1[9][38] = "O";
        przystanki[18].nazwa = "Czmoń Leśna";
        przystanki[18].odjazdy1[7][55] = "O";
        przystanki[18].odjazdy1[9][40] = "O";
        przystanki[19].nazwa = "Czmoń Strażacka";
        przystanki[19].odjazdy1[7][57] = "O";
        przystanki[19].odjazdy1[9][42] = "O";
        przystanki[20].nazwa = "Czmoń Lipowa";
        przystanki[20].odjazdy1[8][1] = "O";
        przystanki[20].odjazdy1[9][46] = "O";
        przystanki[21].nazwa = "Czmoń Os Radosne";
        przystanki[21].odjazdy1[8][2] = "O";
        przystanki[21].odjazdy1[9][47] = "O";
        przystanki[22].nazwa = "Radzewo Pomorska";
        przystanki[22].odjazdy1[8][4] = "O";
        przystanki[22].odjazdy1[9][49] = "O";
        przystanki[23].nazwa = "Radzewo Strażnica";
        przystanki[23].odjazdy1[8][6] = "O";
        przystanki[23].odjazdy1[9][51] = "O";
        przystanki[24].nazwa = "Radzewo SP";
        przystanki[24].odjazdy1[8][7] = "O";
        przystanki[24].odjazdy1[9][52] = "O";
        przystanki[25].nazwa = "Dworzyska";
        przystanki[25].odjazdy1[8][11] = "O";
        przystanki[25].odjazdy1[9][56] = "O";
        przystanki[26].nazwa = "Radzewo SP";
        przystanki[26].odjazdy1[8][15] = "O";
        przystanki[26].odjazdy1[10][0] = "O";
        przystanki[27].nazwa = "Radzewo Strażnica";
        przystanki[27].odjazdy1[8][16] = "O";
        przystanki[27].odjazdy1[10][1] = "O";
        przystanki[28].nazwa = "Konarskie Skrzyżowanie";
        przystanki[28].odjazdy1[8][20] = "O";
        przystanki[28].odjazdy1[10][5] = "O";
        przystanki[29].nazwa = "Konarskie Wieś";
        przystanki[29].odjazdy1[8][21] = "O";
        przystanki[29].odjazdy1[10][6] = "O";
        przystanki[30].nazwa = "Konarskie Świetlica";
        przystanki[30].odjazdy1[8][22] = "O";
        przystanki[30].odjazdy1[10][7] = "O";
        przystanki[31].nazwa = "Konarskie Pętla";
        przystanki[31].odjazdy1[8][23] = "O";
        przystanki[31].odjazdy1[10][8] = "O";
        przystanki[32].nazwa = "Czołowo Kórnicka";
        przystanki[32].odjazdy1[8][24] = "O";
        przystanki[32].odjazdy1[10][9] = "O";
        przystanki[33].nazwa = "Kórnik - Bnin Rynek";
        przystanki[33].odjazdy1[8][30] = "O";
        przystanki[33].odjazdy1[10][15] = "O";
        przystanki[34].nazwa = "Kórnik Bnin A.Krajowej";
        przystanki[34].odjazdy1[8][31] = "O";
        przystanki[34].odjazdy1[10][16] = "O";
        przystanki[35].nazwa = "Kórnik Prowent";
        przystanki[35].odjazdy1[8][33] = "O";
        przystanki[35].odjazdy1[10][18] = "O";
        przystanki[36].nazwa = "Kórnik - Pl. Niepodległ";
        przystanki[36].odjazdy1[8][35] = "O";
        przystanki[36].odjazdy1[10][20] = "O";

        n = 37;
        przystanki2 = new PrzystanekD[n];
        for ( int k = 0 ; k < n ; k++ ){
          przystanki2[k] = new PrzystanekD();
          przystanki2[k].waznyod = "16-05-2023";
          przystanki2[k].kierunek = "Kórnik Plac Niepodległości"
//TODO zostawiamy
          przystanki2[k].przystanki[0] = "Kórnik - Pl. Niepodległ";
          przystanki2[k].przystanki[1] = "Kórnik - Prowent";
          przystanki2[k].przystanki[2] = "Kórnik Bnin A. Krajowej";
          przystanki2[k].przystanki[3] = "Kórnik - Bnin Rynek";
          przystanki2[k].przystanki[4] = "Kórnik Bnin Konarska";
          przystanki2[k].przystanki[5] = "Konarskie Wieś";
          przystanki2[k].przystanki[6] = "Konarskie Świetlica";
          przystanki2[k].przystanki[7] = "Konarskie Pętla";
          przystanki2[k].przystanki[8] = "Konarskie Skrzyżowanie";
          przystanki2[k].przystanki[9] = "Radzewo Strażnica";
          przystanki2[k].przystanki[10] = "Radzewo SP";
          przystanki2[k].przystanki[11] = "Trzykolne Młyny Radzewska";
          przystanki2[k].przystanki[12] = "Trzyklne Młyny Rogalińska";
          przystanki2[k].przystanki[13] = "Czmoniec Rumiankowa";
          przystanki2[k].przystanki[14] = "Czmoniec Miętowa";
          przystanki2[k].przystanki[15] = "Czmoniec Piwoniowa";
          przystanki2[k].przystanki[16] = "Czmoniec Stokrotkowa";
          przystanki2[k].przystanki[17] = "Czmoniec Marzymięta";
          przystanki2[k].przystanki[18] = "Czmoń Leśna";
          przystanki2[k].przystanki[19] = "Czmoń Strażacka";
          przystanki2[k].przystanki[20] = "Czmoń Lipowa";
          przystanki2[k].przystanki[21] = "Czmoń Os Radosne";
          przystanki2[k].przystanki[22] = "Radzewo Pomorska";
          przystanki2[k].przystanki[23] = "Radzewo Strażnica";
          przystanki2[k].przystanki[24] = "Radzewo SP";
          przystanki2[k].przystanki[25] = "Dworzyska";
          przystanki2[k].przystanki[26] = "Radzewo SP";
          przystanki2[k].przystanki[27] = "Radzewo Strażnica";
          przystanki2[k].przystanki[28] = "Konarskie Skrzyżowanie";
          przystanki2[k].przystanki[29] = "Konarskie Wieś";
          przystanki2[k].przystanki[30] = "Konarskie Świetlica";
          przystanki2[k].przystanki[31] = "Konarskie Pętla";
          przystanki2[k].przystanki[32] = "Czołowo Kórnicka";
          przystanki2[k].przystanki[33] = "Kórnik - Bnin Rynek";
          przystanki2[k].przystanki[34] = "Kórnik Bnin A.Krajowej";
          przystanki2[k].przystanki[35] = "Kórnik Prowent";
          przystanki2[k].przystanki[36] = "Kórnik - Pl. Niepodległ";

          przystanki2[k].linia = "595";


          przystanki2[k].uwagi = null;

        }

      przystanki2[0].nazwa = "Kórnik - Pl. Niepodległ";
      przystanki2[0].odjazdy1[7][15] = "O";
      przystanki2[0].odjazdy1[9][0] = "O";
      przystanki2[1].nazwa = "Kórnik - Prowent";
      przystanki2[1].odjazdy1[7][17] = "O";
      przystanki2[1].odjazdy1[9][2] = "O";
      przystanki2[2].nazwa = "Kórnik Bnin A. Krajowej";
      przystanki2[2].odjazdy1[7][19] = "O";
      przystanki2[2].odjazdy1[9][4] = "O";
      przystanki2[3].nazwa = "Kórnik - Bnin Rynek";
      przystanki2[3].odjazdy1[7][22] = "O";
      przystanki2[3].odjazdy1[9][7] = "O";
      przystanki2[4].nazwa = "Kórnik Bnin Konarska";
      przystanki2[4].odjazdy1[7][24] = "O";
      przystanki2[4].odjazdy1[9][9] = "O";
      przystanki2[5].nazwa = "Konarskie Wieś";
      przystanki2[5].odjazdy1[7][29] = "O";
      przystanki2[5].odjazdy1[9][14] = "O";
      przystanki2[6].nazwa = "Konarskie Świetlica";
      przystanki2[6].odjazdy1[7][30] = "O";
      przystanki2[6].odjazdy1[9][15] = "O";
      przystanki2[7].nazwa = "Konarskie Pętla";
      przystanki2[7].odjazdy1[7][31] = "O";
      przystanki2[7].odjazdy1[9][16] = "O";
      przystanki2[8].nazwa = "Konarskie Skrzyżowanie";
      przystanki2[8].odjazdy1[7][33] = "O";
      przystanki2[8].odjazdy1[9][18] = "O";
      przystanki2[9].nazwa = "Radzewo Strażnica";
      przystanki2[9].odjazdy1[7][36] = "O";
      przystanki2[9].odjazdy1[9][21] = "O";
      przystanki2[10].nazwa = "Radzewo SP";
      przystanki2[10].odjazdy1[7][37] = "O";
      przystanki2[10].odjazdy1[9][22] = "O";
      przystanki2[11].nazwa = "Trzykolne Młyny Radzewska";
      przystanki2[11].odjazdy1[7][42] = "O";
      przystanki2[11].odjazdy1[9][27] = "O";
      przystanki2[12].nazwa = "Trzyklne Młyny Rogalińska";
      przystanki2[12].odjazdy1[7][44] = "O";
      przystanki2[12].odjazdy1[9][29] = "O";
      przystanki2[13].nazwa = "Czmoniec Rumiankowa";
      przystanki2[13].odjazdy1[7][47] = "O";
      przystanki2[13].odjazdy1[9][32] = "O";
      przystanki2[14].nazwa = "Czmoniec Miętowa";
      przystanki2[14].odjazdy1[7][50] = "O";
      przystanki2[14].odjazdy1[9][35] = "O";
      przystanki2[15].nazwa = "Czmoniec Piwoniowa";
      przystanki2[15].odjazdy1[7][51] = "O";
      przystanki2[15].odjazdy1[9][36] = "O";
      przystanki2[16].nazwa = "Czmoniec Stokrotkowa";
      przystanki2[16].odjazdy1[7][52] = "O";
      przystanki2[16].odjazdy1[9][37] = "O";
      przystanki2[17].nazwa = "Czmoniec Marzymięta";
      przystanki2[17].odjazdy1[7][53] = "O";
      przystanki2[17].odjazdy1[9][38] = "O";
      przystanki2[18].nazwa = "Czmoń Leśna";
      przystanki2[18].odjazdy1[7][55] = "O";
      przystanki2[18].odjazdy1[9][40] = "O";
      przystanki2[19].nazwa = "Czmoń Strażacka";
      przystanki2[19].odjazdy1[7][57] = "O";
      przystanki2[19].odjazdy1[9][42] = "O";
      przystanki2[20].nazwa = "Czmoń Lipowa";
      przystanki2[20].odjazdy1[8][1] = "O";
      przystanki2[20].odjazdy1[9][46] = "O";
      przystanki2[21].nazwa = "Czmoń Os Radosne";
      przystanki2[21].odjazdy1[8][2] = "O";
      przystanki2[21].odjazdy1[9][47] = "O";
      przystanki2[22].nazwa = "Radzewo Pomorska";
      przystanki2[22].odjazdy1[8][4] = "O";
      przystanki2[22].odjazdy1[9][49] = "O";
      przystanki2[23].nazwa = "Radzewo Strażnica";
      przystanki2[23].odjazdy1[8][6] = "O";
      przystanki2[23].odjazdy1[9][51] = "O";
      przystanki2[24].nazwa = "Radzewo SP";
      przystanki2[24].odjazdy1[8][7] = "O";
      przystanki2[24].odjazdy1[9][52] = "O";
      przystanki2[25].nazwa = "Dworzyska";
      przystanki2[25].odjazdy1[8][11] = "O";
      przystanki2[25].odjazdy1[9][56] = "O";
      przystanki2[26].nazwa = "Radzewo SP";
      przystanki2[26].odjazdy1[8][15] = "O";
      przystanki2[26].odjazdy1[10][0] = "O";
      przystanki2[27].nazwa = "Radzewo Strażnica";
      przystanki2[27].odjazdy1[8][16] = "O";
      przystanki2[27].odjazdy1[10][1] = "O";
      przystanki2[28].nazwa = "Konarskie Skrzyżowanie";
      przystanki2[28].odjazdy1[8][20] = "O";
      przystanki2[28].odjazdy1[10][5] = "O";
      przystanki2[29].nazwa = "Konarskie Wieś";
      przystanki2[29].odjazdy1[8][21] = "O";
      przystanki2[29].odjazdy1[10][6] = "O";
      przystanki2[30].nazwa = "Konarskie Świetlica";
      przystanki2[30].odjazdy1[8][22] = "O";
      przystanki2[30].odjazdy1[10][7] = "O";
      przystanki2[31].nazwa = "Konarskie Pętla";
      przystanki2[31].odjazdy1[8][23] = "O";
      przystanki2[31].odjazdy1[10][8] = "O";
      przystanki2[32].nazwa = "Czołowo Kórnicka";
      przystanki2[32].odjazdy1[8][24] = "O";
      przystanki2[32].odjazdy1[10][9] = "O";
      przystanki2[33].nazwa = "Kórnik - Bnin Rynek";
      przystanki2[33].odjazdy1[8][30] = "O";
      przystanki2[33].odjazdy1[10][15] = "O";
      przystanki2[34].nazwa = "Kórnik Bnin A.Krajowej";
      przystanki2[34].odjazdy1[8][31] = "O";
      przystanki2[34].odjazdy1[10][16] = "O";
      przystanki2[35].nazwa = "Kórnik Prowent";
      przystanki2[35].odjazdy1[8][33] = "O";
      przystanki2[35].odjazdy1[10][18] = "O";
      przystanki2[36].nazwa = "Kórnik - Pl. Niepodległ";
      przystanki2[36].odjazdy1[8][35] = "O";
      przystanki2[36].odjazdy1[10][20] = "O";
        }
        if ( number.equals("10") == true ){//582
          n = 4;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Czołowo - Czołowo"

            przystanki[k].przystanki[0] = "Kórnik - Pl. Niepodległ";
            przystanki[k].przystanki[1] = "Kórnik - Reja";
            przystanki[k].przystanki[2] = "Mościennica - Mościennica";
            przystanki[k].przystanki[3] = "Czołowo - Czołowo";

            przystanki[k].linia = "596";


            przystanki[k].uwagi = null;

          }

        przystanki[0].nazwa = "Kórnik - Pl. Niepodległ";
        przystanki[0].odjazdy1[12][45] = "O";
        przystanki[1].nazwa = "Kórnik - Reja";
        przystanki[1].odjazdy1[12][47] = "O";
        przystanki[2].nazwa = "Mościennica - Mościennica";
        przystanki[2].odjazdy1[12][54] = "O";
        przystanki[3].nazwa = "Czołowo - Czołowo";
        przystanki[3].odjazdy1[13][1] = "O";

        n = 3;
        przystanki2 = new PrzystanekD[n];
        for ( int k = 0 ; k < n ; k++ ){
          przystanki2[k] = new PrzystanekD();
          przystanki2[k].waznyod = "16-05-2023";
          przystanki2[k].kierunek = "Kórnik Rynek"

          przystanki2[k].przystanki[0] = "Kórnik - Szkoła";
          przystanki2[k].przystanki[1] = "Kórnik - Reja";
          przystanki2[k].przystanki[2] = "Czołowo - Czołowo";

          przystanki2[k].linia = "596";


          przystanki2[k].uwagi = null;

        }

      przystanki2[0].nazwa = "Kórnik - Szkoła";
      przystanki2[0].odjazdy1[12][56] = "O";
      przystanki2[0].odjazdy1[15][21] = "O";
      przystanki2[1].nazwa = "Kórnik - Reja";
      przystanki2[1].odjazdy1[12][53] = "O";
      przystanki2[0].odjazdy1[15][18] = "O";
      przystanki2[2].nazwa = "Czołowo - Czołowo";
      przystanki2[2].odjazdy1[12][46] = "O";
      przystanki2[0].odjazdy1[15][11] = "O";
        }
        if ( number.equals("11") == true ){//582
          n = 10;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Jaryszki - Składowa"

            przystanki[k].przystanki[0] = "Błażejewo - Przylesie";
            przystanki[k].przystanki[1] = "Kórnik - Bnin Osiedle";
            przystanki[k].przystanki[2] = "Kórnik - Bnin Rynek";
            przystanki[k].przystanki[3] = "Kórnik Bnin Armii Krajowej";
            przystanki[k].przystanki[4] = "Kórnik - Pl. Niepodległ";
            przystanki[k].przystanki[5] = "Kórnik Reja";
            przystanki[k].przystanki[6] = "Skrzynki Jeziorna";
            przystanki[k].przystanki[7] = "Gądki - Gądki";
            przystanki[k].przystanki[8] = "Gądki - Węzeł";
            przystanki[k].przystanki[9] = "Jaryszki Składowa";

            przystanki[k].linia = "597";


            przystanki[k].uwagi = null;

          }

        przystanki[0].nazwa = "Błażejewo - Przylesie";
        przystanki[0].odjazdy1[6][37] = "O";
        przystanki[1].nazwa = "Kórnik - Bnin Osiedle";
        przystanki[1].odjazdy1[6][40] = "O";
        przystanki[2].nazwa = "Kórnik - Bnin Rynek";
        przystanki[2].odjazdy1[6][42] = "O";
        przystanki[3].nazwa = "Kórnik Bnin Armii Krajowej";
        przystanki[3].odjazdy1[6][46] = "O";
        przystanki[4].nazwa = "Kórnik - Pl. Niepodległ";
        przystanki[4].odjazdy1[6][47] = "O";
        przystanki[5].nazwa = "Kórnik Reja";
        przystanki[5].odjazdy1[6][49] = "O";
        przystanki[6].nazwa = "Skrzynki Jeziorna";
        przystanki[6].odjazdy1[6][52] = "O";
        przystanki[7].nazwa = "Gądki - Gądki";
        przystanki[7].odjazdy1[6][55] = "O";
        przystanki[8].nazwa = "Gądki - Węzeł";
        przystanki[8].odjazdy1[6][58] = "O";
        przystanki[9].nazwa = "Jaryszki Składowa";
        przystanki[9].odjazdy1[7][4] = "O";
//TODO wpisac dalsze rozklady powrot
        n = 10;
        przystanki2 = new PrzystanekD[n];
        for ( int k = 0 ; k < n ; k++ ){
          przystanki2[k] = new PrzystanekD();
          przystanki2[k].waznyod = "16-05-2023";
          przystanki2[k].kierunek = "Jaryszki - Składowa"

          przystanki2[k].przystanki[0] = "Błażejewo - Przylesie";
          przystanki2[k].przystanki[1] = "Kórnik - Bnin Osiedle";
          przystanki2[k].przystanki[2] = "Kórnik - Bnin Rynek";
          przystanki2[k].przystanki[3] = "Kórnik Bnin Armii Krajowej";
          przystanki2[k].przystanki[4] = "Kórnik - Pl. Niepodległ";
          przystanki2[k].przystanki[5] = "Kórnik Reja";
          przystanki2[k].przystanki[6] = "Skrzynki Jeziorna";
          przystanki2[k].przystanki[7] = "Gądki - Gądki";
          przystanki2[k].przystanki[8] = "Gądki - Węzeł";
          przystanki2[k].przystanki[9] = "Jaryszki Składowa";

          przystanki2[k].linia = "597";


          przystanki2[k].uwagi = null;

        }

      przystanki2[0].nazwa = "Błażejewo - Przylesie";
      przystanki2[0].odjazdy1[6][37] = "O";
      przystanki2[1].nazwa = "Kórnik - Bnin Osiedle";
      przystanki2[1].odjazdy1[6][40] = "O";
      przystanki2[2].nazwa = "Kórnik - Bnin Rynek";
      przystanki2[2].odjazdy1[6][42] = "O";
      przystanki2[3].nazwa = "Kórnik Bnin Armii Krajowej";
      przystanki2[3].odjazdy1[6][46] = "O";
      przystanki2[4].nazwa = "Kórnik - Pl. Niepodległ";
      przystanki2[4].odjazdy1[6][47] = "O";
      przystanki2[5].nazwa = "Kórnik Reja";
      przystanki2[5].odjazdy1[6][49] = "O";
      przystanki2[6].nazwa = "Skrzynki Jeziorna";
      przystanki2[6].odjazdy1[6][52] = "O";
      przystanki2[7].nazwa = "Gądki - Gądki";
      przystanki2[7].odjazdy1[6][55] = "O";
      przystanki2[8].nazwa = "Gądki - Węzeł";
      przystanki2[8].odjazdy1[6][58] = "O";
      przystanki2[9].nazwa = "Jaryszki Składowa";
      przystanki2[9].odjazdy1[7][4] = "O";
        }

        if ( number.equals("12") == true ){
          int n = 11;
          przystanki = new PrzystanekD[n];
          for ( int k = 0 ; k < n ; k++ ){
            przystanki[k] = new PrzystanekD();
            przystanki[k].waznyod = "16-05-2023";
            przystanki[k].kierunek = "Szczytniki - Pętla"

            przystanki[k].przystanki[0] = "Kórnik - Pl. Niepodległ";
            przystanki[k].przystanki[1] = "Kórnik Poprzeczna";
            przystanki[k].przystanki[2] = "Kórnik - Reja";
            przystanki[k].przystanki[3] = "Skrzynki Jeziorna";
            przystanki[k].przystanki[4] = "Gądki PKP";
            przystanki[k].przystanki[5] = "Borówiec Las";
            przystanki[k].przystanki[6] = "Koninko Las";
            przystanki[k].przystanki[7] = "Koninko Granatowa";
            przystanki[k].przystanki[8] = "Koninko Dziennikarska";
            przystanki[k].przystanki[9] = "Koninko Pisarska";
            przystanki[k].przystanki[10] = "Szczytniki Pętla";

            przystanki[k].linia = "599";


            przystanki[k].uwagi = null;

          }

        przystanki[0].nazwa = "Kórnik - Pl. Niepodległ";
        przystanki[0].odjazdy1[5][30] = "O";
        przystanki[0].odjazdy1[6][21] = "O";
        przystanki[0].odjazdy1[9][13] = "O";
        przystanki[0].odjazdy1[11][0] = "O";

        przystanki[1].nazwa = "Kórnik Poprzeczna";
        przystanki[1].odjazdy1[5][31] = "O";
        przystanki[1].odjazdy1[6][22] = "O";
        przystanki[1].odjazdy1[9][14] = "O";
        przystanki[1].odjazdy1[11][1] = "O";
        przystanki[2].nazwa = "Kórnik - Reja";
        przystanki[2].odjazdy1[5][32] = "O";
        przystanki[2].odjazdy1[6][23] = "O";
        przystanki[2].odjazdy1[9][15] = "O";
        przystanki[2].odjazdy1[11][2] = "O";
        przystanki[3].nazwa = "Skrzynki Jeziorna";
        przystanki[3].odjazdy1[5][35] = "O";
        przystanki[3].odjazdy1[6][26] = "O";
        przystanki[3].odjazdy1[9][18] = "O";
        przystanki[3].odjazdy1[11][5] = "O";
        przystanki[4].nazwa = "Gądki PKP";
        przystanki[4].odjazdy1[5][40] = "O";
        przystanki[4].odjazdy1[6][31] = "O";
        przystanki[4].odjazdy1[9][23] = "O";
        przystanki[4].odjazdy1[11][10] = "O";
        przystanki[5].nazwa = "Borówiec Las";
        przystanki[5].odjazdy1[5][43] = "O";
        przystanki[5].odjazdy1[6][34] = "O";
        przystanki[5].odjazdy1[9][26] = "O";
        przystanki[5].odjazdy1[11][13] = "O";
        przystanki[6].nazwa = "Koninko Las";
        przystanki[6].odjazdy1[5][45] = "O";
        przystanki[6].odjazdy1[6][36] = "O";
        przystanki[6].odjazdy1[9][28] = "O";
        przystanki[6].odjazdy1[11][15] = "O";
        przystanki[7].nazwa = "Koninko Granatowa";
        przystanki[7].odjazdy1[5][47] = "O";
        przystanki[7].odjazdy1[6][38] = "O";
        przystanki[7].odjazdy1[9][30] = "O";
        przystanki[7].odjazdy1[11][17] = "O";
        przystanki[8].nazwa = "Koninko Dziennikarska";
        przystanki[8].odjazdy1[5][48] = "O";
        przystanki[8].odjazdy1[6][39] = "O";
        przystanki[8].odjazdy1[9][31] = "O";
        przystanki[8].odjazdy1[11][18] = "O";
        przystanki[9].nazwa = "Koninko Pisarska";
        przystanki[9].odjazdy1[5][49] = "O";
        przystanki[9].odjazdy1[6][40] = "O";
        przystanki[9].odjazdy1[9][32] = "O";
        przystanki[9].odjazdy1[11][19] = "O";
        przystanki[10].nazwa = "Szczytniki Pętla";
        przystanki[10].odjazdy1[5][50] = "O";
        przystanki[10].odjazdy1[6][41] = "O";
        przystanki[10].odjazdy1[9][33] = "O";
        przystanki[10].odjazdy1[11][20] = "O";

        int n = 11;
        przystanki2 = new PrzystanekD[n];
        for ( int k = 0 ; k < n ; k++ ){
          przystanki2[k] = new PrzystanekD();
          przystanki2[k].waznyod = "16-05-2023";
          przystanki2[k].kierunek = "Szczytniki - Pętla"

          przystanki2[k].przystanki[0] = "Kórnik - Pl. Niepodległ";
          przystanki2[k].przystanki[1] = "Kórnik Poprzeczna";
          przystanki2[k].przystanki[2] = "Kórnik - Reja";
          przystanki2[k].przystanki[3] = "Skrzynki Jeziorna";
          przystanki2[k].przystanki[4] = "Gądki PKP";
          przystanki2[k].przystanki[5] = "Borówiec Las";
          przystanki2[k].przystanki[6] = "Koninko Las";
          przystanki2[k].przystanki[7] = "Koninko Granatowa";
          przystanki2[k].przystanki[8] = "Koninko Dziennikarska";
          przystanki2[k].przystanki[9] = "Koninko Pisarska";
          przystanki2[k].przystanki[10] = "Szczytniki Pętla";

          przystanki2[k].linia = "599";


          przystanki2[k].uwagi = null;

        }

      przystanki2[0].nazwa = "Kórnik - Pl. Niepodległ";
      przystanki2[0].odjazdy1[5][30] = "O";
      przystanki2[0].odjazdy1[6][21] = "O";
      przystanki2[0].odjazdy1[9][13] = "O";
      przystanki2[0].odjazdy1[11][0] = "O";

      przystanki2[1].nazwa = "Kórnik Poprzeczna";
      przystanki2[1].odjazdy1[5][31] = "O";
      przystanki2[1].odjazdy1[6][22] = "O";
      przystanki2[1].odjazdy1[9][14] = "O";
      przystanki2[1].odjazdy1[11][1] = "O";
      przystanki2[2].nazwa = "Kórnik - Reja";
      przystanki2[2].odjazdy1[5][32] = "O";
      przystanki2[2].odjazdy1[6][23] = "O";
      przystanki2[2].odjazdy1[9][15] = "O";
      przystanki2[2].odjazdy1[11][2] = "O";
      przystanki2[3].nazwa = "Skrzynki Jeziorna";
      przystanki2[3].odjazdy1[5][35] = "O";
      przystanki2[3].odjazdy1[6][26] = "O";
      przystanki2[3].odjazdy1[9][18] = "O";
      przystanki2[3].odjazdy1[11][5] = "O";
      przystanki2[4].nazwa = "Gądki PKP";
      przystanki2[4].odjazdy1[5][40] = "O";
      przystanki2[4].odjazdy1[6][31] = "O";
      przystanki2[4].odjazdy1[9][23] = "O";
      przystanki2[4].odjazdy1[11][10] = "O";
      przystanki2[5].nazwa = "Borówiec Las";
      przystanki2[5].odjazdy1[5][43] = "O";
      przystanki2[5].odjazdy1[6][34] = "O";
      przystanki2[5].odjazdy1[9][26] = "O";
      przystanki2[5].odjazdy1[11][13] = "O";
      przystanki2[6].nazwa = "Koninko Las";
      przystanki2[6].odjazdy1[5][45] = "O";
      przystanki2[6].odjazdy1[6][36] = "O";
      przystanki2[6].odjazdy1[9][28] = "O";
      przystanki2[6].odjazdy1[11][15] = "O";
      przystanki2[7].nazwa = "Koninko Granatowa";
      przystanki2[7].odjazdy1[5][47] = "O";
      przystanki2[7].odjazdy1[6][38] = "O";
      przystanki2[7].odjazdy1[9][30] = "O";
      przystanki2[7].odjazdy1[11][17] = "O";
      przystanki2[8].nazwa = "Koninko Dziennikarska";
      przystanki2[8].odjazdy1[5][48] = "O";
      przystanki2[8].odjazdy1[6][39] = "O";
      przystanki2[8].odjazdy1[9][31] = "O";
      przystanki2[8].odjazdy1[11][18] = "O";
      przystanki2[9].nazwa = "Koninko Pisarska";
      przystanki2[9].odjazdy1[5][49] = "O";
      przystanki2[9].odjazdy1[6][40] = "O";
      przystanki2[9].odjazdy1[9][32] = "O";
      przystanki2[9].odjazdy1[11][19] = "O";
      przystanki2[10].nazwa = "Szczytniki Pętla";
      przystanki2[10].odjazdy1[5][50] = "O";
      przystanki2[10].odjazdy1[6][41] = "O";
      przystanki2[10].odjazdy1[9][33] = "O";
      przystanki2[10].odjazdy1[11][20] = "O";
        }
      PrzystanekD[] p2 = this.reverse(przystanki2);
      return return this.merge(przystanki,p2);
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

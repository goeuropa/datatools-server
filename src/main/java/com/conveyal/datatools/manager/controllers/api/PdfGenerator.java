package com.conveyal.datatools.manager.controllers.api;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;

import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
public class PdfGenerator {

  public PrzystanekD generujKombus(String number){
    PrzystanekD p = new PrzystanekD(number);
    return p;
    //}
  }
  public void generujPrzystanek(PrzystanekD przystanek, String outputFilename){
    System.out.println("Generuje: " + przystanek);
    System.out.println("Do pliku: " + outputFilename);

    // ustawiamy dane
    int godzina = 12;
    int minuta = 30;
    int x = 0;
    int y = 0;
    int szerokosc = 1400;
    int wysokosc = 989;
    String inputImageFileName = "grafika.png";

    try {
        // tworzymy dokument PDF
        Document document = new Document(new Rectangle(1400, 989));
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFilename));
        document.open();
        PdfContentByte cb = writer.getDirectContent();

        // ładujemy plik z grafiką
        File file = new File(inputImageFileName);
        Image image = Image.getInstance(file.getAbsolutePath());

        cb.saveState();
        cb.addImage(image, szerokosc, 0, 0, wysokosc, 0, 0);
        cb.restoreState();
        // nanosimy godzinę i minutę na wybranej pozycji
        cb.beginText();


        //end of header


        //odjazdy1
        this.header(cb,przystanek);
        this.odjazdy1(cb,przystanek);
        this.odjazdy2(cb,przystanek);
        this.odjazdy3(cb,przystanek);
        this.przystanki(cb,przystanek);
        this.uwagi(cb,przystanek);

        document.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  public static void main(String[] args) {
        PdfGenerator pdf = new PdfGenerator();
        PrzystanekD p = new PrzystanekD("2");
        p.nazwa = "Rondo Śródka";
        p.kierunek = "Małe Garbary";
        p.waznyod = "04-04-2023";
        p.linia = "582";

        p.odjazdy1[3][20] = "O";
        p.odjazdy1[3][40] = "O";
        p.odjazdy1[4][20] = "K";
        p.odjazdy1[15][20] = "O";

        p.odjazdy2[4][10] = "O";
        p.odjazdy2[4][50] = "O";
        p.odjazdy2[15][30] = "O";

        p.odjazdy3[12][20] = "O";
        p.odjazdy3[12][35] = "K";

        p.przystanki[0] = "Szymanowskiego";
        p.przystanki[1] = "Opienskiego";
        p.przystanki[2] = "Kurpińskiego";
        p.przystanki[3] = "Lechicka";
        p.przystanki[4] = "Os. Pod Lipami";
        p.przystanki[5] = "Armii Poznań";
        p.przystanki[6] = "Słowiańska";
        p.przystanki[7] = "Most Teatralny";
        p.przystanki[8] = "Rondo Kaponiera";
        p.przystanki[9] = "Dworzec Główny PKP";
        p.przystanki[10] = "Rynek Łazarski";
        p.przystanki[11] = "Hetmańska";
        p.przystanki[12] = "Rolna";
        p.przystanki[13] = "28 Czerwca 1956 r. ";
        pdf.generujPrzystanek(p,"output2.pdf");


    }
  public void header(PdfContentByte cb, PrzystanekD przystanek){
    try {
    cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 18);
  /*  for ( int i = 0 ; i < 1400 ; i+=50 )
      for ( int j = 0 ; j < 989 ; j+=50 )
        cb.showTextAligned(Element.ALIGN_CENTER, String.format("%02d:%02d", i, j), i, j, 0);
        */
    cb.showTextAligned(Element.ALIGN_LEFT, "Przystanek: ", 335, 920, 0);
    cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 24);
    cb.showTextAligned(Element.ALIGN_LEFT, przystanek.nazwa, 335, 885, 0);

    cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 18);
    cb.showTextAligned(Element.ALIGN_LEFT, "Kierunek: ", 335, 855, 0);
    cb.showTextAligned(Element.ALIGN_LEFT, przystanek.kierunek, 420, 855, 0);

    cb.showTextAligned(Element.ALIGN_LEFT, "Ważny od: ", 580, 920, 0);
    cb.showTextAligned(Element.ALIGN_LEFT, przystanek.waznyod, 680, 920, 0);

    cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 100);
    cb.showTextAligned(Element.ALIGN_LEFT, przystanek.linia, 105, 850, 0);
    cb.endText();
  }
  catch ( Exception ex){
    System.out.println(ex);
  }
  }
  public void odjazdy1(PdfContentByte cb, PrzystanekD przystanek){
    try {
    int sx = 45;
    int sy = 750;
    int kursor = 26;

    int odstepMinute = 50;
    int odstepMinutes = 40;
    int odstepLong = 80;
    //start wspolrzedne
    int scale = 1;
//TODO; odjazdy2,3 long last

    for ( int i = 3 ; i <= 23 ; i++ )
      {
        for ( int j = 0 ; j < 60 ; j++ )
          if ( przystanek.odjazdy1[i][j] != null )
            {
              System.out.println(i+","+j);
              cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 22);
              cb.showTextAligned(Element.ALIGN_CENTER, new Integer(i).toString(), sx, sy-(i-3)*kursor, 0);//godziny 3,4,5,6,7 .. 23
              int z = 0;
              int count = 0;
              boolean lastLong = false;

              while ( z < 60 ){

                if ( przystanek.odjazdy1[i][z] != null )
                  {
                    if ( lastLong == true )
                      cb.showTextAligned(Element.ALIGN_LEFT, przystanek.showMinute(przystanek.odjazdy1[i][z],z), sx+odstepMinute+(count*odstepMinutes)+odstepLong, sy-(i-3)*kursor, 0);//
                    else
                      cb.showTextAligned(Element.ALIGN_LEFT, przystanek.showMinute(przystanek.odjazdy1[i][z],z), sx+odstepMinute+(count*odstepMinutes), sy-(i-3)*kursor, 0);//
                    if ( przystanek.showMinute(przystanek.odjazdy1[i][z],z) == "S,D" )
                      lastLong = true;
                    else
                      lastLong = false;
                    count++;
                  }
                z++;
              }
            }
            else{
              cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 22);
              cb.showTextAligned(Element.ALIGN_CENTER, new Integer(i).toString(), sx, sy-(i-3)*kursor, 0);//godziny 3,4,5,6,7 .. 23
            }

      }
    } catch (Exception e) {
      e.printStackTrace();
  }
  }
  public void odjazdy2(PdfContentByte cb, PrzystanekD przystanek){
    try {
    int sx = 425;
    int sy = 750;
    int kursor = 26;

    int odstepMinute = 50;
    int odstepMinutes = 40;
    //start wspolrzedne
    int scale = 1;


    for ( int i = 3 ; i <= 23 ; i++ )
      {
        for ( int j = 0 ; j < 60 ; j++ )
          if ( przystanek.odjazdy1[i][j] != null )
            {
              System.out.println(i+","+j);
              cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 22);
              cb.showTextAligned(Element.ALIGN_CENTER, new Integer(i).toString(), sx, sy-(i-3)*kursor, 0);//godziny 3,4,5,6,7 .. 23
              int z = 0;
              int count = 0;
              while ( z < 60 ){

                if ( przystanek.odjazdy1[i][z] != null )
                  {
                    cb.showTextAligned(Element.ALIGN_LEFT, przystanek.showMinute(przystanek.odjazdy1[i][z],z), sx+odstepMinute+(count*odstepMinutes), sy-(i-3)*kursor, 0);//
                    count++;
                  }
                z++;
              }
            }
            else{
              cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 22);
              cb.showTextAligned(Element.ALIGN_CENTER, new Integer(i).toString(), sx, sy-(i-3)*kursor, 0);//godziny 3,4,5,6,7 .. 23
            }

      }
    } catch (Exception e) {
      e.printStackTrace();
  }
}
  public void odjazdy3(PdfContentByte cb, PrzystanekD przystanek){
    try {
    int sx = 745;
    int sy = 750;
    int kursor = 26;

    int odstepMinute = 50;
    int odstepMinutes = 40;
    //start wspolrzedne
    int scale = 1;


    for ( int i = 3 ; i <= 23 ; i++ )
      {
        for ( int j = 0 ; j < 60 ; j++ )
          if ( przystanek.odjazdy1[i][j] != null )
            {
              System.out.println(i+","+j);
              cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 22);
              cb.showTextAligned(Element.ALIGN_CENTER, new Integer(i).toString(), sx, sy-(i-3)*kursor, 0);//godziny 3,4,5,6,7 .. 23
              int z = 0;
              int count = 0;
              while ( z < 60 ){

                if ( przystanek.odjazdy1[i][z] != null )
                  {
                    cb.showTextAligned(Element.ALIGN_LEFT, przystanek.showMinute(przystanek.odjazdy1[i][z],z), sx+odstepMinute+(count*odstepMinutes), sy-(i-3)*kursor, 0);//
                    count++;
                  }
                z++;
              }
            }
            else{
              cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED), 22);
              cb.showTextAligned(Element.ALIGN_CENTER, new Integer(i).toString(), sx, sy-(i-3)*kursor, 0);//godziny 3,4,5,6,7 .. 23
            }

      }
    } catch (Exception e) {
      e.printStackTrace();
  }
  }
  public void przystanki(PdfContentByte cb, PrzystanekD przystanek){
    try {
    int sx = 1070;
    int sy = 750;
    int kursor = 26;

    int odstepMinute = 50;
    int odstepPrzystanki = 30;
    //start wspolrzedne
    int scale = 1;

    for ( int i = 0 ; i < 20 ; i++ )
      {
              cb.showTextAligned(Element.ALIGN_LEFT, przystanek.przystanki[i], sx, sy-(i)*odstepPrzystanki, 0);//
      }
    } catch (Exception e) {
      e.printStackTrace();
  }
}
public void uwagi(PdfContentByte cb, PrzystanekD przystanek){
  try {
  int sx = 140;
  int sy = 140;
  int kursor = 26;

  int odstepMinute = 50;
  int odstepPrzystanki = 30;
  //start wspolrzedne
  int scale = 1;

  for ( int i = 0 ; i < przystanek.uwagi.length ; i++ )
    {
            cb.showTextAligned(Element.ALIGN_LEFT, przystanek.uwagi[i], sx, sy-(i)*odstepPrzystanki, 0);//
    }
  } catch (Exception e) {
    e.printStackTrace();
}
}
}

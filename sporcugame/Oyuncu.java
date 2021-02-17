package sporcugame;

import java.util.ArrayList;

public class Oyuncu {
    int oyuncuID = 0;
    String oyuncuAdi = "";
    int Skor = 0;
    
    public Oyuncu(){    
    }
    
    public Oyuncu(int oyuncuID, String oyuncuAdi, int Skor){    
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.Skor = Skor;      
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public int getSkor() {
        return Skor;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }
    
    
    public void skorGoster(){
       // System.out.println(Skor);
    }
    
    public int kartSec(){
        return  (int) (Math.random() * (9 - 0 + 1)) + 0; //S böyle yazmış
    }
    
    // KART LİSTESİ özelliği... ???
    ArrayList<Sporcu> oyuncukartlar = new ArrayList<Sporcu>(); // OYUNCU ARRAYLIST OLUSTURMA
}

package sporcugame;

public class Bilgisayar extends Oyuncu{
    
    public Bilgisayar(){     
        super();
    }
    
    public Bilgisayar(int oyuncuID, String oyuncuAdi, int Skor){  
        super(oyuncuID,oyuncuAdi,Skor);
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.Skor = Skor;
    }
    
    @Override
    public int kartSec(){
        return  (int) (Math.random() * (10));
    }
}

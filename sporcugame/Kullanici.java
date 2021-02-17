package sporcugame;

public class Kullanici extends Oyuncu{
    
    public Kullanici(){    
        super();
    }
    
    public Kullanici(int oyuncuID, String oyuncuAdi, int Skor){  
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

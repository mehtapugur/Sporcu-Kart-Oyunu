package sporcugame;

public class Futbolcu extends Sporcu{
    
    String futbolcuAdi = "";
    String futbolcuTakim = "";
    String iconAdi = "";
    int penaltı = 0;
    int serbestVurus = 0;
    int kaleciKarsiKarsiya = 0;
    Boolean kartKullanildiMi = false;
    
    public Futbolcu(){
        super();
    }
    
    public Futbolcu(String futbolcuAdi, String futbolcuTakim){
        super(futbolcuAdi,futbolcuTakim);
        this.futbolcuAdi = futbolcuAdi;
        this.futbolcuTakim = futbolcuTakim;    
    }

    public String getFutbolcuAdi() {
        return futbolcuAdi;
    }

    public String getFutbolcuTakim() {
        return futbolcuTakim;
    }

    public int getPenaltı() {
        return penaltı;
    }

    public int getSerbestVurus() {
        return serbestVurus;
    }

    public int getKaleciKarsiKarsiya() {
        return kaleciKarsiKarsiya;
    }

    public void setFutbolcuAdi(String futbolcuAdi) {
        this.futbolcuAdi = futbolcuAdi;
    }

    public void setFutbolcuTakim(String futbolcuTakim) {
        this.futbolcuTakim = futbolcuTakim;
    }

    public void setPenaltı(int penaltı) {
        this.penaltı = penaltı;
    }

    public void setSerbestVurus(int serbestVurus) {
        this.serbestVurus = serbestVurus;
    }

    public void setKaleciKarsiKarsiya(int kaleciKarsiKarsiya) {
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }
    
    public String getIcon(){
        return iconAdi;
    }
    
    public void setIcon(String iconAdi){
        this.iconAdi = iconAdi;
    }
    
    @Override
    public int sporcuPuaniGoster(){
       return 0;
    }
    
}

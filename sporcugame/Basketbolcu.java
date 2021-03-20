package sporcugame;

public class Basketbolcu extends Sporcu{
    String basketbolcuAdi = "";
    String basketbolcuTakim = "";
    String iconAdi = "";
    int ikilik = 0;
    int ucluk = 0;
    int serbestAtis = 0;
    Boolean kartKullanildiMi = false;
    
    public Basketbolcu(){
        super();
    }
    
    public Basketbolcu(String basketbolcuAdi, String basketbolcuTakim){
        super(basketbolcuAdi,basketbolcuTakim);
        this.basketbolcuAdi = basketbolcuAdi;
        this.basketbolcuTakim = basketbolcuTakim;       
    }

    public String getBasketbolcuAdi() {
        return basketbolcuAdi;
    }

    public String getBasketbolcuTakim() {
        return basketbolcuTakim;
    }

    public int getIkilik() {
        return ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setBasketbolcuAdi(String basketbolcuAdi) {
        this.basketbolcuAdi = basketbolcuAdi;
    }

    public void setBasketbolcuTakim(String basketbolcuTakim) {
        this.basketbolcuTakim = basketbolcuTakim;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
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

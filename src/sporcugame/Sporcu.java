package sporcugame;

public class Sporcu {
    
    String sporcuIsim = "";
    String sporcuTakim = "";
    
    public Sporcu(){    
    }
    
    public Sporcu(String sporcuIsim, String sporcuTakim){ 
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
    }

    public String getSporcuIsim() {
        return sporcuIsim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }
    
    public int sporcuPuaniGoster(){
            return 0;
    }
    
}

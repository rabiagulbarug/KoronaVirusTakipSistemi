
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author RABİA
 */
public class Hasta {
    private String isim,memleket,meslek,cinsiyet;
    private float ates;
    private boolean teshis;
    private LocalDate tarih;

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Hasta(String isim, String memleket, String meslek, String cinsiyet, float ates, boolean teshis, LocalDate tarih) {
        this.isim = isim;
        this.memleket = memleket;
        this.meslek = meslek;
        this.cinsiyet = cinsiyet;
        this.ates = ates;
        this.teshis = teshis;
        this.tarih = tarih;
    }

   

    public String getMemleket() {
        return memleket;
    }

    public void setMemleket(String memleket) {
        this.memleket = memleket;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public float getAtes() {
        return ates;
    }

    public void setAtes(float ates) {
        this.ates = ates;
    }

    public boolean isTeshis() {
        return teshis;
    }

    public void setTeshis(boolean teshis) {
        this.teshis = teshis;
    }
}

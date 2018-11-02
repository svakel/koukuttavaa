package fi.academy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "kommentit")
public class Kommentti {

    @Id
    private BigInteger id;
    private String kirjoittaja;
    private String otsikko;
    private String kommentti;
    private String nimiCode;

    public Kommentti(String kirjoittaja, String otsikko, String kommentti, String nimiCode) {
        this.kirjoittaja = kirjoittaja;
        this.otsikko = otsikko;
        this.kommentti = kommentti;
        this.nimiCode = nimiCode;
    }

    public Kommentti() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    public String getNimiCode() {
        return nimiCode;
    }

    public void setNimiCode(String nimiCode) {
        this.nimiCode = nimiCode;
    }
}


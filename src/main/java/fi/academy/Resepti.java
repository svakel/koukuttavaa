package fi.academy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "reseptit")
public class Resepti {
    @Id
    private Object id;
    private String code;
    private String tekija;
    private String nimi;
    private String annosmaara;
    private String valmistusaika;
    private List ainesosalista = new ArrayList<String>();
    private List ohje = new ArrayList<String>();
    private List reseptikategoria = new ArrayList<String>();
    public Resepti() {
    }
    public Resepti(String code, String tekija, String nimi, String annosmaara, String valmistusaika, List ainesosalista, List ohje, List reseptikategoria) {
        this.code = code;
        this.tekija = tekija;
        this.nimi = nimi;
        this.annosmaara = annosmaara;
        this.valmistusaika = valmistusaika;
        this.ainesosalista = ainesosalista;
        this.ohje = ohje;
        this.reseptikategoria = reseptikategoria;
    }
    public Object getId() {
        return id;
    }
    public void setId(Object id) {
        this.id = id;
    }
    public String getTekija() {
        return tekija;
    }
    public void setTekija(String tekija) {
        this.tekija = tekija;
    }
    public String getNimi() {
        return nimi;
    }
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    public String getAnnosmaara() {
        return annosmaara;
    }
    public void setAnnosmaara(String annosmaara) {
        this.annosmaara = annosmaara;
    }
    public String getValmistusaika() {
        return valmistusaika;
    }
    public void setValmistusaika(String valmistusaika) {
        this.valmistusaika = valmistusaika;
    }
    public List getAinesosalista() {
        return ainesosalista;
    }
    public void setAinesosalista(List ainesosalista) {
        this.ainesosalista = ainesosalista;
    }
    public List getOhje() {
        return ohje;
    }
    public void setOhje(List ohje) {
        this.ohje = ohje;
    }
    public List getReseptikategoria() {
        return reseptikategoria;
    }
    public void setReseptikategoria(List reseptikategoria) {
        this.reseptikategoria = reseptikategoria;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
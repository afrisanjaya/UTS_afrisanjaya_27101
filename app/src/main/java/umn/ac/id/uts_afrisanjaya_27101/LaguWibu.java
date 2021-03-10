package umn.ac.id.uts_afrisanjaya_27101;

import java.io.Serializable;

public class LaguWibu implements Serializable {
    private String judul;
    private String laguURI;
    public LaguWibu(String judul, String laguURI){
        this.judul = judul;
        this.laguURI = laguURI;
    }


    public String getJudul() {
        return this.judul;
    }


    public String getLaguURI() {
        return this.laguURI;
    }


    public void setJudul(String judul) {
        this.judul = judul;
    }


    public void setLaguURI(String laguURI) {
        this.laguURI = laguURI;
    }

}

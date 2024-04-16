package me.fit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = Muzej.GET_ALL_MUZEJI, query = "SELECT * FROM Muzej m")
})
public class Muzej {

    public static final String GET_ALL_MUZEJI = "getAllMuzeji";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "muzej_seq")
    private Long id;
    private String naziv;
    private String lokacija;
    private int brojPosjetitelja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public int getBrojPosjetitelja() {
        return brojPosjetitelja;
    }

    public void setBrojPosjetitelja(int brojPosjetitelja) {
        this.brojPosjetitelja = brojPosjetitelja;
    }
}


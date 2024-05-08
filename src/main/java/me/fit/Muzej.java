package me.fit;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = Muzej.GET_ALL_MUZEJI, query = "SELECT m FROM Muzej m")
})
public class Muzej {

    public static final String GET_ALL_MUZEJI = "getAllMuzeji";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "muzej_seq")
    private Long id;
    private String naziv;
    private String lokacija;
    private int brojPosjetitelja;
    
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Muzej_Korisnik", 
        joinColumns = { @JoinColumn(name = "muzej_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "korisnik_id") }
    )
	private Set<Korisnik> korisnici = new HashSet<>();
	
	

    public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

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


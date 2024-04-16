package me.fit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Korisnik.GET_ALL_KORISNIKE, query = "Select * from korisnik" )
})
public class Korisnik {
	
	public static final String GET_ALL_KORISNIKE = "getAllKorisnike";
	public static final String GET_KORISNICI_BY_NAME = "getKorisniciByName";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korisnik_seq")
	private Long id; 
	private String name;
	private String username;
	private String jmbg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	

}

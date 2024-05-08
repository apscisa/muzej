package me.fit;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = Korisnik.GET_ALL_KORISNIKE, query = "Select k from Korisnik k" ),
	@NamedQuery(name = Korisnik.GET_KORISNICI_BY_NAME, query = "Select k from Korisnik k where k.name = :name") 
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private IPLog iplog;
	
	
	@ManyToMany(mappedBy = "korisnici")
	private Set<Muzej> muzeji;
	

	public Set<Muzej> getMuzeji() {
		return muzeji;
	}

	public void setMuzeji(Set<Muzej> muzeji) {
		this.muzeji = muzeji;
	}

	public IPLog getIplog() {
		return iplog;
	}

	public void setIplog(IPLog iplog) {
		this.iplog = iplog;
	}

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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Korisnik other = (Korisnik) obj;
		if (jmbg == null) {
			if (other.jmbg != null)
				return false;
		} else if (!jmbg.equals(other.jmbg))
			return false;
		return true;
	}
	
	

}

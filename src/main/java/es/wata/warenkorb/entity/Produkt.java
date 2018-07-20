package es.wata.warenkorb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "produkt")
public class Produkt implements Serializable {

	private static final long serialVersionUID = -8988466953118227910L;

	// ATRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;
	@NotEmpty
	private double preis;

	@ManyToMany
	@JoinTable(name = "produkt_produktgruppe", joinColumns = {
			@JoinColumn(name = "produkt_id") }, inverseJoinColumns = { @JoinColumn(name = "gruppe_id") })
	@JsonManagedReference
	private Set<Produktgruppe> gruppe = new HashSet<Produktgruppe>();

	@ManyToMany(mappedBy = "warenkorb")
	@JsonIgnore
	private List<Kunde> kunden = new ArrayList<Kunde>();

	@OneToOne(cascade = CascadeType.ALL)
	private Rabatt rabatt;

	// CONSTRUCT
	public Produkt() {
	}

	// GETERS AND SETERS
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

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public void setKunden(List<Kunde> kunden) {
		this.kunden = kunden;
	}

	public List<Kunde> getKunden() {
		return kunden;
	}

	public void setGruppe(Set<Produktgruppe> gruppe) {
		this.gruppe = gruppe;
	}

	public Set<Produktgruppe> getGruppe() {
		return gruppe;
	}

	public Rabatt getRabat() {
		return rabatt;
	}

	public void setRabat(Rabatt rabat) {
		this.rabatt = rabat;
	}

}

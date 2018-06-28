package es.wata.warenkorb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="produkt")
public class Produkt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7959251865088967062L;
	//ATRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;
	@NotEmpty
	private double precio;
	
	@ManyToMany
	@JoinTable(name="Produkt_ProduktGroupe")
	private Set<ProduktGroupe> groupe = new HashSet<ProduktGroupe>();
	
	@ManyToMany(mappedBy="warenkorb")
	private List<Kunde> kunden = new ArrayList<Kunde>();

	//CONSTRUCT
	public Produkt() {}
	//GETERS AND SETERS
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setKunden(List<Kunde> kunden) {
		this.kunden = kunden;
	}
	public List<Kunde> getKunden() {
		return kunden;
	}
	public void setGroupe(Set<ProduktGroupe> groupe) {
		this.groupe = groupe;
	}
	public Set<ProduktGroupe> getGroupe() {
		return groupe;
	}

}

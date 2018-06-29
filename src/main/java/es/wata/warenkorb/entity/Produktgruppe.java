package es.wata.warenkorb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Produktgruppe")
public class Produktgruppe implements Serializable {

	private static final long serialVersionUID = -1608069395562040475L;
	// ATRIBUTTE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@ManyToMany(mappedBy = "gruppe")
	@JsonBackReference
	private List<Produkt> produkte = new ArrayList<Produkt>();

	@OneToOne(cascade = CascadeType.ALL)
	private Rabatt rabatt;

	// CONSTRUCTOR
	public Produktgruppe() {
	}

	// GET AND SETTERS
	public List<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(List<Produkt> produkte) {
		this.produkte = produkte;
	}

	public Rabatt getRabatt() {
		return rabatt;
	}

	public void setRabatt(Rabatt rabatt) {
		this.rabatt = rabatt;
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

}

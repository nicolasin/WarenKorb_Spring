package es.wata.warenkorb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Kundegruppe")
public class Kundegruppe {
	//ATRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	private Rabatt rabatt;
	//CONSTRUCTOR
	public Kundegruppe() {}
	public Rabatt getRabatt() {
		return rabatt;
	}
	//GET AND SETERS
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

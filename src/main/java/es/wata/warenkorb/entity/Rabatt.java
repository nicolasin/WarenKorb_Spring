package es.wata.warenkorb.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Entity
@Table(name="Rabatt")
public class Rabatt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4089578288262084195L;
	private enum typeRabat {ABS, REL};
	//ATRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private typeRabat type;
	@NotEmpty
	private double wert;
	//CONSTRUCTORS
	public Rabatt() {}
	
	//GET AND SETERS
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public typeRabat getType() {
		return type;
	}
	public void setType(typeRabat type) {
		this.type = type;
	}
	public double getWert() {
		return wert;
	}
	public void setWert(double wert) {
		this.wert = wert;
	}
	
	
}
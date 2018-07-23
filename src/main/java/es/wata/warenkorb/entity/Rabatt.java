package es.wata.warenkorb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rabatt")
public class Rabatt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4089578288262084195L;
	public enum typeRabatt {ABS, REL};
	//ATRIBUTE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private typeRabatt type;
	@NotNull
	private Double wert;
	//CONSTRUCTORS
	public Rabatt() {}
	
	public Rabatt(String name, double wert, typeRabatt typeRabatt) {
		this.name = name;
		this.wert = wert;
		this.type = typeRabatt;
	}

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
	public typeRabatt getType() {
		return type;
	}
	public void setType(typeRabatt type) {
		this.type = type;
	}
	public double getWert() {
		return wert;
	}
	public void setWert(double wert) {
		this.wert = wert;
	}
	
	public double rabattAnwenden(double preis) {
		if(this.type == typeRabatt.ABS) {
			return wert;
		}else {
			return preis *(wert/100);
		}
	}

	@Override
	public String toString() {
		return Id+" "+name + "," + type.toString() + ", " + wert ;
	}
	
	
}
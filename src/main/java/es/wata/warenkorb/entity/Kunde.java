package es.wata.warenkorb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Kunde")
public class Kunde implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8640384290133152667L;
	// ATRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String nick;
	@NotEmpty
	private String password;
	@ManyToMany
	@JoinTable(name = "warenkorb", joinColumns = { @JoinColumn(name = "kunde_id") }, inverseJoinColumns = {
			@JoinColumn(name = "produkt_id") })
	@JsonIgnore
	private List<Produkt> warenkorb = new ArrayList<Produkt>();

	@ManyToOne
	private Kundegruppe gruppe;
	@OneToOne(cascade = CascadeType.ALL)
	private Rabatt rabatt;



	// CONSTRUCTOR
	public Kunde() {
	}
	public Kunde(String name, String nick, String password) {
		this.name = name;
		this.nick = nick;
		this.password = password;
		this.rabatt = null;
		this.gruppe = null;
	}

	// GETERES AND SETERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Kundegruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Kundegruppe gruppe) {
		this.gruppe = gruppe;
	}

	public List<Produkt> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(List<Produkt> warenkorb) {
		this.warenkorb = warenkorb;
	}

	public void addProduktToWarenkorb(Produkt produkt) {
		warenkorb.add(produkt);
	}

	public void removeProduktVonWarenkorb(Produkt produkt) {
		if (warenkorb.contains(produkt)) {
			Iterator<Produkt> iter = warenkorb.iterator();
			int countIndex = 0;
			while (iter.hasNext()) {
				if (iter.next().equals(produkt)) {
					break;
				}
				countIndex++;
			}
			warenkorb.remove(countIndex);
		}
	}

	public void entlerenWarenkorb() {
		warenkorb.clear();

	}
	public Rabatt getRabatt() {
		return rabatt;
	}

	public void setRabatt(Rabatt rabatt) {
		this.rabatt = rabatt;
	}
}

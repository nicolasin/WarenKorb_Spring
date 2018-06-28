package es.wata.warenkorb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Kunde")
public class Kunde implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8640384290133152667L;
	//ATRIBUTES
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
	@JoinTable(name = "warenkorb", joinColumns = {
			@JoinColumn(name = "kunde_id") }, inverseJoinColumns = { @JoinColumn(name = "produkt_id") })
	private List<Produkt> warenkorb = new ArrayList<Produkt>();

	@ManyToOne
	KundeGroupe groupes;
	
	//CONSTRUCTOR
	public Kunde() {}

	//GETERES AND SETERS
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
	public KundeGroupe getGroupes() {
		return groupes;
	}

	public void setGroupes(KundeGroupe groupes) {
		this.groupes = groupes;
	}

	public List<Produkt> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(List<Produkt> warenkorb) {
		this.warenkorb = warenkorb;
	}
}

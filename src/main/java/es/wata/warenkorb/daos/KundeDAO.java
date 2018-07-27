package es.wata.warenkorb.daos;

import org.springframework.data.repository.CrudRepository;

import es.wata.warenkorb.entity.Kunde;

public interface KundeDAO  extends CrudRepository<Kunde, Long>{
	public Kunde findByName(String name);
}

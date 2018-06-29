package es.wata.warenkorb.daos;

import org.springframework.data.repository.CrudRepository;

import es.wata.warenkorb.entity.Produkt;

public interface ProduktDAO extends CrudRepository<Produkt, Long>{

}

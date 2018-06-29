package es.wata.warenkorb.services.interfaces;

import java.util.List;

import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;

public interface ProduktServiceInterface {
	public List<Produkt> getListProdukt();
	public Produkt	getProduktById(Long id);
	public List<Produktgruppe> getAllGroups();
	public Produktgruppe produktgrupeByID(Long id);
}

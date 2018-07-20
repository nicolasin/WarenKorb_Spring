package es.wata.warenkorb.services.interfaces;

import java.util.List;

import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.exceptions.ServiceException;

public interface ProduktServiceInterface {
	public List<Produkt> getListProdukt()throws ServiceException;
	public Produkt	getProduktById(Long id)throws ServiceException;
	public List<Produktgruppe> getAllGroups()throws ServiceException;
	public Produktgruppe produktgrupeByID(Long id)throws ServiceException;
}

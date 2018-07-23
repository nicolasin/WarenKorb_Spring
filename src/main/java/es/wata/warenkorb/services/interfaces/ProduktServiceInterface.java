package es.wata.warenkorb.services.interfaces;

import java.util.List;

import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.exceptions.ServiceException;

public interface ProduktServiceInterface {
	public List<Produkt> getListProdukt()throws ServiceException;
	public Produkt	getProduktById(Long id)throws ServiceException;
	public List<Produktgruppe> getAllCategorie()throws ServiceException;
	public Produktgruppe categorieByID(Long id)throws ServiceException;
	public void addProdukt(String name, double preis)throws ServiceException;
	public void deleteProduktById(Long id)throws ServiceException;
	public void removeCategorie(Long id)throws ServiceException ;
	public void addCategorie(String name)throws ServiceException ;
	
}

package es.wata.warenkorb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.ProduktDAO;
import es.wata.warenkorb.daos.ProduktgruppeDAO;
import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.exceptions.ServiceException;
import es.wata.warenkorb.helperClasses.ApiResponse;
import es.wata.warenkorb.services.interfaces.ProduktServiceInterface;
@Service
public class ProduktService implements ProduktServiceInterface {
	private static final Logger LOG = LoggerFactory.getLogger(ProduktService.class);
	@Autowired
	private ProduktDAO produktDAO;
	@Autowired
	ProduktgruppeDAO produktGruppeDAO;
	
	//PRODUKT
	@Transactional
	@Override
	public List<Produkt> getListProdukt()throws ServiceException{
		LOG.info("GET LIST PRODUKT");
		return (List<Produkt>)produktDAO.findAll();
	}
	@Transactional
	@Override
	public Produkt	getProduktById(Long id)throws ServiceException {
		existException(id);
		LOG.info("GET PRODUKT ["+id+"]");
		return produktDAO.findOne(id);
	}
	
	@Override
	public void addProdukt(String name, double preis) throws ServiceException {
		Produkt produkt = new Produkt(name, preis);
		LOG.info("ADD NEU PRODUKT ["+produkt.getName()+"]");
		produktDAO.save(produkt);	
	}
	@Override
	public void deleteProduktById(Long id) throws ServiceException {
		existException(id);
		LOG.info("DELETE PRODUKT ["+id+"]");
		produktDAO.delete(id);
		
	}
	private void existException(Long id)throws ServiceException {
		if(!produktDAO.exists(id)) {
			throw new ServiceException(new ApiResponse("produkt NOT FOUND", HttpStatus.NOT_FOUND));
		}
	}
	
	
	//CATEGORIAS
	@Transactional
	@Override
	public List<Produktgruppe> getAllCategorie()throws ServiceException{
		LOG.info("GET ALL CATEGORIES");
		return (List<Produktgruppe>) produktGruppeDAO.findAll();
	}
	@Transactional
	@Override
	public Produktgruppe categorieByID(Long id)throws ServiceException {
		
		if(!produktGruppeDAO.exists(id)) {
			throw new ServiceException(new ApiResponse("Categorie NOT FOUND", HttpStatus.NOT_FOUND));
		}
		LOG.info("GET CATEGORIE ["+id+"]");
		return produktGruppeDAO.findOne(id);
	}
	@Transactional
	@Override
	public void addCategorie(String name)throws ServiceException {
		Produktgruppe produktgruppe = new Produktgruppe();
		produktgruppe.setName(name);
		LOG.info("ADD NEW CATEGORIE ["+produktgruppe.getName()+"]");
		produktGruppeDAO.save(produktgruppe);
	}
	@Transactional
	@Override
	public void removeCategorie(Long id)throws ServiceException {
		if(!produktGruppeDAO.exists(id)) {
			throw new ServiceException(new ApiResponse("Categorie NOT FOUND", HttpStatus.NOT_FOUND));
		}
		LOG.info("REMOVE CATEGORIE ["+id+"]");
		produktGruppeDAO.delete(id);
	}
}

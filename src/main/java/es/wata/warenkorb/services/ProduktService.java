package es.wata.warenkorb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.ProduktDAO;
import es.wata.warenkorb.daos.ProduktgruppeDAO;
import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.exceptions.ServiceException;
import es.wata.warenkorb.services.interfaces.ProduktServiceInterface;
@Service
public class ProduktService implements ProduktServiceInterface {
	private static final Logger LOG = LoggerFactory.getLogger(ProduktService.class);
	@Autowired
	private ProduktDAO produktDAO;
	@Autowired
	ProduktgruppeDAO produktGruppeDAO;
	@Transactional
	@Override
	public List<Produkt> getListProdukt()throws ServiceException{
		LOG.info("GET LIST PRODUKT");
		return (List<Produkt>)produktDAO.findAll();
	}
	@Transactional
	@Override
	public Produkt	getProduktById(Long id)throws ServiceException {
		return produktDAO.findOne(id);
	}
	@Transactional
	@Override
	public List<Produktgruppe> getAllGroups()throws ServiceException{
		return (List<Produktgruppe>) produktGruppeDAO.findAll();
	}
	@Transactional
	@Override
	public Produktgruppe produktgrupeByID(Long id)throws ServiceException {
		
		return produktGruppeDAO.findOne(id);
	}
}

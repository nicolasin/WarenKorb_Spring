package es.wata.warenkorb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.ProduktDAO;
import es.wata.warenkorb.daos.ProduktgruppeDAO;
import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.services.interfaces.ProduktServiceInterface;
@Service
public class ProduktService implements ProduktServiceInterface {
	@Autowired
	private ProduktDAO produktDAO;
	@Autowired
	ProduktgruppeDAO produktGruppeDAO;
	@Transactional
	@Override
	public List<Produkt> getListProdukt(){
		return (List<Produkt>)produktDAO.findAll();
	}
	@Transactional
	@Override
	public Produkt	getProduktById(Long id) {
		return produktDAO.findOne(id);
	}
	@Transactional
	@Override
	public List<Produktgruppe> getAllGroups(){
		return (List<Produktgruppe>) produktGruppeDAO.findAll();
	}
	@Transactional
	@Override
	public Produktgruppe produktgrupeByID(Long id) {
		
		return produktGruppeDAO.findOne(id);
	}
}

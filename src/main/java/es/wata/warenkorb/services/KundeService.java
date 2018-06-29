package es.wata.warenkorb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.KundeDAO;
import es.wata.warenkorb.daos.ProduktDAO;
import es.wata.warenkorb.entity.Kunde;
import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.services.interfaces.KundeInterfaceService;
@Service
public class KundeService implements KundeInterfaceService{
	@Autowired
	private KundeDAO kundeDAO;
	@Autowired
	private ProduktDAO produktDAO;
	@Override
	@Transactional
	public List<Kunde> getAll() {
		
		return (List<Kunde>)kundeDAO.findAll();
	}

	@Override
	@Transactional
	public Kunde getById(Long id) {
		return kundeDAO.findOne(id);
	}

	@Override
	@Transactional
	public void addProduktToKunde(Long id, Long idProdukt) {
		Kunde kunde = kundeDAO.findOne(id);
		Produkt produkt = produktDAO.findOne(idProdukt);
		kunde.addProduktToWarenkorb(produkt);
		
	}
	
	@Override
	@Transactional
	public void removeProduktToKunde(Long id, Long idProdukt) {
		Kunde kunde = kundeDAO.findOne(id);
		Produkt produkt = produktDAO.findOne(idProdukt);
		kunde.removeProduktVonWarenkorb(produkt);
		
	}

	@Override
	@Transactional
	public void entlerenWarenkorb(Long id) {
		Kunde kunde = kundeDAO.findOne(id);
	
		kunde.entlerenWarenkorb();
		
	}

}

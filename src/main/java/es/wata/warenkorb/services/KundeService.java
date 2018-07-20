package es.wata.warenkorb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.KundeDAO;
import es.wata.warenkorb.daos.ProduktDAO;
import es.wata.warenkorb.entity.Kunde;
import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.exceptions.ServiceException;
import es.wata.warenkorb.helperClasses.ApiResponse;
import es.wata.warenkorb.services.interfaces.KundeInterfaceService;
@Service
public class KundeService implements KundeInterfaceService{
	private static final Logger LOG = LoggerFactory.getLogger(KundeService.class);
	@Autowired
	private KundeDAO kundeDAO;
	@Autowired
	private ProduktDAO produktDAO;
	@Override
	@Transactional
	public List<Kunde> getAll()throws ServiceException {
		List<Kunde> kunden  = (List<Kunde>)kundeDAO.findAll();
		if(kunden.isEmpty()) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}
		return kunden;
	}

	@Override
	@Transactional
	public Kunde getById(Long id)throws ServiceException {
		Kunde kunde = kundeDAO.findOne(id);
		if(kunde==null) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}
		return kunde;
	}

	@Override
	@Transactional
	public void addProduktToKunde(Long id, Long idProdukt) throws ServiceException{
		
		Kunde kunde = kundeDAO.findOne(id);
		Produkt produkt = produktDAO.findOne(idProdukt);
		if(kunde==null) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}

		if(produkt==null) {
			throw new ServiceException(new ApiResponse("Produkt Not Found", HttpStatus.NOT_FOUND));
		}
		kunde.addProduktToWarenkorb(produkt);
		
	}
	
	@Override
	@Transactional
	public void removeProduktToKunde(Long id, Long idProdukt)throws ServiceException {
		Kunde kunde = kundeDAO.findOne(id);
		Produkt produkt = produktDAO.findOne(idProdukt);
		if(kunde==null) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}

		if(produkt==null) {
			throw new ServiceException(new ApiResponse("Produkt Not Found", HttpStatus.NOT_FOUND));
		}
		if(!kunde.getWarenkorb().contains(produkt)) {
			throw new ServiceException(new ApiResponse("This produkt is not in warenkorb", HttpStatus.NOT_FOUND));
		}
		kunde.removeProduktVonWarenkorb(produkt);
		
	}

	@Override
	@Transactional
	public void entlerenWarenkorb(Long id)throws ServiceException {
		
		Kunde kunde = kundeDAO.findOne(id);
		if(kunde==null) {
			LOG.error("KUNDE NOT FOUND");
			throw new ServiceException(new ApiResponse("kunde not found", HttpStatus.NOT_FOUND));
		}
		kunde.entlerenWarenkorb();
		
	}
	@Override
	public void deleteKunde(Long idKunde) throws ServiceException {
		Kunde kunde = kundeDAO.findOne(idKunde);
		if(kunde==null) {
			throw new ServiceException(new ApiResponse("id Kunde is not valid", HttpStatus.NOT_FOUND));
		}else {
			kundeDAO.delete(idKunde);
		}
		
	}
	@Override
	public void addNeuKunde(String name, String nick, String password) throws ServiceException {
		if( name == null || nick == null || password==null) {
			throw new ServiceException(new ApiResponse("Faltan Parámetros", HttpStatus.BAD_REQUEST));
		}
		if(isNotCorrectTheName(name)) {
			throw new ServiceException(new ApiResponse("Nombre Invalido", HttpStatus.BAD_REQUEST));
		}
		if(isNotCorrectThePassword(password)) {
			throw new ServiceException(new ApiResponse("Password Invalida", HttpStatus.BAD_REQUEST));
		}
		Kunde kunde = new Kunde(name, nick, password);
		kundeDAO.save(kunde);	
	}

	private boolean isNotCorrectTheName(String name) {
		// TODO Auto-generated method stub
		return false;
		
	}

	private boolean isNotCorrectThePassword(String password) {
		return false;
	}

	

}

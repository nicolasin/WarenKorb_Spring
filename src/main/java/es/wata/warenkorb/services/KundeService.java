package es.wata.warenkorb.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class KundeService implements KundeInterfaceService {
	private static final Logger LOG = LoggerFactory.getLogger(KundeService.class);
	@Autowired
	private KundeDAO kundeDAO;
	@Autowired
	private ProduktDAO produktDAO;

	@Override
	@Transactional
	public List<Kunde> getAll() throws ServiceException {
		List<Kunde> kunden = (List<Kunde>) kundeDAO.findAll();
		if (kunden.isEmpty()) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}
		LOG.info("SHOW LIST KUNDE");
		return kunden;
	}

	@Override
	@Transactional
	public Kunde getById(Long id) throws ServiceException {
		Kunde kunde = kundeDAO.findOne(id);
		if (kunde == null) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}
		LOG.info("SHOW KUNDE " + kunde.getName());
		return kunde;
	}

	@Override
	@Transactional
	public void addProduktToKunde(Long id, Long idProdukt) throws ServiceException {

		Kunde kunde = kundeDAO.findOne(id);
		Produkt produkt = produktDAO.findOne(idProdukt);
		if (kunde == null) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}
		if (produkt == null) {
			throw new ServiceException(new ApiResponse("Produkt Not Found", HttpStatus.NOT_FOUND));
		}
		LOG.info("ADD NEW PRODUKT " + produkt.getName());
		kunde.addProduktToWarenkorb(produkt);

	}

	@Override
	@Transactional
	public void removeProduktToKunde(Long id, Long idProdukt) throws ServiceException {
		Kunde kunde = kundeDAO.findOne(id);
		Produkt produkt = produktDAO.findOne(idProdukt);
		if (kunde == null) {
			throw new ServiceException(new ApiResponse("Kunde Not Found", HttpStatus.NOT_FOUND));
		}

		if (produkt == null) {
			throw new ServiceException(new ApiResponse("Produkt Not Found", HttpStatus.NOT_FOUND));
		}
		if (!kunde.getWarenkorb().contains(produkt)) {
			throw new ServiceException(new ApiResponse("This produkt is not in warenkorb", HttpStatus.NOT_FOUND));
		}
		LOG.info("REMOVE PRODUKT" + produkt.getName() + " TO WARENKORB FROM " + kunde.getName() + "[" + kunde.getId()
				+ "]");
		kunde.removeProduktVonWarenkorb(produkt);

	}

	@Override
	@Transactional
	public void entlerenWarenkorb(Long id) throws ServiceException {

		Kunde kunde = kundeDAO.findOne(id);
		if (kunde == null) {
			throw new ServiceException(new ApiResponse("kunde not found", HttpStatus.NOT_FOUND));
		}
		LOG.info("REMOVE ALL PRODUKT  TO WARENKORB FROM " + kunde.getName() + "[" + kunde.getId() + "]");
		kunde.entlerenWarenkorb();

	}

	@Override
	@Transactional
	public void deleteKunde(Long idKunde) throws ServiceException {
		Kunde kunde = kundeDAO.findOne(idKunde);
		if (kunde == null) {
			throw new ServiceException(new ApiResponse("id Kunde is not valid", HttpStatus.NOT_FOUND));
		} else {
			LOG.info("REMOVE KUNDE " + kunde.getName() + "[" + kunde.getId() + "]");
			kundeDAO.delete(idKunde);
		}

	}

	@Override
	@Transactional
	public void addNeuKunde(String name, String nick, String password, String email) throws ServiceException {
		if (name == null || nick == null || password == null) {
			throw new ServiceException(new ApiResponse("Faltan Parámetros", HttpStatus.BAD_REQUEST));
		}
		if (isNotCorrectTheEmail(email)) {
			throw new ServiceException(new ApiResponse("Email not valid", HttpStatus.BAD_REQUEST));
		}
		if (isNotCorrectTheName(name)) {
			throw new ServiceException(new ApiResponse("Nombre not valid", HttpStatus.BAD_REQUEST));
		}
		if (isNotCorrectThePassword(password)) {
			throw new ServiceException(new ApiResponse(
					"Password not valid, must contains numbers, special character and more than 7 character",
					HttpStatus.BAD_REQUEST));
		}
		Kunde kunde = new Kunde(name, nick, password, email);
		LOG.info("ADD NEW KUNDE " + kunde.getName() + "[" + kunde.getId() + "]");
		kundeDAO.save(kunde);
	}

	private boolean isNotCorrectTheEmail(String email) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		if (mather.find() == true) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isNotCorrectTheName(String name) {
		return (isContainsNumber(name) || isContainsStrangerChars(name));
	}

	private boolean isContainsStrangerChars(String name) {
		String strangerCharacters = "ª!\"·$%&/()=?¿";
		for (int i = 0; i < strangerCharacters.length(); i++) {
			if (name.contains("" + strangerCharacters.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private boolean isNotCorrectThePassword(String password) {
		return (isContainsNumber(password) && isContainsStrangerChars(password) && password.length() >= 8);
	}

	private boolean isContainsNumber(String name) {
		for (int i = 0; i < 10; i++) {
			if (name.contains("" + i)) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public void save(Kunde kunde) throws ServiceException {
		kundeDAO.save(kunde);
		
	}

}

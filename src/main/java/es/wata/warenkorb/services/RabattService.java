package es.wata.warenkorb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.RabattDAO;
import es.wata.warenkorb.entity.Rabatt;
import es.wata.warenkorb.exceptions.ServiceException;
import es.wata.warenkorb.helperClasses.ApiResponse;
import es.wata.warenkorb.services.interfaces.RabattInterfaceService;
@Service
public class RabattService implements RabattInterfaceService {

	
	@Autowired
	RabattDAO rabattDAO;
	
	@Override
	public List<Rabatt> getListRabatt() throws ServiceException {
		List<Rabatt> rabatte = (List<Rabatt>) rabattDAO.findAll();
		return rabatte;
	}

	@Override
	public Rabatt getRabattByID(Long id) throws ServiceException {
		Rabatt rabatt = rabattDAO.findOne(id);
		if(rabatt==null) {
			throw new ServiceException(new ApiResponse("Rabatt not found",HttpStatus.NOT_FOUND));
		}
		return rabatt;
	}

	@Override
	@Transactional
	public void addRabatt(String name, double wert, String type) throws ServiceException {
		
		Rabatt.typeRabatt typeRabatt = typeRabattFromString(type); 
		if(typeRabatt!=null){
			Rabatt rabatt = new Rabatt(name, wert, typeRabatt);
			rabattDAO.save(rabatt);
		}else {
			throw new ServiceException(new ApiResponse("Error type von Rabatt",HttpStatus.BAD_GATEWAY));
		}
		
	}
	private Rabatt.typeRabatt typeRabattFromString(String type) {
		
		for(Rabatt.typeRabatt typeRabatt: Rabatt.typeRabatt.values()) {
			if(typeRabatt.toString().equals(type)) {
				return typeRabatt;
			}
		}
		return null;
	}

	@Override
	public void deleteRabatt(Long id) throws ServiceException {
		if(!rabattDAO.exists(id)) {
			throw new ServiceException(new ApiResponse("Error, rabatt not found", HttpStatus.NOT_FOUND));
		}
		rabattDAO.delete(id);
	}

}

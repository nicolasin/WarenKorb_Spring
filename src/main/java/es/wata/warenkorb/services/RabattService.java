package es.wata.warenkorb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.wata.warenkorb.daos.RabattDAO;
import es.wata.warenkorb.entity.Rabatt;
import es.wata.warenkorb.exceptions.ServiceException;
import es.wata.warenkorb.services.interfaces.RabattInterfaceService;

public class RabattService implements RabattInterfaceService {

	
	@Autowired
	RabattDAO rabattDAO;
	@Override
	public List<Rabatt> getListRabatt() throws ServiceException {
		List<Rabatt> rabatte = (List<Rabatt>) rabattDAO.findAll();
		System.out.println("lkasldkjaldkas");
		return rabatte;
	}

}

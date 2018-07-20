package es.wata.warenkorb.services.interfaces;

import java.util.List;

import es.wata.warenkorb.entity.Kunde;
import es.wata.warenkorb.exceptions.ServiceException;

public interface KundeInterfaceService {
	
	public List<Kunde> getAll() throws ServiceException;
	public Kunde getById(Long id)throws ServiceException;
	public void addProduktToKunde(Long id, Long idProdukt)throws ServiceException;
	public void removeProduktToKunde(Long id, Long idProdukt)throws ServiceException;
	public void entlerenWarenkorb(Long id)throws ServiceException;
	public void addNeuKunde(String name, String nick, String password) throws ServiceException ;
	public void deleteKunde(Long idKunde)throws ServiceException;
	
}
